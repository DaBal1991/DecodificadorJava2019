
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;

public class Modelo {

    private String driver, prefijoConexion, ip, usr, psw, bd, tabla, trad, cara;
    private Connection conexion;
    private ActionListener listener;

    public Modelo() {

        driver = "com.mysql.cj.jdbc.Driver";
        prefijoConexion = "jdbc:mysql://";
        ip = "127.0.0.1";
        bd = "codigo";
        tabla = "representacion";
        usr = "";
        psw = "";
        conexion = obtenerConexion();
    }

    public ArrayList<Codigo> consulta() {

        conexion = obtenerConexion();
        ArrayList<Codigo> alfabeto = new ArrayList();

        String q = "SELECT * FROM " + tabla;

        try {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(q);

            while (resultSet.next()) {
                alfabeto.add(new Codigo(resultSet.getString(1), resultSet.getString(2)));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            reportException(ex.getMessage());
        }

        return alfabeto;
    }

    public String codificador(String frase) {

        ArrayList<Codigo> c = consulta();
        String[] desarmador = frase.split("");
        String aux;
        ArrayList<String> fraseFinal = new ArrayList();

        for (int j = 0; j < desarmador.length; j++) {
            for (int i = 0; i < c.size(); i++) {

                if (c.get(i).getCaracter().equals(desarmador[j])) {

                    if (c.get(i).getNumero().length() < 5) {
                        fraseFinal.add(decodificarNumero(c.get(i).getNumero()));

                    } else {
                        fraseFinal.add(c.get(i).getNumero());
                    }
                }

            }
        }

        aux = String.join(" ", fraseFinal);

        return aux;
    }

    public String decodificarNumero(String s) {

        ArrayList<Codigo> c = consulta();
        String[] desarmador = s.split("");
        String nFinal = null;
        ArrayList<String> numeroFinal = new ArrayList();

        for (int i = 0; i < desarmador.length; i++) {
            for (int j = 0; j < c.size(); j++) {
                if (c.get(j).getCaracter().equals(desarmador[i])) {

                    numeroFinal.add(c.get(j).getNumero());
                }
            }
        }

        nFinal = String.join("", numeroFinal);

        return nFinal;
    }

    private Connection obtenerConexion() {
        if (conexion == null) {
            try {
                Class.forName(driver); // driver = "com.mysql.cj.jdbc.Driver";
            } catch (ClassNotFoundException ex) {
                reportException(ex.getMessage());
            }
            try { // prefijoConexion = "jdbc:mysql://";
                conexion
                        = DriverManager.getConnection(prefijoConexion + ip + "/" + bd, usr, psw);
            } catch (Exception ex) {
                reportException(ex.getMessage());
            }
            Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        }
        return conexion;
    }

    private class ShutDownHook extends Thread {

        public void run() {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

}


public class Codigo {

    private String caracter;
    private String numero;

    public Codigo(String caracter, String numero) {
        this.caracter = caracter;
        this.numero = numero;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return caracter + " = " + numero;
    }
    

}

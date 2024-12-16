
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author damia
 */
public class Controlador implements ActionListener{
    
    private Vista v;
    private Modelo m;
    
    public Controlador(Vista v, Modelo m){
        this.v = v;
        this.m = m;
        this.v.btnCodificar.addActionListener(this);
        
    }
    
    public void iniciar(){
        v.setTitle("Codificador a Binario");
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        v.txtBinario.setText(m.codificador(v.txtHumano.getText()));
    }
}

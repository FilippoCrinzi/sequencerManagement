/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author filippocrinzi
 */
public class SequencerFormPanel extends FormPanel{
    private List<Label> label = new ArrayList<>();
    
    
    
    public SequencerFormPanel(){
        super();
        this.label.add(new Label("Name:",Label.LEFT ));
        this.label.add(new Label("Speed(sample x day):",Label.LEFT));
        this.label.add(new Label("Type:",Label.LEFT));
        
        
        createFormPanel(this.label, new ArrayList<>());
        
        
    }
    public boolean controlError() {
        // Ottieni il valore del secondo campo (Speed)
        TextField speedField = text.get(1); // Indice 1 per il campo "Speed"
        String speedText = speedField.getText();

        try {
            int speedValue = Integer.parseInt(speedText);
            if (speedValue < 1 || speedValue > 100) {
                JOptionPane.showMessageDialog(this, "Please enter a valid speed (1 to 100).", "Input Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a numeric value for speed.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true; // Se tutto va bene, restituisci true
    }

    // Metodo per il salvataggio dei dati
    public void saveData() {
        System.out.println("salvataggio andato a buon fine");   
    }
    
}

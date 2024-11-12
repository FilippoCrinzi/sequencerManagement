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
import model.Client;

/**
 *
 * @author filippocrinzi
 */
public class ClientFormPanel extends FormPanel{
    private List<Label> label = new ArrayList<>();

    
    
    
    public ClientFormPanel(){
        super();
        this.label.add(new Label("Name:",Label.LEFT ));
        this.label.add(new Label("Referent:",Label.LEFT));
        this.label.add(new Label("Phone number:",Label.LEFT));
        this.label.add(new Label("Email:",Label.LEFT));
        this.label.add(new Label("Adress:", Label.LEFT));
        
        createFormPanel(this.label, new ArrayList<>());
     
    }
    
    public boolean controlError() {
        // Verifica che tutti i campi siano completati
        for (int i = 0; i < text.size(); i++) {
            String fieldText = text.get(i).getText().trim();
            if (fieldText.isEmpty()) {
                JOptionPane.showMessageDialog(this, label.get(i).getText() + " cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Verifica che il campo del numero di telefono contenga solo cifre
        String phoneNumber = text.get(2).getText().trim(); // Assume che il campo del numero di telefono sia il terzo
        if (!phoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Phone number must contain only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Se tutti i controlli sono superati, ritorna true
        return true;
        
    //TODO: ricordati di fare in modo che non ci siano piu clienti con lo stesso nome 

    }
    
    public Client getClient() {
        String name = text.get(0).getText();
        String referent = text.get(1).getText();
        String phoneNumber = text.get(2).getText();
        String email = text.get(3).getText();
        String address = text.get(4).getText();

        return new Client(name, referent, phoneNumber, email, address);
    }
    
    public void clearFields() {
        for (TextField field : text) {
            field.setText("");
        }
    }
    
   
}
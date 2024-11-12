/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.ClientDAO;
import javax.swing.JOptionPane;
import model.Client;
import view.ClientFormPanel;
import view.MainView;

/**
 *
 * @author filippocrinzi
 */
public class ClientFormController {
    private ClientFormPanel clientFormPanel;
    private MainView mainView;
    private ClientDAO clientDAO;
    
    
    public ClientFormController(ClientFormPanel clientFormPanel, MainView mainView){
        this.clientFormPanel = clientFormPanel;
        this.mainView = mainView;
        this.clientDAO = new ClientDAO();
        
        this.clientFormPanel.getBackButton().addActionListener(e -> backClient());
        this.clientFormPanel.getSaveButton().addActionListener(e -> saveClient());
    }
    
    
    private void backClient(){
        mainView.showPanel("ClientPanel");
    }
    private void saveClient(){
        Client clientToAdd = clientFormPanel.getClient();
        //prova
        

        // Salva il client usando ClientDAO
        if(clientFormPanel.controlError()){
            boolean isAdded = clientDAO.addClient(clientToAdd);
            if (isAdded) {
                System.out.println("Client da aggiungere: ");
                System.out.println("Nome: " + clientToAdd.getName());
                System.out.println("Referente: " + clientToAdd.getReferent());
                System.out.println("Numero di telefono: " + clientToAdd.getPhoneNumber());
                System.out.println("Email: " + clientToAdd.getEmail());
                System.out.println("Indirizzo: " + clientToAdd.getAdress());
                JOptionPane.showMessageDialog(mainView, "Client saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                mainView.updateOrderFormClientList();
                clientFormPanel.clearFields();
            } else {
                JOptionPane.showMessageDialog(mainView, "Error saving client.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}

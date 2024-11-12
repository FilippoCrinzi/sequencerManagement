/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import Dao.ClientDAO;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Client;
import view.ClientDataPanel;
import view.MainView;

/**
 *
 * @author filippocrinzi
 */
public class ClientDataController {
    private ClientDataPanel clientPanel;
    private MainView mainView;
    private ClientDAO clientDAO;
    
    
    public ClientDataController(ClientDataPanel clientPanel, MainView mainView){
        this.clientPanel = clientPanel;
        this.mainView = mainView;
        this.clientDAO = new ClientDAO();
        
        this.clientPanel.getBackButton().addActionListener(e -> backMenu());
        this.clientPanel.getAddButton().addActionListener(e -> addFormClient());
        
        loadClientData();
    }
    
    
    private void backMenu(){
        mainView.showPanel("MenuPanel");
    }
    private void addFormClient(){
        mainView.showPanel("ClientFormPanel");
    }
    public List<Client> getClientList() {
        return clientDAO.getClientList();
    }
    private void deleteClient(Client client) {
        int response = JOptionPane.showConfirmDialog(
            mainView,
            "Vuoi eliminare il cliente " + client.getName() + "?",
            "Conferma eliminazione",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            boolean success = clientDAO.deleteClient(client);

            if (success) {
               int rowIndex = this.getClientList().indexOf(client); 
               clientPanel.removeDeleteButton(rowIndex);
               mainView.updateOrderFormClientList();
               loadClientData(); 
            } else {
                JOptionPane.showMessageDialog(mainView, "Errore durante l'eliminazione del cliente.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void loadClientData() {
    List<Client> clients = getClientList();
    clientPanel.loadClientData(clients);
    
    List<JButton> deleteButtons = clientPanel.getDeleteButtons(); // Ottieni tutti i bottoni "Delete"

    for (int i = 0; i < deleteButtons.size(); i++) {
        Client client = clients.get(i); // Ottieni il client corrispondente alla riga
        JButton deleteButton = deleteButtons.get(i);
     
        // Aggiungi l'action listener che richiama il metodo deleteClient con il client corrispondente
        deleteButton.addActionListener(e -> {deleteClient(client);});
    }
}
    
    
}

package view;

import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import model.Client;
import model.Order;

public class OrderFormPanel extends FormPanel {
    private List<Label> label = new ArrayList<>();
    private JComboBox<String> clientComboBox;
    private Map<String, Client> clientMap = new HashMap<>();  // Mappa per associare nomi di clienti agli oggetti Client
    
    public OrderFormPanel(List<Client> clients) {
        super();

        this.label.add(new Label("Order ID:", Label.LEFT));
        this.label.add(new Label("Client:", Label.LEFT));
        this.label.add(new Label("Total Samples:", Label.LEFT));

        // Crea la ComboBox e popola la mappa con i clienti
        clientComboBox = new JComboBox<>();
        for (Client client : clients) {
            clientComboBox.addItem(client.getName());
            clientMap.put(client.getName(), client);  // Associa il nome del cliente all'oggetto Client
        }

        // Lista dei componenti per creare il form
        List<Object> components = new ArrayList<>();
        components.add(new TextField()); // Campo testo per Order ID
        components.add(clientComboBox);   // ComboBox per il cliente
        components.add(new TextField());  // Campo testo per Total Samples

        // Usa la nuova versione di createFormPanel
        createFormPanel(this.label, components);
    }

    @Override
    public boolean controlError() {
        return true;
    }

    public void clearFields() {
        for (TextField field : text) {
            field.setText("");
        }
        clientComboBox.setSelectedIndex(0);
    }

    public Order getOrder() {
        String orderId = text.get(0).getText();
        String clientName = (String) clientComboBox.getSelectedItem();
        Client client = clientMap.get(clientName);  
        int totalSamples = Integer.parseInt(text.get(1).getText());

        return new Order(orderId, client, totalSamples);  
    }
    
    public void updateClientList(List<Client> clients) {
    clientComboBox.removeAllItems(); 
    clientMap.clear(); 

    for (Client client : clients) {
        clientComboBox.addItem(client.getName());
        clientMap.put(client.getName(), client);
    }
}
}

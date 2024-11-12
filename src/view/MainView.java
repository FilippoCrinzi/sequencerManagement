/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import Dao.ClientDAO;
import controller.ClientDataController;
import controller.ClientFormController;
import controller.OrderDataController;
import controller.SequencerDataController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author filippocrinzi
 */
public class MainView extends JFrame{
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JButton clientButton;
    private JButton sequencerButton;
    private JButton orderButton;
    private FormFactory formFactory = new FormFactory(this);
    private ClientDataPanel clientPanel = new ClientDataPanel();
    private OrderDataPanel orderPanel = new OrderDataPanel();
    private SequencerDataPanel sequencerPanel = new SequencerDataPanel();
    
    private ClientDataController clientDataController = new ClientDataController(clientPanel,this);
    private OrderDataController orderDataController = new OrderDataController(orderPanel,this);
    private SequencerDataController sequencerDataController = new SequencerDataController(sequencerPanel,this);
    
    
    
    public MainView() {
        setTitle("Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));  

        // Creazione dei bottoni
        clientButton = createButton("Client", "icon/group.png");
        sequencerButton = createButton("Sequencer", "icon/dna.png");
        orderButton = createButton("Order", "icon/test-tube.png");
        
        JPanel menuPanel = new JPanel(); 
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        menuPanel.add(clientButton);
        menuPanel.add(sequencerButton);
        menuPanel.add(orderButton);
        
        // Impostazione del CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        // Aggiungere le viste
        cardPanel.add(menuPanel, "MenuPanel");
        cardPanel.add(clientPanel, "ClientPanel");
        cardPanel.add(orderPanel, "OrderPanel");
        cardPanel.add(sequencerPanel,"SequencerPanel");
        cardPanel.add(formFactory.createPanel("ClientFormPanel"),"ClientFormPanel");
        cardPanel.add(formFactory.createPanel("OrderFormPanel"),"OrderFormPanel");
        cardPanel.add(formFactory.createPanel("SequencerFormPanel"),"SequencerFormPanel");

        // Aggiunta dei pannelli principali alla finestra
        
        add(cardPanel);
        cardLayout.show(cardPanel, "MenuPanel"); 
        
    }
    
    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setIcon(new ImageIcon(iconPath)); // Imposta l'icona
        button.setHorizontalTextPosition(SwingConstants.RIGHT); // Testo a destra dell'icona
        button.setPreferredSize(new Dimension(150, 50)); // Dimensione preferita del bottone
        button.setBackground(Color.LIGHT_GRAY); // Colore di sfondo
        button.setForeground(Color.BLACK); // Colore del testo
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Font personalizzato
        return button;
    }
    
    public void showPanel(String panelName){
        if(panelName == "ClientPanel"){
           clientDataController.loadClientData();
        } else if(panelName == "OrderPanel"){
            orderDataController.loadOrderData();
        }
        cardLayout.show(cardPanel, panelName);
    }
    
    public JButton getClientButton() {
        return clientButton;
    }
    public JButton getSequencerButton() {
        return sequencerButton;
    }
    public JButton getOrderButton() {
        return orderButton;
    }
    public ClientDataController getClientDataController(){
        return clientDataController;
    }
    
    public void updateOrderFormClientList() {
        formFactory.getOrderFormPanel().updateClientList(clientDataController.getClientList());
    }

    
}

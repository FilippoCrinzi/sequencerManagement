/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author filippocrinzi
 */
import controller.ClientFormController;
import controller.OrderFormController;
import controller.SequencerFormController;
import javax.swing.*;

public class FormFactory {
    private MainView mainView;
    private OrderFormPanel orderFormPanel;
    public FormFactory(MainView mainView){
        this.mainView = mainView;
    }
    public JPanel createPanel(String panelType) {
        switch (panelType) {
            case "OrderFormPanel":
                orderFormPanel = new OrderFormPanel(mainView.getClientDataController().getClientList());
                OrderFormController orderFormController = new OrderFormController(orderFormPanel,mainView);
                return  orderFormPanel;
            case "SequencerFormPanel":
                SequencerFormPanel sequencerFormPanel = new SequencerFormPanel();
                SequencerFormController sequencerFormController = new SequencerFormController(sequencerFormPanel,mainView);
                return sequencerFormPanel;
            case "ClientFormPanel":
                ClientFormPanel clientFormPanel = new ClientFormPanel();
                ClientFormController clientFormController = new ClientFormController(clientFormPanel,mainView);        
                return clientFormPanel;
            default:
                throw new IllegalArgumentException("Panel type not recognized");
        }
    }
    
    public OrderFormPanel getOrderFormPanel(){
        return orderFormPanel;
    }
}

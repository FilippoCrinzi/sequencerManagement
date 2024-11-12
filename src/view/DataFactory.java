/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author filippocrinzi
 */

import controller.ClientDataController;
import controller.OrderDataController;
import controller.SequencerDataController;
import javax.swing.*;

public class DataFactory {
    private MainView mainView;
    public DataFactory(MainView mainView){
        this.mainView = mainView;
    }
    public JPanel createPanel(String panelType){
        switch (panelType) {
            case "OrderDataPanel":
                OrderDataPanel orderDataPanel = new OrderDataPanel();
                OrderDataController orderDataController = new OrderDataController(orderDataPanel,mainView);
                return  orderDataPanel;
            case "SequencerDataPanel":
                SequencerDataPanel sequencerDataPanel = new SequencerDataPanel();
                SequencerDataController sequencerDataController = new SequencerDataController(sequencerDataPanel,mainView);
                return sequencerDataPanel;
            case "ClientDataPanel":
                ClientDataPanel clientDataPanel = new ClientDataPanel();
                ClientDataController clientDataController = new ClientDataController(clientDataPanel,mainView);        
                return clientDataPanel;
            default:
                throw new IllegalArgumentException("Panel type not recognized");
        }
    }
}

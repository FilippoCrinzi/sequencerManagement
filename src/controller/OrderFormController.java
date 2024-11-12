/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.OrderDAO;
import javax.swing.JOptionPane;
import model.Client;
import model.Order;
import view.MainView;
import view.OrderFormPanel;

/**
 *
 * @author filippocrinzi
 */
public class OrderFormController {
    private OrderFormPanel orderFormPanel;
    private MainView mainView;
    private OrderDAO orderDAO;
    
    
    public OrderFormController(OrderFormPanel orderFormPanel, MainView mainView){
        this.orderFormPanel = orderFormPanel;
        this.mainView = mainView;
        this.orderDAO = new OrderDAO();
        
        this.orderFormPanel.getBackButton().addActionListener(e -> backClient());
        this.orderFormPanel.getSaveButton().addActionListener(e -> saveOrder());
    }
    
    
    private void backClient(){
        mainView.showPanel("OrderPanel");
    }
    
    private void saveOrder(){
        Order orderToAdd = orderFormPanel.getOrder();
        //prova
        

        // Salva il client usando ClientDAO
        if(orderFormPanel.controlError()){
            boolean isAdded = orderDAO.addOrder(orderToAdd);
            if (isAdded) {
                JOptionPane.showMessageDialog(mainView, "Client saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                orderFormPanel.clearFields();
            } else {
                JOptionPane.showMessageDialog(mainView, "Error saving client.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
    
}

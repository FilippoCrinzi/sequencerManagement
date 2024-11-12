/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.OrderDAO;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Order;
import view.OrderDataPanel;
import view.MainView;

/**
 *
 * @author filippocrinzi
 */
public class OrderDataController {
    private OrderDataPanel orderPanel;
    private MainView mainView;
    private OrderDAO orderDAO;
    
    public OrderDataController(OrderDataPanel clientPanel, MainView mainView){
        this.orderPanel = clientPanel;
        this.mainView = mainView;
        this.orderDAO = new OrderDAO();
        
        this.orderPanel.getBackButton().addActionListener(e -> backMenu());
        this.orderPanel.getAddButton().addActionListener(e -> addOrder());
        
        loadOrderData();
    }
    
    private void backMenu(){
        mainView.showPanel("MenuPanel");
    }
    private void addOrder(){
        mainView.showPanel("OrderFormPanel");
    }
    
    private List<Order> getOrderList(){
        return orderDAO.getOrderList();
    }
    private void deleteOrder(Order order){
        int response = JOptionPane.showConfirmDialog(
            mainView,
            "Vuoi eliminare l'ordine " + order.getOrderID() + "?",
            "Conferma eliminazione",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION){
            boolean success = orderDAO.deleteOrder(order);
            
            if(success){
                int rowIndex = this.getOrderList().indexOf(order);
                orderPanel.removeDeleteButton(rowIndex);
                loadOrderData();
            } else {
                JOptionPane.showMessageDialog(mainView, "Errore durante l'eliminazione di un ordine");
            }
        }
    }
    
    
    public void loadOrderData(){
        List<Order> orders = getOrderList();
        orderPanel.loadOrderData(orders);
        
        List<JButton> deleteButtons = orderPanel.getDeleteButtons();
        
        for(int i = 0; i < deleteButtons.size(); i++){
            Order order = orders.get(i);
            JButton deleteButton = deleteButtons.get(i);
            
            deleteButton.addActionListener(e -> {deleteOrder(order);});
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import view.MainView;



/**
 *
 * @author filippocrinzi
 */
public class MainViewController {
    private MainView mainView;
    
    public MainViewController(MainView mainView){
        this.mainView = mainView;
        this.mainView.getClientButton().addActionListener(e -> openClient());
        this.mainView.getSequencerButton().addActionListener(e -> openSequencer());
        this.mainView.getOrderButton().addActionListener(e -> openOrder());
    }
    
    private void openClient(){
        mainView.showPanel("ClientPanel");
    }
    private void openSequencer(){
        mainView.showPanel("SequencerPanel");
    }
    private void openOrder(){
        mainView.showPanel("OrderPanel");
    }
    
}

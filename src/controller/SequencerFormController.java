/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import view.MainView;
import view.SequencerFormPanel;

/**
 *
 * @author filippocrinzi
 */
public class SequencerFormController {
    private SequencerFormPanel sequencerFormPanel;
    private MainView mainView;
    
    
    public SequencerFormController(SequencerFormPanel sequencerFormPanel, MainView mainView){
        this.sequencerFormPanel = sequencerFormPanel;
        this.mainView = mainView;
        
        this.sequencerFormPanel.getBackButton().addActionListener(e -> backClient());
        this.sequencerFormPanel.getSaveButton().addActionListener(e -> save());
    }
    
    
    private void backClient(){
        mainView.showPanel("SequencerPanel");
    }
    private void save(){
        if (sequencerFormPanel.controlError()) {
                // Esegui il salvataggio se non ci sono errori
                sequencerFormPanel.saveData();
            }
    }
}

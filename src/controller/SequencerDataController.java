/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.SequencerDataPanel;
import view.MainView;

/**
 *
 * @author filippocrinzi
 */
public class SequencerDataController {
   private SequencerDataPanel sequencerPanel;
    private MainView mainView;
    
    public SequencerDataController(SequencerDataPanel clientPanel, MainView mainView){
        this.sequencerPanel = clientPanel;
        this.mainView = mainView;
        
        this.sequencerPanel.getBackButton().addActionListener(e -> backMenu());
        this.sequencerPanel.getAddButton().addActionListener(e-> addSequencer());
    }
    
    private void backMenu(){
        mainView.showPanel("MenuPanel");
    } 
    private void addSequencer(){
        mainView.showPanel("SequencerFormPanel");
    }
}

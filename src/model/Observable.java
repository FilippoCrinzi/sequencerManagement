/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


/**
 *
 * @author filippocrinzi
 */
public class Observable {
    private Observer observer;
    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    public void removeObserver() {
        this.observer = null;    
    }
    protected void notifyObservers(LocalDate estimatedCompletionDate, int samplesProcessed) {
       if (observer != null) {
            observer.update(estimatedCompletionDate, samplesProcessed);
        }
    }
}

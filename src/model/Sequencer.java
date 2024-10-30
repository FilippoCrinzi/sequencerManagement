/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author filippocrinzi
 */
public class Sequencer extends Observable{
    public enum SequencerType {
    TYPE_A, 
    TYPE_B, 
    TYPE_C  
}
    private String name;                    
    private SequencerType type;             
    private int sequencingSpeed;            
    private int associatedOrderId;          
    private LocalDate estimatedCompletionDate; 
    private int samplesProcessed;          
    private boolean isOccupied;

    // Costruttore
    public Sequencer(String name, SequencerType type, int sequencingSpeed) {
        this.name = name;
        this.type = type;
        this.sequencingSpeed = sequencingSpeed;
        this.associatedOrderId = -1; // Valore di default per nessun ordine associato
        this.estimatedCompletionDate = null; // Valore di default, non impostato
        this.samplesProcessed = 0;   // Inizialmente nessun campione è stato processato
    }

    // Getter e Setter
    public String getName() {
        return name;
    }

    public SequencerType getType() {
        return type;
    }

    public int getSequencingSpeed() {
        return sequencingSpeed;
    }

    public int getAssociatedOrderId() {
        return associatedOrderId;
    }

    public void setAssociatedOrderId(int orderId) {
        this.associatedOrderId = orderId;
    }

    public LocalDate getEstimatedCompletionDate() {
        return estimatedCompletionDate;
    }

    public void setEstimatedCompletionDate(LocalDate estimatedDate) {
        this.estimatedCompletionDate = estimatedDate;
    }

    public int getSamplesProcessed() {
        return samplesProcessed;
    }

    public void setSamplesProcessed(int samplesProcessed) {
        this.samplesProcessed = samplesProcessed;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
    // Metodo per resettare l'associazione con un ordine
    public void resetOrderAssociation() {
        this.associatedOrderId = -1;
        this.estimatedCompletionDate = null;
        this.samplesProcessed = 0;
    }
    public LocalDate calculateCompletionDate(Order order) {
        int remainingSamples = order.getTotalSamples() - this.samplesProcessed;
        int daysNeeded = (int) Math.ceil((double) remainingSamples / sequencingSpeed);
        this.estimatedCompletionDate = LocalDate.now().plus(daysNeeded, ChronoUnit.DAYS);
        notifyObservers(estimatedCompletionDate, samplesProcessed);
       
        return this.estimatedCompletionDate;
    }
    public void completeOrder() {
        resetOrderAssociation();
        removeObserver();
        isOccupied = false;
    }
}

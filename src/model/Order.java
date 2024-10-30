/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;

/**
 *
 * @author filippocrinzi
 */
public class Order implements Observer{
    private String orderID;
    private Client client;
    private int totalSamples;
    private LocalDate estimatedCompletionDate;
    private int samplesProcessed = 0;
    
    
    public Order(String orderID, Client client, int totalSamples){
        this.orderID = orderID;
        this.client = client;
        this.totalSamples = totalSamples;
    }
    //setter and getter
    public void setOrderID(String orderID){
        this.orderID = orderID;
    }
    public String getOrderID(){
        return orderID;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public Client getClient(){
        return client;
    }
    public void setTotalSamples(int totalSamples){
        this.totalSamples = totalSamples;
    }
    public int getTotalSamples(){
        return totalSamples;
    }
    public void setEstimatedCompletionDate(LocalDate estimatedCompletionDate){
        this.estimatedCompletionDate = estimatedCompletionDate;
    }
    public LocalDate getEstimatedCompletionDate(){
        return estimatedCompletionDate;
    }
    public void setSamplesProcessed(int samplesProcessed){
        this.samplesProcessed = samplesProcessed;
    }
    public int getSamplesProcessed(){
        return samplesProcessed;
    }
    @Override
    public void update(LocalDate estimatedCompletionDate, int samplesProcessed) {
        this.estimatedCompletionDate = estimatedCompletionDate;
        this.samplesProcessed = samplesProcessed;
    }
}

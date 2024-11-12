/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Client;
import model.Order;

/**
 *
 * @author filippocrinzi
 */
public class OrderDAO {
    private final String url = "jdbc:postgresql://localhost:5432/sequencer_db"; 
    private final String user = "postgres"; 
    private final String password = "...."; 
    
    public boolean addOrder(Order order){
        String query = "INSERT INTO Orders (orderid, client,total_samples, estimated_completion_date, samples_processed) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, order.getOrderID());
            stmt.setString(2, order.getClient().getName());
            stmt.setInt(3, order.getTotalSamples());
            stmt.setNull(4, java.sql.Types.DATE);
            stmt.setInt(5, order.getSamplesProcessed());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
            
    }
   


    public List<Order> getOrderList() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT orderid, client,total_samples, estimated_completion_date, samples_processed FROM Orders";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                ClientDAO clientDAO = new ClientDAO();
                Client client = clientDAO.getClientByName(rs.getString("client"));  // Assicurati di implementare questo metodo in ClientDAO

                Order order = new Order(
                    rs.getString("orderid"),
                    client,
                    rs.getInt("total_samples")
                );
                java.sql.Date estimatedCompletionDate = rs.getDate("estimated_completion_date");
                    if (estimatedCompletionDate != null) {
                        order.setEstimatedCompletionDate(estimatedCompletionDate.toLocalDate());
                    }
                order.setSamplesProcessed(rs.getInt("samples_processed"));

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public boolean deleteOrder(Order order) {
        String query = "DELETE FROM orders WHERE orderid = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, order.getOrderID());

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

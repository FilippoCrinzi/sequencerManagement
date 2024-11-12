/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import model.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filippocrinzi
 */
public class ClientDAO {
    private final String url = "jdbc:postgresql://localhost:5432/sequencer_db"; 
    private final String user = "postgres"; 
    private final String password = "...."; 

    // Metodo per aggiungere un cliente al database
    public boolean addClient(Client client) {
        String query = "INSERT INTO Clients (name, referent, phone_number, email, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, client.getName());
            stmt.setString(2, client.getReferent());
            stmt.setString(3, client.getPhoneNumber());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getAdress());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  // Metodo per ottenere la lista di tutti i clienti
    public List<Client> getClientList() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT name, referent, phone_number, email, address FROM Clients";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Client client = new Client(
                    rs.getString("name"),
                    rs.getString("referent"),
                    rs.getString("phone_number"),
                    rs.getString("email"),
                    rs.getString("address")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
    
    public boolean deleteClient(Client client) {
        String query = "DELETE FROM Clients WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, client.getName());

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public Client getClientByName(String name) {
    String query = "SELECT name, referent, phone_number, email, address FROM Clients WHERE name = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Client(
                rs.getString("name"),
                rs.getString("referent"),
                rs.getString("phone_number"),
                rs.getString("email"),
                rs.getString("address")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
    
}


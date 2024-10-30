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
/**
 *
 * @author filippocrinzi
 */
public class UserDAO {
    public static boolean authenticate(String username, String password) {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        
        try {
            
             // URL del database
            String dbURL = "jdbc:postgresql://localhost:5432/sequencer_db";
            String dbUsername = "postgres"; 
            String dbPassword = "....";

            // Crea la connessione
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            
            // Prepara la query per l'autenticazione
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            // Debugging: Stampa la query e le credenziali
            System.out.println("Query: " + query);
            System.out.println("Username: " + username + ", Password: " + password);
            
            // Esegui la query
            resultSet = preparedStatement.executeQuery();      
            
            // Controlla se ci sono risultati
            return resultSet.next();
        } catch (SQLException e) {
            // Stampa l'eccezione se c'è un errore
            e.printStackTrace();
            return false; // Restituisci false in caso di errore
        } finally {
            // Chiudi le risorse
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

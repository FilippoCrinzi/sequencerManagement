/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.LoginController;
import Dao.UserDAO;
import view.Login;

/**
 *
 * @author filippocrinzi
 */
public class main {
    public static void main(String[] args) {
        
        System.out.println("prova stampa");        // Crea un'istanza di UserDAO (assicurati che sia correttamente configurata)
        UserDAO userDAO = new UserDAO();

        // Crea un'istanza della vista di login
        Login loginView = new Login();

        // Crea il controller e passa la vista e il DAO
        LoginController loginController = new LoginController(loginView, userDAO);
        
        // Nota: La finestra di login si aprirà automaticamente nel costruttore di Login
    }
}

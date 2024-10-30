/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.UserDAO;
import view.Login;

/**
 *
 * @author filippocrinzi
 */
public class LoginController {
    private Login loginView;
    private UserDAO userDAO;

    public LoginController(Login loginView, UserDAO userDAO) {
        this.loginView = loginView;
        this.userDAO = userDAO;

        // Aggiungi l'ActionListener al pulsante di accesso
        this.loginView.getLogInButton().addActionListener(e -> authenticate());
    }

    private void authenticate() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        if (userDAO.authenticate(username, password)) {
            // Autenticazione riuscita, procedi (ad esempio, apri la finestra principale)
            // Qui puoi anche chiudere la finestra di login se necessario
            System.out.println("Accesso riuscito");
            loginView.dispose(); 
        } else {
            // Mostra messaggio di errore
            loginView.setErrorMessage("Credenziali errate. Riprova.");
        }
    }
}

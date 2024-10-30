/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author filippocrinzi
 */


public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel errorMessage;

    public Login() {
        // Imposta la finestra
        setTitle("Login");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null); // Centra la finestra

        

        // Campo username
        usernameField = new JTextField(15);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        usernameField.setBackground(new Color(255, 255, 255));

        // Campo password
        passwordField = new JPasswordField(15);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        passwordField.setBackground(new Color(255, 255, 255));

        // Pulsante login
        loginButton = new JButton("Log In");
        

        // Messaggio di errore
        errorMessage = new JLabel("");
        errorMessage.setForeground(Color.RED);

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        gbc.gridy = 3;
        add(errorMessage, gbc);

        setVisible(true);
    }

    // Metodi per ottenere i dati
    public String getUsername() {
        return usernameField.getText().trim();
    }

    public String getPassword() {
        return new String(passwordField.getPassword()).trim();
    }

    // Aggiungi un metodo per visualizzare i messaggi di errore
    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }
    public JButton getLogInButton() {
        return loginButton;
    }

}


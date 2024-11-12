package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Classe base per un pannello di dati con titolo, pulsante "Back" e pulsante "Add".
 * Il titolo è centrato e stilizzato, mentre i pulsanti sono posizionati ai lati opposti.
 * @author filippocrinzi
 */
public abstract class DataPanel extends JPanel {
    protected JTable dataTable;
    protected JButton backButton;
    protected JButton addButton;
    protected JLabel titleLabel;
    protected java.util.List<JButton> deleteButtons = new java.util.ArrayList<>();
    protected JPanel buttonPanel = new JPanel();

    public DataPanel(String title) {
        // Layout principale
        setLayout(new BorderLayout());

        // Inizializzazione del pulsante "Back" con icona
        initializeBackButton();

        // Inizializzazione del pulsante "Add" con icona
        initializeAddButton();

        // Creazione del pannello superiore per pulsanti e titolo
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(addButton, BorderLayout.EAST);

        // Pannello per centrare il titolo e limitarne la larghezza
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(230, 230, 230));
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        
        titlePanel.add(titleLabel);
        topPanel.add(titlePanel, BorderLayout.CENTER);

        // Aggiunta di margine inferiore per separare il titolo dalla tabella
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        // Aggiunta del pannello superiore al layout principale
        add(topPanel, BorderLayout.NORTH);

        // Creazione della tabella specifica
        createTable();

        // Pannello per la tabella
        JScrollPane tableScrollPane = new JScrollPane(dataTable);
        add(tableScrollPane, BorderLayout.CENTER);
    }

    private void initializeBackButton() {
        backButton = new JButton();
        backButton.setIcon(new ImageIcon("icon/back-button.png")); // Assicurati che il percorso sia corretto
        backButton.setPreferredSize(new Dimension(40, 40));
        backButton.setContentAreaFilled(false); // Rimuove il background per un aspetto pulito
        backButton.setBorderPainted(false); // Rimuove il bordo
    }

    private void initializeAddButton() {
        addButton = new JButton();
        addButton.setIcon(new ImageIcon("icon/plus.png")); // Assicurati che il percorso sia corretto
        addButton.setPreferredSize(new Dimension(40, 40));
        addButton.setContentAreaFilled(false); // Rimuove il background per un aspetto pulito
        addButton.setBorderPainted(false); // Rimuove il bordo
    }
    
    public java.util.List<JButton> addDeleteButtons(int numberOfButtons) {
        buttonPanel.removeAll();
        deleteButtons.clear();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // BoxLayout verticale per i bottoni
        
          
        
        buttonPanel.add(Box.createVerticalStrut(15));
        

        for (int i = 0; i < numberOfButtons; i++) {
            JButton deleteButton = new JButton(new ImageIcon("icon/cestino1.png"));
            deleteButton.setFocusPainted(false);
            deleteButton.setBackground(Color.WHITE);

            // Imposta la dimensione fissa dei bottoni per renderli piccoli (30x30 px)
            deleteButton.setPreferredSize(new Dimension(26, 26)); // Quadrato di dimensioni 30x30
            deleteButton.setMaximumSize(new Dimension(26, 26));  // Blocca la dimensione massima
            deleteButton.setMinimumSize(new Dimension(26, 26));  // Blocca la dimensione minima

            // Aggiungi il bottone al pannello
            deleteButton.setMargin(new Insets(0, 0, 0, 0));
            buttonPanel.add(deleteButton);
            deleteButtons.add(deleteButton);
        }

        // Aggiungi il pannello dei bottoni al lato destro della tabella
        add(buttonPanel, BorderLayout.EAST);
        revalidate(); // Rendi il pannello visibile
        repaint();

        return deleteButtons; // Restituisci la lista dei bottoni
    }
    
    public void removeDeleteButton(int index) {
    if (index >= 0 && index < deleteButtons.size()) {
        
        JButton deleteButton = deleteButtons.remove(index);

        // Aggiorna il pannello
        revalidate();
        repaint();
    }
}



    protected abstract void createTable();

    public JTable getDataTable() {
        return dataTable;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) dataTable.getModel();
    }
}

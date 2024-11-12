package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author filippocrinzi
 */
public abstract class FormPanel extends JPanel {
    private JButton save;
    protected List<TextField> text = new ArrayList<>();
    private List<Label> label = new ArrayList<>();
    private JButton back;
    private GridBagConstraints gbc = new GridBagConstraints();
    String type = new String();

    public FormPanel() {
        // Disattiva il layout manager per il posizionamento assoluto
        setLayout(null);

        // Crea il pulsante "Back" con un'icona
        this.back = new JButton(new ImageIcon("icon/back-button.png")); 
        this.back.setText("");
        this.back.setContentAreaFilled(false); 
        this.back.setBorderPainted(false); // Rimuove il bordo del pulsante
        this.back.setFocusPainted(false); // Rimuove l'effetto focus
        this.back.setBounds(10, 10, 30, 30); // Posiziona il pulsante in alto a sinistra

        // Aggiungi il pulsante al pannello
        add(this.back);

        // Configura il layout per il form
        JPanel formPanel = new JPanel(new GridBagLayout());
        this.save = new JButton("Save");

        this.gbc.fill = GridBagConstraints.HORIZONTAL;
        this.gbc.anchor = GridBagConstraints.CENTER;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;

        // Aggiungi il formPanel con layout a griglia al centro
        formPanel.setBounds(50, 50, 400, 300); // Imposta la posizione e la dimensione del formPanel
        add(formPanel);
    }
    
    void createFormPanel(List<Label> label, List<Object> extraComponents) {
    JPanel formPanel = (JPanel) getComponent(1); // Ottieni il formPanel centrale
    this.label = label;
    this.type = type;

    // Se la lista di componenti extra è vuota, gestisci solo le etichette
    if (extraComponents.isEmpty()) {
        for (int i = 0; i < this.label.size(); i++) {
            Label lbl = label.get(i);
            gbc.gridy = i;
            formPanel.add(lbl, gbc);

            // Aggiungi solo il TextField (come nel codice originale)
            TextField field = new TextField();
            field.setPreferredSize(new Dimension(200, 30)); // Dimensione dei campi di testo
            this.text.add(field);

            gbc.gridx = 1;
            formPanel.add(field, gbc);
            gbc.gridx = 0;
        }
    } else {
        // Se la lista di componenti extra non è vuota, gestisci anche i componenti extra
        for (int i = 0; i < this.label.size(); i++) {
            Label lbl = label.get(i);
            gbc.gridy = i;
            formPanel.add(lbl, gbc);

            // Aggiungi il componente extra (TextField o JComboBox)
            if (i < extraComponents.size()) {
                Object component = extraComponents.get(i);

                if (component instanceof TextField) {
                    TextField field = (TextField) component;
                    field.setPreferredSize(new Dimension(200, 30));
                    this.text.add(field);
                    gbc.gridx = 1;
                    formPanel.add(field, gbc);
                } else if (component instanceof JComboBox) {
                    gbc.gridx = 1;
                    formPanel.add((JComboBox<?>) component, gbc);
                }
            }
            gbc.gridx = 0;
        }
    }

    // Aggiungi il pulsante "Save"
    gbc.gridy++;
    gbc.gridx = 0;
    formPanel.add(this.save, gbc);
}

    public JButton getBackButton() {
        return back;
    }
    
    public JButton getSaveButton() {
        return save;
    }
    
    protected abstract boolean controlError();

}

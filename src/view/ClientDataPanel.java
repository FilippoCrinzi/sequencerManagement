/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
/**
 *
 * @author filippocrinzi
 */
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import model.Client;
import java.util.List;
import javax.swing.JTable;

public class ClientDataPanel extends DataPanel {
    private List<JButton> deleteButtons = new ArrayList<>();
    public ClientDataPanel() {
        super("Client");
    }

    @Override
    protected void createTable() {
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                
                return false;
            }
        };

        tableModel.setColumnIdentifiers(new String[]{"Name", "Referent", "Phone Number", "Email", "Address"});
        dataTable = new JTable(tableModel);
        dataTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        dataTable.setRowHeight(25);

        // Renderer per le celle non interattive, per evitare il colore blu
        DefaultTableCellRenderer nonEditableRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, false, false, row, column);
                cell.setBackground(Color.WHITE);  // Sfondo bianco per le celle non selezionabili
                setHorizontalAlignment(SwingConstants.CENTER);
                setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                return cell;
            }
        };
        
        for (int i = 0; i < dataTable.getColumnCount(); i++) {
            dataTable.getColumnModel().getColumn(i).setCellRenderer(nonEditableRenderer);
        }
    }

    public void loadClientData(List<Client> clients) {
        DefaultTableModel tableModel = getTableModel();
        tableModel.setRowCount(0);
        deleteButtons.clear();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(clients.size(), 1, 5, 5));

        for (Client client : clients) {
            tableModel.addRow(new Object[]{
                client.getName(),
                client.getReferent(),
                client.getPhoneNumber(),
                client.getEmail(),
                client.getAdress()
            });
        }
        deleteButtons = addDeleteButtons(clients.size());
        
    }
   
    public List<JButton> getDeleteButtons() {
        return deleteButtons;
    }
}





    


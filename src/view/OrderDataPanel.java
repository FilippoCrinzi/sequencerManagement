/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Order;

/**
 *
 * @author filippocrinzi
 */
public class OrderDataPanel extends DataPanel{
    private List<JButton> deleteButtons = new ArrayList<>();
    public OrderDataPanel() {
        super("Order");
    }
    @Override
    protected void createTable() {
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                
                return false;
            }
        };
        
        tableModel.setColumnIdentifiers(new String[]{"Order ID", "Client Name", "Total Samples", "Estimated Completion Date", "Samples Processed"});
        dataTable = new JTable(tableModel);
        dataTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        dataTable.setRowHeight(25);
        dataTable.getColumnModel().getColumn(0).setMaxWidth(61);
        dataTable.getColumnModel().getColumn(1).setMaxWidth(85);
        dataTable.getColumnModel().getColumn(2).setMaxWidth(90);
        dataTable.getColumnModel().getColumn(3).setMaxWidth(176);
        dataTable.getColumnModel().getColumn(4).setMaxWidth(132);
        
        
        // Renderer per le celle non interattive, per evitare il colore blu
        DefaultTableCellRenderer nonEditableRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, false, false, row, column);
                cell.setBackground(Color.WHITE);  // Sfondo bianco per le celle non selezionabili
                setHorizontalAlignment(SwingConstants.CENTER);
                setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                if ("__/__/__".equals(value)) {
                    cell.setForeground(Color.LIGHT_GRAY);  // Imposta testo in grigio chiaro
                } else {
                    cell.setForeground(Color.BLACK);  // Testo normale in nero per gli altri valori
                }
                return cell;
            }
        };
        
        for (int i = 0; i < dataTable.getColumnCount(); i++) {
            dataTable.getColumnModel().getColumn(i).setCellRenderer(nonEditableRenderer);
        }
    }
    
    public void loadOrderData(List<Order> orders){
        DefaultTableModel tableModel = getTableModel();
        tableModel.setRowCount(0);
        deleteButtons.clear();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(orders.size(), 1, 5, 5));

        for (Order order : orders) {
            tableModel.addRow(new Object[]{
                order.getOrderID(),
                order.getClient().getName(),
                order.getTotalSamples(),
                order.getEstimatedCompletionDate() != null 
                    ? order.getEstimatedCompletionDate() 
                    : "__/__/__",
                order.getSamplesProcessed()
            });
        }
        deleteButtons = addDeleteButtons(orders.size());
    }
    
    public List<JButton> getDeleteButtons() {
        return deleteButtons;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author filippocrinzi
 */
public class SequencerDataPanel extends DataPanel {
   public SequencerDataPanel() {
        super("Sequencer");
    }
    @Override
    protected void createTable() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Name", "Speed(sample x day)", "OrderID", "Completion Date","Samples Processed","Status"});
        dataTable = new JTable(tableModel);
        dataTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        dataTable.getColumnModel().getColumn(0).setMaxWidth(50);
        dataTable.getColumnModel().getColumn(2).setMaxWidth(60);
        dataTable.getColumnModel().getColumn(5).setMaxWidth(60);
    }
    
}



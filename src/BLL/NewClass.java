package BLL;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.*;


public class NewClass extends JFrame  {
    private JTable table;
    private int pHeight = 60;
       public NewClass() {
           ImageIcon testIcon = new ImageIcon("src/IMAGE/donhang.jpg");
          // ImageIcon errorIcon = (ImageIcon) UIManager.getIcon("OptionPane.errorIcon");
           ImageIcon infoIcon = new ImageIcon("src/IMAGE/Capture.jpg");
           ImageIcon warnIcon = new ImageIcon("src/IMAGE/fb.jpg");
           String[] columnNames = {"Picture", "Description"};
           Object[][] data = {{testIcon  , "About"}, {infoIcon, "Add"}, {warnIcon, "Copy"},};
           DefaultTableModel model = new DefaultTableModel(data, columnNames);
           table = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(2, column).getClass();
            }
          };
           table.setRowHeight(pHeight);
           table.setPreferredScrollableViewportSize(table.getPreferredSize());
           JScrollPane scrollPane = new JScrollPane(table);
           add(scrollPane, BorderLayout.CENTER);
         }

    public static void main(String[] args) {
        NewClass frame = new NewClass();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        frame.pack();
        frame.setVisible(true);
    }
}
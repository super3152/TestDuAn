/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author PhuDX
 */
public class Excel {

    //Xuất Excel truyền vào bảng cần xuất
    public boolean ExportExcel(JTable tab) {
        boolean result = false;
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            WritableWorkbook workbook;
            try {
                workbook = Workbook.createWorkbook(new File(file + ".xls"));
                WritableSheet sheet1 = workbook.createSheet("ChauNganShop", 0);
                DefaultTableModel model = (DefaultTableModel) tab.getModel();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    sheet1.addCell(new Label(j, 0, (String) tab.getColumnName(j)));
                }
                int rowBegin = 1;
                int colBegin = 0;

                for (int row = rowBegin, j = 0; row < model.getRowCount() + rowBegin; row++, j++) {
                    for (int col = colBegin, k = 0; col < model.getColumnCount() + colBegin; col++, k++) {
                        Object data = model.getValueAt(j, k);
                        sheet1.addCell(new Label(col, row, (String) data.toString()));
                    }
                }
                workbook.write();
                workbook.close();
            } catch (IOException e) {
                System.out.println("Error create file\n" + e.toString());
            } catch (RowsExceededException e) {
                System.out.println("Error write file\n" + e.toString());
            } catch (WriteException e) {
                System.out.println("Error write file\n" + e.toString());
            }
            result = true;
        }
        return result;
    }

    public DefaultTableModel openAndReadFileExcel(JTable tab) {
        DefaultTableModel model = null;
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showOpenDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Workbook workbook;
            try {
                // create workbook to open file
                workbook = Workbook.getWorkbook(new File(file + ""));
                // get sheet want read
                Sheet sheet = workbook.getSheet(0);
                // get number row and col contain data
                int rows = sheet.getRows();
                int cols = sheet.getColumns();
                String[] colTieuDe = new String[cols];
                for (int col = 0; col < cols; col++) {
                    Cell cell = sheet.getCell(col, 0);
                    colTieuDe[col] = cell.getContents();
                }
                model = new DefaultTableModel(colTieuDe, 0);
                Object[] hang;
                // read data in each cell
                for (int row = 1; row < rows; row++) {
                    hang = new Object[9];
                    for (int col = 0; col < cols; col++) {
                        Cell cell = sheet.getCell(col, row);
                        hang[col] = cell.getContents();
                    }
                    model.addRow(hang);
                }
                // close
                workbook.close();
            } catch (BiffException | IOException e) {
                System.out.println("File not found\n" + e.toString());
            }
        }
        return model;
    }
}

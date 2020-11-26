/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Takemikazuchi
 */
public class pnltongquan extends javax.swing.JPanel {

    /**
     * Creates new form pnltongquan
     */
    public pnltongquan() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {

        }
        initComponents();
        Thongke7ngay();
        BLL.BLLHoatDong.HienThiChiTietHoatDong(tblHoatdong);
        BLL.BLLHoatDong.HienThiChiTietHoatDong(tblHoatdong1);
        BLL.BLLThongke.HienThiThongKeSanPhamBanChay2(tblSanphambanchay);
         tblSanphambanchay.getColumnModel().getColumn(0).setWidth(0);
        tblSanphambanchay.getColumnModel().getColumn(0).setMinWidth(0);
        tblSanphambanchay.getColumnModel().getColumn(0).setMaxWidth(0);
        
     
          JFreeChart line = createChart(createDataset());
          
        ChartPanel chartPanel = new ChartPanel(line);
       jPanel3.add(chartPanel);
   
       CategoryPlot plot = line.getCategoryPlot();
       LineAndShapeRenderer renderer = new LineAndShapeRenderer();
plot.setRenderer(renderer);
plot.setBackgroundPaint(Color.white);
renderer.setSeriesPaint(0, Color.black);
plot.setRangeGridlinesVisible(true);
plot.setRangeGridlinePaint(Color.gray);
 
plot.setDomainGridlinesVisible(true);
plot.setDomainGridlinePaint(Color.gray);
    }
      public JFreeChart createChart(DefaultCategoryDataset dataset) {
       JFreeChart lineChart = ChartFactory.createLineChart(
         "Doanh thu bán hàng 7 ngày qua",
         null,null,
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
      
        return lineChart;
    }

    
 public  DefaultCategoryDataset createDataset( ) {

      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
           int homnay;
            if (jTable1.getValueAt(0, 0) == null) {
         homnay = 0;
     }else{homnay = Integer.parseInt(jTable1.getValueAt(0, 0).toString());}   
         BLL.ChuyenDoi.ChuyenSangSo(String.valueOf(homnay));
         System.out.println(homnay);
         
         int homqua1;
            if (jTable2.getValueAt(0, 0) == null) {
         homqua1 = 0;
     }else{homqua1 = Integer.parseInt(jTable2.getValueAt(0, 0).toString());}   
         BLL.ChuyenDoi.ChuyenSangSo(String.valueOf(homqua1));
         System.out.println(homqua1);
         
         int homqua2;
            if (jTable3.getValueAt(0, 0) == null) {
         homqua2 = 0;
     }else{homqua2 = Integer.parseInt(jTable3.getValueAt(0, 0).toString());}   
         BLL.ChuyenDoi.ChuyenSangSo(String.valueOf(homqua2));
         System.out.println(homqua2);
         
         int homqua3;
            if (jTable4.getValueAt(0, 0) == null) {
         homqua3 = 0;
     }else{homqua3 = Integer.parseInt(jTable4.getValueAt(0, 0).toString());}   
         BLL.ChuyenDoi.ChuyenSangSo(String.valueOf(homqua3));
         System.out.println(homqua3);
         
         int homqua4;
            if (jTable5.getValueAt(0, 0) == null) {
         homqua4 = 0;
     }else{homqua4 = Integer.parseInt(jTable5.getValueAt(0, 0).toString());}   
         BLL.ChuyenDoi.ChuyenSangSo(String.valueOf(homqua4));
         System.out.println(homqua4);
         
         int homqua5;
            if (jTable6.getValueAt(0, 0) == null) {
         homqua5 = 0;
     }else{homqua5 = Integer.parseInt(jTable6.getValueAt(0, 0).toString());}   
         BLL.ChuyenDoi.ChuyenSangSo(String.valueOf(homqua5));
         System.out.println(homqua5);
         
         int homqua6;
            if (jTable7.getValueAt(0, 0) == null) {
         homqua6 = 0;
     }else{homqua6 = Integer.parseInt(jTable7.getValueAt(0, 0).toString());}   
         BLL.ChuyenDoi.ChuyenSangSo(String.valueOf(homqua6));
         System.out.println(homqua6);
            
      
      
         
      dataset.addValue(homnay , "Doanh thu ngày" , ""+homqua6m);
      dataset.addValue( homqua1 , "Doanh thu ngày" , ""+homqua5m );
      dataset.addValue( homqua2 , "Doanh thu ngày" , ""+homqua4m  );
      dataset.addValue( homqua3 , "Doanh thu ngày" , ""+homqua3m );
      dataset.addValue( homqua4 , "Doanh thu ngày" , ""+homqua2m );
      dataset.addValue(homqua5 , "Doanh thu ngày" , ""+homqua1m );
      dataset.addValue( homqua6 , "Doanh thu ngày" , ""+homnaym );
      
      
    
      return dataset;
   }
public void Thongke7ngay(){
     BLL.BLLThongke.HienThiSanPham(jTable1, gethomqua6());
   BLL.BLLThongke.HienThiSanPham(jTable2, gethomqua5());
   BLL.BLLThongke.HienThiSanPham(jTable3, gethomqua4());
   BLL.BLLThongke.HienThiSanPham(jTable4, gethomqua3());
   BLL.BLLThongke.HienThiSanPham(jTable5, gethomqua2());
   BLL.BLLThongke.HienThiSanPham(jTable6, gethomqua1());
   BLL.BLLThongke.HienThiSanPham(jTable7, gethomnay());
     gethomnay();
        gethomqua1();
        gethomqua2();
        gethomqua3();
        gethomqua4();
        gethomqua5();
        gethomqua6();
        
          
         DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
         dtm1.setRowCount(1);
         DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel();
         dtm2.setRowCount(1);
         DefaultTableModel dtm3 = (DefaultTableModel) jTable3.getModel();
         dtm3.setRowCount(1);
         DefaultTableModel dtm4 = (DefaultTableModel) jTable4.getModel();
         dtm4.setRowCount(1);
         DefaultTableModel dtm5 = (DefaultTableModel) jTable5.getModel();
         dtm5.setRowCount(1);
         DefaultTableModel dtm6 = (DefaultTableModel) jTable6.getModel();
         dtm6.setRowCount(1);
         DefaultTableModel dtm7 = (DefaultTableModel) jTable7.getModel();
         dtm7.setRowCount(1);
}
 public String homnaym = gethomnays();
 public String homqua1m = gethomqua1s();
 public String homqua2m = gethomqua2s();
 public String homqua3m = gethomqua3s();
 public String homqua4m = gethomqua4s();
 public String homqua5m = gethomqua5s();
 public String homqua6m = gethomqua6s();
 
   public Date homnay() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -0);
    return cal.getTime();
}
  
 public Date homqua1() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    return cal.getTime();
}
  public Date homqua2() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -2);
    return cal.getTime();
}
   public Date homqua3() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -3);
    return cal.getTime();
}
    public Date homqua4() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -4);
    return cal.getTime();
}
     public Date homqua5() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -5);
    return cal.getTime();
}
      public Date homqua6() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -6);
    return cal.getTime();
}
 
 
 
 
 
 
 
 
 

 
  public  String gethomnays() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        System.out.println(dateFormat.format(homnay()));
        return dateFormat.format(homnay());
}
 public String gethomqua1s() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        System.out.println(dateFormat.format(homqua1()));
        return dateFormat.format(homqua1());
}
 public String gethomqua2s() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        System.out.println(dateFormat.format(homqua2()));
        return dateFormat.format(homqua2());
}
 public String gethomqua3s() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        System.out.println(dateFormat.format(homqua3()));
        return dateFormat.format(homqua3());
}
 public String gethomqua4s() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        System.out.println(dateFormat.format(homqua4()));
        return dateFormat.format(homqua4());
}
 public String gethomqua5s() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        System.out.println(dateFormat.format(homqua5()));
        return dateFormat.format(homqua5());
}
 public String gethomqua6s() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        System.out.println(dateFormat.format(homqua6()));
        return dateFormat.format(homqua6());
}
 
 
   public  String gethomnay() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(homnay()));
        return dateFormat.format(homnay());
}
 public String gethomqua1() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(homqua1()));
        return dateFormat.format(homqua1());
}
 public String gethomqua2() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(homqua2()));
        return dateFormat.format(homqua2());
}
 public String gethomqua3() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(homqua3()));
        return dateFormat.format(homqua3());
}
 public String gethomqua4() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(homqua4()));
        return dateFormat.format(homqua4());
}
 public String gethomqua5() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(homqua5()));
        return dateFormat.format(homqua5());
}
 public String gethomqua6() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(homqua6()));
        return dateFormat.format(homqua6());
}
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblHoatdong1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDoanhthu = new javax.swing.JLabel();
        lblDonhang = new javax.swing.JLabel();
        lblKhachhang = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHoatdong = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanphambanchay = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable2KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable3KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable4KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable5KeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable6KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable7KeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(jTable7);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(jTable1);

        tblHoatdong1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHoatdong1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Người dùng", "Hoạt động", "Ngày", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoatdong1.setRowHeight(25);
        jScrollPane11.setViewportView(tblHoatdong1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(975, 643));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(254, 254));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Tổng quan cửa hàng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Doanh thu:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Hóa đơn:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Khách hàng:");

        lblDoanhthu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDoanhthu.setForeground(new java.awt.Color(255, 51, 0));
        lblDoanhthu.setText("1.000.000.000 đ");

        lblDonhang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDonhang.setForeground(new java.awt.Color(0, 0, 255));
        lblDonhang.setText("13 Đơn");

        lblKhachhang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKhachhang.setForeground(new java.awt.Color(255, 102, 0));
        lblKhachhang.setText("100 Khách hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDonhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblKhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDonhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jPanel4.add(jPanel1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setPreferredSize(new java.awt.Dimension(254, 254));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Thông tin kho hàng");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Dự trữ tối đa:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Tồn kho:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Giá trị tồn kho:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("10000 sản phẩm");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 102, 0));
        jLabel18.setText("500 sản phẩm");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("100.000.000đ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jPanel4.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel20.setText("Nhật ký hoạt động");

        jButton1.setText("Xem chi tiết");
        jButton1.setPreferredSize(new java.awt.Dimension(87, 20));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new java.awt.BorderLayout());

        tblHoatdong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHoatdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Người dùng", "Hoạt động", "Ngày", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoatdong.setRowHeight(25);
        jScrollPane10.setViewportView(tblHoatdong);

        jPanel6.add(jScrollPane10, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel10);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSanphambanchay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Ảnh", "Sản phẩm", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanphambanchay.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblSanphambanchay.setRowHeight(50);
        tblSanphambanchay.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblSanphambanchay);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sản phẩm bán chạy");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyReleased

    private void jTable3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3KeyReleased

    private void jTable4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4KeyReleased

    private void jTable5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5KeyReleased

    private void jTable6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6KeyReleased

    private void jTable7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7KeyReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased

    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      jdlChitiethoatdong hd = new jdlChitiethoatdong(new javax.swing.JFrame(), true);
      hd.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    public static javax.swing.JScrollPane jScrollPane11;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JScrollPane jScrollPane7;
    public static javax.swing.JScrollPane jScrollPane8;
    public static javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    public static javax.swing.JTable jTable3;
    public static javax.swing.JTable jTable4;
    public static javax.swing.JTable jTable5;
    public static javax.swing.JTable jTable6;
    public static javax.swing.JTable jTable7;
    public static javax.swing.JLabel lblDoanhthu;
    public static javax.swing.JLabel lblDonhang;
    public static javax.swing.JLabel lblKhachhang;
    public static javax.swing.JTable tblHoatdong;
    public static javax.swing.JTable tblHoatdong1;
    public static javax.swing.JTable tblSanphambanchay;
    // End of variables declaration//GEN-END:variables
}

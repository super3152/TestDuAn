/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChuyenDoi;
import DAO.DBConection;
import DTO.DTOHoaDon;
import DTO.DTOKhachHang;
import DTO.DTOKho;
import DTO.DTOSanPham;
import DTO.MyCombobox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Takemikazuchi
 */
public class pnlbanhang extends javax.swing.JPanel {

    public static int MaHD;
    public static String SoHoaDon;

    public pnlbanhang() {
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
       
        if (SoHoaDon == null) {
            FillSanPhamHayDung();
            menu.add(panel);
            BLL.BLLKhachHang.DoDuLieuVaoCBBKhachHang(cbbKhachHang);
            BLL.BLLSanPham.DoDuLieuVaoCBBTCSanPham(cbbTatCaSP);
            cbbSize.removeAllItems();
            cbbSize.addItem("Size");
            cbbMau.removeAllItems();
            cbbMau.addItem("Màu");
            cbbSize.setEnabled(false);
            cbbMau.setEnabled(false);
            NgayGio();
        } else {
             FillSanPhamHayDung();
            DTO.DTOHoaDon hd = BLL.BLLHoaDon.GetMaHD(MaHD);
            txtSoHoaDon.setText(SoHoaDon);
            BLL.BLLKhachHang.SetCBBKhachHang(cbbKhachHang, hd.getMaKhachHang());
            txtNgayTao.setText(hd.getNgayTaoHoaDon());
            BLL.BLLHoaDon.DoSanPhamLenLaiHoaDon(tblChiTietHoaDon, MaHD);
            for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
                double UuDai = 0;
                UuDai = UuDai + ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 8).toString());
                txtUuDai.setText(ChuyenDoi.DinhDangTien(UuDai));
            }
            btnChonSP.setEnabled(false);
            cbbTatCaSP.setEnabled(false);
            cbbSize.setEnabled(false);
            cbbMau.setEnabled(false);
            txtSoHoaDon.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtUuDai.setEnabled(false);
            txtTongTien.setEnabled(false);
            btnMuaHang.setEnabled(false);

        }

    }

    pnlbanhang(int MaHD, String SoHoaDon) {
        pnlbanhang.MaHD = MaHD;
        pnlbanhang.SoHoaDon = SoHoaDon;
    }

    public void NgayGio() {
        Thread clock;
        clock = new Thread() {
            @Override
            public void run() {
                while (true) {
                    SimpleDateFormat formattime = new SimpleDateFormat("hh:mm:ss");
                    SimpleDateFormat formatday = new SimpleDateFormat("yyyy/MM/dd");
                    Calendar cal = new GregorianCalendar();
                    String time, day;
                    time = formattime.format(cal.getTime());
                    day = formatday.format(cal.getTime());

                    txtNgayTao.setText(day);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
        };
        clock.start();

    }

    private void FillSanPhamHayDung() {

        jPanel20.removeAll();

        ArrayList<DTOSanPham> sanpham = DAO.DAOHoaDon.GetSanPhamHayDung();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[sanpham.size()];
        JLabel[] lblImgBan = new JLabel[sanpham.size()];
        JLabel[] lblTenBan = new JLabel[sanpham.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < sanpham.size(); i++) {
            checkclick.add(i, false);

            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(sanpham.get(i).getAnhSanPham()).getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH));
            lblImgBan[i].setIcon(imageIcon);
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTenBan[i].setText(sanpham.get(i).getTenSanPham());

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(21, Short.MAX_VALUE))
            );
            pnlBanLayout.setVerticalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImgBan[i])
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTenBan[i])
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            int j = i;
            pnlBan[j].addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    e.getComponent().setBackground(Color.yellow);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        e.getComponent().setBackground(Color.yellow);

                    } else {

                        e.getComponent().setBackground(new java.awt.Color(240, 240, 240));
                    }
                }
            });
            jPanel20.add(pnlBan[i]);
        }
        jPanel20.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        list = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        menu = new javax.swing.JPopupMenu();
        pnlnennhanvienphutrach1 = new javax.swing.JPanel();
        lblnhomkhachhang6 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtHanTraNo = new javax.swing.JTextField();
        pnlnenthemdon = new javax.swing.JPanel();
        txtsodon = new javax.swing.JTextField();
        tbpchuyentab = new javax.swing.JTabbedPane();
        pnlDonHang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMuaHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        pnlnennhomkhachhang4 = new javax.swing.JPanel();
        lblnhomkhachhang8 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        pnlnennhomkhachhang5 = new javax.swing.JPanel();
        lblnhomkhachhang7 = new javax.swing.JLabel();
        txtSoHoaDon = new javax.swing.JTextField();
        pnlnennhomkhachhang3 = new javax.swing.JPanel();
        lblnhomkhachhang9 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        pnlnennhomkhachhang6 = new javax.swing.JPanel();
        lblnhomkhachhang10 = new javax.swing.JLabel();
        txtUuDai = new javax.swing.JTextField();
        pnlnennhomkhachhang7 = new javax.swing.JPanel();
        lblnhomkhachhang11 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        pnlnennhomkhachhang8 = new javax.swing.JPanel();
        lblnhomkhachhang12 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        pnlnennhomkhachhang9 = new javax.swing.JPanel();
        lblnhomkhachhang13 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        pnlnennhomkhachhang10 = new javax.swing.JPanel();
        lblnhomkhachhang14 = new javax.swing.JLabel();
        jdcHanTraCongNo = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInHoaDon = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        cbbTatCaSP = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbMau = new javax.swing.JComboBox<>();
        btnChonSP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        panel.setPreferredSize(new java.awt.Dimension(560, 130));

        list.setBorder(null);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list.setViewportView(jList1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list)
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        pnlnennhanvienphutrach1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach1.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang6.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang6.setText("Ngày tạo");
        lblnhomkhachhang6.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach1.add(lblnhomkhachhang6, java.awt.BorderLayout.PAGE_START);

        txtNgayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayTaoActionPerformed(evt);
            }
        });
        pnlnennhanvienphutrach1.add(txtNgayTao, java.awt.BorderLayout.CENTER);

        txtHanTraNo.setText("jTextField1");

        pnlnenthemdon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsodon.setText("jTextField1");

        setBackground(new java.awt.Color(225, 226, 226));
        setPreferredSize(new java.awt.Dimension(980, 619));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        tbpchuyentab.setBackground(new java.awt.Color(255, 255, 255));
        tbpchuyentab.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tbpchuyentab.setPreferredSize(new java.awt.Dimension(1011, 652));
        tbpchuyentab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpchuyentabMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(266, 70));

        btnMuaHang.setBackground(new java.awt.Color(255, 255, 255));
        btnMuaHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMuaHang.setForeground(new java.awt.Color(255, 255, 255));
        btnMuaHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/thanhtoan.jpg"))); // NOI18N
        btnMuaHang.setText("THANH TOÁN");
        btnMuaHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btnMuaHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CHI TIẾT");

        pnlnennhomkhachhang4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang4.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang8.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang8.setText("Tổng tiền");
        lblnhomkhachhang8.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang4.add(lblnhomkhachhang8, java.awt.BorderLayout.PAGE_START);

        txtTongTien.setEditable(false);
        txtTongTien.setText("0");
        pnlnennhomkhachhang4.add(txtTongTien, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang5.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang5.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang7.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang7.setText("Số Hóa Đơn");
        lblnhomkhachhang7.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang5.add(lblnhomkhachhang7, java.awt.BorderLayout.PAGE_START);

        txtSoHoaDon.setEditable(false);
        pnlnennhomkhachhang5.add(txtSoHoaDon, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang3.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang9.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang9.setText("Khách Hàng");
        lblnhomkhachhang9.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang3.add(lblnhomkhachhang9, java.awt.BorderLayout.PAGE_START);

        cbbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHangActionPerformed(evt);
            }
        });
        pnlnennhomkhachhang3.add(cbbKhachHang, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang6.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang6.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang10.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang10.setText("Chiết khấu (%)");
        lblnhomkhachhang10.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang6.add(lblnhomkhachhang10, java.awt.BorderLayout.PAGE_START);

        txtUuDai.setText("0");
        pnlnennhomkhachhang6.add(txtUuDai, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang7.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang7.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang11.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang11.setText("Tiền khách đưa");
        lblnhomkhachhang11.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang7.add(lblnhomkhachhang11, java.awt.BorderLayout.PAGE_START);

        txtThanhToan.setText("0");
        txtThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhToanActionPerformed(evt);
            }
        });
        txtThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtThanhToanKeyReleased(evt);
            }
        });
        pnlnennhomkhachhang7.add(txtThanhToan, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang8.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang8.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang12.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang12.setText("Tiền thừa");
        lblnhomkhachhang12.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang8.add(lblnhomkhachhang12, java.awt.BorderLayout.PAGE_START);

        txtTienThua.setEditable(false);
        txtTienThua.setText("0");
        pnlnennhomkhachhang8.add(txtTienThua, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang9.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang9.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang13.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang13.setText("Nợ");
        lblnhomkhachhang13.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang9.add(lblnhomkhachhang13, java.awt.BorderLayout.PAGE_START);

        txtNo.setText("0");
        pnlnennhomkhachhang9.add(txtNo, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang10.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang10.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang14.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang14.setText("Hạn trả");
        lblnhomkhachhang14.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang10.add(lblnhomkhachhang14, java.awt.BorderLayout.PAGE_START);

        jdcHanTraCongNo.setDateFormatString("dd/MM/yyyy");
        pnlnennhomkhachhang10.add(jdcHanTraCongNo, java.awt.BorderLayout.CENTER);

        txtInHoaDon.setColumns(20);
        txtInHoaDon.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtInHoaDon.setRows(5);
        txtInHoaDon.setToolTipText("");
        jScrollPane2.setViewportView(txtInHoaDon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnennhomkhachhang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang5, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang6, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang7, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang8, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang9, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang10, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhomkhachhang5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang6, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang7, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang8, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang9, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang10, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(694, 40));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/add_new_34px.png"))); // NOI18N
        jButton2.setText("Thêm đơn");
        jButton2.setBorder(null);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbbTatCaSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTatCaSPItemStateChanged(evt);
            }
        });
        cbbTatCaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTatCaSPMouseClicked(evt);
            }
        });
        cbbTatCaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTatCaSPActionPerformed(evt);
            }
        });

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Size" }));
        cbbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSizeMouseClicked(evt);
            }
        });
        cbbSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbSizeKeyReleased(evt);
            }
        });

        cbbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu" }));
        cbbMau.setToolTipText("");
        cbbMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauActionPerformed(evt);
            }
        });

        btnChonSP.setText("Chon");
        btnChonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSPActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/iris_scan_20px.png"))); // NOI18N
        jButton1.setText("Scanner");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTatCaSP, 0, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMau)
                            .addComponent(cbbSize)
                            .addComponent(cbbTatCaSP)))
                    .addComponent(btnChonSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ảnh", "Mã SP", "Tên SP", "Size", "Màu", "Số lượng", "Đơn giá", "Ưu đãi", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietHoaDon.setRowHeight(60);
        tblChiTietHoaDon.setShowVerticalLines(false);
        tblChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietHoaDon);
        if (tblChiTietHoaDon.getColumnModel().getColumnCount() > 0) {
            tblChiTietHoaDon.getColumnModel().getColumn(0).setMinWidth(0);
            tblChiTietHoaDon.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblChiTietHoaDon.getColumnModel().getColumn(0).setMaxWidth(0);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setMinWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setMaxWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setMinWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Hay Mua");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quần Jean");
        jPanel22.add(jLabel6, java.awt.BorderLayout.PAGE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel13, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel1);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Áo Nike");
        jPanel23.add(jLabel8, java.awt.BorderLayout.PAGE_END);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.add(jLabel9, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel14, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel17);

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sản phẩm");
        jPanel24.add(jLabel10, java.awt.BorderLayout.PAGE_END);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.add(jLabel11, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel15, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel18);

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel25.setLayout(new java.awt.BorderLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sản phẩm");
        jPanel25.add(jLabel12, java.awt.BorderLayout.PAGE_END);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new java.awt.BorderLayout());

        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel26.add(jLabel13, java.awt.BorderLayout.CENTER);

        jPanel25.add(jPanel26, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel19);

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sản phẩm");
        jPanel27.add(jLabel14, java.awt.BorderLayout.PAGE_END);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel28.add(jLabel15, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel28, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel21);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel29.setLayout(new java.awt.BorderLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Sản phẩm");
        jPanel29.add(jLabel16, java.awt.BorderLayout.PAGE_END);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new java.awt.BorderLayout());

        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel30.add(jLabel17, java.awt.BorderLayout.CENTER);

        jPanel29.add(jPanel30, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel10);

        jPanel4.add(jPanel20, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlDonHangLayout = new javax.swing.GroupLayout(pnlDonHang);
        pnlDonHang.setLayout(pnlDonHangLayout);
        pnlDonHangLayout.setHorizontalGroup(
            pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDonHangLayout.createSequentialGroup()
                .addGroup(pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDonHangLayout.setVerticalGroup(
            pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDonHangLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbpchuyentab.addTab("Đơn Số 1", pnlDonHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );

        tbpchuyentab.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnMuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaHangActionPerformed
        int dongDuocChon = tblChiTietHoaDon.getRowCount();
        if (dongDuocChon == 0) {
            ThongBaoCanhBao.ThongBao("Bạn chưa có sản phẩm không thể thanh toán !", "Thông Báo !");
            return;
        }
        DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetTenKH(cbbKhachHang.getSelectedItem().toString());
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            if (BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText()) < BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText())) {
                ThongBaoCanhBao.ThongBao("Khách chưa trả đủ tiền !", "Thông Báo !");
                return;
            }
        }
        if (txtSoHoaDon.getText() != null) {
            String SoHoaDon;
            int MaNV;
            int MaKhachHang;
            int TinhTrang;
            int TraHang;
            double TongTien;

            SoHoaDon = txtSoHoaDon.getText();
            String NgayTaoHD = txtNgayTao.getText();
            MaNV = BLL.BLLHoaDon.LayMaNhanVienString(BLL.BLLlogin.nguoidung.getTenNguoiDung());
            TinhTrang = 0;
            TraHang = 0;
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());

            MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
            MaKhachHang = (int) cbbKH.Value;
            double CongNo = 0;

            DTOHoaDon HD = new DTOHoaDon(SoHoaDon, NgayTaoHD, MaNV, TinhTrang, TongTien, MaKhachHang, TraHang, CongNo);

            BLL.BLLHoaDon.ThemHoaDon(HD);
            DTO.DTOKhachHang lkh = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
            double TongTienHangBang = lkh.getTongTienHang();
            double TongTienHang = TongTienHangBang + TongTien;
            DTO.DTOKhachHang skh = new DTO.DTOKhachHang(MaKhachHang, NgayTaoHD, TongTienHang);
            DTO.DTOKhachHang lkhs = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
            double TongTienHangBangSau = lkhs.getTongTienHang();
            int MaLoaiKhachHang;
            if (lkhs.getIdLoaiKhachHang() == 1) {
                if (TongTienHangBangSau >= 1000000) {
                    MaLoaiKhachHang = 2;
                    DTOKhachHang lkh2 = new DTOKhachHang(MaKhachHang, MaLoaiKhachHang);
                    BLL.BLLKhachHang.SuaLoaiKhachHang(lkh2);
                }
            }
            if (lkhs.getIdLoaiKhachHang() == 2) {
                if (TongTienHangBangSau >= 5000000) {
                    MaLoaiKhachHang = 3;
                    DTOKhachHang lkh3 = new DTOKhachHang(MaKhachHang, MaLoaiKhachHang);
                    BLL.BLLKhachHang.SuaLoaiKhachHang(lkh3);
                }
            }

            BLL.BLLKhachHang.SuaHoaDonKhachHang(skh);
            ThongBaoCanhBao.ThongBao("Đặt hàng thành công !", "Thông Báo !");
            BillHoaDon();

            int MaHD = BLL.BLLHoaDon.LayMaHoaDonString(SoHoaDon);
            for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {

                int MaSP = Integer.parseInt(tblChiTietHoaDon.getValueAt(i, 0).toString());
                int SoLuong = Integer.parseInt(tblChiTietHoaDon.getValueAt(i, 6).toString());
                double ChietKhau = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(i, 8).toString());
                double ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(i, 9).toString());
                String GhiChu = "Mới";
                DTO.DTOChiTietHoaDon cthd = new DTO.DTOChiTietHoaDon(MaHD, MaSP, SoLuong, ThanhTien, ChietKhau, GhiChu);
                BLL.BLLHoaDon.ThemChiTietHoaDon(cthd);

                DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

                int SoLuongTrongBang = sp.getTonKho();
                int SoLuongSauKhiDatHang = SoLuongTrongBang - SoLuong;

                DTOSanPham spp = new DTOSanPham(MaSP, SoLuongSauKhiDatHang);
                BLL.BLLHoaDon.SuaSoLuongChoSP(spp);
                DTO.DTOKho kh = BLL.BLLKho.GetKhoTheoIDSP(MaSP);
                int HangDangVe = kh.getHangDangVe();
                DTOKho stkh = new DTOKho(MaSP, SoLuongSauKhiDatHang, HangDangVe);

                BLL.BLLHoaDon.SuaTonKhoTrongKho(stkh);
            }
        }
        MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
        int MaKhachHang = (int) cbbKH.Value;
        DTO.DTOKhachHang lkh = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
        double CongNoBang = lkh.getCongNo();
        double CongNo = ChuyenDoi.ChuyenSangSo(txtNo.getText());
        double CongNoSua = CongNoBang + CongNo;

        String SoHoaDon = txtSoHoaDon.getText();
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            int TinhTrang = 1;
            DTOHoaDon HD = new DTOHoaDon(SoHoaDon, TinhTrang);
            BLL.BLLHoaDon.SuaTrangThaiHoaDon(HD);
        }
        if (khl.getIdLoaiKhachHang() == 3) {
            if (txtNo.getText().equals("0")) {
                int TinhTrang = 1;
                DTOHoaDon HD = new DTOHoaDon(SoHoaDon, TinhTrang);
                BLL.BLLHoaDon.SuaTrangThaiHoaDon(HD);
            } else {
                int TinhTrang = 2;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String HanTraCongNo = sdf.format(jdcHanTraCongNo.getDate());
                DTOHoaDon HD = new DTOHoaDon(SoHoaDon, TinhTrang, CongNo, HanTraCongNo);
                BLL.BLLHoaDon.SuaTrangThaiHanNoHoaDon(HD);
                DTO.DTOKhachHang skh = new DTO.DTOKhachHang(MaKhachHang, CongNoSua);
                BLL.BLLKhachHang.SuaNoTraHangKhachHang(skh);
            }

        }
        DefaultTableModel dtm = (DefaultTableModel) tblChiTietHoaDon.getModel();
        dtm.setRowCount(0);
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                "Bạn Có Muốn In Hóa Đơn Không ?", //thông báo
                "Thông Báo !", //tiêu đề
                JOptionPane.YES_NO_OPTION, //lựa chọn
                JOptionPane.ERROR_MESSAGE); // icon

        if (ketquasaukhibam == JOptionPane.YES_OPTION) {

            printRecord(txtInHoaDon);

        }
        txtSoHoaDon.setText("");
        txtUuDai.setText("0");
        txtThanhToan.setText("0");
        txtTienThua.setText("0");
        txtNo.setText("0");
        jdcHanTraCongNo.setDate(null);
        txtHanTraNo.setText("");
        txtTongTien.setText("0");
        cbbSize.removeAllItems();
        cbbSize.addItem("Size");
        cbbMau.removeAllItems();
        cbbMau.addItem("Màu");
        cbbSize.setEnabled(false);
        cbbMau.setEnabled(false);
        DefaultTableModel tbModel = (DefaultTableModel) tblChiTietHoaDon.getModel();
        tbModel.setRowCount(0);


    }//GEN-LAST:event_btnMuaHangActionPerformed

    private void tblChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonMouseClicked
        if (SoHoaDon == null) {
            if (evt.getClickCount() == 2) {
                int dongDuocChon = tblChiTietHoaDon.getSelectedRow();
                double ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(dongDuocChon, 9).toString());
                double TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
                TongTien = TongTien - ThanhTien;
                double UuDai = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(dongDuocChon, 8).toString());
                double TongUuDai = BLL.ChuyenDoi.ChuyenTien(txtUuDai.getText());
                TongUuDai = TongUuDai - UuDai;

                txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(TongTien));
                txtUuDai.setText(BLL.ChuyenDoi.DinhDangTien(TongUuDai));

                jdlChinhSanPhamHoaDon jdlCTHD = new jdlChinhSanPhamHoaDon(new javax.swing.JFrame(), true);
                jdlCTHD.setVisible(true);
                try {

                    DefaultTableModel tbModel = (DefaultTableModel) tblChiTietHoaDon.getModel();
                    tbModel.removeRow(dongDuocChon);

                } catch (Exception e) {
                }

            }
        }

    }//GEN-LAST:event_tblChiTietHoaDonMouseClicked

    private void cbbTatCaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTatCaSPActionPerformed
        String TenSP = cbbTatCaSP.getSelectedItem().toString();
        BLL.BLLSanPham.SizeSanPhamTheoTen(cbbSize, TenSP);
        MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
        int MaSize = Integer.parseInt(mbs.Value.toString());
        System.out.println(MaSize);
        BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, TenSP, MaSize);
    }//GEN-LAST:event_cbbTatCaSPActionPerformed

    private void tbpchuyentabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpchuyentabMouseClicked

    }//GEN-LAST:event_tbpchuyentabMouseClicked
 public static int so = 1;

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           
   so++;
   
      JPanel  buttonPanel = new JPanel();
buttonPanel.setSize(new Dimension(974, 587));
         buttonPanel.setLayout(new java.awt.BorderLayout());
         
        tbpchuyentab.addTab("Đơn Số "+so, buttonPanel);
        pnldonbanhang tdh = new pnldonbanhang();
        buttonPanel.add(tdh);
        tbpchuyentab.setSelectedIndex(so-1);
        System.out.println(so-1);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnChonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSPActionPerformed
        if (cbbSize.getSelectedItem().equals("Size")) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn size sản phẩm để mua hàng", "Thông Báo");
            return;
        }
        if (cbbMau.getSelectedItem().equals("Màu")) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn màu sản phẩm để mua hàng", "Thông Báo");
            return;
        }
        String TenSP = cbbTatCaSP.getSelectedItem().toString();
        MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
        int MaSize = Integer.parseInt(mbs.Value.toString());
        MyCombobox mbm = (MyCombobox) cbbMau.getSelectedItem();
        int MaMau = Integer.parseInt(mbm.Value.toString());
        int MaSP = BLL.BLLSanPham.LayMaSanPhamString(TenSP, MaSize, MaMau);
        DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);
        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            int MaSPB = (int) tblChiTietHoaDon.getValueAt(i, 0);
            int SoLuong = (int) tblChiTietHoaDon.getValueAt(i, 6);
            double UuDai = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 8).toString());
            double TongTien = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 9).toString());

            if (MaSP == MaSPB) {
                DefaultTableModel model = (DefaultTableModel) tblChiTietHoaDon.getModel();
                model.removeRow(i);
                double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrung(tblChiTietHoaDon, sp, SoLuong, UuDai);
                double TongTienCu = ChuyenDoi.ChuyenSangSo(txtTongTien.getText());
                double TongTienTru = TongTienCu - TongTien;
                double TongTienMoi = TongTienTru + tongTien;
                txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                cbbSize.setEnabled(false);
                cbbMau.setEnabled(false);
                cbbSize.removeAllItems();
                cbbSize.addItem("Size");
                cbbMau.removeAllItems();
                cbbMau.addItem("Màu");
                return;
            }
        }

        if (sp.getTonKho() <= 0) {
            ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
            return;
        }
        int SoLuong = 1;
        double UuDai = 0;

        double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDon(tblChiTietHoaDon, sp, SoLuong, UuDai);
        txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));
        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            double TongUuDai = BLL.ChuyenDoi.ChuyenTien(txtUuDai.getText());
            txtUuDai.setText(ChuyenDoi.DinhDangTien(TongUuDai));
        }

        if (txtSoHoaDon.getText().equals("")) {

            txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

        }
        cbbSize.setEnabled(false);
        cbbMau.setEnabled(false);
        cbbSize.removeAllItems();
        cbbSize.addItem("Size");
        cbbMau.removeAllItems();
        cbbMau.addItem("Màu");


    }//GEN-LAST:event_btnChonSPActionPerformed

    private void cbbTatCaSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTatCaSPItemStateChanged


    }//GEN-LAST:event_cbbTatCaSPItemStateChanged

    private void cbbTatCaSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTatCaSPMouseClicked
        String TenSP = cbbTatCaSP.getSelectedItem().toString();
        BLL.BLLSanPham.SizeSanPhamTheoTen(cbbSize, TenSP);
        MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
        int MaSize = Integer.parseInt(mbs.Value.toString());
        System.out.println(MaSize);
        BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, TenSP, MaSize);
        cbbSize.setEnabled(true);
        cbbMau.setEnabled(true);

    }//GEN-LAST:event_cbbTatCaSPMouseClicked

    private void cbbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSizeMouseClicked
        String TenSP = cbbTatCaSP.getSelectedItem().toString();
        MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
        int MaSize = Integer.parseInt(mbs.Value.toString());
        System.out.println(MaSize);
        BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, TenSP, MaSize);

        cbbMau.setEnabled(true);
    }//GEN-LAST:event_cbbSizeMouseClicked

    private void cbbSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbSizeKeyReleased
        String TenSP = cbbTatCaSP.getSelectedItem().toString();
        MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
        int MaSize = Integer.parseInt(mbs.Value.toString());
        BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, TenSP, MaSize);
    }//GEN-LAST:event_cbbSizeKeyReleased

    private void cbbMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMauActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GUI.jdlCameraScanners pnl = new GUI.jdlCameraScanners(new javax.swing.JFrame(), true);
        pnl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhToanActionPerformed

    private void txtNgayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayTaoActionPerformed

    private void cbbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHangActionPerformed
        MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
        int MaKhachHang = (int) cbbKH.Value;
        DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            txtNo.setText("0");
            jdcHanTraCongNo.setDate(null);
            txtHanTraNo.setText("");
            jdcHanTraCongNo.setEnabled(false);
        } else if (khl.getIdLoaiKhachHang() == 3) {
            double TongTien, TienTra, No;
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
            TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
            No = TongTien - TienTra;
            txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
            if (TienTra > TongTien) {
                txtNo.setText("0");
            }
            if (txtNo.getText().equals("0")) {
                jdcHanTraCongNo.setDate(null);
                jdcHanTraCongNo.setEnabled(false);
            } else {
                jdcHanTraCongNo.setEnabled(true);
                Date date = new Date();
                jdcHanTraCongNo.setDate(date);
                txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
            }

        }
    }//GEN-LAST:event_cbbKhachHangActionPerformed
    public void BillHoaDon() {
         txtInHoaDon.setFont(txtInHoaDon.getFont().deriveFont(Font.BOLD, 13f));
        String TongTien = txtTongTien.getText();
        String KhachHang = cbbKhachHang.getSelectedItem().toString();
        String SoHoaDon = txtSoHoaDon.getText();
        String NgayTao = txtNgayTao.getText();
        String NhanVien = BLL.BLLlogin.nguoidung.getTenNguoiDung();
        String TienKhachTra = txtThanhToan.getText();
        String TienThua = txtTienThua.getText();
        String No = txtNo.getText();
        String HanTraNo = txtHanTraNo.getText();

        
        txtInHoaDon.setText(txtInHoaDon.getText() + "             SHOP QUẦN ÁO CHÂU NGÂN                         \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "         70 Bà Triệu - TP. Buôn Ma Thuột                        \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "               ĐT: 0905 28 51 51                      \n");
        txtInHoaDon.setFont(txtInHoaDon.getFont().deriveFont(Font.BOLD, 13f));

        txtInHoaDon.setText(txtInHoaDon.getText() + "                   __________                    \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                Phiêu Thanh Toán                       \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
       
        txtInHoaDon.setText(txtInHoaDon.getText() + "Số Hóa Đơn : " + SoHoaDon + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Ngày :" + NgayTao + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Khách Hàng : " + KhachHang + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Nhân Viên : " + NhanVien + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "_________________________________________________\n");
        //Heading
        txtInHoaDon.setText(txtInHoaDon.getText() + "Sản Phẩm" + "\t" + "SL" + "\t" + "Giá" + "\t" + "Ưu Đãi" + "\t" + "Tổng" + "\n");

        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            String TenSP = tblChiTietHoaDon.getValueAt(i, 3).toString();
            String Size = tblChiTietHoaDon.getValueAt(i, 4).toString();
            String Mau = tblChiTietHoaDon.getValueAt(i, 5).toString();
            int SoLuong = (int) tblChiTietHoaDon.getValueAt(i, 6);
            String Gia = tblChiTietHoaDon.getValueAt(i, 7).toString();
            String UuDai = tblChiTietHoaDon.getValueAt(i, 8).toString();
            String ThanhTien = tblChiTietHoaDon.getValueAt(i, 9).toString();
            txtInHoaDon.setText(txtInHoaDon.getText() + "-------------------------------------------------\n");
            txtInHoaDon.setText(txtInHoaDon.getText() + TenSP +"    "+ "\t" + SoLuong + "\t" + Gia + "\t" + UuDai + "\t" + ThanhTien + "\n");
            txtInHoaDon.setText(txtInHoaDon.getText() + Size + "-" + Mau + "\n");
        
        }
        txtInHoaDon.setText(txtInHoaDon.getText() + "_________________________________________________\n");
          txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Thành Tiền : " + TongTien + " VNĐ" + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Tiền Khách Trả : " + TienKhachTra + " VNĐ" + "\n");
        if (!txtTienThua.getText().equals("0")) {
            txtInHoaDon.setText(txtInHoaDon.getText() + "Tiền Thừa : " + TienThua + " VNĐ" + "\n");
        }
        if (!txtNo.getText().equals("0")) {
            txtInHoaDon.setText(txtInHoaDon.getText() + "Tiền Nợ : " + No + " VNĐ" + "\n");
            txtInHoaDon.setText(txtInHoaDon.getText() + "Hạn Trả Nợ : " + HanTraNo + "\n");
        }
        txtInHoaDon.setText(txtInHoaDon.getText() + "                  __________                     \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "               Cảm Ơn Quý Khách            \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                 Hẹn gặp lại               \n");
    }

    private void printRecord(JTextArea label) {
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D) graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX() + 10, pageFormat.getImageableY() + 10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.5, 0.5);

                // Now paint panel as graphics2D
                label.paint(graphics2D);

                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if (returningResult) {
            // Use try catch exeption for failure
            try {
                // Now call print method inside printerJob to print
                printerJob.print();
            } catch (PrinterException printerException) {
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }
    private void txtThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhToanKeyReleased
        double TienTra, TongTien, TienThua, No;
        DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetTenKH(cbbKhachHang.getSelectedItem().toString());
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
            TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
            txtThanhToan.setText(BLL.ChuyenDoi.DinhDangTien(TienTra));
            TienThua = TienTra - TongTien;

            txtTienThua.setText(BLL.ChuyenDoi.DinhDangTien(TienThua));
            if (TienTra < TongTien) {
                txtTienThua.setText("0");
            }
        } else if (khl.getIdLoaiKhachHang() == 3) {
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
            TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
            txtThanhToan.setText(BLL.ChuyenDoi.DinhDangTien(TienTra));
            TienThua = TienTra - TongTien;
            No = TongTien - TienTra;
            txtTienThua.setText(BLL.ChuyenDoi.DinhDangTien(TienThua));
            txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
            if (TienThua < 0) {
                txtTienThua.setText("0");
            }
            if (No < 0) {
                txtNo.setText("0");
            }
            if (txtNo.getText().equals("0")) {
                jdcHanTraCongNo.setDate(null);
                jdcHanTraCongNo.setEnabled(false);
            } else {
                jdcHanTraCongNo.setEnabled(true);
                Date date = new Date();
                jdcHanTraCongNo.setDate(date);
                txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
            }

        }
    }//GEN-LAST:event_txtThanhToanKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonSP;
    private javax.swing.JButton btnMuaHang;
    public static javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTatCaSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static com.toedter.calendar.JDateChooser jdcHanTraCongNo;
    private javax.swing.JLabel lblnhomkhachhang10;
    private javax.swing.JLabel lblnhomkhachhang11;
    private javax.swing.JLabel lblnhomkhachhang12;
    private javax.swing.JLabel lblnhomkhachhang13;
    private javax.swing.JLabel lblnhomkhachhang14;
    private javax.swing.JLabel lblnhomkhachhang6;
    private javax.swing.JLabel lblnhomkhachhang7;
    private javax.swing.JLabel lblnhomkhachhang8;
    private javax.swing.JLabel lblnhomkhachhang9;
    private javax.swing.JScrollPane list;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pnlDonHang;
    private javax.swing.JPanel pnlnennhanvienphutrach1;
    private javax.swing.JPanel pnlnennhomkhachhang10;
    private javax.swing.JPanel pnlnennhomkhachhang3;
    private javax.swing.JPanel pnlnennhomkhachhang4;
    private javax.swing.JPanel pnlnennhomkhachhang5;
    private javax.swing.JPanel pnlnennhomkhachhang6;
    private javax.swing.JPanel pnlnennhomkhachhang7;
    private javax.swing.JPanel pnlnennhomkhachhang8;
    private javax.swing.JPanel pnlnennhomkhachhang9;
    public static javax.swing.JPanel pnlnenthemdon;
    public static javax.swing.JTable tblChiTietHoaDon;
    public static javax.swing.JTabbedPane tbpchuyentab;
    private javax.swing.JTextField txtHanTraNo;
    private javax.swing.JTextArea txtInHoaDon;
    public static javax.swing.JTextField txtNgayTao;
    public static javax.swing.JTextField txtNo;
    public static javax.swing.JTextField txtSoHoaDon;
    public static javax.swing.JTextField txtThanhToan;
    public static javax.swing.JTextField txtTienThua;
    public static javax.swing.JTextField txtTongTien;
    public static javax.swing.JTextField txtUuDai;
    public static javax.swing.JTextField txtsodon;
    // End of variables declaration//GEN-END:variables

}

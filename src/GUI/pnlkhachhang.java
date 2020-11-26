/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import DTO.DTOKhachHang;
import DTO.DTOLoaiKhachHang;
import DTO.MyCombobox;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Takemikazuchi
 */
public final class pnlkhachhang extends javax.swing.JPanel {

    private void FillKhachHang() {

        pnlloaikhachhang.removeAll();

        DefaultTableModel dtm = (DefaultTableModel) tblkhachhang.getModel();
        dtm.setRowCount(0);

        ArrayList<DTOLoaiKhachHang> loaikhachhang = DAO.DAOLoaiKhachHang.GetLoaiKhachHang();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[loaikhachhang.size()];
        JLabel[] lblImgBan = new JLabel[loaikhachhang.size()];
        JLabel[] lblTenBan = new JLabel[loaikhachhang.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < loaikhachhang.size(); i++) {
            checkclick.add(i, false);
            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTenBan[i].setText(loaikhachhang.get(i).getTenLoaiKhachHang());

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                public void mousePressed(MouseEvent e) {
                    if (checkclick.get(j)) {
                        checkclick.set(j, false);

                        e.getComponent().setBackground(Color.yellow);
                    } else {
                        checkclick.set(j, true);
                        BLL.BLLKhachHang.HienThiKhachHangTheoMa(tblkhachhang, loaikhachhang.get(j).getIdLoaiKhachHang());
                        for (int k = 0; k < loaikhachhang.size(); k++) {
                            if (k != j) {
                                checkclick.set(k, false);
                                pnlBan[k].setBackground(new java.awt.Color(240, 240, 240));
                            }
                        }
                    }
                }

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
            pnlloaikhachhang.add(pnlBan[i]);
        }
        pnlloaikhachhang.updateUI();
    }

    public pnlkhachhang() {
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
         
         Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        jdcNgaySinh.setDate(date);
        FillKhachHang();
         BLL.BLLKhachHang.HienThiKhachHang(tblkhachhang, txtTimKiem.getText());
        txtIdNguoiDung.setText(Integer.toString(BLL.BLLlogin.nguoidung.getIdNguoiDung()));
        txtNhanVien.setText(BLL.BLLlogin.nguoidung.getTenNguoiDung());
        BLL.BLLKhachHang.DoDuLieuVaoCBBLoaiKhachHang(cbbLoaiKhachHang);     
        
        
        cbbloaikhachhang.setBackground(Color.WHITE);
      
      
       
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmKhachHang = new javax.swing.JPopupMenu();
        mniXoaKhachHang = new javax.swing.JMenuItem();
        tbpchuyentab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnldanhsach = new javax.swing.JPanel();
        cbbloaikhachhang = new javax.swing.JComboBox<>();
        srcdanhsach = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        pnlloaikhachhang = new javax.swing.JPanel();
        lblloaikhachhang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlthemsuakhachhang = new javax.swing.JPanel();
        pnlnenthemsuakhachhang1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac2 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac = new javax.swing.JPanel();
        pnlnenthongtinkhac = new javax.swing.JPanel();
        lblthongtinkhac = new javax.swing.JLabel();
        pnlnennhomkhachhang = new javax.swing.JPanel();
        lblnhomkhachhang = new javax.swing.JLabel();
        cbbLoaiKhachHang = new javax.swing.JComboBox<>();
        pnlnennhanvienphutrach = new javax.swing.JPanel();
        lblnhanvienphutrach = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        pnlnenmota = new javax.swing.JPanel();
        lblmota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextPane();
        pnlnenlonthongtincoban = new javax.swing.JPanel();
        pnlnenlonngoaithongtin = new javax.swing.JPanel();
        pnlnenngoaithongtin = new javax.swing.JPanel();
        pnlnenthongtin = new javax.swing.JPanel();
        lblthongtincoban = new javax.swing.JLabel();
        pnlnenmatkhau = new javax.swing.JPanel();
        lblmatkhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        pnlemail = new javax.swing.JPanel();
        lblemail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlnensodienthoai = new javax.swing.JPanel();
        lblsodienthoai = new javax.swing.JLabel();
        txtsodienthoai = new javax.swing.JTextField();
        pnlnenhotenkhachhang = new javax.swing.JPanel();
        lblhotenkhachhang = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblthongtinbosung = new javax.swing.JLabel();
        pnlnenid = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        pnlnenmangxahoi = new javax.swing.JPanel();
        lblmangxahoi = new javax.swing.JLabel();
        txtMangXaHoi = new javax.swing.JTextField();
        pnlnengioitinh = new javax.swing.JPanel();
        lblgioitinh = new javax.swing.JLabel();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        pnlnenngaysinh = new javax.swing.JPanel();
        lblngaysinh = new javax.swing.JLabel();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblthongtindiachi = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtIdNguoiDung = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtTag = new javax.swing.JTextField();
        pnlnentinh = new javax.swing.JPanel();
        lbltinh = new javax.swing.JLabel();
        cbbtinh = new javax.swing.JComboBox<>();
        pnlnendiachi = new javax.swing.JPanel();
        lbldiachihientai = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        pnlnenngoaibtn = new javax.swing.JPanel();
        pnlnenbtn = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        FileChooser = new javax.swing.JFileChooser();

        mniXoaKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/delete_20px.png"))); // NOI18N
        mniXoaKhachHang.setText("Xóa khách hàng");
        mniXoaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaKhachHangActionPerformed(evt);
            }
        });
        ppmKhachHang.add(mniXoaKhachHang);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 620));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        tbpchuyentab.setBackground(new java.awt.Color(255, 255, 255));
        tbpchuyentab.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnldanhsach.setBackground(new java.awt.Color(255, 255, 255));
        pnldanhsach.setForeground(new java.awt.Color(255, 255, 255));
        pnldanhsach.setPreferredSize(new java.awt.Dimension(980, 618));

        cbbloaikhachhang.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbbloaikhachhang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc khách hàng" }));
        cbbloaikhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbbloaikhachhang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbbloaikhachhang.setFocusCycleRoot(true);
        cbbloaikhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbloaikhachhangActionPerformed(evt);
            }
        });

        tblkhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblkhachhang.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", "", "", null},
                {"", "", "", "", "", "", null},
                {"", "", "", "", "", null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số Điện Thoại", "Email", "Ngày Sinh", "Địa Chỉ", "Giới Tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblkhachhang.setDragEnabled(true);
        tblkhachhang.setFocusable(false);
        tblkhachhang.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblkhachhang.setName(""); // NOI18N
        tblkhachhang.setRowHeight(40);
        tblkhachhang.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblkhachhang.setShowVerticalLines(false);
        tblkhachhang.getTableHeader().setReorderingAllowed(false);
        tblkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachhangMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblkhachhangMouseReleased(evt);
            }
        });
        srcdanhsach.setViewportView(tblkhachhang);

        txtTimKiem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        pnlloaikhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlloaikhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblloaikhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblloaikhachhang.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblloaikhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblloaikhachhang.setText("Loại khách hàng");
        lblloaikhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/delete_20px_1.png"))); // NOI18N
        jButton1.setText("Xóa K.Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenance_20px.png"))); // NOI18N
        jButton2.setText("Sửa K.Hàng");

        jButton3.setText("Thêm loại KH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Chi Tiết Khách Hàng");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnldanhsachLayout = new javax.swing.GroupLayout(pnldanhsach);
        pnldanhsach.setLayout(pnldanhsachLayout);
        pnldanhsachLayout.setHorizontalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addComponent(lblloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cbbloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem))
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addComponent(pnlloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jSeparator4)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(srcdanhsach, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
        );
        pnldanhsachLayout.setVerticalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addComponent(pnlloaikhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(srcdanhsach, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)))
        );

        cbbloaikhachhang.getAccessibleContext().setAccessibleParent(cbbloaikhachhang);

        jPanel2.add(pnldanhsach, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );

        tbpchuyentab.addTab("Danh Sách Khách Hàng", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/list_20px.png")), jPanel1); // NOI18N

        pnlnenthemsuakhachhang1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaianhdaidienvathongtinkhac1.setPreferredSize(new java.awt.Dimension(275, 550));
        pnlnenngoaianhdaidienvathongtinkhac1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac.setPreferredSize(new java.awt.Dimension(275, 300));
        pnlnenngoaianhdaidienvathongtinkhac.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtinkhac2.setBackground(new java.awt.Color(255, 255, 0));
        pnlnenngoaithongtinkhac2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(244, 246, 248), 5, true));
        pnlnenngoaithongtinkhac2.setPreferredSize(new java.awt.Dimension(275, 310));

        pnlnenngoaithongtinkhac1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaithongtinkhac1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenngoaithongtinkhac1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtinkhac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        pnlnenthongtinkhac.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtinkhac.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblthongtinkhac.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtinkhac.setText("Thông tin khác");
        lblthongtinkhac.setPreferredSize(new java.awt.Dimension(34, 20));

        pnlnennhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang.setText("Nhóm khách hàng");
        lblnhomkhachhang.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang.add(lblnhomkhachhang, java.awt.BorderLayout.PAGE_START);

        cbbLoaiKhachHang.setToolTipText("");
        pnlnennhomkhachhang.add(cbbLoaiKhachHang, java.awt.BorderLayout.CENTER);

        pnlnennhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach.setLayout(new java.awt.BorderLayout());

        lblnhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        lblnhanvienphutrach.setText("Nhân viên phụ trách");
        lblnhanvienphutrach.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach.add(lblnhanvienphutrach, java.awt.BorderLayout.PAGE_START);
        pnlnennhanvienphutrach.add(txtNhanVien, java.awt.BorderLayout.CENTER);

        pnlnenmota.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmota.setLayout(new java.awt.BorderLayout());

        lblmota.setBackground(new java.awt.Color(255, 255, 255));
        lblmota.setText("Mô tả");
        lblmota.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnenmota.add(lblmota, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(txtMoTa);

        pnlnenmota.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlnenthongtinkhacLayout = new javax.swing.GroupLayout(pnlnenthongtinkhac);
        pnlnenthongtinkhac.setLayout(pnlnenthongtinkhacLayout);
        pnlnenthongtinkhacLayout.setHorizontalGroup(
            pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinkhacLayout.createSequentialGroup()
                .addGroup(pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblthongtinkhac, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlnenthongtinkhacLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlnennhomkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlnennhanvienphutrach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlnenmota, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlnenthongtinkhacLayout.setVerticalGroup(
            pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinkhacLayout.createSequentialGroup()
                .addComponent(lblthongtinkhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhomkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhanvienphutrach, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnenmota, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlnenngoaithongtinkhacLayout = new javax.swing.GroupLayout(pnlnenngoaithongtinkhac);
        pnlnenngoaithongtinkhac.setLayout(pnlnenngoaithongtinkhacLayout);
        pnlnenngoaithongtinkhacLayout.setHorizontalGroup(
            pnlnenngoaithongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthongtinkhac, javax.swing.GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
        );
        pnlnenngoaithongtinkhacLayout.setVerticalGroup(
            pnlnenngoaithongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthongtinkhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenngoaithongtinkhac1.add(pnlnenngoaithongtinkhac, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlnenngoaithongtinkhac2Layout = new javax.swing.GroupLayout(pnlnenngoaithongtinkhac2);
        pnlnenngoaithongtinkhac2.setLayout(pnlnenngoaithongtinkhac2Layout);
        pnlnenngoaithongtinkhac2Layout.setHorizontalGroup(
            pnlnenngoaithongtinkhac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenngoaithongtinkhac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlnenngoaithongtinkhac2Layout.setVerticalGroup(
            pnlnenngoaithongtinkhac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenngoaithongtinkhac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenngoaianhdaidienvathongtinkhac.add(pnlnenngoaithongtinkhac2, java.awt.BorderLayout.CENTER);

        pnlnenngoaianhdaidienvathongtinkhac1.add(pnlnenngoaianhdaidienvathongtinkhac, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang1.add(pnlnenngoaianhdaidienvathongtinkhac1, java.awt.BorderLayout.EAST);

        pnlnenlonthongtincoban.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonthongtincoban.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 246, 248), 5));
        pnlnenlonthongtincoban.setPreferredSize(new java.awt.Dimension(700, 550));
        pnlnenlonthongtincoban.setLayout(new java.awt.BorderLayout());

        pnlnenlonngoaithongtin.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonngoaithongtin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenlonngoaithongtin.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        pnlnenngoaithongtin.setLayout(new java.awt.BorderLayout());

        pnlnenthongtin.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblthongtincoban.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtincoban.setText("Thông tin cơ bản");

        pnlnenmatkhau.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmatkhau.setLayout(new java.awt.BorderLayout());

        lblmatkhau.setBackground(new java.awt.Color(255, 255, 255));
        lblmatkhau.setText("Mật khẩu");
        lblmatkhau.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenmatkhau.add(lblmatkhau, java.awt.BorderLayout.PAGE_START);
        pnlnenmatkhau.add(txtMatKhau, java.awt.BorderLayout.CENTER);

        pnlemail.setBackground(new java.awt.Color(255, 255, 255));
        pnlemail.setLayout(new java.awt.BorderLayout());

        lblemail.setBackground(new java.awt.Color(255, 255, 255));
        lblemail.setText("Email");
        lblemail.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlemail.add(lblemail, java.awt.BorderLayout.PAGE_START);
        pnlemail.add(txtEmail, java.awt.BorderLayout.CENTER);

        pnlnensodienthoai.setBackground(new java.awt.Color(255, 255, 255));
        pnlnensodienthoai.setLayout(new java.awt.BorderLayout());

        lblsodienthoai.setBackground(new java.awt.Color(255, 255, 255));
        lblsodienthoai.setText("Số điện thoại");
        lblsodienthoai.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnensodienthoai.add(lblsodienthoai, java.awt.BorderLayout.PAGE_START);
        pnlnensodienthoai.add(txtsodienthoai, java.awt.BorderLayout.CENTER);

        pnlnenhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang.setText("Họ tên khách hàng");
        lblhotenkhachhang.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang.add(lblhotenkhachhang, java.awt.BorderLayout.PAGE_START);

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        pnlnenhotenkhachhang.add(txtHoTen, java.awt.BorderLayout.CENTER);

        lblthongtinbosung.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtinbosung.setText("Thông tin bổ sung");

        pnlnenid.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenid.setLayout(new java.awt.BorderLayout());

        lblid.setBackground(new java.awt.Color(255, 255, 255));
        lblid.setText("ID");
        lblid.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenid.add(lblid, java.awt.BorderLayout.PAGE_START);

        txtId.setEditable(false);
        pnlnenid.add(txtId, java.awt.BorderLayout.CENTER);

        pnlnenmangxahoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmangxahoi.setLayout(new java.awt.BorderLayout());

        lblmangxahoi.setBackground(new java.awt.Color(255, 255, 255));
        lblmangxahoi.setText("Mạng xã hội");
        lblmangxahoi.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlnenmangxahoi.add(lblmangxahoi, java.awt.BorderLayout.PAGE_START);
        pnlnenmangxahoi.add(txtMangXaHoi, java.awt.BorderLayout.CENTER);

        pnlnengioitinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlnengioitinh.setLayout(new java.awt.BorderLayout());

        lblgioitinh.setBackground(new java.awt.Color(255, 255, 255));
        lblgioitinh.setText("Giới tính");
        lblgioitinh.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnengioitinh.add(lblgioitinh, java.awt.BorderLayout.PAGE_START);

        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        pnlnengioitinh.add(cbbGioiTinh, java.awt.BorderLayout.CENTER);

        pnlnenngaysinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngaysinh.setLayout(new java.awt.BorderLayout());

        lblngaysinh.setBackground(new java.awt.Color(255, 255, 255));
        lblngaysinh.setText("Ngày sinh");
        lblngaysinh.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenngaysinh.add(lblngaysinh, java.awt.BorderLayout.PAGE_START);

        jdcNgaySinh.setDateFormatString("dd/MM/yyyy");
        pnlnenngaysinh.add(jdcNgaySinh, java.awt.BorderLayout.CENTER);

        lblthongtindiachi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtindiachi.setText("Thông tin địa chỉ");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ID Người Dùng");
        jLabel17.setPreferredSize(new java.awt.Dimension(52, 20));
        jPanel39.add(jLabel17, java.awt.BorderLayout.PAGE_START);

        txtIdNguoiDung.setEditable(false);
        jPanel39.add(txtIdNguoiDung, java.awt.BorderLayout.CENTER);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tag");
        jLabel18.setPreferredSize(new java.awt.Dimension(31, 20));
        jPanel40.add(jLabel18, java.awt.BorderLayout.PAGE_START);
        jPanel40.add(txtTag, java.awt.BorderLayout.CENTER);

        pnlnentinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlnentinh.setLayout(new java.awt.BorderLayout());

        lbltinh.setBackground(new java.awt.Color(255, 255, 255));
        lbltinh.setText("Tỉnh");
        lbltinh.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnentinh.add(lbltinh, java.awt.BorderLayout.PAGE_START);

        cbbtinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Tĩnh", "Hải Dương", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", "Phú Yên", "Cần Thơ", "Đà Nẵng", "Hải Phòng", "Hà Nội", "TP HCM" }));
        cbbtinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtinhActionPerformed(evt);
            }
        });
        cbbtinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbtinhKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbtinhKeyReleased(evt);
            }
        });
        pnlnentinh.add(cbbtinh, java.awt.BorderLayout.CENTER);

        pnlnendiachi.setBackground(new java.awt.Color(255, 255, 255));
        pnlnendiachi.setLayout(new java.awt.BorderLayout());

        lbldiachihientai.setBackground(new java.awt.Color(255, 255, 255));
        lbldiachihientai.setText("Địa chỉ hiện tại (Xã, Phường - Quận, Huyện) *");
        lbldiachihientai.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnendiachi.add(lbldiachihientai, java.awt.BorderLayout.PAGE_START);
        pnlnendiachi.add(txtDiaChi, java.awt.BorderLayout.CENTER);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout pnlnenthongtinLayout = new javax.swing.GroupLayout(pnlnenthongtin);
        pnlnenthongtin.setLayout(pnlnenthongtinLayout);
        pnlnenthongtinLayout.setHorizontalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlemail, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnenmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnensodienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(lblthongtincoban, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnenmangxahoi, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnenid, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnenngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnengioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(lblthongtinbosung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnendiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnentinh, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(lblthongtindiachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlnenthongtinLayout.setVerticalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblthongtincoban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnensodienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnenmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(pnlemail, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtinbosung, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnengioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(pnlnenngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnenid, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(pnlnenmangxahoi, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtindiachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnentinh, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(pnlnendiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlnenngoaithongtin.add(pnlnenthongtin, java.awt.BorderLayout.CENTER);

        pnlnenlonngoaithongtin.add(pnlnenngoaithongtin, java.awt.BorderLayout.CENTER);

        pnlnenlonthongtincoban.add(pnlnenlonngoaithongtin, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang1.add(pnlnenlonthongtincoban, java.awt.BorderLayout.CENTER);

        pnlnenngoaibtn.setPreferredSize(new java.awt.Dimension(975, 40));

        pnlnenbtn.setBackground(new java.awt.Color(244, 246, 248));

        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/checkmark_20px.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenance_20px.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/available_updates_20px.png"))); // NOI18N
        btnlammoi.setText("Làm mới");
        btnlammoi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnlnenbtnLayout = new javax.swing.GroupLayout(pnlnenbtn);
        pnlnenbtn.setLayout(pnlnenbtnLayout);
        pnlnenbtnLayout.setHorizontalGroup(
            pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenbtnLayout.createSequentialGroup()
                .addContainerGap(593, Short.MAX_VALUE)
                .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        pnlnenbtnLayout.setVerticalGroup(
            pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenbtnLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout pnlnenngoaibtnLayout = new javax.swing.GroupLayout(pnlnenngoaibtn);
        pnlnenngoaibtn.setLayout(pnlnenngoaibtnLayout);
        pnlnenngoaibtnLayout.setHorizontalGroup(
            pnlnenngoaibtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlnenngoaibtnLayout.setVerticalGroup(
            pnlnenngoaibtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenthemsuakhachhang1.add(pnlnenngoaibtn, java.awt.BorderLayout.PAGE_END);

        FileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlthemsuakhachhangLayout = new javax.swing.GroupLayout(pnlthemsuakhachhang);
        pnlthemsuakhachhang.setLayout(pnlthemsuakhachhangLayout);
        pnlthemsuakhachhangLayout.setHorizontalGroup(
            pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthemsuakhachhang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlthemsuakhachhangLayout.createSequentialGroup()
                    .addGap(487, 487, 487)
                    .addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(488, Short.MAX_VALUE)))
        );
        pnlthemsuakhachhangLayout.setVerticalGroup(
            pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthemsuakhachhang1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
            .addGroup(pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlthemsuakhachhangLayout.createSequentialGroup()
                    .addGap(293, 293, 293)
                    .addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(293, Short.MAX_VALUE)))
        );

        tbpchuyentab.addTab("Thêm - Sửa khách hàng", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenancde_20px.png")), pnlthemsuakhachhang); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbloaikhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbloaikhachhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbloaikhachhangActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        String HoTen = txtHoTen.getText();
        String SoDienThoai = txtsodienthoai.getText();
        String Email = txtEmail.getText();
        String MatKhau = txtMatKhau.getText();
        String DiaChi = txtDiaChi.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String NgaySinh = sdf.format(jdcNgaySinh.getDate());
        String GioiTinh;
        if (cbbGioiTinh.getSelectedItem().toString().equals("Nam")) {
            GioiTinh = "1";
        } else {
            GioiTinh = "0";
        }
        MyCombobox mb = (MyCombobox) cbbLoaiKhachHang.getSelectedItem();
        int MaLoaiKhachHang = Integer.parseInt(mb.Value.toString());
        int MaNguoiDung = Integer.parseInt(txtIdNguoiDung.getText());
        String MangXaHoi = txtMangXaHoi.getText();
        
        if (jdcNgaySinh.getDate() == null) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn chọn ngày sinh", "Thông báo");
            return;
        }
        String Tag = txtTag.getText();
        String MoTa = txtMoTa.getText();
        if (BLL.BLLKhachHang.KiemTraThemKhachHang(HoTen, SoDienThoai, Email, MatKhau, NgaySinh, DiaChi, MangXaHoi, Tag, MoTa)) {
            DTOKhachHang kh = new DTOKhachHang(MaLoaiKhachHang, MaNguoiDung, HoTen, SoDienThoai, Email, MatKhau, NgaySinh, DiaChi, GioiTinh, MangXaHoi, MoTa, Tag);
            BLL.BLLKhachHang.ThemKhachHang(kh);
            ThongBaoCanhBao.ThongBao("Thêm khách hàng thành công", "Thông báo");

            BLL.BLLKhachHang.HienThiKhachHang(tblkhachhang,txtTimKiem.getText());
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void tblkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachhangMouseClicked
        int Dongduocchon = tblkhachhang.getSelectedRow();
        TableModel model = tblkhachhang.getModel();
        if (evt.getClickCount() == 2) {
            if (Dongduocchon >= 0) {
                int MaKH = Integer.parseInt(tblkhachhang.getValueAt(Dongduocchon, 0).toString());
                DTOKhachHang kh = BLL.BLLKhachHang.GetMaKH(MaKH);
                txtHoTen.setText(kh.getTenKhachHang());
                txtsodienthoai.setText(kh.getSoDienThoai() + "");
                txtEmail.setText(kh.getEmail());
                txtMatKhau.setText(kh.getMatKhau());
                txtDiaChi.setText(kh.getDiaChi());
                System.out.println((tblkhachhang.getValueAt(Dongduocchon, 4).toString()));
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tblkhachhang.getValueAt(Dongduocchon, 4));
                    jdcNgaySinh.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (kh.getGioiTinh().equals("1")) {
                    cbbGioiTinh.setSelectedItem("Nam");
                } else {
                    cbbGioiTinh.setSelectedItem("Nữ");
                }
                txtMangXaHoi.setText(kh.getMangXaHoi());
                txtId.setText(kh.getIdKhachHang() + "");
                BLL.BLLKhachHang.SetCBBLoaiKhachHang(cbbLoaiKhachHang, kh.getIdLoaiKhachHang());
                txtTag.setText(kh.getTag());
                txtMoTa.setText(kh.getMoTa());
                tbpchuyentab.setSelectedIndex(1);

            }
        }
    }//GEN-LAST:event_tblkhachhangMouseClicked
    public static File FILE;
    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileChooserActionPerformed

    private void cbbtinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbtinhActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed


    }//GEN-LAST:event_txtTimKiemKeyPressed


    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped


    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int kq = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn xóa khách hàng này không?",
                "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {

            int cacDong[] = tblkhachhang.getSelectedRows();
            for (int i = 0; i < cacDong.length; i++) {
                int maKH = Integer.parseInt(tblkhachhang.getValueAt(cacDong[i], 0).toString());
                DAO.DAOKhachHang.XoaKhachHang(maKH);
            }
        }
        BLL.BLLKhachHang.HienThiKhachHang(tblkhachhang,txtTimKiem.getText());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblkhachhangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachhangMouseReleased
        if (evt.isPopupTrigger()) {
            ppmKhachHang.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblkhachhangMouseReleased

    private void mniXoaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaKhachHangActionPerformed
        int kq = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn xóa khách hàng này không?",
                "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {

            int cacDong[] = tblkhachhang.getSelectedRows();
            for (int i = 0; i < cacDong.length; i++) {
                int maKH = Integer.parseInt(tblkhachhang.getValueAt(cacDong[i], 0).toString());
                DAO.DAOKhachHang.XoaKhachHang(maKH);
            }
        }
       BLL.BLLKhachHang.HienThiKhachHang(tblkhachhang,txtTimKiem.getText());
    }//GEN-LAST:event_mniXoaKhachHangActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int MaKhachHang = Integer.parseInt(txtId.getText());
        String HoTen = txtHoTen.getText();
        String SoDienThoai = txtsodienthoai.getText();
        String Email = txtEmail.getText();
        String MatKhau = txtMatKhau.getText();
        String DiaChi = txtDiaChi.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String NgaySinh = sdf.format(jdcNgaySinh.getDate());
        String GioiTinh;
        if (cbbGioiTinh.getSelectedItem().toString().equals("Nam")) {
            GioiTinh = "1";
        } else {
            GioiTinh = "0";
        }
        MyCombobox mb = (MyCombobox) cbbLoaiKhachHang.getSelectedItem();
        int MaLoaiKhachHang = Integer.parseInt(mb.Value.toString());
        int MaNguoiDung = Integer.parseInt(txtIdNguoiDung.getText());
        String MangXaHoi = txtMangXaHoi.getText();
        if (jdcNgaySinh.getDate() == null) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn chọn ngày sinh", "Thông báo");
            return;
        }
        String Tag = txtTag.getText();
        String MoTa = txtMoTa.getText();
        if (BLL.BLLKhachHang.KiemTraThemKhachHang(HoTen, SoDienThoai, Email, MatKhau, NgaySinh, DiaChi, MangXaHoi, Tag, MoTa)) {
            DTOKhachHang kh = new DTOKhachHang(MaKhachHang,MaLoaiKhachHang, MaNguoiDung, HoTen, SoDienThoai, Email, MatKhau, NgaySinh, DiaChi, GioiTinh, MangXaHoi, MoTa, Tag);
            BLL.BLLKhachHang.SuaKhachHang(kh);
            ThongBaoCanhBao.ThongBao("Sửa khách hàng thành công", "Thông báo");

            BLL.BLLKhachHang.HienThiKhachHang(tblkhachhang,txtTimKiem.getText());
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void cbbtinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbtinhKeyReleased
         String Tinh;

        Tinh = cbbtinh.getSelectedItem().toString();
        txtDiaChi.setText(""+Tinh);
    }//GEN-LAST:event_cbbtinhKeyReleased

    private void cbbtinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbtinhKeyPressed
        String Tinh;

        Tinh = cbbtinh.getSelectedItem().toString();
        txtDiaChi.setText(""+Tinh);
    }//GEN-LAST:event_cbbtinhKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       jdlLoaiKhacHang jdlLKH = new jdlLoaiKhacHang(new javax.swing.JFrame(), true);
        jdlLKH.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         int dongduocchon = tblkhachhang.getSelectedRow();
        if (dongduocchon < 0) {
            ThongBaoCanhBao.ThongBao("Bạn Chưa Chọn Khách Hàng !", "Thông Báo");
            return;
        }
        int MaKH = Integer.parseInt(tblkhachhang.getValueAt(dongduocchon, 0).toString());
        new pnlChiTietKhachHang(MaKH).setVisible(true);
        pnldanhsach.setVisible(false);
        pnlChiTietKhachHang ctkh = new pnlChiTietKhachHang();
        jPanel2.add(ctkh);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
     BLL.BLLKhachHang.HienThiKhachHang(tblkhachhang, txtTimKiem.getText());
    }//GEN-LAST:event_txtTimKiemKeyReleased
    public static boolean saveLogo(File file) {
        File dir = new File("logos");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JComboBox<String> cbbLoaiKhachHang;
    private javax.swing.JComboBox<String> cbbloaikhachhang;
    private javax.swing.JComboBox<String> cbbtinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JLabel lbldiachihientai;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblgioitinh;
    public static javax.swing.JLabel lblhotenkhachhang;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblloaikhachhang;
    private javax.swing.JLabel lblmangxahoi;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblmota;
    private javax.swing.JLabel lblngaysinh;
    private javax.swing.JLabel lblnhanvienphutrach;
    private javax.swing.JLabel lblnhomkhachhang;
    private javax.swing.JLabel lblsodienthoai;
    private javax.swing.JLabel lblthongtinbosung;
    private javax.swing.JLabel lblthongtincoban;
    private javax.swing.JLabel lblthongtindiachi;
    private javax.swing.JLabel lblthongtinkhac;
    private javax.swing.JLabel lbltinh;
    private javax.swing.JMenuItem mniXoaKhachHang;
    public static javax.swing.JPanel pnldanhsach;
    private javax.swing.JPanel pnlemail;
    private javax.swing.JPanel pnlloaikhachhang;
    private javax.swing.JPanel pnlnenbtn;
    private javax.swing.JPanel pnlnendiachi;
    private javax.swing.JPanel pnlnengioitinh;
    private javax.swing.JPanel pnlnenhotenkhachhang;
    private javax.swing.JPanel pnlnenid;
    private javax.swing.JPanel pnlnenlonngoaithongtin;
    private javax.swing.JPanel pnlnenlonthongtincoban;
    private javax.swing.JPanel pnlnenmangxahoi;
    private javax.swing.JPanel pnlnenmatkhau;
    private javax.swing.JPanel pnlnenmota;
    private javax.swing.JPanel pnlnenngaysinh;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac1;
    private javax.swing.JPanel pnlnenngoaibtn;
    private javax.swing.JPanel pnlnenngoaithongtin;
    private javax.swing.JPanel pnlnenngoaithongtinkhac;
    private javax.swing.JPanel pnlnenngoaithongtinkhac1;
    private javax.swing.JPanel pnlnenngoaithongtinkhac2;
    private javax.swing.JPanel pnlnennhanvienphutrach;
    private javax.swing.JPanel pnlnennhomkhachhang;
    private javax.swing.JPanel pnlnensodienthoai;
    private javax.swing.JPanel pnlnenthemsuakhachhang1;
    private javax.swing.JPanel pnlnenthongtin;
    private javax.swing.JPanel pnlnenthongtinkhac;
    private javax.swing.JPanel pnlnentinh;
    private javax.swing.JPanel pnlthemsuakhachhang;
    private javax.swing.JPopupMenu ppmKhachHang;
    private javax.swing.JScrollPane srcdanhsach;
    public static javax.swing.JTable tblkhachhang;
    private javax.swing.JTabbedPane tbpchuyentab;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdNguoiDung;
    private javax.swing.JTextField txtMangXaHoi;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextPane txtMoTa;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtTag;
    public static javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtsodienthoai;
    // End of variables declaration//GEN-END:variables

 
}

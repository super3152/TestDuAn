/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChuyenDoi;
import DTO.DTONguoidung;
import DTO.DTOPhatLuong;
import DTO.MyCombobox;
import static GUI.pnlkhachhang.txtTimKiem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Takemikazuchi
 */
public class pnlnhanvien extends javax.swing.JPanel {

    private void FillNhanVien() {

        pnlChucVu.removeAll();

        DefaultTableModel dtm = (DefaultTableModel) tblNguoiDung.getModel();
        dtm.setRowCount(0);

        ArrayList<DTONguoidung> chucvu = DAO.DAONguoiDung.GetChucVu();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[chucvu.size()];
        JLabel[] lblImgBan = new JLabel[chucvu.size()];
        JLabel[] lblTenBan = new JLabel[chucvu.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < chucvu.size(); i++) {
            checkclick.add(i, false);
            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14));
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            if (chucvu.get(i).getQuyen() == 1) {
                lblTenBan[i].setText("Quản Trị");
            } else {
                lblTenBan[i].setText("Nhân Viên");
            }

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
                        BLL.BLLNguoiDung.HienThiNguoiDungTheoChucVu(tblNguoiDung, chucvu.get(j).getQuyen());
                        for (int k = 0; k < chucvu.size(); k++) {
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
            pnlChucVu.add(pnlBan[i]);
        }
        pnlChucVu.updateUI();
    }

    public pnlnhanvien() {

        initComponents();
        Date date = new Date();
        jdcNgayVaoLam.setDate(date);
        jdcNgaySinh.setDate(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        txtNgayPhat.setText(strDate);
        BLL.BLLNguoiDung.DoDuLieuVaoCBBNguoiDung(cbbNhanVienPL);
        FillNhanVien();
        BLL.BLLNguoiDung.DoDuLieuVaoCBBLuong(cbbLuong);
        BLL.BLLNguoiDung.DoDuLieuVaoCBBLuong(cbbLuongPL);
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText());
        BLL.BLLPhatLuong.Hienthiphatluong(tblPhatluong);
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmNhanVien = new javax.swing.JPopupMenu();
        mniXoaNhanVien = new javax.swing.JMenuItem();
        tbpchuyentab = new javax.swing.JTabbedPane();
        pnldanhsach = new javax.swing.JPanel();
        cbbloaikhachhang = new javax.swing.JComboBox<>();
        srcdanhsach = new javax.swing.JScrollPane();
        tblNguoiDung = new javax.swing.JTable();
        txtTimKiemNV = new javax.swing.JTextField();
        pnlChucVu = new javax.swing.JPanel();
        lblloaikhachhang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        pnlthemsuakhachhang = new javax.swing.JPanel();
        pnlnenthemsuakhachhang1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac = new javax.swing.JPanel();
        pnlnenngoaianhdaidien1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidien = new javax.swing.JPanel();
        pnlnenanhdaidien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlanhdaidien = new javax.swing.JPanel();
        lblAnhDaiDien = new javax.swing.JLabel();
        lblanhdaidien = new javax.swing.JLabel();
        pnlnenngoaithongtinkhac2 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac = new javax.swing.JPanel();
        pnlnenthongtinkhac = new javax.swing.JPanel();
        lblthongtinkhac = new javax.swing.JLabel();
        pnlnennhomkhachhang = new javax.swing.JPanel();
        lblnhomkhachhang = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        pnlnennhanvienphutrach = new javax.swing.JPanel();
        lblnhanvienphutrach = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
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
        txtCMND = new javax.swing.JTextField();
        pnlnenmangxahoi = new javax.swing.JPanel();
        lblmangxahoi = new javax.swing.JLabel();
        jdcNgayVaoLam = new com.toedter.calendar.JDateChooser();
        pnlnengioitinh = new javax.swing.JPanel();
        lblgioitinh = new javax.swing.JLabel();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        pnlnenngaysinh = new javax.swing.JPanel();
        lblngaysinh = new javax.swing.JLabel();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblthongtindiachi = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel40 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbbLuong = new javax.swing.JComboBox<>();
        pnlnentinh = new javax.swing.JPanel();
        lbltinh = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
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
        jPanel1 = new javax.swing.JPanel();
        pnlnenthemsuakhachhang2 = new javax.swing.JPanel();
        pnlnenlonthongtincoban1 = new javax.swing.JPanel();
        pnlnenlonngoaithongtin1 = new javax.swing.JPanel();
        pnlnenngoaithongtin1 = new javax.swing.JPanel();
        pnlnenthongtin1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhatluong = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        pnlnenmatkhau2 = new javax.swing.JPanel();
        lblmatkhau2 = new javax.swing.JLabel();
        txtTienPhat = new javax.swing.JTextField();
        pnlemail2 = new javax.swing.JPanel();
        lblemail2 = new javax.swing.JLabel();
        txtNgayPhat = new javax.swing.JTextField();
        pnlnensodienthoai2 = new javax.swing.JPanel();
        lblsodienthoai2 = new javax.swing.JLabel();
        txtTienThuong = new javax.swing.JTextField();
        pnlnenhotenkhachhang2 = new javax.swing.JPanel();
        lblhotenkhachhang2 = new javax.swing.JLabel();
        cbbNhanVienPL = new javax.swing.JComboBox<>();
        pnlnenmatkhau3 = new javax.swing.JPanel();
        lblmatkhau3 = new javax.swing.JLabel();
        cbbLuongPL = new javax.swing.JComboBox<>();
        pnlemail3 = new javax.swing.JPanel();
        lblemail3 = new javax.swing.JLabel();
        txtSoNgayNghi = new javax.swing.JTextField();
        pnlnensodienthoai3 = new javax.swing.JPanel();
        lblsodienthoai3 = new javax.swing.JLabel();
        txtGhichuPL = new javax.swing.JTextField();
        pnlnenhotenkhachhang3 = new javax.swing.JPanel();
        lblhotenkhachhang3 = new javax.swing.JLabel();
        txtSoNgayLam = new javax.swing.JTextField();
        pnlnenhotenkhachhang4 = new javax.swing.JPanel();
        lblhotenkhachhang4 = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        btnPhatluong = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        mniXoaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/delete_20px.png"))); // NOI18N
        mniXoaNhanVien.setText("Xóa nhân viên");
        mniXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaNhanVienActionPerformed(evt);
            }
        });
        ppmNhanVien.add(mniXoaNhanVien);

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 620));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        tbpchuyentab.setBackground(new java.awt.Color(255, 255, 255));
        tbpchuyentab.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        pnldanhsach.setBackground(new java.awt.Color(255, 255, 255));
        pnldanhsach.setForeground(new java.awt.Color(255, 255, 255));
        pnldanhsach.setPreferredSize(new java.awt.Dimension(980, 618));

        cbbloaikhachhang.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbbloaikhachhang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc nhân viên" }));
        cbbloaikhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbbloaikhachhang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbbloaikhachhang.setFocusCycleRoot(true);
        cbbloaikhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbloaikhachhangActionPerformed(evt);
            }
        });

        tblNguoiDung.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblNguoiDung.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        tblNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null, "", null, null, null, null, null},
                {"", "", "", "", null, "", null, null, null, null, null},
                {"", "", "", "", null, "", null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên nhân viên", "Số Điện Thoại", "Email", "Giới Tính", "Ngày Sinh", "Ngày Vào Làm", "Hình Ảnh", "Chức Vụ", "Trạng Thái", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNguoiDung.setDragEnabled(true);
        tblNguoiDung.setFocusable(false);
        tblNguoiDung.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblNguoiDung.setName(""); // NOI18N
        tblNguoiDung.setRowHeight(40);
        tblNguoiDung.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblNguoiDung.setShowVerticalLines(false);
        tblNguoiDung.getTableHeader().setReorderingAllowed(false);
        tblNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNguoiDungMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblNguoiDungMouseReleased(evt);
            }
        });
        srcdanhsach.setViewportView(tblNguoiDung);

        txtTimKiemNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKiemNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemNVKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemNVKeyTyped(evt);
            }
        });

        pnlChucVu.setBackground(new java.awt.Color(255, 255, 255));
        pnlChucVu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblloaikhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblloaikhachhang.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblloaikhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblloaikhachhang.setText("Chức vụ");
        lblloaikhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/delete_20px_1.png"))); // NOI18N
        jButton1.setText("Xóa N.Viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenance_20px.png"))); // NOI18N
        jButton2.setText("Sửa N.Viên");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thêm chức vụ");

        javax.swing.GroupLayout pnldanhsachLayout = new javax.swing.GroupLayout(pnldanhsach);
        pnldanhsach.setLayout(pnldanhsachLayout);
        pnldanhsachLayout.setHorizontalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addComponent(lblloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cbbloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemNV))
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jSeparator4)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addComponent(srcdanhsach, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
        );
        pnldanhsachLayout.setVerticalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addComponent(pnlChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        tbpchuyentab.addTab("Danh sách nhân viên", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/list_20px.png")), pnldanhsach); // NOI18N

        pnlnenthemsuakhachhang1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaianhdaidienvathongtinkhac1.setPreferredSize(new java.awt.Dimension(275, 550));
        pnlnenngoaianhdaidienvathongtinkhac1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac.setPreferredSize(new java.awt.Dimension(275, 300));
        pnlnenngoaianhdaidienvathongtinkhac.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidien1.setBackground(new java.awt.Color(0, 51, 204));
        pnlnenngoaianhdaidien1.setPreferredSize(new java.awt.Dimension(200, 260));
        pnlnenngoaianhdaidien1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidien.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaianhdaidien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 246, 248), 5));
        pnlnenngoaianhdaidien.setPreferredSize(new java.awt.Dimension(275, 260));

        pnlnenanhdaidien.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenanhdaidien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("                                                                ");
        jLabel1.setPreferredSize(new java.awt.Dimension(192, 1));
        pnlnenanhdaidien.add(jLabel1);

        pnlanhdaidien.setBackground(new java.awt.Color(255, 255, 255));
        pnlanhdaidien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnhDaiDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhDaiDienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlanhdaidienLayout = new javax.swing.GroupLayout(pnlanhdaidien);
        pnlanhdaidien.setLayout(pnlanhdaidienLayout);
        pnlanhdaidienLayout.setHorizontalGroup(
            pnlanhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlanhdaidienLayout.setVerticalGroup(
            pnlanhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlnenanhdaidien.add(pnlanhdaidien);

        lblanhdaidien.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblanhdaidien.setText("Ảnh đại diện");
        pnlnenanhdaidien.add(lblanhdaidien);

        javax.swing.GroupLayout pnlnenngoaianhdaidienLayout = new javax.swing.GroupLayout(pnlnenngoaianhdaidien);
        pnlnenngoaianhdaidien.setLayout(pnlnenngoaianhdaidienLayout);
        pnlnenngoaianhdaidienLayout.setHorizontalGroup(
            pnlnenngoaianhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenngoaianhdaidienLayout.createSequentialGroup()
                .addComponent(pnlnenanhdaidien, javax.swing.GroupLayout.PREFERRED_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlnenngoaianhdaidienLayout.setVerticalGroup(
            pnlnenngoaianhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenanhdaidien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenngoaianhdaidien1.add(pnlnenngoaianhdaidien, java.awt.BorderLayout.PAGE_START);

        pnlnenngoaianhdaidienvathongtinkhac.add(pnlnenngoaianhdaidien1, java.awt.BorderLayout.PAGE_START);

        pnlnenngoaithongtinkhac2.setBackground(new java.awt.Color(255, 255, 0));
        pnlnenngoaithongtinkhac2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(244, 246, 248), 5, true));
        pnlnenngoaithongtinkhac2.setPreferredSize(new java.awt.Dimension(275, 310));

        pnlnenngoaithongtinkhac1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaithongtinkhac1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenngoaithongtinkhac1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtinkhac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        pnlnenthongtinkhac.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtinkhac.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblthongtinkhac.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblthongtinkhac.setText("Thông tin khác");
        lblthongtinkhac.setPreferredSize(new java.awt.Dimension(34, 20));

        pnlnennhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang.setText("Chức vụ");
        lblnhomkhachhang.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang.add(lblnhomkhachhang, java.awt.BorderLayout.PAGE_START);

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Trị", "Nhân Viên" }));
        cbbChucVu.setToolTipText("");
        pnlnennhomkhachhang.add(cbbChucVu, java.awt.BorderLayout.CENTER);

        pnlnennhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach.setLayout(new java.awt.BorderLayout());

        lblnhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        lblnhanvienphutrach.setText("ID");
        lblnhanvienphutrach.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach.add(lblnhanvienphutrach, java.awt.BorderLayout.PAGE_START);

        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlnennhanvienphutrach.add(txtId, java.awt.BorderLayout.CENTER);

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
                .addComponent(pnlnenmota, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
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
        lblhotenkhachhang.setText("Họ tên nhân viên");
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
        lblid.setText("Chứng Minh Nhân Dân");
        lblid.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenid.add(lblid, java.awt.BorderLayout.PAGE_START);
        pnlnenid.add(txtCMND, java.awt.BorderLayout.CENTER);

        pnlnenmangxahoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmangxahoi.setLayout(new java.awt.BorderLayout());

        lblmangxahoi.setBackground(new java.awt.Color(255, 255, 255));
        lblmangxahoi.setText("Ngày Vào Làm");
        lblmangxahoi.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlnenmangxahoi.add(lblmangxahoi, java.awt.BorderLayout.PAGE_START);

        jdcNgayVaoLam.setDateFormatString("dd/MM/yyyy"); // NOI18N
        pnlnenmangxahoi.add(jdcNgayVaoLam, java.awt.BorderLayout.CENTER);

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

        jdcNgaySinh.setDateFormatString("dd/MM/yyyy"); // NOI18N
        pnlnenngaysinh.add(jdcNgaySinh, java.awt.BorderLayout.CENTER);

        lblthongtindiachi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtindiachi.setText("Thông tin địa chỉ");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Trạng thái");
        jLabel17.setPreferredSize(new java.awt.Dimension(52, 20));
        jPanel39.add(jLabel17, java.awt.BorderLayout.PAGE_START);

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Đã nghỉ làm" }));
        jPanel39.add(cbbTrangThai, java.awt.BorderLayout.CENTER);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mức Lương");
        jLabel18.setPreferredSize(new java.awt.Dimension(31, 20));
        jPanel40.add(jLabel18, java.awt.BorderLayout.PAGE_START);

        jPanel40.add(cbbLuong, java.awt.BorderLayout.CENTER);

        pnlnentinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlnentinh.setLayout(new java.awt.BorderLayout());

        lbltinh.setBackground(new java.awt.Color(255, 255, 255));
        lbltinh.setText("Tên Đăng Nhập");
        lbltinh.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnentinh.add(lbltinh, java.awt.BorderLayout.PAGE_START);
        pnlnentinh.add(txtTenDangNhap, java.awt.BorderLayout.CENTER);

        pnlnendiachi.setBackground(new java.awt.Color(255, 255, 255));
        pnlnendiachi.setLayout(new java.awt.BorderLayout());

        lbldiachihientai.setBackground(new java.awt.Color(255, 255, 255));
        lbldiachihientai.setText("Địa chỉ hiện tại (Xã, Phường - Quận, Huyện) ");
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
                    .addComponent(pnlnentinh, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(pnlnendiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
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
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

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
                    .addContainerGap(294, Short.MAX_VALUE)))
        );

        tbpchuyentab.addTab("Thêm - Sửa nhân viên", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenancde_20px.png")), pnlthemsuakhachhang); // NOI18N

        pnlnenthemsuakhachhang2.setLayout(new java.awt.BorderLayout());

        pnlnenlonthongtincoban1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonthongtincoban1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 246, 248), 5));
        pnlnenlonthongtincoban1.setPreferredSize(new java.awt.Dimension(700, 550));
        pnlnenlonthongtincoban1.setLayout(new java.awt.BorderLayout());

        pnlnenlonngoaithongtin1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonngoaithongtin1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenlonngoaithongtin1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        pnlnenngoaithongtin1.setLayout(new java.awt.BorderLayout());

        pnlnenthongtin1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtin1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPhatluong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên nhân viên", "Mức lương", "Ngày phát", "Số ngày đi làm", "Số ngày nghỉ", "Tiền thưởng", "Tiền phạt", "Lương", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhatluong.setRowHeight(40);
        tblPhatluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhatluongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhatluong);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel5");

        pnlnenmatkhau2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmatkhau2.setLayout(new java.awt.BorderLayout());

        lblmatkhau2.setBackground(new java.awt.Color(255, 255, 255));
        lblmatkhau2.setText("Tiền phạt");
        lblmatkhau2.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenmatkhau2.add(lblmatkhau2, java.awt.BorderLayout.PAGE_START);

        txtTienPhat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienPhatKeyReleased(evt);
            }
        });
        pnlnenmatkhau2.add(txtTienPhat, java.awt.BorderLayout.CENTER);

        pnlemail2.setBackground(new java.awt.Color(255, 255, 255));
        pnlemail2.setLayout(new java.awt.BorderLayout());

        lblemail2.setBackground(new java.awt.Color(255, 255, 255));
        lblemail2.setText("Ngày phát");
        lblemail2.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlemail2.add(lblemail2, java.awt.BorderLayout.PAGE_START);
        pnlemail2.add(txtNgayPhat, java.awt.BorderLayout.CENTER);

        pnlnensodienthoai2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnensodienthoai2.setLayout(new java.awt.BorderLayout());

        lblsodienthoai2.setBackground(new java.awt.Color(255, 255, 255));
        lblsodienthoai2.setText("Tiền thưởng");
        lblsodienthoai2.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnensodienthoai2.add(lblsodienthoai2, java.awt.BorderLayout.PAGE_START);

        txtTienThuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienThuongKeyReleased(evt);
            }
        });
        pnlnensodienthoai2.add(txtTienThuong, java.awt.BorderLayout.CENTER);

        pnlnenhotenkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang2.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang2.setText("Nhân viên");
        lblhotenkhachhang2.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang2.add(lblhotenkhachhang2, java.awt.BorderLayout.PAGE_START);

        cbbNhanVienPL.setToolTipText("");
        pnlnenhotenkhachhang2.add(cbbNhanVienPL, java.awt.BorderLayout.CENTER);

        pnlnenmatkhau3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmatkhau3.setLayout(new java.awt.BorderLayout());

        lblmatkhau3.setBackground(new java.awt.Color(255, 255, 255));
        lblmatkhau3.setText("Lương");
        lblmatkhau3.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenmatkhau3.add(lblmatkhau3, java.awt.BorderLayout.PAGE_START);

        pnlnenmatkhau3.add(cbbLuongPL, java.awt.BorderLayout.CENTER);

        pnlemail3.setBackground(new java.awt.Color(255, 255, 255));
        pnlemail3.setLayout(new java.awt.BorderLayout());

        lblemail3.setBackground(new java.awt.Color(255, 255, 255));
        lblemail3.setText("Số ngày nghỉ");
        lblemail3.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlemail3.add(lblemail3, java.awt.BorderLayout.PAGE_START);

        txtSoNgayNghi.setText("0");
        txtSoNgayNghi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiKeyReleased(evt);
            }
        });
        pnlemail3.add(txtSoNgayNghi, java.awt.BorderLayout.CENTER);

        pnlnensodienthoai3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnensodienthoai3.setLayout(new java.awt.BorderLayout());

        lblsodienthoai3.setBackground(new java.awt.Color(255, 255, 255));
        lblsodienthoai3.setText("Ghi chú");
        lblsodienthoai3.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnensodienthoai3.add(lblsodienthoai3, java.awt.BorderLayout.PAGE_START);
        pnlnensodienthoai3.add(txtGhichuPL, java.awt.BorderLayout.CENTER);

        pnlnenhotenkhachhang3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang3.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang3.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang3.setText("Số ngày đi làm");
        lblhotenkhachhang3.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang3.add(lblhotenkhachhang3, java.awt.BorderLayout.PAGE_START);

        txtSoNgayLam.setText("30");
        txtSoNgayLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNgayLamActionPerformed(evt);
            }
        });
        pnlnenhotenkhachhang3.add(txtSoNgayLam, java.awt.BorderLayout.CENTER);

        pnlnenhotenkhachhang4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang4.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang4.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblhotenkhachhang4.setForeground(new java.awt.Color(255, 0, 0));
        lblhotenkhachhang4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhotenkhachhang4.setText("Tổng tiền lương:");
        lblhotenkhachhang4.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang4.add(lblhotenkhachhang4, java.awt.BorderLayout.PAGE_START);

        txtTong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongActionPerformed(evt);
            }
        });
        pnlnenhotenkhachhang4.add(txtTong, java.awt.BorderLayout.CENTER);

        btnPhatluong.setText("Phát lương");
        btnPhatluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhatluongActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout pnlnenthongtin1Layout = new javax.swing.GroupLayout(pnlnenthongtin1);
        pnlnenthongtin1.setLayout(pnlnenthongtin1Layout);
        pnlnenthongtin1Layout.setHorizontalGroup(
            pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                                .addComponent(pnlemail2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addComponent(pnlnenmatkhau2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtin1Layout.createSequentialGroup()
                                .addComponent(pnlnenhotenkhachhang2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addComponent(pnlnensodienthoai2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                            .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                                .addComponent(pnlemail3, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addComponent(pnlnenmatkhau3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtin1Layout.createSequentialGroup()
                                .addComponent(pnlnenhotenkhachhang3, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addComponent(pnlnensodienthoai3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlnenhotenkhachhang4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPhatluong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator5))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator6)))
                .addContainerGap())
            .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlnenthongtin1Layout.setVerticalGroup(
            pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnensodienthoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlnenhotenkhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnenmatkhau2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlemail2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnensodienthoai3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlnenhotenkhachhang3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnenmatkhau3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlemail3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhatluong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlnenhotenkhachhang4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtin1Layout.createSequentialGroup()
                    .addGap(356, 356, 356)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlnenngoaithongtin1.add(pnlnenthongtin1, java.awt.BorderLayout.CENTER);

        pnlnenlonngoaithongtin1.add(pnlnenngoaithongtin1, java.awt.BorderLayout.CENTER);

        pnlnenlonthongtincoban1.add(pnlnenlonngoaithongtin1, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang2.add(pnlnenlonthongtincoban1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlnenthemsuakhachhang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlnenthemsuakhachhang2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
        );

        tbpchuyentab.addTab("Lương nhân viên", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/get_cash_20px.png")), jPanel1); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoNgayLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNgayLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNgayLamActionPerformed

    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileChooserActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        MyCombobox Luong = (MyCombobox) cbbLuong.getSelectedItem();
        String TenNguoiDung = txtHoTen.getText();
        String SoDienThoai = txtsodienthoai.getText();
        String Email = txtEmail.getText();
        String GioiTinh;
        if (cbbGioiTinh.getSelectedItem().toString().equals("Nam")) {
            GioiTinh = "1";
        } else {
            GioiTinh = "0";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String NgaySinh = sdf.format(jdcNgaySinh.getDate());

        String NgayVaoLam = sdf.format(jdcNgayVaoLam.getDate());
        String DiaChi = txtDiaChi.getText();
        String CMND = txtCMND.getText();
        String MatKhau = txtMatKhau.getText();
        String TenDangNhap = txtTenDangNhap.getText();
        if (lblAnhDaiDien.getIcon() == null) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn hình ảnh khách hàng", "Thông báo");
            return;
        }
        String AnhDaiDien = FILE.getName();
        int TrangThai;
        if (cbbTrangThai.getSelectedItem().toString().equals("Đang làm việc")) {
            TrangThai = 1;
        } else {
            TrangThai = 0;
        }
        int ChucVu;
        if (cbbChucVu.getSelectedItem().toString().equals("Quản trị")) {
            ChucVu = 1;
        } else {
            ChucVu = 0;
        }
        String MoTa = txtMoTa.getText();
        if (BLL.BLLNguoiDung.KiemTraThemNguoiDung(TenNguoiDung, SoDienThoai, Email, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, MoTa)) {
            DTONguoidung nd = new DTONguoidung(Integer.parseInt(Luong.Value.toString()), TenNguoiDung, SoDienThoai, Email, GioiTinh, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, AnhDaiDien, ChucVu, TrangThai, MoTa);
            BLL.BLLNguoiDung.ThemNguoiDung(nd);
            ThongBaoCanhBao.ThongBao("Thêm nhân viên thành công", "Thông báo");
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText());
             LamMoiNhanVien();

        }


    }//GEN-LAST:event_btnthemActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed
    public static File FILE;

    private void lblAnhDaiDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhDaiDienMouseClicked
        if (FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            FILE = FileChooser.getSelectedFile();
            if (!FILE.getName().matches(".+(\\.png|\\.jpg|\\.gif)$")) {
                ThongBaoCanhBao.ThongBao("Không phải hình ảnh", "Thông Báo");
                return;
            }
            if (saveLogo(FILE)) {
                lblAnhDaiDien.setIcon(readLogo(FILE.getName()));
                lblAnhDaiDien.setToolTipText(FILE.getName());
            }
        }
    }//GEN-LAST:event_lblAnhDaiDienMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int kq = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn xóa nhân viên này không?",
                "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {

            int cacDong[] = tblNguoiDung.getSelectedRows();
            for (int i = 0; i < cacDong.length; i++) {
                int maND = Integer.parseInt(tblNguoiDung.getValueAt(cacDong[i], 0).toString());
                DAO.DAONguoiDung.XoaNhanVien(maND);
            }
        }
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiem.getText());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimKiemNVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNVKeyTyped

    }//GEN-LAST:event_txtTimKiemNVKeyTyped

    private void txtTimKiemNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNVKeyPressed

    }//GEN-LAST:event_txtTimKiemNVKeyPressed

    private void tblNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNguoiDungMouseClicked
        int Dongduocchon = tblNguoiDung.getSelectedRow();
        TableModel model = tblNguoiDung.getModel();
        if (evt.getClickCount() == 2) {
            if (Dongduocchon >= 0) {
                int MaND = Integer.parseInt(tblNguoiDung.getValueAt(Dongduocchon, 0).toString());
                DTONguoidung nd = BLL.BLLNguoiDung.GetMaND(MaND);
                txtHoTen.setText(nd.getTenNguoiDung());
                txtsodienthoai.setText(nd.getSoDienThoai() + "");
                txtEmail.setText(nd.getEmail());
                txtMatKhau.setText(nd.getMatKhau());
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tblNguoiDung.getValueAt(Dongduocchon, 5));
                    jdcNgaySinh.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tblNguoiDung.getValueAt(Dongduocchon, 6));
                    jdcNgayVaoLam.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (nd.getGioiTinh().equals("1")) {
                    cbbGioiTinh.setSelectedItem("Nam");
                } else {
                    cbbGioiTinh.setSelectedItem("Nữ");
                }
                txtCMND.setText(nd.getCMND());
                txtDiaChi.setText(nd.getDiaChi());
                txtTenDangNhap.setText(nd.getTenDangNhap());
                  DefaultComboBoxModel cbc = (DefaultComboBoxModel) cbbLuong.getModel();
            for (int i = 0; i < cbbLuong.getItemCount(); i++) {
                MyCombobox mL = (MyCombobox) cbc.getElementAt(i);
                String tenloai = (mL.Text.toString());
                if (tenloai.equals(tblNguoiDung.getValueAt(Dongduocchon, 10).toString())) {
                    cbbLuong.setSelectedIndex(i);
                }
            }
                if (nd.getTrangThai() == 1) {
                    cbbTrangThai.setSelectedItem("Đang làm việc");
                } else {
                    cbbTrangThai.setSelectedItem("Đã nghỉ làm");
                }
                lblAnhDaiDien.setIcon(readLogo(model.getValueAt(Dongduocchon, 7).toString()));
                lblAnhDaiDien.setToolTipText(model.getValueAt(Dongduocchon, 7).toString());
                if (nd.getQuyen() == 1) {
                    cbbChucVu.setSelectedItem("Quản Trị");
                } else {
                    cbbChucVu.setSelectedItem("Nhân Viên");
                }
                txtId.setText(nd.getIdNguoiDung()+"");
                txtMoTa.setText(nd.getMoTa());
                tbpchuyentab.setSelectedIndex(1);

            }
        }
    }//GEN-LAST:event_tblNguoiDungMouseClicked

    private void cbbloaikhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbloaikhachhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbloaikhachhangActionPerformed

    private void txtTongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void mniXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaNhanVienActionPerformed
        int kq = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn xóa nhân viên này không?",
                "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {

            int cacDong[] = tblNguoiDung.getSelectedRows();
            for (int i = 0; i < cacDong.length; i++) {
                int maND = Integer.parseInt(tblNguoiDung.getValueAt(cacDong[i], 0).toString());
                DAO.DAONguoiDung.XoaNhanVien(maND);
            }
        }
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiem.getText());
    }//GEN-LAST:event_mniXoaNhanVienActionPerformed

    private void tblNguoiDungMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNguoiDungMouseReleased
        if (evt.isPopupTrigger()) {
            ppmNhanVien.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblNguoiDungMouseReleased

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        LamMoiNhanVien();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int MaNguoiDung = Integer.parseInt(txtId.getText());
        MyCombobox Luong = (MyCombobox) cbbLuong.getSelectedItem();
        String TenNguoiDung = txtHoTen.getText();
        String SoDienThoai = txtsodienthoai.getText();
        String Email = txtEmail.getText();
        String GioiTinh;
        if (cbbGioiTinh.getSelectedItem().toString().equals("Nam")) {
            GioiTinh = "1";
        } else {
            GioiTinh = "0";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String NgaySinh = sdf.format(jdcNgaySinh.getDate());

        String NgayVaoLam = sdf.format(jdcNgayVaoLam.getDate());
        String DiaChi = txtDiaChi.getText();
        String CMND = txtCMND.getText();
        String MatKhau = txtMatKhau.getText();
        String TenDangNhap = txtTenDangNhap.getText();
        if (lblAnhDaiDien.getIcon() == null) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn hình ảnh khách hàng", "Thông báo");
            return;
        }
        String AnhDaiDien = lblAnhDaiDien.getToolTipText();
        int TrangThai;
        if (cbbTrangThai.getSelectedItem().toString().equals("Đang làm việc")) {
            TrangThai = 1;
        } else {
            TrangThai = 0;
        }
        int ChucVu;
        if (cbbChucVu.getSelectedItem().toString().equals("Quản trị")) {
            ChucVu = 1;
        } else {
            ChucVu = 0;
        }
        String MoTa = txtMoTa.getText();
        if (BLL.BLLNguoiDung.KiemTraSuaNguoiDung(TenNguoiDung, SoDienThoai, Email, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, MoTa)) {
            DTONguoidung nd = new DTONguoidung(MaNguoiDung,Integer.parseInt(Luong.Value.toString()), TenNguoiDung, SoDienThoai, Email, GioiTinh, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, AnhDaiDien, ChucVu, TrangThai, MoTa);
            BLL.BLLNguoiDung.SuaNguoiDung(nd);
            ThongBaoCanhBao.ThongBao("Sửa nhân viên thành công", "Thông báo");
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText());
             LamMoiNhanVien();

        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void tblPhatluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhatluongMouseClicked
      
    }//GEN-LAST:event_tblPhatluongMouseClicked

    private void txtSoNgayNghiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiKeyReleased
        int NgayLam, NgayNghi;
       
        NgayNghi =  BLL.ChuyenDoi.ChuyenSo(txtSoNgayNghi.getText());
        NgayLam = 30 - NgayNghi;
         txtSoNgayNghi.setText(BLL.ChuyenDoi.DinhDangSo(NgayNghi));
        txtSoNgayLam.setText(ChuyenDoi.doubleToString(NgayLam));
        if (NgayNghi > 30) {
            txtSoNgayLam.setText("30");
             txtSoNgayNghi.setText("0");
        }
    }//GEN-LAST:event_txtSoNgayNghiKeyReleased
 double Luong,tienThuong ,tongLuong;
    private void txtTienThuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienThuongKeyReleased
         Luong = BLL.ChuyenDoi.ChuyenTien(cbbLuong.getSelectedItem().toString());
        tienThuong = BLL.ChuyenDoi.ChuyenTien(txtTienThuong.getText());
        txtTienThuong.setText(BLL.ChuyenDoi.DinhDangTien(tienThuong));
        tongLuong = Luong + tienThuong;
        txtTong.setText(BLL.ChuyenDoi.DinhDangTien(tongLuong));
    }//GEN-LAST:event_txtTienThuongKeyReleased

    private void txtTienPhatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienPhatKeyReleased
         double Luong,tienPhat ,tongLuong1;

        Luong = BLL.ChuyenDoi.ChuyenTien(cbbLuong.getSelectedItem().toString());
        tienPhat = BLL.ChuyenDoi.ChuyenTien(txtTienPhat.getText());

        txtTienPhat.setText(BLL.ChuyenDoi.DinhDangTien(tienPhat));

        tongLuong1 = tongLuong - tienPhat;

        txtTong.setText(BLL.ChuyenDoi.DinhDangTien(tongLuong1));
    }//GEN-LAST:event_txtTienPhatKeyReleased

    private void btnPhatluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhatluongActionPerformed
         MyCombobox mb = (MyCombobox) cbbNhanVienPL.getSelectedItem();
        int MaLoaiNV =Integer.parseInt(mb.Value.toString());
        
         String NgayPhat=txtNgayPhat.getText();
        String SoNgayDiLam = txtSoNgayLam.getText();
        String SoNgayNghi = txtSoNgayNghi.getText();
        double TT =ChuyenDoi.ChuyenSangSo(txtTienThuong.getText());
        double TP =ChuyenDoi.ChuyenSangSo(txtTienPhat.getText());
        DecimalFormat formatter = new DecimalFormat("#########");
        String TienThuong = formatter.format(TT);       
        String TienPhat = formatter.format(TP);
         String GhiChu = txtGhichuPL.getText();
         MyCombobox mb1 = (MyCombobox) cbbLuong.getSelectedItem();
        int MaLuong =Integer.parseInt(mb1.Value.toString());
        double T =ChuyenDoi.ChuyenSangSo(txtTong.getText());
        String Tong = formatter.format(T);
        if (BLL.BLLNguoiDung.KiemTraPhatLuong(MaLoaiNV, NgayPhat, SoNgayDiLam, SoNgayNghi, TienThuong, TienPhat, GhiChu, MaLuong,Tong)) {
            DTO.DTOPhatLuong pl = new DTO.DTOPhatLuong(MaLoaiNV, NgayPhat, SoNgayDiLam, SoNgayNghi, TienThuong, TienPhat, GhiChu, MaLuong, Tong);
            BLL.BLLNguoiDung.PhatLuong(pl);
            ThongBaoCanhBao.ThongBao("Phát lương thành công", "Thông Báo");
             BLL.BLLPhatLuong.Hienthiphatluong(tblPhatluong);
        }
    }//GEN-LAST:event_btnPhatluongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    private void LamMoiNhanVien() {
        txtHoTen.setText("");
        txtsodienthoai.setText("");
        txtEmail.setText("");
        txtMatKhau.setText("");
        Date date = new Date();
        jdcNgaySinh.setDate(date);
        jdcNgayVaoLam.setDate(date);
        cbbGioiTinh.setSelectedIndex(0);
        txtCMND.setText("");
        txtDiaChi.setText("");
        txtTenDangNhap.setText("");
        cbbTrangThai.setSelectedIndex(0);
        lblAnhDaiDien.setIcon(null);
        cbbChucVu.setSelectedIndex(0);
        txtId.setText("");
        txtMoTa.setToolTipText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton btnPhatluong;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JComboBox<String> cbbLuong;
    private javax.swing.JComboBox<String> cbbLuongPL;
    private javax.swing.JComboBox<String> cbbNhanVienPL;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbbloaikhachhang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private com.toedter.calendar.JDateChooser jdcNgayVaoLam;
    private javax.swing.JLabel lblAnhDaiDien;
    private javax.swing.JLabel lblanhdaidien;
    private javax.swing.JLabel lbldiachihientai;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblemail2;
    private javax.swing.JLabel lblemail3;
    private javax.swing.JLabel lblgioitinh;
    private javax.swing.JLabel lblhotenkhachhang;
    private javax.swing.JLabel lblhotenkhachhang2;
    private javax.swing.JLabel lblhotenkhachhang3;
    private javax.swing.JLabel lblhotenkhachhang4;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblloaikhachhang;
    private javax.swing.JLabel lblmangxahoi;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblmatkhau2;
    private javax.swing.JLabel lblmatkhau3;
    private javax.swing.JLabel lblmota;
    private javax.swing.JLabel lblngaysinh;
    private javax.swing.JLabel lblnhanvienphutrach;
    private javax.swing.JLabel lblnhomkhachhang;
    private javax.swing.JLabel lblsodienthoai;
    private javax.swing.JLabel lblsodienthoai2;
    private javax.swing.JLabel lblsodienthoai3;
    private javax.swing.JLabel lblthongtinbosung;
    private javax.swing.JLabel lblthongtincoban;
    private javax.swing.JLabel lblthongtindiachi;
    private javax.swing.JLabel lblthongtinkhac;
    private javax.swing.JLabel lbltinh;
    private javax.swing.JMenuItem mniXoaNhanVien;
    private javax.swing.JPanel pnlChucVu;
    private javax.swing.JPanel pnlanhdaidien;
    private javax.swing.JPanel pnldanhsach;
    private javax.swing.JPanel pnlemail;
    private javax.swing.JPanel pnlemail2;
    private javax.swing.JPanel pnlemail3;
    private javax.swing.JPanel pnlnenanhdaidien;
    private javax.swing.JPanel pnlnenbtn;
    private javax.swing.JPanel pnlnendiachi;
    private javax.swing.JPanel pnlnengioitinh;
    private javax.swing.JPanel pnlnenhotenkhachhang;
    private javax.swing.JPanel pnlnenhotenkhachhang2;
    private javax.swing.JPanel pnlnenhotenkhachhang3;
    private javax.swing.JPanel pnlnenhotenkhachhang4;
    private javax.swing.JPanel pnlnenid;
    private javax.swing.JPanel pnlnenlonngoaithongtin;
    private javax.swing.JPanel pnlnenlonngoaithongtin1;
    private javax.swing.JPanel pnlnenlonthongtincoban;
    private javax.swing.JPanel pnlnenlonthongtincoban1;
    private javax.swing.JPanel pnlnenmangxahoi;
    private javax.swing.JPanel pnlnenmatkhau;
    private javax.swing.JPanel pnlnenmatkhau2;
    private javax.swing.JPanel pnlnenmatkhau3;
    private javax.swing.JPanel pnlnenmota;
    private javax.swing.JPanel pnlnenngaysinh;
    private javax.swing.JPanel pnlnenngoaianhdaidien;
    private javax.swing.JPanel pnlnenngoaianhdaidien1;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac1;
    private javax.swing.JPanel pnlnenngoaibtn;
    private javax.swing.JPanel pnlnenngoaithongtin;
    private javax.swing.JPanel pnlnenngoaithongtin1;
    private javax.swing.JPanel pnlnenngoaithongtinkhac;
    private javax.swing.JPanel pnlnenngoaithongtinkhac1;
    private javax.swing.JPanel pnlnenngoaithongtinkhac2;
    private javax.swing.JPanel pnlnennhanvienphutrach;
    private javax.swing.JPanel pnlnennhomkhachhang;
    private javax.swing.JPanel pnlnensodienthoai;
    private javax.swing.JPanel pnlnensodienthoai2;
    private javax.swing.JPanel pnlnensodienthoai3;
    private javax.swing.JPanel pnlnenthemsuakhachhang1;
    private javax.swing.JPanel pnlnenthemsuakhachhang2;
    private javax.swing.JPanel pnlnenthongtin;
    private javax.swing.JPanel pnlnenthongtin1;
    private javax.swing.JPanel pnlnenthongtinkhac;
    private javax.swing.JPanel pnlnentinh;
    private javax.swing.JPanel pnlthemsuakhachhang;
    private javax.swing.JPopupMenu ppmNhanVien;
    private javax.swing.JScrollPane srcdanhsach;
    private javax.swing.JTable tblNguoiDung;
    private javax.swing.JTable tblPhatluong;
    private javax.swing.JTabbedPane tbpchuyentab;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGhichuPL;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextPane txtMoTa;
    private javax.swing.JTextField txtNgayPhat;
    private javax.swing.JTextField txtSoNgayLam;
    private javax.swing.JTextField txtSoNgayNghi;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTienPhat;
    private javax.swing.JTextField txtTienThuong;
    public static javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txtTong;
    private javax.swing.JTextField txtsodienthoai;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChuyenDoi;
import DTO.DTOPhieuNhap;
import DTO.MyCombobox;
import static GUI.pnlthemphieunhap.jdcNgayNhap;
import static GUI.pnlthemphieunhap.tblChitietphieunhap;
import static GUI.pnlthemphieunhap.txtTongtien;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class jdlThanhToanPhieu extends javax.swing.JDialog {

    /**
     * Creates new form jdlThanhToanPhieu
     */
    public jdlThanhToanPhieu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblSoPhieuNhap.setText(GUI.pnlthemphieunhap.txtMaDonNhapHang.getText());
        txtTienHang.setText(pnlthemphieunhap.txtTongtien.getText());
        txtTienThue.setText("0");
        txtTongCong.setText(txtTienHang.getText());
        jdcHanTraCongNo.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtInPhieuNhap = new javax.swing.JTextArea();
        txtHanTraNo = new javax.swing.JTextField();
        pnlChucNang2 = new javax.swing.JPanel();
        lblSoLuong2 = new javax.swing.JLabel();
        lblGhiChu15 = new javax.swing.JLabel();
        txtTienHang = new javax.swing.JTextField();
        jFileChooser3 = new javax.swing.JFileChooser();
        cbbPhuongThuc = new javax.swing.JComboBox<>();
        txtThanhToan = new javax.swing.JTextField();
        lblGhiChu17 = new javax.swing.JLabel();
        lblGhiChu18 = new javax.swing.JLabel();
        txtTienThue = new javax.swing.JTextField();
        txtTongCong = new javax.swing.JTextField();
        lblGhiChu19 = new javax.swing.JLabel();
        lblGhiChu20 = new javax.swing.JLabel();
        lblGhiChu21 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        lblGhiChu22 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        lblGhiChu23 = new javax.swing.JLabel();
        jdcHanTraCongNo = new com.toedter.calendar.JDateChooser();
        pnlButton = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSoPhieuNhap = new javax.swing.JLabel();

        txtInPhieuNhap.setColumns(20);
        txtInPhieuNhap.setRows(5);
        jScrollPane1.setViewportView(txtInPhieuNhap);

        txtHanTraNo.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlChucNang2.setBackground(new java.awt.Color(153, 153, 153));
        pnlChucNang2.setForeground(new java.awt.Color(255, 255, 255));
        pnlChucNang2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnlChucNangFocusGained(evt);
            }
        });

        lblSoLuong2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoLuong2.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong2.setText("Phương Thức Thanh Toán");

        lblGhiChu15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu15.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu15.setText("Tiền Thuế");

        txtTienHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTienHang.setEnabled(false);
        txtTienHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienHangActionPerformed(evt);
            }
        });
        txtTienHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienHangKeyReleased(evt);
            }
        });

        jFileChooser3.setPreferredSize(new java.awt.Dimension(0, 0));

        cbbPhuongThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Quẹt Thẻ", "Chuyển Khoản", "COD", " " }));

        txtThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        lblGhiChu17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu17.setForeground(new java.awt.Color(255, 255, 255));

        lblGhiChu18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu18.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu18.setText("Tiền Hàng");

        txtTienThue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTienThue.setEnabled(false);
        txtTienThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThueActionPerformed(evt);
            }
        });
        txtTienThue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienThueKeyReleased(evt);
            }
        });

        txtTongCong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTongCong.setEnabled(false);
        txtTongCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongCongActionPerformed(evt);
            }
        });
        txtTongCong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongCongKeyReleased(evt);
            }
        });

        lblGhiChu19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu19.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu19.setText("Tổng Cộng");

        lblGhiChu20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu20.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu20.setText("Thanh Toán");

        lblGhiChu21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu21.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu21.setText("Tiền Thừa");

        txtTienThua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTienThua.setEnabled(false);
        txtTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuaActionPerformed(evt);
            }
        });
        txtTienThua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienThuaKeyReleased(evt);
            }
        });

        lblGhiChu22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu22.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu22.setText("Nợ");

        txtNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNo.setEnabled(false);
        txtNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoActionPerformed(evt);
            }
        });
        txtNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoKeyReleased(evt);
            }
        });

        lblGhiChu23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu23.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu23.setText("Hạn Trả");

        jdcHanTraCongNo.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout pnlChucNang2Layout = new javax.swing.GroupLayout(pnlChucNang2);
        pnlChucNang2.setLayout(pnlChucNang2Layout);
        pnlChucNang2Layout.setHorizontalGroup(
            pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNang2Layout.createSequentialGroup()
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChucNang2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlChucNang2Layout.createSequentialGroup()
                                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlChucNang2Layout.createSequentialGroup()
                                        .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSoLuong2)
                                            .addComponent(lblGhiChu18)
                                            .addComponent(lblGhiChu15))
                                        .addGap(34, 34, 34)
                                        .addComponent(lblGhiChu17))
                                    .addComponent(lblGhiChu19)
                                    .addComponent(lblGhiChu20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTienThue, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienHang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbPhuongThuc, javax.swing.GroupLayout.Alignment.LEADING, 0, 159, Short.MAX_VALUE)
                                    .addComponent(txtTongCong, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtThanhToan, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlChucNang2Layout.createSequentialGroup()
                                    .addComponent(lblGhiChu21)
                                    .addGap(138, 138, 138)
                                    .addComponent(txtTienThua))
                                .addGroup(pnlChucNang2Layout.createSequentialGroup()
                                    .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblGhiChu22)
                                        .addComponent(lblGhiChu23))
                                    .addGap(151, 151, 151)
                                    .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNo)
                                        .addComponent(jdcHanTraCongNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(pnlChucNang2Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jFileChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );
        pnlChucNang2Layout.setVerticalGroup(
            pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNang2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong2)
                    .addComponent(cbbPhuongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGhiChu17)
                    .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGhiChu18)))
                .addGap(34, 34, 34)
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu15)
                    .addComponent(txtTienThue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu19)
                    .addComponent(txtTongCong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu20)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu21)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu22)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlChucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblGhiChu23)
                    .addComponent(jdcHanTraCongNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jFileChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pnlButton.setBackground(new java.awt.Color(153, 153, 153));

        btnOK.setBackground(new java.awt.Color(204, 255, 204));
        btnOK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOK.setForeground(new java.awt.Color(0, 153, 0));
        btnOK.setText("Thanh Toán");
        btnOK.setToolTipText("");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnThoat)
                .addGap(67, 67, 67)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnThoat))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlTitle.setBackground(new java.awt.Color(153, 153, 153));
        pnlTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 0, 4), null, null));
        pnlTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTitleMouseDragged(evt);
            }
        });
        pnlTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTitleMousePressed(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(212, 216, 225));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Thông tin thanh toán cho đơn");

        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(36, 36, 36))
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblSoPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlChucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String SoPhieuNhap = lblSoPhieuNhap.getText();
        String ThanhToan;
        double CongNo = ChuyenDoi.ChuyenSangSo(txtNo.getText());
        String HinhThucThanhToan = cbbPhuongThuc.getSelectedItem().toString();
        String HanTraCongNo;
        if (txtNo.getText().equals("0")) {
            HanTraCongNo = "0000-00-00";
            ThanhToan = "Đã Thanh Toán";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            HanTraCongNo = sdf.format(jdcHanTraCongNo.getDate());
            ThanhToan = "Đang Nợ";
        }
        DTOPhieuNhap PN = new DTOPhieuNhap(SoPhieuNhap, HinhThucThanhToan, ThanhToan, CongNo, HanTraCongNo);
        BLL.BLLPhieuNhap.SuaThanhToanPN(PN);
        MyCombobox mb = (MyCombobox) pnlthemphieunhap.cbbNhaCungCap.getSelectedItem();
        int MaNCC = (int) mb.Value;
        DTO.DTONhaCungCap ncc = BLL.BLLNhaCungCap.GetMaNCC(MaNCC);
        double CongNoBang = ncc.getCongNo();
        double CongNoSua = CongNoBang + CongNo;
        DTO.DTONhaCungCap sncc = new DTO.DTONhaCungCap(MaNCC, CongNoSua);
        BLL.BLLNhaCungCap.SuaCongNoNCC(sncc);
        ThongBaoCanhBao.ThongBao("Thanh toán thành công", "Thông Báo");
        BillPhieuNhap(); 
        pnlthemphieunhap.btnThanhToan.setEnabled(false);
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                "Bạn Có Muốn In Hóa Đơn Phiếu Nhập Không ?", //thông báo
                "Thông Báo !", //tiêu đề
                JOptionPane.YES_NO_OPTION, //lựa chọn
                JOptionPane.ERROR_MESSAGE); // icon

        if (ketquasaukhibam == JOptionPane.YES_OPTION) {
            printRecord(txtInPhieuNhap);
        }
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed
    public void BillPhieuNhap() {
        String TongTien = txtTongtien.getText();
        String NhaCungCap = pnlthemphieunhap.cbbNhaCungCap.getSelectedItem().toString();
        String MaDonNhapHang = pnlthemphieunhap.txtMaDonNhapHang.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String NgayNhap = sdf.format(jdcNgayNhap.getDate());
        String NhanVien = BLL.BLLlogin.nguoidung.getTenNguoiDung();
        String TienTra = txtThanhToan.getText();
        String TienThua = txtTienThua.getText();
        String No = txtNo.getText();
        String HanTraNo = txtHanTraNo.getText();

        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "-------------------------------------------------\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "             SHOP QUẦN ÁO CHÂU NGÂN                         \n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "         70 Bà Triệu - TP. Buôn Ma Thuột                        \n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "               ĐT: 0905 28 51 51                      \n");
        txtInPhieuNhap.setFont(txtInPhieuNhap.getFont().deriveFont(Font.BOLD, 13f));

        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "-------------------------------------------------\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "                Phiếu Nhập Hàng                      \n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Nhà Cung Cấp : " + NhaCungCap + "\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Mã Đơn Nhập : " + MaDonNhapHang + "\t" + "Ngày :" + NgayNhap + "\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Nhân Viên : " + NhanVien + "\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "-------------------------------------------------\n");
        //Heading
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Sản Phẩm" + "\t" + "SL" + "\t" + "Giá" + "\t" + "Đơn Vi" + "\t" + "Thành Tiền" + "\n");

        for (int i = 0; i < tblChitietphieunhap.getRowCount(); i++) {
            String TenSP = tblChitietphieunhap.getValueAt(i, 3).toString();
            String Size = tblChitietphieunhap.getValueAt(i, 4).toString();
            String Mau = tblChitietphieunhap.getValueAt(i, 5).toString();
            int SoLuong = (int) tblChitietphieunhap.getValueAt(i, 6);
            String Gia = tblChitietphieunhap.getValueAt(i, 7).toString();
            String DonVi = tblChitietphieunhap.getValueAt(i, 8).toString();
            String ThanhTien = tblChitietphieunhap.getValueAt(i, 9).toString();
            txtInPhieuNhap.setText(txtInPhieuNhap.getText() + TenSP + "-" + Size + "-" + Mau + "\t" + SoLuong + "\t" + Gia + "\t" + DonVi + "\t" + ThanhTien + "\n");
        }
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "-------------------------------------------------\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Tổng Tiền : " + TongTien + " VNĐ" + "\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Tiền Trả : " + TienTra + " VNĐ" + "\n");
        if (!txtTienThua.getText().equals("0")) {
            txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Tiền Thừa : " + TienThua + " VNĐ" + "\n");
        }
        if (!txtNo.getText().equals("0")) {
            txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Tiền Nợ : " + No + " VNĐ" + "\n");
            txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "Hạn Trả Nợ : " + HanTraNo + "\n");
        }
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "-------------------------------------------------\n");
        txtInPhieuNhap.setText(txtInPhieuNhap.getText() + "                  Cảm Ơn Quý Khách            \n");
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
  
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

    }//GEN-LAST:event_jLabel10MouseClicked

    private void pnlTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMouseDragged

    }//GEN-LAST:event_pnlTitleMouseDragged

    private void pnlTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMousePressed

    }//GEN-LAST:event_pnlTitleMousePressed

    private void pnlChucNangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlChucNangFocusGained

    }//GEN-LAST:event_pnlChucNangFocusGained

    private void txtTongCongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongCongKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongCongKeyReleased

    private void txtTongCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongCongActionPerformed

    private void txtTienThueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienThueKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThueKeyReleased

    private void txtTienThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThueActionPerformed

    private void txtThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhToanKeyReleased
        double TienTra, TongTien, No, TienThua;

        TongTien = BLL.ChuyenDoi.ChuyenTien(pnlthemphieunhap.txtTongtien.getText());
        TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());

        txtThanhToan.setText(BLL.ChuyenDoi.DinhDangTien(TienTra));
        TienThua = TienTra - TongTien;
        No = TongTien - TienTra;

        txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
        txtTienThua.setText(ChuyenDoi.DinhDangTien(TienThua));
        if (TienTra > TongTien) {
            txtNo.setText("0");
            jdcHanTraCongNo.setEnabled(false);
            jdcHanTraCongNo.setDate(null);
        }
        if (TienTra < TongTien) {
            txtTienThua.setText("0");
            jdcHanTraCongNo.setEnabled(true);
            Date date = new Date();
            jdcHanTraCongNo.setDate(date);
             txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
        }
    }//GEN-LAST:event_txtThanhToanKeyReleased

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhToanActionPerformed

    private void txtTienHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienHangKeyReleased

    }//GEN-LAST:event_txtTienHangKeyReleased

    private void txtTienHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienHangActionPerformed

    private void txtTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaActionPerformed

    private void txtTienThuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienThuaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaKeyReleased

    private void txtNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoActionPerformed

    private void txtNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdlThanhToanPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdlThanhToanPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdlThanhToanPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdlThanhToanPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdlThanhToanPhieu dialog = new jdlThanhToanPhieu(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbbPhuongThuc;
    private javax.swing.JFileChooser jFileChooser3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcHanTraCongNo;
    private javax.swing.JLabel lblGhiChu15;
    private javax.swing.JLabel lblGhiChu17;
    private javax.swing.JLabel lblGhiChu18;
    private javax.swing.JLabel lblGhiChu19;
    private javax.swing.JLabel lblGhiChu20;
    private javax.swing.JLabel lblGhiChu21;
    private javax.swing.JLabel lblGhiChu22;
    private javax.swing.JLabel lblGhiChu23;
    private javax.swing.JLabel lblSoLuong2;
    private javax.swing.JLabel lblSoPhieuNhap;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlChucNang2;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTextField txtHanTraNo;
    private javax.swing.JTextArea txtInPhieuNhap;
    public static javax.swing.JTextField txtNo;
    public static javax.swing.JTextField txtThanhToan;
    public static javax.swing.JTextField txtTienHang;
    public static javax.swing.JTextField txtTienThua;
    public static javax.swing.JTextField txtTienThue;
    public static javax.swing.JTextField txtTongCong;
    // End of variables declaration//GEN-END:variables
}
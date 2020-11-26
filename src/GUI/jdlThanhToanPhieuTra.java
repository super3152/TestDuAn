/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChuyenDoi;
import DAO.DBConection;
import DTO.DTOKhachHang;
import DTO.DTOTraHang;
import DTO.MyCombobox;
import static GUI.pnltrahang.cbbKhachHang;
import java.awt.Font;
import java.io.File;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static GUI.pnltrahang.tblPhieutra;
import static GUI.pnltrahang.txtNgayTra;
import static GUI.pnltrahang.txtSoDonHang;
import static GUI.pnltrahang.txtSoDonTraHang;
import static GUI.pnltrahang.txtTongtien;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class jdlThanhToanPhieuTra extends javax.swing.JDialog {

    /**
     * Creates new form jdlThanhToanPhieuTra
     */
    public jdlThanhToanPhieuTra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblSoPhieuTra.setText(GUI.pnltrahang.txtSoDonTraHang.getText());
        txtTienTraHang.setText(GUI.pnltrahang.txtTongtien.getText());
        txtNoHoaDon.setText(GUI.pnltrahang.txtCongNo.getText());
        double TongTienTra = ChuyenDoi.ChuyenSangSo(txtTienTraHang.getText());
        double NoHoaDon = ChuyenDoi.ChuyenSangSo(txtNoHoaDon.getText());
        if (TongTienTra >= NoHoaDon) {
            txtTongCong.setText(ChuyenDoi.DinhDangTien(TongTienTra - NoHoaDon));
        } else if (TongTienTra < NoHoaDon) {
            txtTongCong.setText(ChuyenDoi.DinhDangTien(NoHoaDon - TongTienTra));
        }
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
        txtInPhieuTra = new javax.swing.JTextArea();
        pnlChucNang = new javax.swing.JPanel();
        lblSoLuong = new javax.swing.JLabel();
        lblGhiChu = new javax.swing.JLabel();
        txtTienTraHang = new javax.swing.JTextField();
        jFileChooser1 = new javax.swing.JFileChooser();
        cbbPhuongThuc = new javax.swing.JComboBox<>();
        lblGhiChu2 = new javax.swing.JLabel();
        txtNoHoaDon = new javax.swing.JTextField();
        lblGhiChu3 = new javax.swing.JLabel();
        lblGhiChu4 = new javax.swing.JLabel();
        txtTongCong = new javax.swing.JTextField();
        txtThanhToan = new javax.swing.JTextField();
        lblGhiChu5 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        pnlButton = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSoPhieuTra = new javax.swing.JLabel();

        txtInPhieuTra.setColumns(20);
        txtInPhieuTra.setRows(5);
        jScrollPane1.setViewportView(txtInPhieuTra);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THANH TOÁN PHIẾU TRẢ");

        pnlChucNang.setBackground(new java.awt.Color(153, 153, 153));
        pnlChucNang.setForeground(new java.awt.Color(255, 255, 255));
        pnlChucNang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnlChucNangFocusGained(evt);
            }
        });

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong.setText("Phương Thức Thanh Toán");

        lblGhiChu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu.setText("Tổng Tiền Trả Hàng");

        txtTienTraHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTienTraHang.setEnabled(false);

        jFileChooser1.setPreferredSize(new java.awt.Dimension(0, 0));

        cbbPhuongThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Quẹt Thẻ", "Chuyển Khoản", "COD", " " }));
        cbbPhuongThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPhuongThucActionPerformed(evt);
            }
        });

        lblGhiChu2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu2.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu2.setText("Nợ Hóa Đơn");

        txtNoHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNoHoaDon.setEnabled(false);

        lblGhiChu3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu3.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu3.setText("Tổng Cộng");

        lblGhiChu4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu4.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu4.setText("Thanh Toán");

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

        txtThanhToan.setText("0");
        txtThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtThanhToan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtThanhToanFocusGained(evt);
            }
        });
        txtThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtThanhToanKeyReleased(evt);
            }
        });

        lblGhiChu5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu5.setForeground(new java.awt.Color(255, 255, 255));
        lblGhiChu5.setText("Tiền Thừa");

        txtTienThua.setText("0");
        txtTienThua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTienThua.setEnabled(false);

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlChucNangLayout.createSequentialGroup()
                                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoLuong)
                                    .addComponent(lblGhiChu))
                                .addGap(36, 36, 36)
                                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbPhuongThuc, 0, 159, Short.MAX_VALUE)
                                    .addComponent(txtTienTraHang)))
                            .addGroup(pnlChucNangLayout.createSequentialGroup()
                                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGhiChu2)
                                    .addComponent(lblGhiChu3))
                                .addGap(122, 122, 122)
                                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtTongCong)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChucNangLayout.createSequentialGroup()
                                .addComponent(lblGhiChu4)
                                .addGap(123, 123, 123)
                                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChucNangLayout.createSequentialGroup()
                                .addComponent(lblGhiChu5)
                                .addGap(135, 135, 135)
                                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbPhuongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(txtTienTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addComponent(lblSoLuong)
                        .addGap(45, 45, 45)
                        .addComponent(lblGhiChu)))
                .addGap(18, 18, 18)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu2)
                    .addComponent(txtNoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGhiChu3)
                    .addComponent(txtTongCong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu4)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGhiChu5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGap(66, 66, 66)
                .addComponent(btnThoat)
                .addGap(65, 65, 65)
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
        lblTitle.setText("Thông tin thanh toán cho phiếu");

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
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTitleLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblSoPhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnlChucNang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlChucNangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlChucNangFocusGained

    }//GEN-LAST:event_pnlChucNangFocusGained

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        double TongTienTra = ChuyenDoi.ChuyenSangSo(txtTienTraHang.getText());
        double NoHoaDon = ChuyenDoi.ChuyenSangSo(txtNoHoaDon.getText());
        if (TongTienTra >= NoHoaDon) {
            if (BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText()) < BLL.ChuyenDoi.ChuyenTien(txtTongCong.getText())) {
                ThongBaoCanhBao.ThongBao("Shop chưa trả đủ tiền cho khách !", "Thông Báo !");
                return;
            }
        } else if (TongTienTra < NoHoaDon) {
            if (BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText()) < BLL.ChuyenDoi.ChuyenTien(txtTongCong.getText())) {
                ThongBaoCanhBao.ThongBao("Khách hàng chưa trả đủ tiền!", "Thông Báo !");
                return;
            }
        }
        
        String SoPhieuTra = lblSoPhieuTra.getText();
        String HoanTien;
        HoanTien = "Đã Thanh Toán";
        String TrangThai = "Đã Nhận";
        String HinhThucThanhToan = cbbPhuongThuc.getSelectedItem().toString();
        double KhachHangNo = 0;
        DTOKhachHang nkh = BLL.BLLKhachHang.GetTenKH(GUI.pnltrahang.cbbKhachHang.getSelectedItem().toString());
        double NoTrongBang = nkh.getCongNo();
        double NoDon = ChuyenDoi.ChuyenSangSo(txtNoHoaDon.getText());
        double NoConLai = NoTrongBang - NoDon;
        MyCombobox mbkh = (MyCombobox) GUI.pnltrahang.cbbKhachHang.getSelectedItem();
        int MaKH = Integer.parseInt(mbkh.Value.toString());
        DTO.DTOTraHang th = new DTOTraHang(SoPhieuTra, TrangThai, HoanTien, HinhThucThanhToan);
        String SoHoaDon = GUI.pnltrahang.txtSoDonHang.getText();
        BLL.BLLTraHang.SuaThanhToanTraHang(th);        
        DTO.DTOKhachHang kh = new DTO.DTOKhachHang(MaKH, NoConLai);
        BLL.BLLKhachHang.SuaNoTraHangKhachHang(kh);
        DTO.DTOHoaDon hd = new DTO.DTOHoaDon(SoHoaDon, KhachHangNo);
        BLL.BLLHoaDon.SuaNoHoaDonPhieuTra(hd);
        ThongBaoCanhBao.ThongBao("Thanh toán phiếu trả thành công!", "Thông Báo");
        BillPhieuTra();
        pnltrahang.btnThanhToan.setEnabled(false);
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                "Bạn Có Muốn In Hóa Đơn Phiếu Nhập Không ?", //thông báo
                "Thông Báo !", //tiêu đề
                JOptionPane.YES_NO_OPTION, //lựa chọn
                JOptionPane.ERROR_MESSAGE); // icon

        if (ketquasaukhibam == JOptionPane.YES_OPTION) {
           printRecord(txtInPhieuTra);
        }
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed
     public void BillPhieuTra() {
        String TongTien = txtTongtien.getText();
        String KhachHang = cbbKhachHang.getSelectedItem().toString();
        String SoHoaDon = txtSoDonHang.getText();
        String SoDontra = txtSoDonTraHang.getText();
        String NgayTra = txtNgayTra.getText();
        String NhanVien = BLL.BLLlogin.nguoidung.getTenNguoiDung();
        String TienKhachTra = txtThanhToan.getText();
        String TienThua = txtTienThua.getText();
 

        txtInPhieuTra.setText(txtInPhieuTra.getText() + "-------------------------------------------------\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "             SHOP QUẦN ÁO CHÂU NGÂN                         \n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "         70 Bà Triệu - TP. Buôn Ma Thuột                        \n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "               ĐT: 0905 28 51 51                      \n");
        txtInPhieuTra.setFont(txtInPhieuTra.getFont().deriveFont(Font.BOLD, 13f));

        txtInPhieuTra.setText(txtInPhieuTra.getText() + "-------------------------------------------------\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "                Phiêu Trả Hàng                       \n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "Khách Hàng : " + KhachHang + "\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "Số Đơn Trả : " + SoHoaDon + "\t" + "Ngày :" + NgayTra + "\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "Số Đơn Hàng : " + SoDontra + "\t" + "Nhân Viên : " + NhanVien + "\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "-------------------------------------------------\n");
        //Heading
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "Sản Phẩm" + "\t" + "SL" + "\t" + "Giá" + "\t" + "Phí Trả" + "\t" + "Thành Tiền" + "\n");

        for (int i = 0; i < tblPhieutra.getRowCount(); i++) {
            String TenSP = tblPhieutra.getValueAt(i, 2).toString();
            String Size = tblPhieutra.getValueAt(i, 3).toString();
            String Mau = tblPhieutra.getValueAt(i, 4).toString();
            int SoLuong = (int) tblPhieutra.getValueAt(i, 5);
            String Gia = tblPhieutra.getValueAt(i, 6).toString();
            String PhiTra = tblPhieutra.getValueAt(i, 7).toString();
            String ThanhTien = tblPhieutra.getValueAt(i, 8).toString();
            txtInPhieuTra.setText(txtInPhieuTra.getText() + TenSP + "-" + Size + "-" + Mau + "\t" + SoLuong + "\t" + Gia + "\t" + PhiTra + "\t" + ThanhTien + "\n");
        }
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "-------------------------------------------------\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "Tổng Tiền : " + TongTien + " VNĐ" + "\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "Tiền Trả : " + TienKhachTra + " VNĐ" + "\n");
        if (!txtTienThua.getText().equals("0")) {
            txtInPhieuTra.setText(txtInPhieuTra.getText() + "Tiền Thừa : " + TienThua + " VNĐ" + "\n");
        }
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "-------------------------------------------------\n");
        txtInPhieuTra.setText(txtInPhieuTra.getText() + "                  Cảm Ơn Quý Khách            \n");
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
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

    }//GEN-LAST:event_jLabel10MouseClicked

    private void pnlTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMouseDragged

    }//GEN-LAST:event_pnlTitleMouseDragged

    private void pnlTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMousePressed

    }//GEN-LAST:event_pnlTitleMousePressed

    private void cbbPhuongThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPhuongThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPhuongThucActionPerformed

    private void txtTongCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongCongActionPerformed

    private void txtTongCongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongCongKeyReleased

    }//GEN-LAST:event_txtTongCongKeyReleased

    private void txtThanhToanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtThanhToanFocusGained
        txtThanhToan.setText("");
    }//GEN-LAST:event_txtThanhToanFocusGained

    private void txtThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhToanKeyReleased
        double TienTra, TongTien, TienDu;
        
        TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongCong.getText());
        TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
        
        txtThanhToan.setText(BLL.ChuyenDoi.DinhDangTien(TienTra));
        
        TienDu = TienTra - TongTien;
        
        txtTienThua.setText(BLL.ChuyenDoi.DinhDangTien(TienDu));
        if (TienTra < TongTien) {
            txtTienThua.setText("0");
        }
    }//GEN-LAST:event_txtThanhToanKeyReleased

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
            java.util.logging.Logger.getLogger(jdlThanhToanPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdlThanhToanPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdlThanhToanPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdlThanhToanPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdlThanhToanPhieuTra dialog = new jdlThanhToanPhieuTra(new javax.swing.JFrame(), true);
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
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblGhiChu2;
    private javax.swing.JLabel lblGhiChu3;
    private javax.swing.JLabel lblGhiChu4;
    private javax.swing.JLabel lblGhiChu5;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblSoPhieuTra;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTextArea txtInPhieuTra;
    public static javax.swing.JTextField txtNoHoaDon;
    public static javax.swing.JTextField txtThanhToan;
    public static javax.swing.JTextField txtTienThua;
    public static javax.swing.JTextField txtTienTraHang;
    public static javax.swing.JTextField txtTongCong;
    // End of variables declaration//GEN-END:variables
}

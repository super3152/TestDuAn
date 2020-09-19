/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DBConection;
import DTO.DTOKhachHang;
import DTO.DTOLoaiKhachHang;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Takemikazuchi
 */
public final class pnlkhachhang extends javax.swing.JPanel {

    /**
     * Creates new form 
     */
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    DTOKhachHang khachhang;
    DTOLoaiKhachHang loaikh;
    public ArrayList<DTOKhachHang> LayKhachHang(){
         ArrayList<DTOKhachHang> khachhangs = new ArrayList<DTOKhachHang>();
            conn = DBConection.getDatabase();
            String query = "SELECT * FROM khachhang";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                khachhang = new DTOKhachHang(rs.getInt("idkhachhang"), rs.getInt("idloaikhachhang"), rs.getInt("idnguoidung"), rs.getString("tenkhachhang"),
                rs.getInt("sodienthoai"), rs.getString("email"), rs.getString("matkhau"), rs.getDate("ngaysinh"), rs.getString("diachi"), rs.getString("gioitinh"),
                rs.getString("mangxahoi"), rs.getString("mota"),rs.getString("tag"));
                khachhangs.add(khachhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
      return khachhangs;
    }
        public ArrayList<DTOLoaiKhachHang> LayLoaiKhachHang() {
        ArrayList<DTOLoaiKhachHang> loaikhachhang = new ArrayList<DTOLoaiKhachHang>();
         conn = DBConection.getDatabase();
        String query = "select * from loaikhachhang";
        try {
             st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                loaikh = new DTOLoaiKhachHang(rs.getInt("idloaikhachhang"), rs.getString("tenloaikhachhang"), rs.getString("uudai"), rs.getString("mota"));
                loaikhachhang.add(loaikh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaikhachhang; 
        
}
      
 
       
            public ArrayList<DTOKhachHang> LayKhachHangTheoMa(int MaLoaiKhachHang){
         ArrayList<DTOKhachHang> laykhachhang = new ArrayList<DTOKhachHang>();
            conn = DBConection.getDatabase();
            String query = "SELECT * FROM khachhang where idloaikhachhang = '" + MaLoaiKhachHang + "'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                khachhang = new DTOKhachHang(rs.getInt("idkhachhang"), rs.getInt("idloaikhachhang"), rs.getInt("idnguoidung"), rs.getString("tenkhachhang"),
                rs.getInt("sodienthoai"), rs.getString("email"), rs.getString("matkhau"), rs.getDate("ngaysinh"), rs.getString("diachi"), rs.getString("gioitinh"),
                rs.getString("mangxahoi"), rs.getString("mota"),rs.getString("tag"));
                laykhachhang.add(khachhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
      return laykhachhang;
    }
            public void HienThiKhachHang1(JTable tbl){
        ArrayList<DTOLoaiKhachHang> danhsachkh =  LayLoaiKhachHang();
        DefaultTableModel model = (DefaultTableModel) tblkhachhang.getModel();
        //clead khi chạy không chồng dữ liệu lên nhau
        model.setRowCount(0);
        Object[] row = new Object[8];
        for(int i =0;i<danhsachkh.size();i++){
            row[0] = danhsachkh.get(i).getIdLoaiKhachHang();
            row[1] = danhsachkh.get(i).getTenLoaiKhachHang();
            row[2] = danhsachkh.get(i).getUuDai();
            row[3] = danhsachkh.get(i).getMoTa();

            model.addRow(row);
        }
    }
             public void HienThiKhachHangTheoMa1(JTable tbl,int MaLKH){
        ArrayList<DTOKhachHang> danhsachkh = LayKhachHangTheoMa(MaLKH);
        DefaultTableModel model = (DefaultTableModel) tblkhachhang.getModel();
        //clead khi chạy không chồng dữ liệu lên nhau
        model.setRowCount(0);
        Object[] row = new Object[8];
        for(int i =0;i<danhsachkh.size();i++){
            row[0] = danhsachkh.get(i).getIdKhachHang();
            row[1] = danhsachkh.get(i).getTenKhachHang();
            row[2] = danhsachkh.get(i).getSoDienThoai();
            row[3] = danhsachkh.get(i).getEmail();
            row[4] = danhsachkh.get(i).getNgaySinh();
            row[5] = danhsachkh.get(i).getDiaChi();
             if (danhsachkh.get(i).getGioiTinh().equals(1)) {
                    row[6] = "Nữ";
                } else {
                    row[6] = "Nam";
                }
      
            row[7] = danhsachkh.get(i).getMangXaHoi();
            model.addRow(row);
        }
    }
    public void HienThiKhachHang(){
        ArrayList<DTOKhachHang> danhsachkh = LayKhachHang();
        DefaultTableModel model = (DefaultTableModel) tblkhachhang.getModel();
        //clead khi chạy không chồng dữ liệu lên nhau
        model.setRowCount(0);
        Object[] row = new Object[8];
        for(int i =0;i<danhsachkh.size();i++){
            row[0] = danhsachkh.get(i).getIdKhachHang();
            row[1] = danhsachkh.get(i).getTenKhachHang();
            row[2] = danhsachkh.get(i).getSoDienThoai();
            row[3] = danhsachkh.get(i).getEmail();
            row[4] = danhsachkh.get(i).getNgaySinh();
            row[5] = danhsachkh.get(i).getDiaChi();
             if (danhsachkh.get(i).getGioiTinh().equals(1)) {
                    row[6] = "Nữ";
                } else {
                    row[6] = "Nam";
                }
      
            row[7] = danhsachkh.get(i).getMangXaHoi();
            model.addRow(row);
        }
    }
      private void FillKhachHang() {
        pnlLoaiKhachHang.removeAll();

        DefaultTableModel dtm = (DefaultTableModel) tblkhachhang.getModel();
        dtm.setRowCount(0);

        ArrayList<DTOLoaiKhachHang> loaikhachhang = LayLoaiKhachHang();
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

                        HienThiKhachHangTheoMa1(tblkhachhang, loaikhachhang.get(j).getIdLoaiKhachHang());
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
            pnlLoaiKhachHang.add(pnlBan[i]);
        }
        pnlLoaiKhachHang.updateUI();
    }
    public pnlkhachhang() {
        try{
              for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
              {
                  if ("Windows".equals(info.getName()))
                  {
                      UIManager.setLookAndFeel(info.getClassName());
                      break;
                  }
              }
          }catch(Exception ex){
               
    }
  
          initComponents();
          System.out.println(LayKhachHang());
          FillKhachHang();
          HienThiKhachHang();
          cbbloc.setBackground(Color.WHITE);
          tblkhachhang.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
          tblkhachhang.getTableHeader().setOpaque(false);        
          tblkhachhang.getTableHeader().setBackground(new Color(33,36,51));          
          tblkhachhang.getTableHeader().setForeground(Color.WHITE);
          tblkhachhang.setRowHeight(25);
          
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpchuyentab = new javax.swing.JTabbedPane();
        pnldanhsach = new javax.swing.JPanel();
        cbbloc = new javax.swing.JComboBox<>();
        srcdanhsach = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();
        txttimkiem = new javax.swing.JTextField();
        pnlLoaiKhachHang = new javax.swing.JPanel();
        lbltieude = new javax.swing.JLabel();
        pnlthemsuakhachhang = new javax.swing.JPanel();
        pnlnennoidung = new javax.swing.JPanel();
        pnlcoban = new javax.swing.JPanel();
        lbthongtincoban = new javax.swing.JLabel();
        lblhoten = new javax.swing.JLabel();
        lblsdt = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        lblmatkhau = new javax.swing.JLabel();
        pnlanh = new javax.swing.JPanel();
        pnlnenanh = new javax.swing.JPanel();
        lbltenanh = new javax.swing.JLabel();
        pnldiachi = new javax.swing.JPanel();
        txtdiachiht = new javax.swing.JTextField();
        lbldiachi = new javax.swing.JLabel();
        lblhuyen = new javax.swing.JLabel();
        lbltinh = new javax.swing.JLabel();
        lblxa = new javax.swing.JLabel();
        lbldiachiht = new javax.swing.JLabel();
        cbbxa = new javax.swing.JComboBox<>();
        cbbtinh = new javax.swing.JComboBox<>();
        cbbhuyen = new javax.swing.JComboBox<>();
        pnlbosung = new javax.swing.JPanel();
        cbbgioitinh = new javax.swing.JComboBox<>();
        txtngaysinh = new javax.swing.JTextField();
        lblgioitinh = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        lblmxh = new javax.swing.JLabel();
        lblngaysinh = new javax.swing.JLabel();
        lblbosung = new javax.swing.JLabel();
        txtmxh = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        pnlkhac = new javax.swing.JPanel();
        lblkhac = new javax.swing.JLabel();
        lblnguoithem = new javax.swing.JLabel();
        cbbnguoithem = new javax.swing.JComboBox<>();
        cbbnhom = new javax.swing.JComboBox<>();
        lblnhom = new javax.swing.JLabel();
        lblmota = new javax.swing.JLabel();
        txtmota = new javax.swing.JTextField();
        bttsua = new javax.swing.JButton();
        bttthem = new javax.swing.JButton();
        sprkengang = new javax.swing.JSeparator();
        btterset = new javax.swing.JButton();

        setBackground(new java.awt.Color(33, 36, 51));
        setPreferredSize(new java.awt.Dimension(980, 620));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        tbpchuyentab.setBackground(new java.awt.Color(255, 255, 255));
        tbpchuyentab.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        pnldanhsach.setBackground(new java.awt.Color(33, 36, 51));
        pnldanhsach.setPreferredSize(new java.awt.Dimension(980, 618));

        cbbloc.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cbbloc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc khách hàng" }));
        cbbloc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbbloc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbbloc.setFocusCycleRoot(true);
        cbbloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbblocActionPerformed(evt);
            }
        });

        tblkhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblkhachhang.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", "", "", null, null},
                {"", "", "", "", "", "", null, null},
                {"", "", "", "", "", null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số Điện Thoại", "Email", "Ngày Sinh", "Địa Chỉ", "Giới Tính", "Mạng Xã Hội"
            }
        ));
        tblkhachhang.setDragEnabled(true);
        tblkhachhang.setFocusable(false);
        tblkhachhang.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblkhachhang.setName(""); // NOI18N
        tblkhachhang.setRowHeight(25);
        tblkhachhang.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblkhachhang.setShowVerticalLines(false);
        tblkhachhang.getTableHeader().setReorderingAllowed(false);
        srcdanhsach.setViewportView(tblkhachhang);

        txttimkiem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlLoaiKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlLoaiKhachHang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbltieude.setBackground(new java.awt.Color(33, 36, 51));
        lbltieude.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbltieude.setForeground(new java.awt.Color(255, 255, 255));
        lbltieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltieude.setText("Loại khách hàng");
        lbltieude.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnldanhsachLayout = new javax.swing.GroupLayout(pnldanhsach);
        pnldanhsach.setLayout(pnldanhsachLayout);
        pnldanhsachLayout.setHorizontalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltieude, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addComponent(cbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                    .addComponent(srcdanhsach)))
        );
        pnldanhsachLayout.setVerticalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltieude, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLoaiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(srcdanhsach)))
        );

        cbbloc.getAccessibleContext().setAccessibleParent(cbbloc);

        tbpchuyentab.addTab("Danh sách khách hàng", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/list_20px.png")), pnldanhsach); // NOI18N

        pnlthemsuakhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlthemsuakhachhang.setForeground(new java.awt.Color(255, 255, 255));

        pnlnennoidung.setBackground(new java.awt.Color(244, 246, 248));

        pnlcoban.setBackground(new java.awt.Color(255, 255, 255));
        pnlcoban.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbthongtincoban.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbthongtincoban.setText("Thông tin cơ bản");

        lblhoten.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblhoten.setText("Họ tên khách hàng");

        lblsdt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblsdt.setText("Số điện thoại        ");

        txthoten.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtsdt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lblemail.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblemail.setText("Email");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        lblmatkhau.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblmatkhau.setText("Mật khẩu");

        javax.swing.GroupLayout pnlcobanLayout = new javax.swing.GroupLayout(pnlcoban);
        pnlcoban.setLayout(pnlcobanLayout);
        pnlcobanLayout.setHorizontalGroup(
            pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcobanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbthongtincoban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlcobanLayout.createSequentialGroup()
                        .addComponent(jTextField4)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField5))
                    .addGroup(pnlcobanLayout.createSequentialGroup()
                        .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlcobanLayout.createSequentialGroup()
                                .addComponent(lblhoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addGroup(pnlcobanLayout.createSequentialGroup()
                                .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txthoten))
                                .addGap(9, 9, 9)))
                        .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlcobanLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        pnlcobanLayout.setVerticalGroup(
            pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcobanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbthongtincoban, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addComponent(lblhoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(lblemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlcobanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlanh.setBackground(new java.awt.Color(255, 255, 255));
        pnlanh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlnenanhLayout = new javax.swing.GroupLayout(pnlnenanh);
        pnlnenanh.setLayout(pnlnenanhLayout);
        pnlnenanhLayout.setHorizontalGroup(
            pnlnenanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlnenanhLayout.setVerticalGroup(
            pnlnenanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbltenanh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbltenanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltenanh.setText("Ảnh đại diện");

        javax.swing.GroupLayout pnlanhLayout = new javax.swing.GroupLayout(pnlanh);
        pnlanh.setLayout(pnlanhLayout);
        pnlanhLayout.setHorizontalGroup(
            pnlanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlanhLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(pnlnenanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlanhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltenanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlanhLayout.setVerticalGroup(
            pnlanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlanhLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(pnlnenanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltenanh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnldiachi.setBackground(new java.awt.Color(255, 255, 255));
        pnldiachi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtdiachiht.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lbldiachi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbldiachi.setText("Thông tin địa chỉ");

        lblhuyen.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblhuyen.setText("Huyện               ");

        lbltinh.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbltinh.setText("Tỉnh                    ");

        lblxa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblxa.setText("Xã, Phường          ");

        lbldiachiht.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbldiachiht.setText("Địa chỉ hiện tại     ");

        javax.swing.GroupLayout pnldiachiLayout = new javax.swing.GroupLayout(pnldiachi);
        pnldiachi.setLayout(pnldiachiLayout);
        pnldiachiLayout.setHorizontalGroup(
            pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldiachiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldiachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnldiachiLayout.createSequentialGroup()
                        .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdiachiht)
                            .addComponent(lbldiachiht, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbxa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnldiachiLayout.createSequentialGroup()
                        .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbhuyen, 0, 327, Short.MAX_VALUE)
                            .addComponent(lblhuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbtinh, 0, 327, Short.MAX_VALUE)
                            .addComponent(lbltinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnldiachiLayout.setVerticalGroup(
            pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnldiachiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblxa, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lbldiachiht, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiachiht, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbxa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltinh, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lblhuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldiachiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbtinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbhuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlbosung.setBackground(new java.awt.Color(255, 255, 255));
        pnlbosung.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtngaysinh.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lblgioitinh.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblgioitinh.setText("Giới tính               ");

        lblid.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblid.setText("ID khách hàng (Xem không sửa)");

        lblmxh.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblmxh.setText("Mạng xã hội");

        lblngaysinh.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblngaysinh.setText("Ngày sinh             ");

        lblbosung.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblbosung.setText("Thông tin bổ sung");

        javax.swing.GroupLayout pnlbosungLayout = new javax.swing.GroupLayout(pnlbosung);
        pnlbosung.setLayout(pnlbosungLayout);
        pnlbosungLayout.setHorizontalGroup(
            pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbosungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbosung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlbosungLayout.createSequentialGroup()
                        .addGroup(pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmxh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblngaysinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(txtngaysinh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblmxh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblgioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(cbbgioitinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtid))))
                .addContainerGap())
        );
        pnlbosungLayout.setVerticalGroup(
            pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbosungLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblbosung, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblgioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lblngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblid, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lblmxh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlbosungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmxh, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtid))
                .addContainerGap())
        );

        pnlkhac.setBackground(new java.awt.Color(255, 255, 255));
        pnlkhac.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblkhac.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblkhac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblkhac.setText("Thông tin khác");

        lblnguoithem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblnguoithem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblnguoithem.setText("Nhân viên phụ trách");
        lblnguoithem.setToolTipText("");

        cbbnguoithem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbnhom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblnhom.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblnhom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblnhom.setText("Nhóm khách hàng");
        lblnhom.setToolTipText("");

        lblmota.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblmota.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblmota.setText("Mô tả");
        lblmota.setToolTipText("");

        javax.swing.GroupLayout pnlkhacLayout = new javax.swing.GroupLayout(pnlkhac);
        pnlkhac.setLayout(pnlkhacLayout);
        pnlkhacLayout.setHorizontalGroup(
            pnlkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlkhacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnguoithem, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(cbbnguoithem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblnhom, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(cbbnhom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblmota, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(txtmota))
                .addContainerGap())
            .addGroup(pnlkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlkhacLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblkhac, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlkhacLayout.setVerticalGroup(
            pnlkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlkhacLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblnguoithem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbnguoithem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnhom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbnhom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmota, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlkhacLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblkhac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(244, Short.MAX_VALUE)))
        );

        bttsua.setText("Sửa ");

        bttthem.setText("Thêm");

        btterset.setText("Reset");

        javax.swing.GroupLayout pnlnennoidungLayout = new javax.swing.GroupLayout(pnlnennoidung);
        pnlnennoidung.setLayout(pnlnennoidungLayout);
        pnlnennoidungLayout.setHorizontalGroup(
            pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnennoidungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sprkengang)
                    .addGroup(pnlnennoidungLayout.createSequentialGroup()
                        .addGap(581, 581, 581)
                        .addComponent(btterset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlnennoidungLayout.createSequentialGroup()
                        .addGroup(pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlbosung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlcoban, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnldiachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlkhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlnennoidungLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(pnlanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)))))
                .addContainerGap())
        );
        pnlnennoidungLayout.setVerticalGroup(
            pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnennoidungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlnennoidungLayout.createSequentialGroup()
                        .addComponent(pnlcoban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnldiachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlbosung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlnennoidungLayout.createSequentialGroup()
                        .addComponent(pnlanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlkhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sprkengang, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttthem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttsua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btterset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout pnlthemsuakhachhangLayout = new javax.swing.GroupLayout(pnlthemsuakhachhang);
        pnlthemsuakhachhang.setLayout(pnlthemsuakhachhangLayout);
        pnlthemsuakhachhangLayout.setHorizontalGroup(
            pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnennoidung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlthemsuakhachhangLayout.setVerticalGroup(
            pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlthemsuakhachhangLayout.createSequentialGroup()
                .addComponent(pnlnennoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        tbpchuyentab.addTab("Thêm & Sửa khách hàng", pnlthemsuakhachhang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbblocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbblocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbblocActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btterset;
    private javax.swing.JButton bttsua;
    private javax.swing.JButton bttthem;
    private javax.swing.JComboBox<String> cbbgioitinh;
    private javax.swing.JComboBox<String> cbbhuyen;
    private javax.swing.JComboBox<String> cbbloc;
    private javax.swing.JComboBox<String> cbbnguoithem;
    private javax.swing.JComboBox<String> cbbnhom;
    private javax.swing.JComboBox<String> cbbtinh;
    private javax.swing.JComboBox<String> cbbxa;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblbosung;
    private javax.swing.JLabel lbldiachi;
    private javax.swing.JLabel lbldiachiht;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblgioitinh;
    private javax.swing.JLabel lblhoten;
    private javax.swing.JLabel lblhuyen;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblkhac;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblmota;
    private javax.swing.JLabel lblmxh;
    private javax.swing.JLabel lblngaysinh;
    private javax.swing.JLabel lblnguoithem;
    private javax.swing.JLabel lblnhom;
    private javax.swing.JLabel lblsdt;
    private javax.swing.JLabel lbltenanh;
    private javax.swing.JLabel lbltieude;
    private javax.swing.JLabel lbltinh;
    private javax.swing.JLabel lblxa;
    private javax.swing.JLabel lbthongtincoban;
    private javax.swing.JPanel pnlLoaiKhachHang;
    private javax.swing.JPanel pnlanh;
    private javax.swing.JPanel pnlbosung;
    private javax.swing.JPanel pnlcoban;
    private javax.swing.JPanel pnldanhsach;
    private javax.swing.JPanel pnldiachi;
    private javax.swing.JPanel pnlkhac;
    private javax.swing.JPanel pnlnenanh;
    private javax.swing.JPanel pnlnennoidung;
    private javax.swing.JPanel pnlthemsuakhachhang;
    private javax.swing.JSeparator sprkengang;
    private javax.swing.JScrollPane srcdanhsach;
    private javax.swing.JTable tblkhachhang;
    private javax.swing.JTabbedPane tbpchuyentab;
    private javax.swing.JTextField txtdiachiht;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtmxh;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Admin
 */
public class ThongBaoThoat {
    public static void ThongBao(){
        Object[] options = {"Đồng ý", "Không!"};
        int ketquasaukhibam = JOptionPane.showOptionDialog(new JFrame(),
                "Xác nhận thoát ?", //thông báo 
                "Thông báo!", //tiêu đề  
                JOptionPane.YES_NO_OPTION, //lựa chọn 
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]
                ); 
        if (ketquasaukhibam == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            
        }
    }//đóng của thông báo 
}//đóng của thông báo 

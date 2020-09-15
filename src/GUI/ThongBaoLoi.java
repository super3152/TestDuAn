/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ThongBaoLoi {
    public static void ThongBao(String NoiDung,String TieuDe){
        JOptionPane.showMessageDialog(new JFrame(), NoiDung, TieuDe, JOptionPane.ERROR_MESSAGE);
    }
}

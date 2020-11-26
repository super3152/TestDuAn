/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOChiTietTraHang {
      public static ResultSet LayCTTHTheoMaTH(int MaTH) {
        String query = "SELECT * FROM `chitiettrahang` WHERE `idtrahang` = '" + MaTH + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}

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
public class DAOKe {
     public static ResultSet LayKe(String IDKe) {
        String query = "SELECT * FROM `kesanpham` WHERE `idke` like '%" + IDKe + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayKeTheoID(String IDKe) {
        String query = "SELECT * FROM `kesanpham` WHERE `idke` = '" + IDKe + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}

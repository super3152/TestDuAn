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
public class DAOChiNhanh {
    public static ResultSet LayChiNhanhTheoMa(int MaChiNhanh) {
        String query = "SELECT * FROM chinhanh where idchinhanh =  '" + MaChiNhanh + "'";
        ResultSet rs = DBConection.GetData(query);

        return rs;
    }
}

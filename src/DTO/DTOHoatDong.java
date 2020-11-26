/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author KMB1604
 */
public class DTOHoatDong {
    int idloaihoatdong;
    int idnguoidung;
  

    public DTOHoatDong(int idloaihoatdong, int idnguoidung) {
        this.idloaihoatdong = idloaihoatdong;
        this.idnguoidung = idnguoidung;
      
    }

    
    
    
    public int getIdloaihoatdong() {
        return idloaihoatdong;
    }

    public void setIdloaihoatdong(int idloaihoatdong) {
        this.idloaihoatdong = idloaihoatdong;
    }

    public int getIdnguoidung() {
        return idnguoidung;
    }

    public void setIdnguoidung(int idnguoidung) {
        this.idnguoidung = idnguoidung;
    }

   
    
    
    
            
}

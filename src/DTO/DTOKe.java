/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class DTOKe {
    int IDKe;
    String TenKe;
    String MoTa;

    public DTOKe(int IDKe, String TenKe, String MoTa) {
        this.IDKe = IDKe;
        this.TenKe = TenKe;
        this.MoTa = MoTa;
    }

    public DTOKe(String TenKe, String MoTa) {
        this.TenKe = TenKe;
        this.MoTa = MoTa;
    }

    public int getIDKe() {
        return IDKe;
    }

    public void setIDKe(int IDKe) {
        this.IDKe = IDKe;
    }

    public String getTenKe() {
        return TenKe;
    }

    public void setTenKe(String TenKe) {
        this.TenKe = TenKe;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
}

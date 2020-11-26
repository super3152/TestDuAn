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
public class DTOSize {
    int IDSize;
    String TenSize;
    String MoTa;

    public DTOSize() {
    }

    public DTOSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public DTOSize(int IDSize, String TenSize, String MoTa) {
        this.IDSize = IDSize;
        this.TenSize = TenSize;
        this.MoTa = MoTa;
    }

    public DTOSize(String TenSize, String MoTa) {
        this.TenSize = TenSize;
        this.MoTa = MoTa;
    }

    public int getIDSize() {
        return IDSize;
    }

    public void setIDSize(int IDSize) {
        this.IDSize = IDSize;
    }

    public String getTenSize() {
        return TenSize;
    }

    public void setTenSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
}

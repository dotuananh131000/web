/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author hungj
 */
public class NguoiHoc {

    private String maNH;
    private String hoTen;
    private boolean gioiTinh;
    private String namSinh;
    private String sdt;

    public NguoiHoc() {
    }

    public NguoiHoc(String maNH, String hoTen, boolean gioiTinh, String namSinh, String sdt) {
        this.maNH = maNH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.sdt = sdt;
    }



    public String getMaNH() {
        return maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.getMaNH(),
            this.getHoTen(),
            this.isGioiTinh() ? "Nam" : "Nu",
            this.getNamSinh(),
            this.getSdt(),};
    }
    public Date getNamSinhDate (){
        LocalDate ld = LocalDate.parse(this.namSinh);
        Date d = Date.valueOf(ld);
        return d;
    }

    @Override
    public String toString() {
        return "NguoiHoc{" + "maNH=" + maNH + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", namSinh=" + namSinh + ", sdt=" + sdt + '}';
    }

    


}

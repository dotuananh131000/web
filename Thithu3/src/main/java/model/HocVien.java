/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hungj
 */
public class HocVien {
    private int maHV;
    private float diem;
    private int maKH;
    private String maNH;

    public HocVien() {
    }

    public HocVien(int maHV, float diem, int maKH, String maNH) {
        this.maHV = maHV;
        this.diem = diem;
        this.maKH = maKH;
        this.maNH = maNH;
    }

    public int getMaHV() {
        return maHV;
    }

    public float getDiem() {
        return diem;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    @Override
    public String toString() {
        return "HocVien{" + "maHV=" + maHV + ", diem=" + diem + ", maKH=" + maKH + ", maNH=" + maNH + '}';
    }
    
    public Object [] toDataRow (){
        return new Object[]{
          this.getMaHV(),
            this.getMaKH(),
            this.getDiem(),
            this.getMaNH()
            
        };
    }
}

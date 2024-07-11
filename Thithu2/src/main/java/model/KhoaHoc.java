/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hungj
 */
public class KhoaHoc {

    private int maKH;
    private String ngayLap;
    private String maCD;
    private int thoiLuong;

    public KhoaHoc() {
    }

    public KhoaHoc(int maKH, String ngayLap, String maCD, int thoiLuong) {
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.maCD = maCD;
        this.thoiLuong = thoiLuong;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public String getMaCD() {
        return maCD;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Object [] toDataRow (){
        return new Object []{
            this.getMaKH(),
            this.getNgayLap(),
            this.getMaCD(),
            this.getThoiLuong()
        };
    }

    @Override
    public String toString() {
        return "KhoaHoc{" + "maKH=" + maKH + ", ngayLap=" + ngayLap + ", maCD=" + maCD + ", thoiLuong=" + thoiLuong + '}';
    }

}

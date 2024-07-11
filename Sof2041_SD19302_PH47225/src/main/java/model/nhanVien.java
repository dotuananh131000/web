/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aduc7
 */
public class nhanVien {
    private String maNV;
    private  String matKhau;
    private String hoTen;
    private boolean Vaitro;

    public nhanVien() {
    }

    public nhanVien(String maNV, String matKhau, String hoTen, boolean Vaitro) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.Vaitro = Vaitro;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isVaitro() {
        return Vaitro;
    }

    public void setVaitro(boolean Vaitro) {
        this.Vaitro = Vaitro;
    }

   
    

  
   
}

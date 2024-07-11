/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ketnoi.SqlSever;

/**
 *
 * @author aduc7
 */
public class nhanVienservice {
    public ArrayList<nhanVien> list = new ArrayList();
   public void loaddata() {
    try {
        SqlSever kn = new SqlSever("sof2041", "sa", "1212");
        Connection con = kn.getConnection();
        String sql = "SELECT * FROM nhanvien";
        PreparedStatement pre = con.prepareStatement(sql);
        ResultSet resu = pre.executeQuery();
        while (resu.next()) {
            String maNV = resu.getNString("manv");
            String matKhau = resu.getString("matkhau");
            String hoTen = resu.getString("hoten");
            boolean vaiTro = resu.getBoolean("vaitro"); // Retrieve boolean value directly
            String vaiTroString = vaiTro ? "Trưởng phòng" : "Nhân Viên"; // Convert boolean to string representation
            nhanVien nv = new nhanVien(maNV, matKhau, hoTen, vaiTro);
            list.add(nv);
        }
        con.close();
    } catch (Exception e) {
        // Handle exceptions appropriately
    }
}
   public void update(int vitri,nhanVien nv){
   list.set(vitri, nv);
   }
    
    
}

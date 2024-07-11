/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import JDBC.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.NguoiHoc;
import model.SoDienThoai;

/**
 *
 * @author hungj
 */
public class NguoiHocService {

    ArrayList<NguoiHoc> listNH = new ArrayList<>();

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet re = null;
    private String sql = null;

    public ArrayList<NguoiHoc> getAll() {
        ArrayList<NguoiHoc> listNH =new ArrayList<>();

        sql = """
              select maNH , hoTen , gioiTinh ,ngaysinh  , dienThoai
              from NguoiHoc
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                String maNH, hoTen, dienThoai, ngaySinh;
                boolean gioiTinh;
                maNH = re.getString(1);
                hoTen = re.getString(2);
                gioiTinh = re.getBoolean(3);
                ngaySinh = re.getString(4);
                dienThoai = re.getString(5);
                listNH.add(new NguoiHoc(maNH, hoTen, gioiTinh, ngaySinh, dienThoai));
            }
            return listNH;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<NguoiHoc> timKiem(String hoten) {
        ArrayList<NguoiHoc> listNH = new ArrayList();
        sql = """
         select maNH , hoTen , gioiTinh ,ngaysinh  , dienThoai from nguoihoc
                where hoTen like ?
         """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, '%' + hoten + '%');
            re = ps.executeQuery();
            while (re.next()) {
                String maNH, hoTen, dienThoai, ngaySinh;
                boolean gioiTinh;
                maNH = re.getString(1);
                hoTen = re.getString(2);
                gioiTinh = re.getBoolean(3);
                ngaySinh = re.getString(4);
                dienThoai = re.getString(5);
                listNH.add(new NguoiHoc(maNH, hoTen, gioiTinh, ngaySinh, dienThoai));
            }
            return listNH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<SoDienThoai> getSoDienThoai() {

        ArrayList<SoDienThoai> lstSoDienThoai = new ArrayList<>();
        sql = """
              select dienthoai from nguoihoc
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                String sdt;
                sdt = re.getString(1);
                lstSoDienThoai.add(new SoDienThoai(sdt));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return lstSoDienThoai;
    }

    public int addNguoiHoc(NguoiHoc nh) {

        sql = """
              insert into nguoihoc(maNH , hoTen , gioiTinh ,ngaysinh  , dienThoai)
                     values(?,?,?,?,?);
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nh.getMaNH());
            ps.setObject(2, nh.getHoTen());
            ps.setObject(3, nh.isGioiTinh());
            ps.setObject(4, nh.getNamSinh());
            ps.setObject(5, nh.getSdt());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

//    public boolean updteNguoiHoc(NguoiHoc nh)  {
//         sql = """
//               UPDATE nguoihoc SET  hoTen = ?, gioiTinh = ?, ngaysinh = ?, dienThoai = ?
//               WHERE maNH = ?
//               """;
//
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//
//            ps.setString(1, nh.getHoTen());
//            ps.setString(2, nh.getNamSinh());
//            ps.setBoolean(3, nh.isGioiTinh());
//            ps.setString(4, nh.getSdt());
//            ps.setString(5, nh.getMaNH());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public Integer updteNguoiHoc(NguoiHoc nh) {
        Integer row = null;
        sql = """
              update nguoihoc set hoten =?, gioitinh=?, ngaysinh = ?, dienthoai = ? where manh=?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, nh.getHoTen());
            ps.setBoolean(2, nh.isGioiTinh());
            ps.setDate(3, nh.getNamSinhDate());

            ps.setString(4, nh.getSdt());
            ps.setString(5, nh.getMaNH());

            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public int xoa(NguoiHoc nh) {
        sql = """
              delete From nguoihoc where maNH =?;
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nh.getMaNH());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}

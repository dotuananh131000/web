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
import model.ChuyenDe;
import model.KhoaHoc;

/**
 *
 * @author hungj
 */
public class KhoaHocService {

    ArrayList<KhoaHoc> listKH = new ArrayList<>();
    private Connection con = null;
    private ResultSet re = null;
    private PreparedStatement ps = null;
    private String sql = null;

    public ArrayList<KhoaHoc> getAll() {
        ArrayList<KhoaHoc> listKH = new ArrayList<>();

        sql = """
              select makh, ngaytao, macd , thoiluong from khoahoc
              
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {

                String macd, ngaytao;
                int makh, thoiluong;
                makh = re.getInt(1);
                ngaytao = re.getString(2);
                macd = re.getString(3);
                thoiluong = re.getInt(4);
                listKH.add(new KhoaHoc(makh, ngaytao, macd, thoiluong));

            }
                    return listKH;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ChuyenDe> getChuyenDe() {
        ArrayList<ChuyenDe> listChuyenDe = new ArrayList<>();

        sql = """
              select macd from Khoahoc
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                String macd;
                macd = re.getString(1);
                listChuyenDe.add(new ChuyenDe(macd));

            }
                    return listChuyenDe;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<KhoaHoc> timKiem(int thoiluongTK) {
        ArrayList<KhoaHoc> listKH = new ArrayList<>();

        sql = """
              select makh, ngaytao, macd , thoiluong from khoahoc
              where thoiluong > ?
              order by thoiluong desc
              
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, thoiluongTK);
            re = ps.executeQuery();
            while (re.next()) {
                String ngaytao, macd;
                int makh, thoiluong;

                makh = re.getInt(1);
                ngaytao = re.getString(2);
                macd = re.getString(3);
                thoiluong = re.getInt(4);

                listKH.add(new KhoaHoc(makh, ngaytao, macd, thoiluong));
            }
                    return listKH;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer addNguoiHoc(KhoaHoc kh) {
        Integer row = null;
        sql = """
              insert into khoahoc(thoiluong, ngaytao, macd)
              values(?,?,?);
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getThoiLuong());
            ps.setObject(2, kh.getNgayLap());
            ps.setObject(3, kh.getMaCD());

            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;

    }

    public Integer update(KhoaHoc kh) {
        Integer row = null;
        sql = """
              update khoahoc set thoiluong =?, ngaytao=?, macd=? where makh=?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, kh.getThoiLuong());
            ps.setString(2, kh.getNgayLap());
            ps.setString(3, kh.getMaCD());
            ps.setInt(4, kh.getMaKH());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public int xoa(KhoaHoc nh) {
        sql = """
              delete From khoahoc where makh =?;
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, nh.getMaKH());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}

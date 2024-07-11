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
import model.HocVien;
import model.MaNguoiHoc;

/**
 *
 * @author hungj
 */
public class HocVienService {

    ArrayList<HocVien> listHV = new ArrayList<>();
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet re = null;
    private String sql = null;

    public ArrayList<HocVien> getAll() {
        ArrayList<HocVien> listHV = new ArrayList<>();

        sql = """
              select mahv, makh , diem, manh from hocvien
              
              """;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                String manh;
                int mahv, makh;
                float diem;

                mahv = re.getInt(1);
                makh = re.getInt(2);
                diem = re.getFloat(3);
                manh = re.getString(4);
                listHV.add(new HocVien(mahv, diem, makh, manh));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHV;

    }
    public ArrayList<MaNguoiHoc> getMaNH() {
        ArrayList<MaNguoiHoc> listMaNH = new ArrayList<>();

        sql = """
              select  manh from hocvien
              
              """;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                String manh;

                manh = re.getString(1);
                listMaNH.add(new MaNguoiHoc(manh));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaNH;

    }

}

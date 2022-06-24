/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAn.dao;
import DuAn.utils.XJDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object...arg){
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJDBC.query(sql, arg);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list; //danh sách mảng ->> filltable
        } catch (Exception e) {
            throw new RuntimeException();
        }

        }

    public List<Object[]> getBangDiem(Integer makh){
        String sql = "{CALL sp_BangDiem(?)}"; 
        String[] cols = {"MaNH","HoTen","Diem"};// chứa tên cột khi đổ vào table
        return this.getListOfArray(sql, cols, makh);//chứa kết quả câu lệnh
        }
    public List<Object[]> getLuongNguoiHoc(){
        String sql = "{CALL sp_ThongKeNguoiHoc}";
        String[] cols = {"Nam","SoLuong","DauTien","CuoiCung"};
        return this.getListOfArray(sql, cols);
        }   
    public List<Object[]> getDiemTheoChuyenDe(){
        String sql = "{CALL sp_ThongKeDiem}";
        String[] cols = {"ChuyenDe","SoHV","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols);
        }  

    public List<Object[]> getDoanhThu(int nam){
        String sql = "{CALL sp_ThongKeDoanhThu(?)}";
        String[] cols = {"ChuyenDe","SoKH","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols, nam);
            
        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAn.dao;

import DuAn.entity.ChuyenDe;
import DuAn.utils.XJDBC;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author asus
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String>{
//ma chuyen de: string --> key --> search
    @Override
    public void insert(ChuyenDe model) {
        String sql="INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        XJDBC.update(sql, 
        model.getMaCD(), 
        model.getTenCD(), 
        model.getHocPhi(), 
        model.getThoiLuong(), 
        model.getHinh(),
        model.getMoTa());   
    }

    @Override
    public void update(ChuyenDe model) {
        String sql="UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?";
        XJDBC.update(sql, 
        model.getTenCD(), 
        model.getHocPhi(), 
        model.getThoiLuong(), 
        model.getHinh(), 
        model.getMoTa(),
        model.getMaCD());
    }

    @Override
    public void delete(String MaCD) {
        String sql="DELETE FROM ChuyenDe WHERE MaCD=?";
        XJDBC.update(sql, MaCD); 
    }

     @Override
    public List<ChuyenDe> selectAll() {
        String sql="SELECT * FROM ChuyenDe";
        return selectBySql(sql);
    }
    
    @Override
    public ChuyenDe selectById(String maCD) {
        String sql = "SELECT * FROM ChuyenDe WHERE MaCD=?";
        List<ChuyenDe> list = selectBySql(sql, maCD);
        return list.size() > 0 ? list.get(0) : null;
    }

  protected List<ChuyenDe> selectBySql(String sql, Object...args){
        List<ChuyenDe> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while(rs.next()){
                    ChuyenDe entity=new ChuyenDe();
                    entity.setMaCD(rs.getString("MaCD"));
                    entity.setHinh(rs.getString("Hinh"));
                    entity.setHocPhi(rs.getDouble("HocPhi"));
                    entity.setMoTa(rs.getString("MoTa"));
                    entity.setTenCD(rs.getString("TenCD"));
                    entity.setThoiLuong(rs.getInt("ThoiLuong"));
                    list.add(entity);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_input;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class cls_input_data {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nim;
    public String nama;
    public String kelas;
    public String jurusan;
    
    public void simpan()throws SQLException{
        conn = koneksi.getKoneksi();
        sql = "INSERT INTO input_data(nim,nama,kelas,jurusan)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        pst.setString(2, nama);
        pst.setString(3, kelas);
        pst.setString(4, jurusan);
        pst.execute();
        pst.close();
        
                
    }
    
    public ResultSet UpdateJTable()throws SQLException{
        conn = koneksi.getKoneksi();
        sql="select * from input_data";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
        
    }
    public void hapus()throws SQLException{
        conn = koneksi.getKoneksi();
        String sql = "delete from input_data where nim=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            pst.execute();      
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void edit()throws SQLException{
        conn = koneksi.getKoneksi();
        String sql = "Update input_data set nama=?, kelas=?, jurusan=? where nim=? ";
        pst =conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, kelas);
        pst.setString(3, jurusan);
        pst.setString(4, nim);
        pst.executeUpdate();
        pst.close();
    }
    
    public ResultSet SearchTextList(String nma)throws SQLException{
        conn = koneksi.getKoneksi();
        sql = "select * from input_data where nama like ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        rs = pst.executeQuery();
        return rs;
    }
}

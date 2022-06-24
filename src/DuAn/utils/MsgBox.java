/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAn.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class MsgBox {
    /*
    Hiển thị thông báo cho người dùng
    @param parent là cửa sổ chứa thông báo
    @param message là thông báo
    */ 
    public static void showMessageDialog(Component parent, String content){
        JOptionPane.showMessageDialog(parent, content, "Hệ thống bán hàng Nike Store", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
     /*
    Hiển thị thông báo và yêu cầu người dùng xác nhận
    @param parent là cửa sổ chứa thông báo
    @param message là thông báo
    */
    public static boolean showConfirmDialog(Component parent, String content){
        int choose = JOptionPane.showConfirmDialog(parent, content, "Hệ thống bán hàng Nike Store",
                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose == JOptionPane.YES_OPTION;
    }
    
    /*
    Hiển thị thông báo và yêu cầu người dùng xác nhận
    @param parent là cửa sổ chứa thông báo
    @param message là thông báo
    */
    public static void showErrorDialog(Component parent, String content, String title){
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.ERROR_MESSAGE);
    }
    
    
}

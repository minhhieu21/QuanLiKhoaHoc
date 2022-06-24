/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAn.utils;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author asus
 */
public class XImage {
    /**
     * Ảnh biểu tượng của ứng dụng xuất hiện trên mọi cửa sổ
     * @return 
     */
    public static Image getAppIcon(){
        String file = "D:\\DuAnMau\\PD05172_ProjectSample\\src\\DuAn\\ui\\fpt.png";
        return new ImageIcon(XImage.class.getResource(file)).getImage();
    }
    
    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param src là đối tượng file ảnh
     */
    
    public static void save(File src){//d:/hinh1.png
        File dst = new File("D:\\DuAnMau\\PD05172_ProjectSample\\src\\DuAn\\images",src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path  from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    /**
     * Đọc hình ảnh logo chuyên đề
     * @param filename là tên file logo
     * @return ảnh đọc trước
     */
    public static ImageIcon read(String fileName){
        File path = new File("D:\\DuAnMau\\PD05172_ProjectSample\\src\\DuAn\\images",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}

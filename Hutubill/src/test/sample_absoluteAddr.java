// 文件目录测试类

package test;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class sample_absoluteAddr {
    private static String imageFolder = "C:\\Data\\Gogogo\\Notes\\hutubill\\Hutubill\\img\\";

    public static void main(String[] args) {
        JButton b = new JButton();
        String fileName = "backup.png";
        String tip = "sample";
        // 使用相对路径
        File imageFile = new File(imageFolder, fileName);
        System.out.println("Image absolute path: " + imageFile.getAbsolutePath());
        ImageIcon i = new ImageIcon(imageFile.getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
}

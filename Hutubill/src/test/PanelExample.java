package test;

import javax.swing.*;
import java.awt.*;

public class PanelExample {
    public static void main(String[] args) {
        // 创建 JFrame
        JFrame frame = new JFrame("Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // 创建 JPanel 并设置布局管理器
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 创建组件
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // 使用不同的布局约束添加组件
        panel.add(button1, BorderLayout.NORTH);
        panel.add(button2, BorderLayout.CENTER);
        panel.add(button3, BorderLayout.SOUTH);

        // 将 JPanel 添加到 JFrame
        frame.add(panel);

        // 显示 JFrame
        frame.setVisible(true);
    }
}

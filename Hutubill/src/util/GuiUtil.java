package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiUtil {
    // 设置图片存放路径
    private static String imageFolder = "C:\\Data\\Gogogo\\Notes\\hutubill\\Hutubill\\img";

    /**
     * 给按钮设置图标,按钮内的文字,以及提示文字
     * @param b
     * @param fileName
     * @param tip
     */
    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    /**
     * 为一个或者多个组件设置前景色
     * @param color
     * @param cs
     */
    public static void setColor(Color color, JComponent ... cs) {
        for (JComponent c : cs) {
            c.setForeground(color);
        }
    }

    /**
     * 檢查是否为空
     * @param tf
     * @param input
     * @return
     */
    public static boolean checkEmpty(JTextField tf, String input) {
        String text = tf.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid text");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * 检查输入的内容是否是数字格式
     * @param tf
     * @param input
     * @return
     */
    public static boolean checkNumber(JTextField tf, String input) {
        if(!checkEmpty(tf, input))
            return false;
        String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter integer");
            tf.grabFocus();
            return false;
        }
    }

    /**
     * 检查组建的输入内容是否为零
     * @param tf
     * @param input 输入的组件名字
     * @return
     */
    public static boolean checkZero(JTextField tf, String input) {
        if (!checkEmpty(tf, input))
            return false;
        String text = tf.getText().trim();

        if (0 == Integer.parseInt(text)) {
            JOptionPane.showMessageDialog(null, "Zero is invalid");
            tf.grabFocus();
            return false;
        }

        return true;
    }

    /**
     * 设置外观风格
     * 在界面渲染前设置才能生效
     * */
    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
    * 显示面板类
    * @param p
    * @param strechRate 组件拉伸比
    * */
    public static void showPanel(JPanel p, double strechRate) {
        GuiUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
//        CentrePanel cp = new CentrePanel(strechRate);
//        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.setVisible(true);
//        cp.show(p);
    }

    /**
     * 默认为0.85的拉伸比例
     * @param p
     */
    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }
}
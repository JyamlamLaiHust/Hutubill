// 居中布局
package util;

import java.awt.Component;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

public class CentrePanel extends JPanel {

    private double rate;//拉伸比例
    private JComponent c; //显示的组件
    private boolean strech; //是否拉伸

    public CentrePanel(double rate,boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    public CentrePanel(double rate) {
        this(rate,true); // 默认允许拉伸
    }

    public void repaint() {
        if (null != c) {
            Dimension containerSize = this.getSize();
            Dimension componentSize= c.getPreferredSize();

            if(strech)
                c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            else
                c.setSize(componentSize);

            // 放在界面的水平中心
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
                    containerSize.height / 2 - c.getSize().height / 2);
        }
        super.repaint();
    }

    public void show(JComponent p) {
        this.c = p;

        //获取在显示框架上的全部面板并移除
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }

         // 判断需要显示的面板是否是WorkingPanel
         // 是 则需要用updateDate()来让界面显示和数据库同步
        if (p instanceof WorkingPanel)
            ((WorkingPanel) p).updateDate();

        add(p);
        this.updateUI();
    }

    // 测试函数，在面板上放一个按钮，这个按钮会自动拉伸居中。
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);
        CentrePanel cp = new CentrePanel(0.85,true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b  =new JButton("abc");
        cp.show(b);

    }

}
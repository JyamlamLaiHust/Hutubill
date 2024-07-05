package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GuiUtil;

public class Test{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        GuiUtil.useLNF();
        //面板
        JPanel p = new JPanel();
        //进度条组件
        CircleProgressBar cpb = new CircleProgressBar();
        cpb.setBackgroundColor(ColorUtil.blueColor);
        cpb.setProgress(0);

        //按钮
        JButton b = new JButton("点击");

        //添加组件
        p.setLayout(new BorderLayout());

        p.add(cpb, BorderLayout.CENTER);
        p.add(b, BorderLayout.SOUTH);

        //显示面板
        GuiUtil.showPanel(p);

        //给按钮加监听
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker() {

                    @Override
                    protected Object doInBackground() throws Exception {
                        for (int i = 0; i < 100; i++) {
                            cpb.setProgress(i + 1);
                            cpb.setForegroundColor(ColorUtil.getByPercentage(i + 1));
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                        return null;
                    }

                }.execute();

            }
        });

    }
}
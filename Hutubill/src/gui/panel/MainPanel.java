package gui.panel;

import util.GuiUtil;
import util.CentrePanel;
import gui.listener.ToolBarListener;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    static {
        GuiUtil.useLNF();
    }

    public static MainPanel instance = new MainPanel();

    public JToolBar tb = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    public CentrePanel workingPanel;

    /**
     * 定义工作区布局
     * @param
     * @return
     * */
    private MainPanel() {
        GuiUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GuiUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GuiUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GuiUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GuiUtil.setImageIcon(bConfig, "config.png", "设置");
        GuiUtil.setImageIcon(bBackup, "backup.png", "备份");
        GuiUtil.setImageIcon(bRecover, "restore.png", "恢复");

        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);

        tb.setFloatable(false);

        workingPanel = new CentrePanel(0.6);

        // 采用BorderLayout布局
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        ButtonListener();
    }


    /*
    * 定义监听方法
    * */
    public void ButtonListener() {
        ToolBarListener tbl = new ToolBarListener();
        bBackup.addActionListener(tbl);
        bSpend.addActionListener(tbl);
        bCategory.addActionListener(tbl);
        bConfig.addActionListener(tbl);
        bRecord.addActionListener(tbl);
        bReport.addActionListener(tbl);
        bRecover.addActionListener(tbl);
    }


    public static void main(String[] args) {
        GuiUtil.showPanel(MainPanel.instance,1);
    }

}

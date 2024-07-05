package gui.panel;

import util.GuiUtil;
import util.ColorUtil;
import gui.listener.ConfigListener;
import service.ConfigService;

import javax.swing.*;
import java.awt.*;



public class ConfigPanel extends WorkingPanel {
    static {
        GuiUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("Budget($)");
    public JTextField tfBudget = new JTextField("0");

    JLabel lMysql = new JLabel("MySQL Database Directory:");
    public JTextField tfMysqlPath = new JTextField("");

    JButton bUpdate = new JButton("update");

    public ConfigPanel() {
        GuiUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
        GuiUtil.setColor(ColorUtil.blueColor, bUpdate);

        JPanel pInput = new JPanel();
        JPanel pUpdate = new JPanel();

        int gap = 20;
        pInput.setLayout(new GridLayout(4, 1, gap, gap));

        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);

        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);

        pUpdate.add(bUpdate);
        this.add(pUpdate, BorderLayout.CENTER);

        addListener();
    }

    public void addListener() {
        ConfigListener c = new ConfigListener();
        bUpdate.addActionListener(c);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(ConfigPanel.instance);
    }

    @Override
    public void updateDate() {
        ConfigService cs = new ConfigService();
        //从数据库中获取配置信息
        String budget = cs.getValueByKey(ConfigService.budget);
        String mysqlPath = cs.getValueByKey(ConfigService.mysqlPath);
        //将配置信息显示在界面
        tfBudget.setText(budget);
        tfMysqlPath.setText(mysqlPath);

        //输入框获取焦点
        tfBudget.grabFocus();
    }
}

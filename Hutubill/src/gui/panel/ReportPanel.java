package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import util.ChartUtil;
import util.GuiUtil;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import entity.Record;
import service.ReportService;
import util.ChartUtil;

public class ReportPanel extends WorkingPanel {
    static {
        GuiUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        Image i =ChartUtil.getImage(400, 300);
        ImageIcon icon= new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
    }

    @Override
    public void updateDate() {
        List< Record > rs = new ReportService().getThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350,250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }

    @Override
    public void addListener() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        GuiUtil.showPanel(ReportPanel.instance);
    }
}

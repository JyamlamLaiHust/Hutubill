package gui.panel;

import javax.swing.JButton;
import gui.listener.BackupListener;
import util.ColorUtil;
import util.GuiUtil;

public class BackupPanel extends WorkingPanel{

    private static final long serialVersionUID = 1L;

    static{
        GuiUtil.useLNF();
    }

    public static BackupPanel instance  = new BackupPanel();
    JButton bBuckup = new JButton("Backup");

    private BackupPanel(){
        GuiUtil.setColor(ColorUtil.blueColor,bBuckup);
        this.add(bBuckup);
        addListener();
    }

    public static void main(String[] args){
        GuiUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateDate() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addListener() {
        BackupListener listener = new BackupListener();
        bBuckup.addActionListener(listener);
    }

}
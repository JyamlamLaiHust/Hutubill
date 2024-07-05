package gui.panel;

import javax.swing.JButton;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GuiUtil;

public class RecoverPanel extends WorkingPanel{

    private static final long serialVersionUID = 1L;

    static{
        GuiUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover = new JButton("Recover");

    public RecoverPanel(){
        GuiUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        addListener();
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {
        RecoverListener rl = new RecoverListener();
        bRecover.addActionListener(rl);
    }
}
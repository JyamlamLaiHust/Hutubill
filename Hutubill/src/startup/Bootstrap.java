package startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import gui.page.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GuiUtil;

public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GuiUtil.useLNF();

        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
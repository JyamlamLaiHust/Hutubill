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

        // 确保在事件调度线程（EDT）上执行代码，保证线程安全
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                // 显示主窗口
                MainFrame.instance.setVisible(true);
                // 主面板上显示SpendPanel
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
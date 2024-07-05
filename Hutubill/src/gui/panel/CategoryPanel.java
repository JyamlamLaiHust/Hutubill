package gui.panel;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GuiUtil;

public class CategoryPanel extends WorkingPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static{
        GuiUtil.useLNF();
    }

    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    String colunmNames[]  =  new String[]{"分类名称","消费次数"};

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable(ctm);

    private CategoryPanel(){
        GuiUtil.setColor(ColorUtil.blueColor);
        JScrollPane sp = new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);


        addListener();

    }


    public Category getSelectCategory(){
        int index = t.getSelectedRow();
        return ctm.cs.get(index);
    }


    @Override
    public void updateDate() {

        ctm.cs = new CategoryService().getCategoryWithRecordNumber();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);


        if( 0 == ctm.cs.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }

    }

    @Override
    public void addListener() {
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(CategoryPanel.instance);
    }

}

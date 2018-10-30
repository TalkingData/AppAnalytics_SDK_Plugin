package com.talkingdata.appanalytics.plugin.dialogs;

import com.talkingdata.appanalytics.plugin.ShoppingCart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCartDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table;
    private JButton addItem_button;
    private ShoppingCartDialogCallback shoppingCartDialogCallback;

    public ShoppingCartDialog(ShoppingCartDialogCallback shoppingCartDialogCallback) {
        this.shoppingCartDialogCallback = shoppingCartDialogCallback;

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 500;
        int Swing1y = 500;

        setTitle("TalkingData");
        setSize(Swing1x, Swing1y);

        setBounds((screensize.width - Swing1x) / 2, (screensize.height - Swing1y) / 2 - 100, Swing1x, Swing1y);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setTable();

        buttonOK.addActionListener((e)-> onOK());

        buttonCancel.addActionListener((e)->onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction((e)->onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        addItem_button.addActionListener((e)-> {
                DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
                defaultTableModel.addRow(new Object[]{"","","",0,0});
                table.updateUI();
        });
    }

    private void onOK() {
        // add your code here
        ShoppingCart shoppingCart = ShoppingCart.createShoppingCart();

        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        for (int i = 0;i < defaultTableModel.getRowCount();i++){
            String itemid = (String) defaultTableModel.getValueAt(i, 0);
            String itemcate = (String)defaultTableModel.getValueAt(i, 1);
            String itemname = (String)defaultTableModel.getValueAt(i, 2);
            int itemunit = Integer.parseInt(defaultTableModel.getValueAt(i, 3).toString());
            int itemamount = Integer.parseInt(defaultTableModel.getValueAt(i, 4).toString());
            shoppingCart.addItem(itemid,itemcate,itemname,itemunit,itemamount);
        }

        shoppingCartDialogCallback.ok(shoppingCart);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void setTable(){
        Object[][] rows = new Object[][]{};
        Object[] columns = new Object[]{"商品ID","商品所属类型","商品名称","商品单价","商品购买数量"};

        DefaultTableModel tableModel = new DefaultTableModel(rows, columns){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex > 2){
                    return Integer.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        tableModel.addRow(new Object[]{"007","家电","电视",499900, 1});
        tableModel.addRow(new Object[]{"008","家电","冰箱",399900, 1});
        table.setModel(tableModel);
    }

    public static void main(String[] args) {
        ShoppingCartDialog dialog = new ShoppingCartDialog( (a)->{});
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

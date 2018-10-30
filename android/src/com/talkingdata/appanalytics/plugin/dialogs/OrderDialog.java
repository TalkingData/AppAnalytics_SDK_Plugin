package com.talkingdata.appanalytics.plugin.dialogs;

import com.talkingdata.appanalytics.plugin.Order;
import com.talkingdata.appanalytics.plugin.utils.StringUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class OrderDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField accountid_textField;
    private JTextField orderid_textField;
    private JComboBox<String> type_comboBox;
    private JTable table;
    private JButton additem_button;
    private JTextField pay_textField;
    private JLabel pay_label;
    private JSpinner total_spinner;
    private JLabel payinfo_label;
    private OrderDialogCallback orderDialogCallback;
    private boolean isPay;

    public OrderDialog(boolean isPay, OrderDialogCallback orderDialogCallback) {
        this.orderDialogCallback = orderDialogCallback;
        this.isPay = isPay;

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 750;
        int Swing1y = 500;

        setTitle("TalkingData");
        setSize(Swing1x, Swing1y);

        setBounds((screensize.width - Swing1x) / 2, (screensize.height - Swing1y) / 2 - 100, Swing1x, Swing1y);

        if (!isPay){
            pay_label.setVisible(false);
            pay_textField.setVisible(false);
            payinfo_label.setVisible(false);
        }

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setComboBox();
        setTable();
        total_spinner.setValue(899800);

        additem_button.addActionListener((e)-> {
                DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
                defaultTableModel.addRow(new Object[]{"","","",0,0});
                table.updateUI();
        });

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
    }

    private void setComboBox(){
        type_comboBox.addItem("CNY");
        type_comboBox.addItem("USD");
        type_comboBox.addItem("EUR");
    }

    private void setTable(){
        Object[][] rows = new Object[][]{};
        Object[] columns = new Object[]{"商品ID","商品所属类型","商品名称","商品单价（货币单位为分）","商品购买数量"};


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

    private void onOK() {
        // add your code here
        String currencyType = "CNY";
        if (type_comboBox.getSelectedItem() != null && !StringUtils.isEmpty(type_comboBox.getSelectedItem().toString())){
            currencyType = type_comboBox.getSelectedItem().toString();
        }
        Order order = Order.createOrder(orderid_textField.getText(), Integer.parseInt(total_spinner.getValue().toString()), currencyType);
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        for (int i = 0;i < defaultTableModel.getRowCount();i++){
            String itemid = (String) defaultTableModel.getValueAt(i, 0);
            String itemcate = (String)defaultTableModel.getValueAt(i, 1);
            String itemname = (String)defaultTableModel.getValueAt(i, 2);
            int itemunit = Integer.parseInt(defaultTableModel.getValueAt(i, 3).toString());
            int itemamount = Integer.parseInt(defaultTableModel.getValueAt(i, 4).toString());

            order.addItem(itemid,itemcate,itemname,itemunit,itemamount);
        }
        if (isPay) {
            orderDialogCallback.ok(accountid_textField.getText(), pay_textField.getText(), order);
        }else{
            orderDialogCallback.ok(accountid_textField.getText(), "", order);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        OrderDialog dialog = new OrderDialog(true, (a,b,c)->{});
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

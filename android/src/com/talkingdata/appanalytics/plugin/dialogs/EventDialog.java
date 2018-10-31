package com.talkingdata.appanalytics.plugin.dialogs;

import com.talkingdata.appanalytics.plugin.utils.MessageUtils;
import com.talkingdata.appanalytics.plugin.utils.StringUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class EventDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table;
    private JTextField eventid_textField;
    private JTextField eventLabel_textField;
    private JLabel eventId;
    private JLabel eventLabel;
    private JButton add_button;
    private EventDialogCallback eventDialogCallback;

    public EventDialog(EventDialogCallback eventDialogCallback) {
        this.eventDialogCallback = eventDialogCallback;
        int dpi = Toolkit.getDefaultToolkit().getScreenResolution();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 6 * dpi;
        int Swing1y = 5 * dpi;

        setTitle("TalkingData");
        setSize(Swing1x, Swing1y);

        setBounds((screensize.width - Swing1x) / 2, (screensize.height - Swing1y) / 2 - dpi, Swing1x, Swing1y);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        table.setRowHeight((int) (0.3 * dpi));
        setTable();

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
                defaultTableModel.addRow(new Object[]{"",""});
                table.updateUI();
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void setTable(){
        Object[][] rows = new Object[][]{};
        Object[] columns = new Object[]{"key","value"};


        DefaultTableModel tableModel = new DefaultTableModel(rows, columns);
        tableModel.addRow(new String[]{"商品类型","休闲食品"});
        tableModel.addRow(new String[]{"价格","5~10元"});
        table.setModel(tableModel);

        TableColumn column = null;
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++)
        {
            column = table.getColumnModel().getColumn(i);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(100);
        }
    }

    private void onOK() {
        // add your code here

        if (StringUtils.isEmpty(eventid_textField.getText())){
            MessageUtils.showMessage("事件名称不能为空！");
            return;
        }

        Map map = new HashMap();
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        for (int i = 0;i < defaultTableModel.getRowCount();i++){
            Object key = defaultTableModel.getValueAt(i, 0);
            Object value = defaultTableModel.getValueAt(i, 1);
            map.put(key,value);
        }
        eventDialogCallback.ok(eventid_textField.getText(), eventLabel_textField.getText(), map);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        EventDialog dialog = new EventDialog((a,b,c)->{});
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}

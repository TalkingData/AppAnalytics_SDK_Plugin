package com.talkingdata.appanalytics.plugin.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField itemid_textField;
    private JTextField category_textField;
    private JTextField name_textField;
    private JSpinner unitprice_spinner;
    private JSpinner count_spinner;
    private JLabel count_label;
    private ItemDialogCallback itemDialogCallback;

    public ItemDialog(boolean isAdd, ItemDialogCallback itemDialogCallback) {
        this.itemDialogCallback = itemDialogCallback;

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 500;
        int Swing1y = 260;

        setTitle("TalkingData");
        setSize(Swing1x, Swing1y);

        setBounds((screensize.width - Swing1x) / 2, (screensize.height - Swing1y) / 2 - 100, Swing1x, Swing1y);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        if (!isAdd){
            count_spinner.setVisible(false);
            count_label.setVisible(false);
        }

        unitprice_spinner.setValue(499900);
        count_spinner.setValue(10);

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

    private void onOK() {
        // add your code here
        itemDialogCallback.ok(itemid_textField.getText(), category_textField.getText(), name_textField.getText(), Integer.parseInt(unitprice_spinner.getValue().toString()), Integer.parseInt(count_spinner.getValue().toString()));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ItemDialog dialog = new ItemDialog(false, (a,b,c,d,e)->{});
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

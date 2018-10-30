package com.talkingdata.appanalytics.plugin.dialogs;

import com.talkingdata.appanalytics.plugin.TDAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AccountDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField accountid_textField;
    private JTextField name_textField;
    private JComboBox<TDAccount.AccountType> accountType_comboBox;
    private AccountDialogCallback accountDialogCallback;
    private java.util.List<TDAccount.AccountType> accountType = new ArrayList<>();

    public AccountDialog(AccountDialogCallback accountDialogCallback) {
        this.accountDialogCallback = accountDialogCallback;

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 500;
        int Swing1y = 200;

        setTitle("TalkingData");
        setSize(Swing1x, Swing1y);

        setBounds((screensize.width - Swing1x) / 2, (screensize.height - Swing1y) / 2 - 100, Swing1x, Swing1y);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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

        setComboBox();
    }

    private void setComboBox(){
        accountType.add(TDAccount.AccountType.ANONYMOUS);
        accountType.add(TDAccount.AccountType.REGISTERED);
        accountType.add(TDAccount.AccountType.SINA_WEIBO);
        accountType.add(TDAccount.AccountType.QQ);
        accountType.add(TDAccount.AccountType.QQ_WEIBO);
        accountType.add(TDAccount.AccountType.ND91);
        accountType.add(TDAccount.AccountType.WEIXIN);
        accountType.add(TDAccount.AccountType.TYPE1);
        accountType.add(TDAccount.AccountType.TYPE2);
        accountType.add(TDAccount.AccountType.TYPE3);
        accountType.add(TDAccount.AccountType.TYPE4);
        accountType.add(TDAccount.AccountType.TYPE5);
        accountType.add(TDAccount.AccountType.TYPE6);
        accountType.add(TDAccount.AccountType.TYPE7);
        accountType.add(TDAccount.AccountType.TYPE8);
        accountType.add(TDAccount.AccountType.TYPE9);
        accountType.add(TDAccount.AccountType.TYPE10);

        for (TDAccount.AccountType s : accountType){
            accountType_comboBox.addItem(s);
        }

    }


    private void onOK() {
        // add your code here
        if (accountType_comboBox.getSelectedItem() == null){
            accountType_comboBox.setSelectedIndex(0);
        }
        accountDialogCallback.ok(accountid_textField.getText(), ((TDAccount.AccountType)accountType_comboBox.getSelectedItem()).getType(), name_textField.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AccountDialog dialog = new AccountDialog((a,b,c)->{});
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}

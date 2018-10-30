package com.talkingdata.appanalytics.plugin.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField appidTextField;
    private JTextField channelTextField;
    private InitDialogCallback dialogCallback;

    public InitDialog(InitDialogCallback dialogCallback) {
        this.dialogCallback = dialogCallback;
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 720;
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
    }

    private void onOK() {
        // add your code here
        dialogCallback.ok(appidTextField.getText(), channelTextField.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        InitDialog dialog = new InitDialog((appid,channel)->{});
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

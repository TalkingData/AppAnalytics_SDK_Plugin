package com.talkingdata.appanalytics.plugin.dialogs;

import com.talkingdata.appanalytics.plugin.views.LinkLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PageDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField pageName_textField;
    private LinkLabel linkLabel;
    private PageDialogCallback pageDialogCallback;

    public PageDialog(PageDialogCallback pageDialogCallback) {
        this.pageDialogCallback = pageDialogCallback;

        int dpi = Toolkit.getDefaultToolkit().getScreenResolution();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 5 * dpi;
        int Swing1y = (int) (1.5 * dpi);

        setTitle("TalkingData");
        setSize(Swing1x, Swing1y);

        setBounds((screensize.width - Swing1x) / 2, (screensize.height - Swing1y) / 2  - dpi, Swing1x, Swing1y);

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
        pageDialogCallback.ok(pageName_textField.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void createUIComponents(){
        linkLabel = new LinkLabel("集成文档", "http://doc.talkingdata.com/posts/21");
    }

    public static void main(String[] args) {
        PageDialog dialog = new PageDialog(new PageDialogCallback() {
            @Override
            public void ok(String pageName) {

            }
        });
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

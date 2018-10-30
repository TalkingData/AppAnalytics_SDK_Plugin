package com.talkingdata.appanalytics.plugin.utils;

import javax.swing.*;


public class MessageUtils {
    public static void showMessage(String message){
        try {
//            Messages.showMessageDialog(message,"提示",null);
            JOptionPane.showMessageDialog(null, message, "提示",JOptionPane.ERROR_MESSAGE, IconUtils.getIcon("/icons/talkingdata_dialog.png"));
        }catch (Throwable t){
            t.printStackTrace();
        }
    }
}

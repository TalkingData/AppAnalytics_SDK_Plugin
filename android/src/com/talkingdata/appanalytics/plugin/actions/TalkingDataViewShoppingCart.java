package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.ShoppingCartDialog;

public class TalkingDataViewShoppingCart extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        ShoppingCartDialog shoppingCartDialog = new ShoppingCartDialog((shoppingCart)-> {
                String[] codes = TalkingDataCode.getInstance().getShoppingCartCodes(shoppingCart);
                TalkingDataCode.getInstance().insertCode(e, codes);
        });
        shoppingCartDialog.setVisible(true);
    }
}

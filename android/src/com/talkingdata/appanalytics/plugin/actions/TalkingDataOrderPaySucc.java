package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.OrderDialog;

public class TalkingDataOrderPaySucc extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        OrderDialog accountDialog = new OrderDialog(true, (accountId, payType, order)-> {
                String[] codes = TalkingDataCode.getInstance().getAppOrderCodes(true, accountId, payType, order);
                TalkingDataCode.getInstance().insertCode(e, codes);
        });
        accountDialog.setVisible(true);
    }
}

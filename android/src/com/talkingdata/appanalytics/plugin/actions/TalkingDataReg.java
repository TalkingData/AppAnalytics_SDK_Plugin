package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.AccountDialog;

public class TalkingDataReg extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        AccountDialog accountDialog = new AccountDialog((accountId, accountType, name)-> {
                String[] codes = TalkingDataCode.getInstance().getAppAccountCodes(false, accountId, accountType,name);
                TalkingDataCode.getInstance().insertCode(e, codes);
        });
        accountDialog.setVisible(true);
    }
}

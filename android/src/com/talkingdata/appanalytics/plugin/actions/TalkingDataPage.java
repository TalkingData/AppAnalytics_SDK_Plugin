package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.PageDialog;

public class TalkingDataPage extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        PageDialog accountDialog = new PageDialog((pageName)-> {
                String[] codes = TalkingDataCode.getInstance().getAppPageCodes(pageName);
                TalkingDataCode.getInstance().insertCode(e, codes);
        });
        accountDialog.setVisible(true);
    }
}

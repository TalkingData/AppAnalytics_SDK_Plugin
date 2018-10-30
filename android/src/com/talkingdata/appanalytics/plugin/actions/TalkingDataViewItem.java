package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.ItemDialog;

public class TalkingDataViewItem extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        ItemDialog itemDialog = new ItemDialog(false, (itemId, category, name, unitPrice, count)-> {
                String[] codes = TalkingDataCode.getInstance().getViewItemCodes(itemId,category,name,unitPrice);
                TalkingDataCode.getInstance().insertCode(e, codes);
        });
        itemDialog.setVisible(true);
    }
}

package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.ItemDialog;

public class TalkingDataAddItem extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        ItemDialog itemDialog = new ItemDialog(true, (itemId, category, name, unitPrice, count) -> {
            String[] codes = TalkingDataCode.getInstance().getAddItemCodes(itemId, category, name, unitPrice, count);
            TalkingDataCode.getInstance().insertCode(e, codes);
        });
        itemDialog.setVisible(true);
    }
}

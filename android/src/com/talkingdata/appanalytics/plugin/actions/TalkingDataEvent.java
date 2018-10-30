package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.EventDialog;

public class TalkingDataEvent extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        EventDialog eventDialog = new EventDialog((eventId, eventLabel, map)-> {
                String[] code = TalkingDataCode.getInstance().getAppEventCodes(eventId, eventLabel,map);
                TalkingDataCode.getInstance().insertCode(e, code);
        });
        eventDialog.setVisible(true);
    }
}

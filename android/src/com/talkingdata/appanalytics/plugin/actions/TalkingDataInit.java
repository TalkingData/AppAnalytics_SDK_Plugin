package com.talkingdata.appanalytics.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.talkingdata.appanalytics.plugin.TalkingDataCode;
import com.talkingdata.appanalytics.plugin.dialogs.InitDialog;

public class TalkingDataInit extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
//        if (TalkingDataCode.getInstance().checkApplication(e)) {
            InitDialog initDialog = new InitDialog((appId, channel) -> {
                String code = TalkingDataCode.getInstance().getAppInitCode(appId, channel);
                TalkingDataCode.getInstance().insertCode(e, code);
            });
            initDialog.setVisible(true);
//        }else{
//            MessageUtils.showMessage("请在Application中onCreate()方法中调用初始化！");
//        }
    }


}

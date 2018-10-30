package com.talkingdata.appanalytics.plugin.dialogs;

public interface ItemDialogCallback {
    void ok(String itemId, String category, String name, int unitPrice, int count);
}

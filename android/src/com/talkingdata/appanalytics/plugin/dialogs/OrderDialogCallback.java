package com.talkingdata.appanalytics.plugin.dialogs;

import com.talkingdata.appanalytics.plugin.Order;

public interface OrderDialogCallback {
    void ok(String accountId, String payType, Order order);
}

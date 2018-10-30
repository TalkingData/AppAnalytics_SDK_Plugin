package com.talkingdata.appanalytics.plugin.dialogs;

import java.util.Map;

public interface EventDialogCallback {
    void ok(String eventId, String eventLabel, Map map);
}

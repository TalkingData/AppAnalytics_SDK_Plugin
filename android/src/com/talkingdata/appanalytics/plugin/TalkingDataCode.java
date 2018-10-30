package com.talkingdata.appanalytics.plugin;


import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilBase;
import com.talkingdata.appanalytics.plugin.utils.StringUtils;
import com.talkingdata.appanalytics.plugin.utils.JSON.JSONArray;

import java.util.Map;

public class TalkingDataCode {
    private static class SingleTon {
        private static TalkingDataCode instance = new TalkingDataCode();
    }

    public static TalkingDataCode getInstance() {
        return SingleTon.instance;
    }

    private TalkingDataCode() {
    }

    public String getAppInitCode(String appId, String channel) {
        if (StringUtils.isEmpty(appId) && StringUtils.isEmpty(channel)) {
            return "TCAgent.init(getApplicationContext());";
        } else if (StringUtils.isEmpty(appId)) {
            appId = "请替换为您的AppId";
        } else if (StringUtils.isEmpty(channel)) {
            channel = "请替换为您的渠道";
        }
        return "TCAgent.init(getApplicationContext(),\"" + appId + "\",\"" + channel + "\");";
    }

    public String[] getAddItemCodes(String itemId, String category, String name, int unitPrice, int count) {
        String[] codes = new String[6];
        codes[0] = "String itemId = \"" + itemId + "\";";
        codes[1] = "String category = \"" + category + "\";";
        codes[2] = "String name = \"" + name + "\";";
        codes[3] = "int unitPrice = " + unitPrice + ";";
        codes[4] = "int count = " + count + ";";
        codes[5] = "TCAgent.onAddItemToShoppingCart(itemId,category,name,unitPrice,count);";
        return codes;
    }

    public String[] getViewItemCodes(String itemId, String category, String name, int unitPrice) {
        String[] codes = new String[5];
        codes[0] = "String itemId = \"" + itemId + "\";";
        codes[1] = "String category = \"" + category + "\";";
        codes[2] = "String name = \"" + name + "\";";
        codes[3] = "int unitPrice = " + unitPrice + ";";
        codes[4] = "TCAgent.onViewItem(itemId,category,name,unitPrice);";
        return codes;
    }

    public String[] getAppAccountCodes(boolean isLogin, String accountId, String accountType, String name) {
        String[] codes = new String[3];
        codes[0] = "String accountId = \"" + accountId + "\";";
        codes[1] = "String name = \"" + name + "\";";
        if (isLogin) {
            codes[2] = "TCAgent.onLogin(accountId,TDAccount.AccountType." + accountType + ",name);";
        } else {
            codes[2] = "TCAgent.onRegister(accountId,TDAccount.AccountType." + accountType + ",name);";
        }
        return codes;
    }

    public String[] getAppOrderCodes(boolean isPay, String accountId, String payType, Order order) {
        String[] codes = null;
        try {
            if (!isPay) {
                codes = new String[21];
                codes[0] = "String accountId = \"" + accountId + "\";";
                codes[1] = "String orderId = \"" + order.getString(Order.keyOrderId) + "\";";
                codes[2] = "int totalPrice = " + order.getInt(Order.keyTotalPrice) + ";";
                codes[3] = "String currencyType = \"" + order.getString(Order.keyCurrencyType) + "\";";
                codes[4] = "Order order = Order.createOrder(orderId, totalPrice, currencyType);";

                if (order.has(Order.keyOrderDetail)) {
                    JSONArray items = order.getJSONArray(Order.keyOrderDetail);

                    codes[5] = "try{";
                    codes[6] = "\tString itemsString = \"" + items.toString().replace("\"", "\\\"") + "\";";
                    codes[7] = "\tJSONArray items = new JSONArray(itemsString);";

                    codes[8] = "\tfor (int i = 0; i < items.length(); i++) {";
                    codes[9] = "\t\tJSONObject item = items.getJSONObject(i);";
                    codes[10] = "\t\tString itemid = item.getString(\"id\");";
                    codes[11] = "\t\tString category = item.getString(\"category\");";
                    codes[12] = "\t\tString name = item.getString(\"name\");";
                    codes[13] = "\t\tint unitPrice = item.getInt(\"unitPrice\");";
                    codes[14] = "\t\tint amount = item.getInt(\"count\");";
                    codes[15] = "\t\torder.addItem(itemid, category, name, unitPrice, amount);";
                    codes[16] = "\t}";
                    codes[17] = "\tTCAgent.onPlaceOrder(accountId,order);";
                    codes[18] = "}catch(Throwable t){";
                    codes[19] = "\tt.printStackTrace();";
                    codes[20] = "}";
                }else{
                    codes[5] = "TCAgent.onPlaceOrder(accountId,order);";
                }

            } else {
                codes = new String[22];
                codes[0] = "String accountId = \"" + accountId + "\";";
                codes[1] = "String payType = \"" + payType + "\";";
                codes[2] = "String orderId = \"" + order.getString(Order.keyOrderId) + "\";";
                codes[3] = "int totalPrice = " + order.getInt(Order.keyTotalPrice) + ";";
                codes[4] = "String currencyType = \"" + order.getString(Order.keyCurrencyType) + "\";";
                codes[5] = "Order order = Order.createOrder(orderId, totalPrice, currencyType);";

                if (order.has(Order.keyOrderDetail)) {
                    JSONArray items = order.getJSONArray(Order.keyOrderDetail);
                    codes[6] = "try{";
                    codes[7] = "\tString itemsString = \"" + items.toString().replace("\"", "\\\"") + "\";";
                    codes[8] = "\tJSONArray items = new JSONArray(itemsString);";

                    codes[9] = "\tfor (int i = 0; i < items.length(); i++) {";
                    codes[10] = "\t\tJSONObject item = items.getJSONObject(i);";
                    codes[11] = "\t\tString itemid = item.getString(Order.keyId);";
                    codes[12] = "\t\tString category = item.getString(Order.keyCategory);";
                    codes[13] = "\t\tString name = item.getString(Order.keyName);";
                    codes[14] = "\t\tint unitPrice = item.getInt(Order.keyUnitPrice);";
                    codes[15] = "\t\tint amount = item.getInt(Order.keyAmount);";
                    codes[16] = "\t\torder.addItem(itemid, category, name, unitPrice, amount);";
                    codes[17] = "\t}";
                    codes[18] = "\tTCAgent.onOrderPaySucc(accountId,payType,order);";
                    codes[19] = "}catch(Throwable t){";
                    codes[20] = "\tt.printStackTrace();";
                    codes[21] = "}";
                }else{
                    codes[6] = "TCAgent.onOrderPaySucc(accountId,payType,order);";
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return codes;
    }

    public String[] getShoppingCartCodes(ShoppingCart shoppingCart) {
        String[] codes = null;
        try {

            if (shoppingCart.length() > 0) {
                codes = new String[17];
                codes[0] = "ShoppingCart shoppingCart = ShoppingCart.createShoppingCart();";

                codes[1] = "try{";
                codes[2] = "\tString itemsString = \"" + shoppingCart.toString().replace("\"", "\\\"") + "\";";
                codes[3] = "\tJSONArray items = new JSONArray(itemsString);";

                codes[4] = "\tfor (int i = 0; i < items.length(); i++) {";
                codes[5] = "\t\tJSONObject item = items.getJSONObject(i);";
                codes[6] = "\t\tString itemid = item.getString(\"id\");";
                codes[7] = "\t\tString category = item.getString(\"category\");";
                codes[8] = "\t\tString name = item.getString(\"name\");";
                codes[9] = "\t\tint unitPrice = item.getInt(\"unitPrice\");";
                codes[10] = "\t\tint amount = item.getInt(\"count\");";
                codes[11] = "\t\tshoppingCart.addItem(itemid, category, name, unitPrice, amount);";
                codes[12] = "\t}";
                codes[13] = "\tTCAgent.onViewShoppingCart(shoppingCart);";
                codes[14] = "}catch(Throwable t){";
                codes[15] = "\tt.printStackTrace();";
                codes[16] = "}";
            }else{
                codes = new String[2];
                codes[0] = "ShoppingCart shoppingCart = ShoppingCart.createShoppingCart();";
                codes[1] = "TCAgent.onViewShoppingCart(shoppingCart);";
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return codes;
    }

    public String[] getAppPageCodes(String pageName) {
        String[] codes = new String[10];
        codes[0] = "@Override";
        codes[1] = "protected void onResume(){";
        codes[2] = "\tsuper.onResume();";
        codes[3] = "\tTCAgent.onPageStart(this,\"" + pageName + "\");";
        codes[4] = "}";
        codes[5] = "@Override";
        codes[6] = "protected void onPause(){";
        codes[7] = "\tsuper.onPause();";
        codes[8] = "\tTCAgent.onPageEnd(this,\"" + pageName + "\");";
        codes[9] = "}";
        return codes;
    }

    public String[] getAppEventCodes(String eventId, String eventLabel, Map map) {
        String[] codes = null;
        if (map.size() > 0) {
            codes = new String[map.size() + 2];
            codes[0] = "Map map = new HashMap();";
            int i = 1;
            for (Object key : map.keySet()) {
                Object value = map.get(key);
                codes[i] = "map.put(\"" + key + "\",\"" + value + "\");";
                i++;
            }
            codes[i] = "TCAgent.onEvent(DemoActivity.this,\"" + eventId + "\",\"" + eventLabel + "\", map);";
        }else{
            codes = new String[1];
            codes[0] = "TCAgent.onEvent(DemoActivity.this,\"" + eventId + "\",\"" + eventLabel + "\");";
        }
        return codes;
    }

    public void insertCode(AnActionEvent e, String code) {
        Editor editor = e.getData(DataKeys.EDITOR);
        Project project = e.getProject();
        if (editor != null && project != null) {
            CaretModel caretModel = editor.getCaretModel();
            Document document = editor.getDocument();
            int offset = caretModel.getOffset();
            WriteCommandAction.runWriteCommandAction(project, () -> document.insertString(offset, code));
        }
    }

    public void insertCode(AnActionEvent e, String[] codes) {
        Editor editor = e.getData(DataKeys.EDITOR);
        Project project = e.getProject();
        if (editor != null && project != null) {
            CaretModel caretModel = editor.getCaretModel();
            Document document = editor.getDocument();
            int offset = caretModel.getOffset();
            WriteCommandAction.runWriteCommandAction(project, () -> {
                int insertOffset = offset;
                int curLineNumber;
                int offsetStart = caretModel.getLogicalPosition().column;
                int tabNum = offsetStart / 4;
                int codeNum = 0;
                for (String code : codes) {
                    if (StringUtils.isEmpty(code)){
                        continue;
                    }
                    StringBuilder nextLine = new StringBuilder();
                    if (codeNum > 0) {
                        for (int i = 0; i < tabNum; i++) {
                            nextLine.append("\t");
                        }
                    }
                    code = nextLine.toString() + code;
                    document.insertString(insertOffset, code);

                    if (codeNum < codes.length - 1) {
                        curLineNumber = document.getLineNumber(insertOffset);
                        insertOffset += code.length();
                        document.insertString(insertOffset, "\n");
                        insertOffset = document.getLineStartOffset(curLineNumber + 1);
                        codeNum++;
                    }
                }
            });
        }
    }

    public boolean checkApplication(AnActionEvent e){
        try {
            Editor editor = e.getData(DataKeys.EDITOR);
            if (editor != null){
                Project project = editor.getProject();
                if (project != null){
                    PsiFile psiFile = PsiUtilBase.getPsiFileInEditor(editor,project);
                    if (psiFile != null) {
                        String codes = psiFile.getText();
                        if (!StringUtils.isEmpty(codes)) {
                            String pattern = " extends Application";
                            return codes.contains(pattern);
                        }
                    }
                }

            }

        }catch (Throwable t){
            t.printStackTrace();
        }
        return true;
    }
}

package com.talkingdata.appanalytics.plugin;


import com.talkingdata.appanalytics.plugin.utils.JSON.JSONArray;
import com.talkingdata.appanalytics.plugin.utils.JSON.JSONException;
import com.talkingdata.appanalytics.plugin.utils.StringUtils;
import com.talkingdata.appanalytics.plugin.utils.JSON.JSONObject;


public class ShoppingCart extends JSONArray {

    private static final String keyId="id";
    private static final String keyCategory="category";
    private static final String keyName="name";
    private static final String keyUnitPrice="unitPrice";
    private static final String keyCount="count";

    private ShoppingCart(){
        super();
    }
    public static ShoppingCart createShoppingCart(){
        return new ShoppingCart();
    }
    public void addItem(String itemId ,String category,String name,int unitPrice,int amount){
        try {
            JSONObject jobj=new JSONObject();
            if (!StringUtils.isEmpty(itemId)) {
                jobj.put(keyId,itemId);
            }
            if (!StringUtils.isEmpty(category)) {
                jobj.put(keyCategory, category);
            }
            if (!StringUtils.isEmpty(name)) {
                jobj.put(keyName, name);
            }
            jobj.put(keyUnitPrice, unitPrice);
            jobj.put(keyCount, amount);
            this.put(jobj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

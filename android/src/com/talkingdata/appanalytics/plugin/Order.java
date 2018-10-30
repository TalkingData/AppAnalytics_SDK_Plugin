package com.talkingdata.appanalytics.plugin;


import com.talkingdata.appanalytics.plugin.utils.JSON.JSONArray;
import com.talkingdata.appanalytics.plugin.utils.JSON.JSONException;
import com.talkingdata.appanalytics.plugin.utils.StringUtils;
import com.talkingdata.appanalytics.plugin.utils.JSON.JSONObject;

public class Order extends JSONObject {
	public static final String keyOrderId="keyOrderId";
	public static final String keyTotalPrice="keyTotalPrice";
	public static final String keyCurrencyType="keyCurrencyType";
	public static final String keyOrderDetail="keyOrderDetail";

	private static final String keyId="id";
	private static final String keyCategory="category";
	private static final String keyName="name";
	private static final String keyUnitPrice="unitPrice";
	private static final String keyAmount="count";


	private JSONArray orderDetails=null;

	private Order(String orderId,int totalPrice,String currencyType) {
		super();
		try {
			this.put(keyOrderId, orderId);
			this.put(keyTotalPrice, totalPrice);
			this.put(keyCurrencyType, currencyType);
		} catch (JSONException e) {
			 e.printStackTrace();
		}
	}

	private Order(){
		super();
	}
	public static Order createOrder(String orderId,int totalPrice,String currencyType){
		return new Order(orderId,totalPrice,currencyType);
	}

	public void addItem(String id ,String category,String name,int unitPrice,int amount){
		try {
			if(orderDetails==null){
				orderDetails=new JSONArray();
				this.put(keyOrderDetail, orderDetails);
			}
			JSONObject jobj=new JSONObject();
			if (!StringUtils.isEmpty(id)) {
				jobj.put(keyId,id);
			}
			if (!StringUtils.isEmpty(category)) {
				jobj.put(keyCategory, category);
			}
			if (!StringUtils.isEmpty(name)) {
				jobj.put(keyName, name);
			}
			jobj.put(keyUnitPrice, unitPrice);
			jobj.put(keyAmount, amount);
			orderDetails.put(jobj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}


}


package com.talkingdata.appanalytics.plugin;

public class TDAccount {

    public enum AccountType {
        ANONYMOUS(0, "匿名", "ANONYMOUS"), // 匿名
        REGISTERED(1, "自有帐户显性注册", "REGISTERED"), // 自有帐户显性注册
        SINA_WEIBO(2, "新浪微博", "SINA_WEIBO"), // 新浪微博
        QQ(3, "QQ账号", "QQ"), // QQ账号
        QQ_WEIBO(4, "QQ微博账号", "QQ_WEIBO"), // QQ微博账号
        ND91(5, "网龙91", "ND91"), // 网龙91
        WEIXIN(6, "微信账号", "WEIXIN"),//微信账号
        TYPE1(11, "自定义账号1", "TYPE1"), //
        TYPE2(12, "自定义账号2", "TYPE2"), //
        TYPE3(13, "自定义账号3", "TYPE3"), //
        TYPE4(14, "自定义账号4", "TYPE4"), //
        TYPE5(15, "自定义账号5", "TYPE5"), //
        TYPE6(16, "自定义账号6", "TYPE6"), //
        TYPE7(17, "自定义账号7", "TYPE7"), //
        TYPE8(18, "自定义账号8", "TYPE8"), //
        TYPE9(19, "自定义账号9", "TYPE9"), //
        TYPE10(20, "自定义账号10", "TYPE10"); //

        private final int index;
        private final String name;
        private final String type;

        AccountType(int i, String name, String type) {
            this.index = i;
            this.name = name;
            this.type = type;
        }

        public int getIndex() {
            return index;
        }

        public String getName(){
            return name;
        }
        public String getType(){
            return type;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

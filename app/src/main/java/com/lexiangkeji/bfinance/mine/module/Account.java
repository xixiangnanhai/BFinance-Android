package com.lexiangkeji.bfinance.mine.module;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.laputapp.model.BaseModel;


public class Account extends BaseModel {
    @SerializedName("sessionId")
    public String sessionId;
    //新增的字段
    // {"data":{"token":"DBE56B681373D7E5B86AF3FF018C4283","userId":null},"message":{"error_code":"200","error_msg":"登陆成功"}}
    @SerializedName("token")
    public String token;

    @SerializedName("userId")
    public String userId;

    @SerializedName("mobile")
    public String mobile;

    @SerializedName("userType")
    public int userType;

    public User mUser = new User();

    public static class User {
        public String phone, pwd;
    }


    public AccountInfo mAccountInfo = new AccountInfo();

    public class AccountInfo {
        @SerializedName("accountId")
        public String accountId;
        @SerializedName("name")
        public String name;
        @SerializedName("mobile")
        public String mobile;
        @SerializedName("cardNo")
        public String cardNo;
        @SerializedName("bankName")
        public String bankName;
        @SerializedName("bankIconInShow")
        public String bankIcon;
        @SerializedName("bankBgImageUrl")
        public String bankBgImageUrl;

        public AccountInfo() {
            this.accountId = "";
            this.name = "";
            this.mobile = "";
            this.cardNo = "";
            this.bankName = "";
            this.bankIcon = "";
            this.bankBgImageUrl = "";
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }


//    public String getBanknameAndLastNo() {
//        String result = "";
//        if (mAccountInfo.bankName != null) {
//            result = mAccountInfo.bankName + "  **** **** **** " + getLast4CardNo();
//        }
//        return result;
//    }

    public String getLast4AccountId() {
        String last4 = "";
        if (mAccountInfo != null && mAccountInfo.accountId != null && mAccountInfo.accountId.length() > 4) {
            last4 = mAccountInfo.accountId.substring(mAccountInfo.accountId.length() - 4);
        }

        return last4;
    }

    public String getLast4CardNo() {
        String last4 = "";
        if (mAccountInfo != null && mAccountInfo.cardNo != null && mAccountInfo.cardNo.length() > 4) {
            last4 = mAccountInfo.cardNo.substring(mAccountInfo.cardNo.length() - 4);
        }

        return last4;
    }


}

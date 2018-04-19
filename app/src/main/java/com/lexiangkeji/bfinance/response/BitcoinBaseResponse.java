package com.lexiangkeji.bfinance.response;

import com.google.gson.annotations.SerializedName;
import com.laputapp.http.ExtendedObject;

import java.io.Serializable;

import okhttp3.Headers;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2017/6/6
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public class BitcoinBaseResponse<T> extends ExtendedObject implements Serializable {

    int mStatus;

    Headers mHeaders;
    retrofit2.Response mResponse;

    @SerializedName("message")
    public MessageEntity message;
    @SerializedName("data")
    public T data;

    public String token;

    public static class MessageEntity {
        /**
         * error_code : 200
         * error_msg : 执行成功
         */

        @SerializedName("error_code")
        public int errorCode;
        @SerializedName("error_msg")
        public String errorMsg;
    }

    /**
     * 请求是否成功、0代表成功
     *
     * @return
     */
    public boolean isSuccessed() {
        return message.errorCode == 200 ;
//        return true;
    }

    public boolean isShowMessage() {
        return message.errorCode == 400;
    }

    public String getMessage() {
        return message.errorMsg;
    }

    public int getCode() {
        return message.errorCode;
    }


    /**
     * An unmodifiable collection of headers.
     */
    public Headers getHeaders() {
        return mHeaders;
    }

    public retrofit2.Response getResponse() {
        return mResponse;
    }

}

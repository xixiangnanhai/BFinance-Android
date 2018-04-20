package com.lexiangkeji.bfinance.app_api.api.converter;


import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laputapp.BuildConfig;
import com.laputapp.http.sign.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.IdentityHashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

public class PostReformer extends CarLoanRequestReformer {
    private static final String HEADER_CONTENT_LENGTH = "Content-Length";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=UTF-8");
    private static final MediaType MEDIA_TYPE_FORM = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

    public PostReformer(Request preRequest, String key) {
        super(preRequest, key);
    }

    @Override
    protected Request createNewRequest() {
        Request.Builder builder = getReformedWithUrlRequestBuilder();
        String bodyString = createEncodeBodyString(getPreRequest());
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, bodyString);
        builder.post(requestBody);
        try {
            builder.removeHeader(HEADER_CONTENT_LENGTH);
            builder.addHeader(HEADER_CONTENT_LENGTH, requestBody.contentLength() + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        builder.removeHeader(HEADER_CONTENT_TYPE);
        builder.addHeader(HEADER_CONTENT_TYPE, MEDIA_TYPE_JSON.toString());
        Request reformRequest = builder.build();

        if (BuildConfig.DEBUG) {
            LogUtils.d("SignInterceptor", reformRequest.url().toString());
            LogUtils.d("SignInterceptor", bodyToString(reformRequest));
        }
        return builder.build();
    }

    private String createEncodeBodyString(Request request) {
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            String bodyString = bodyToString(request);
            Map<String, Object> params = createBodyEncodeParams(bodyString);
            Map<String, Object> signMap = createTimeAndSignMap(params);
            Gson gson = new GsonBuilder().create();
            return gson.toJson(signMap);
        }
        return null;
    }

    private Map<String, Object> createBodyEncodeParams(String s) {
        LogUtils.e(s);
        if (JsonUtils.isJSONValid(s)) {
            try {
                return JsonUtils.jsonToMap(new JSONObject(s));
            } catch (JSONException e) {
            }
        }
        IdentityHashMap<String, Object> map = new IdentityHashMap<>();
        String[] keyValues = s.split("&");
        for (String keyValue : keyValues) {
            if (TextUtils.isEmpty(keyValue)) {
                continue;
            }
            String[] paramsWithKey = keyValue.split("=", 2);
            try {
                String key = URLDecoder.decode(paramsWithKey[0], "UTF-8");
                String value = URLDecoder.decode(paramsWithKey[1], "UTF-8");
                map.put(key, value);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}

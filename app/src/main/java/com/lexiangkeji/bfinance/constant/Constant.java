package com.lexiangkeji.bfinance.constant;

import com.lexiangkeji.bfinance.BuildConfig;

public class Constant {

    public static final String URL = "url";
    public static final String API_KEY = "kDIsGtWGs9QsoyqrINH4skyEKPwyZbyz";
    public static String Homefirst = "{\n" + "    \"data\": {\n" + "        \"bannerList\":[{\n" + "            \"imageUrl\":\"http://image.png\",\n" + "            \"jumpUrl\":\"http://jump.html\"\n" + "        },{\n" + "            \"imageUrl\":\"http://image1.png\",\n" + "            \"jumpUrl\":\"http://jump1.html\"\n" + "        }],\n" + "        \"productList\":[{\n" + "            \"id\":\"1\",\n" + "            \"type\":1,\n" + "            \"title\":\"币果BTC增币活期\",\n" + "            \"subTitle\":\"活期\",\n" + "            \"rateDes\":\"+8%\",\n" + "            \"rateSubDes\":\"预期年化收益率\",\n" + "            \"ruleDes\":\"随存随取\",\n" + "            \"ruleSubDes\":\"0.1 BTC起投\"\n" + "        },{\n" + "            \"id\":\"2\",\n" + "            \"type\":2,\n" + "            \"title\":\"币果BTC增币7日期\",\n" + "            \"subTitle\":\"7日\",\n" + "            \"rateDes\":\"+10%\",\n" + "            \"rateSubDes\":\"预期年化收益率\",\n" + "            \"ruleDes\":\"到期可取\",\n" + "            \"ruleSubDes\":\"0.1 ETH起投\"\n" + "        }\n" + "        ],\n" + "        \"investInfo\":{\n" + "            \"amountDes\":\"2,725,568,865.28\",\n" + "            \"populationDes\":\"43,985,582\"\n" + "        }\n" + "    },\n" + "    \"message\": {\n" + "        \"code\": 200,\n" + "        \"msg\": \"获取成功\"\n" + "    }\n" + "}";


    public class NetConfig {

        private static final String RELEASE_SERVER_URL = "https://bssapp.cheddd.com/app/";

        //    private static final String DEBUG_SERVER_URL = "http://192.168.1.102:8080/csd/";
        private static final String DEBUG_SERVER_URL = "http://47.93.163.237:18888/csd/";

        public static final String SERVER_URL = BuildConfig.DEBUG ? DEBUG_SERVER_URL : RELEASE_SERVER_URL;

        //网络请求超时时间
        public static final long CONNECT_TIMEOUT = 10000;
    }
}
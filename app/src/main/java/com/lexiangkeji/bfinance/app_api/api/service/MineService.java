package com.lexiangkeji.bfinance.app_api.api.service;

import com.lexiangkeji.bfinance.app_api.api.ServiceGenerator;

/**
 * Created by mateng on 2017/12/4.
 */

public interface MineService {

    MineService INSTANCE = ServiceGenerator.createService(MineService.class);


//    //    @POST("app/product/regularDetail")
//
//    /**
//     * 月月花生 项目详情接口
//     *
//     * @param productId 产品ID
//     * @return 0
//     */
//    @FormUrlEncoded
//    @POST("app/product/regularDetail")
//    Observable<HuaShengBaseResponse<RegularDetailBean>> getRegularDetails(@Field("productId") String productId);
//
//
//    /**
//     * 交易列表
//     *
//     * @param pageNo    页码
//     * @param pageSize
//     * @param tradeType
//     * @return
//     */
//    @GET("app/v4/trade/tradeList")
//    Observable<HuaShengBaseResponse<TradeBean>> tradeList(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("tradeType") String tradeType);
//
//    /**
//     * 总资产
//     */
//    @POST("app/v4/mine/assets/info")
//    Observable<HuaShengBaseResponse<AssetsInfoBean>> getAssetsInfo();
//
//    /**
//     * 特权本金列表
//     */
//    @FormUrlEncoded
//    @POST("app/v3/invite/experiment_gold/list")
//    Observable<HuaShengBaseResponse<PrerogativeBean>> experimentGoldList(@Field("pageNo") int pageNo, @Field("pageSize") int pageSize);
//
//
//    /**
//     * 安心花生加入详情 ---对应原型：2.4我的账户页面-》加入详情（产品资产详情）
//     */
//    @FormUrlEncoded
//    @POST("app/mine/record/invest/pureRegular/info")
//    Observable<HuaShengBaseResponse<FinancePureRegularInfoModel>> http_getFinancePureRegularInfo(@Field("investId") String investId);
//
//
//    /**
//     * 更换注册手机号--第一步--验证三要素
//     *
//     * @param idNo    身份证号
//     * @param cardNo  银行卡号
//     * @param smsCode 短信验证码
//     */
//    @FormUrlEncoded
//    @POST("app/changeMobile/verify")
//    Observable<HuaShengBaseResponse<ChangeMobileVerifyModel>> http_checkMobileVerifyIdNo(@Field("idNo") String idNo, @Field("cardNo") String cardNo, @Field("smsCode") String smsCode);
//
//    /**
//     * 校验更换注册手机号的身份证号 --对应原型图的5.1修改注册手机号
//     *
//     * @param mobile  手机号
//     * @param smsCode 验证码
//     */
//    @FormUrlEncoded
//    @POST("app/changeMobile/submit")
//    Observable<HuaShengBaseResponse<Object>> http_changeMobileSubmit(@Field("mobile") String mobile, @Field("smsCode") String smsCode, @Field("sign") String sign);
//
//
//    /**
//     * 根据输入的卡号获得是哪个银行
//     */
//    @FormUrlEncoded
//    @POST("app/common/bank/info")
//    Observable<HuaShengBaseResponse<BankInfoByCardNoModel>> http_getBankInfoByCardNumber(@Field("cardNo") String cardNo);
//
//
//    /**
//     * 开户页面的运营位和推荐银行位
//     */
//    @POST("app/mine/account/open/info")
//    Observable<HuaShengBaseResponse<AccountOpenInfoModel>> http_getAccountOpenInfo();
//
//    /**
//     * 获取身份认证信息
//     *
//     * @return
//     */
//    @POST("app/mine/identity/info")
//    Observable<HuaShengBaseResponse<IdentityInfoModel>> http_getIdentityInfo();
//
//
//    /**
//     * 提交身份认证信息
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("app/mine/identity/submit")
//    Observable<HuaShengBaseResponse> http_submitIdentityInfo(@Field("name") String name, @Field("idNo") String idNo);
//
//    /**
//     * 充值结果，充值详情，提现详情，投资详情，转出结果，转出详情。的接口
//     *
//     * @param orderId   交易ID
//     * @param tradeType 交易类型(0 未知 1 充值详情 2 充值结果 3 提现详情 4 投资详情 5 转出结果 6 转出详情)
//     */
//    @GET("app/v2/trade/queryDetailResult")
//    Observable<HuaShengBaseResponse<TransactionDetailsModel>> http_queryDetailResult(@Query("orderId") String orderId, @Query("tradeType") int tradeType);
//
//    /**
//     * 加息卡券信息接口
//     */
//    @POST("app/mine/ticket/info")
//    Observable<HuaShengBaseResponse<TicketTabInfo>> http_getTickTabInfo();
//
//
//    /**
//     * 风险测评接口
//     */
//    @POST("app/user/riskEvaluate/info")
//    Observable<HuaShengBaseResponse<RiskEvaluateInfo>> httpRiskEvaluateInfo();
}

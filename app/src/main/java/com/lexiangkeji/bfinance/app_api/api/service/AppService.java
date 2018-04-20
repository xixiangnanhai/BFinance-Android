package com.lexiangkeji.bfinance.app_api.api.service;


import com.lexiangkeji.bfinance.app_api.api.ServiceGenerator;
import com.lexiangkeji.bfinance.response.BitcoinBaseResponse;
import com.lexiangkeji.bfinance.response.HomeResulInforModel;

import retrofit2.http.POST;
import rx.Observable;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2017/6/5
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public interface AppService {

    AppService INSTANCE = ServiceGenerator.createService(AppService.class);


    /**
     * 获取首页数据
     */
    @POST("app/v3/home/info")
    Observable<BitcoinBaseResponse<HomeResulInforModel>> http_getHomeInfo();





//
//    @FormUrlEncoded
//    @POST("app/user/login")
//    Observable<HuaShengBaseResponse<Account>> login(
//            @Field("mobile") String mobile,
//            @Field("password") String password
//    );
//
//    //登录注册是的判断接口
//    @FormUrlEncoded
//    @POST("app/v2/user/isReg")
//    Observable<HuaShengBaseResponse<Accounts>> loginNext(
//            @Field("mobile") String mobile
//    );
//
//    // 登录注册
//    @FormUrlEncoded
//    @POST("app/v4/user/regAndLogin")
//    Observable<HuaShengBaseResponse<Account>> loginRegister(
//            @Field("mobile") String mobile,
//            @Field("type") int type,
//            @Field("captcha") String captcha,
//            @Field("deviceId") String deviceId,
//            @Field("password") String password
//    );
//
//
//    // 转出(新)
//    @FormUrlEncoded
//    @POST("app/v4/invest/assetChange")
//    Observable<HuaShengBaseResponse<JumpUrlBean>> assetChange(
//            @Field("amount") String amount,
//            @Field("smsCode") String smsCode,
//            @Field("investId") String investId,
//            @Field("productId") String productId   //安心或者灵活产品ID
//    );
//
//    @FormUrlEncoded
//    @POST("app/v4/invest/assetChange")
//    Observable<HuaShengBaseResponse<JumpUrlBean>> assetChange(
//            @Field("amount") String amount,
//            @Field("smsCode") String smsCode,
//            @Field("investId") String investId
//    );
//
//    // TODO: 2017/9/14 0014
//
//    /**
//     * 正式发短信 投资的短信 短信验证码
//     *
//     * @param mobile
//     * @param captcha
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("app/v3/msg/sendSmsCode")
//    Observable<HuaShengBaseResponse<Object>> sendSmsCode(
//            @Field("mobile") String mobile,
//            @Field("sms_code") String captcha,
//            @Field("amount") String amount,
//            @Field("investId") String investId
//    );
//
//    @FormUrlEncoded
//    @POST("app/v2/account/smsCodeApply")
//    Observable<HuaShengBaseResponse<Object>> smsCodeApply(
//            @Field("mobile") String mobile,
//            @Field("srvTxCode") String srvTxCode
//    );
//
//    // 充值限额
//    @GET("app/recharge/info")
//    Observable<HuaShengBaseResponse<RechargeInfo>> rechargeInfo();
//
//
//    @FormUrlEncoded
//    @POST("app/v3/recharge/rechargeOnline")
//    Observable<HuaShengBaseResponse<JumpUrlBean>> rechargeOnline(
//            @Field("txAmount") String txAmount,
//            @Field("smsCode") String smsCode
//    );
//
//    @FormUrlEncoded
//    @POST("app/v2/account/accountOpen")
//    Observable<HuaShengBaseResponse<AccountOpenBean>> accountOpen(
//            @Field("name") String name,
//            @Field("idNo") String idNo,
//            @Field("cardNo") String cardNo,
//            @Field("smsCode") String smsCode,
//            @Field("bankName") String bankName,
//            @Field("mobile") String mobile
//    );
//
//
//    @POST("app/v2/loan/searchDebtByUserId")
//    Observable<HuaShengBaseResponse<List<CreaditorBean>>> searchDebtByUserId();
//
//    @POST("app/v2/innermsg/list")
//    Observable<HuaShengBaseResponse<List<MyMsgBean>>> myMsgList();
//
//    /**
//     * 可以开户的开户银行
//     *
//     * @return 银行列表
//     */
//    @POST("app/v2/recharge/rechargeLimitList")
//    Observable<HuaShengBaseResponse<List<BankListBean>>> rechargeLimitList();
//
//    /**
//     * 我的页面，各种数据的数量
//     *
//     * @return 数据数量
//     */
//    @POST("app/v2/invite/experiment_gold/count")
//    Observable<HuaShengBaseResponse<CountBean>> experimentGoldCount();
//
//    /**
//     * 注意：（升到v3）
//     *
//     * @param type      产品类型 （毕传）
//     * @param productId (产品ID 非月月加入则不传)
//     * @return 返回利率等等数据
//     */
//    @FormUrlEncoded
//    @POST("app/v4/financeProduct/topOne")
//    Observable<HuaShengBaseResponse<TopOneBean>> topOne(@Field("type") int type, @Field("productId") String productId);
//
//
//    @POST("app/v2/cms/list")
//    Observable<HuaShengBaseResponse<List<PlatformNotesBean>>> platformNotes();
//
//    @POST("app/v2/account/queryAccountStateRemote")
////    @POST("app/v3/account/queryAccountStateRemote")
//    Observable<HuaShengBaseResponse<AccountStateBean>> queryAccountState();
//
//    @POST("app/v3/invest/findOutAmount")
//    Observable<HuaShengBaseResponse<FindOutAmountBean>> findOutAmount();
//
//    @POST("app/v2/invite/share")
//    Observable<HuaShengBaseResponse<ShareBean>> share();
//
//    @DELETE("app/v2/user/logout")
//    Observable<HuaShengBaseResponse<Object>> loginOut();
//
//    @GET("app/v2/appVersion/version")
//    Observable<HuaShengBaseResponse<VersionBean>> version();
//
//    @POST("app/v3/account/accountInfo")
//    Observable<HuaShengBaseResponse<Account.AccountInfo>> accountInfo();
//
//    @FormUrlEncoded
//    @POST("app/v2/msg/blog/submit")
//    Observable<HuaShengBaseResponse<Object>> blogSubmit(
//            @Field("msg") String msg
//    );
//
//    @FormUrlEncoded
//    @POST("app/v2/withdraw/valid")
//    Observable<HuaShengBaseResponse<Object>> WithdrawNext(
//            @Field("totalAmount") String totalAmount
//    );
//
//    @POST("app/v2/withdraw/index")
//    Observable<HuaShengBaseResponse<WithdrawLimitBean>> WithdrawLimit();
//
//    @POST("app/v2/invite/experiment_gold/map")
//    Observable<HuaShengBaseResponse<PrerogativeMapBean>> experimentGoldMap();
//
//
//    /**
//     * 加入获取的验证码
//     *
//     * @param investTotal  加入金额
//     * @param balanceAmout 余额
//     * @return
//     */
//    @FormUrlEncoded
////    @POST("app/v2/invest/validationCode")
//    @POST("app/v3/invest/validationCode")
//    Observable<HuaShengBaseResponse<Object>> investAuthCode(
//            @Field("investTotal") double investTotal,
//            @Field("balanceAmout") double balanceAmout
//    );
//
//    /**
//     * 确认加入接口
//     *
//     * @param investTotal  总加入额
//     * @param smsCode      短信验证码
//     * @param ticketId     加息券（卡）ID
//     * @param type         产品类型
//     * @param productId    产品ID（非月月花生不传）
//     * @param balanceAmout 余额(若不使用余额则不传)
//     * @return 返回加入的结果模型
//     */
//    @FormUrlEncoded
//    @POST("app/v5/invest/investVC")
//    Observable<HuaShengBaseResponse<Object>> investVC(
//            @Field("investTotal") double investTotal,
//            @Field("smsCode") String smsCode,
//            @Field("ticketId") String ticketId,
//            @Field("type") int type,
//            @Field("productId") String productId,
//            @Field("balanceAmout") double balanceAmout);
//
//    /**
//     * 发现列表
//     *
//     * @return 返回发现列表
//     */
//    @FormUrlEncoded
//    @POST("app/v2/discovery/list")
//    Observable<HuaShengBaseResponse<FindBean>> findList(@Field("type") int type);
//
//
//    /**
//     * @return 已获加息券列表
//     */
//    @POST("mine/card/used")
//    Observable<HuaShengBaseResponse<HikeOutBean>> hikeOutList();
//
//    /**
//     * @param investAmount 加入的金额
//     * @param status       状态（）
//     * @return 优惠券列表
//     * <p>
//     * 查看已过期优惠券的那个页面在使用
//     */
//    @FormUrlEncoded
//    @POST("app/v3/mine/ticket/list")
//    // 由 v2 升级到  v3
//    Observable<HuaShengBaseResponse<HikeOutBean>> hikeOutList(
//            @Field("investAmount") double investAmount,
//            @Field("status") int status);
//
//    /**
//     * @param investAmount 加入的金额
//     * @param status       状态（）
//     * @param type         产品类型
//     * @return 优惠券列表
//     */
//    @FormUrlEncoded
//    @POST("app/v3/mine/ticket/list")
//    // 由 v2 升级到  v3
//    Observable<HuaShengBaseResponse<HikeOutBean>> hikeOutList(
//            @Field("investAmount") double investAmount,
//            @Field("status") int status,
//            @Field("type") int type,
//            @Field("productId") String productId);
//
//    /**
//     * @param investAmount 加入的金额
//     * @param status       状态（）
//     * @return 优惠券列表
//     */
//    @FormUrlEncoded
//    @POST("app/v3/mine/ticket/list")
//    // 由 v2 升级到  v3
//    Observable<HuaShengBaseResponse<HikeOutBean>> hikeOutList(
//            @Field("investAmount") double investAmount,
//            @Field("status") int status,
//            @Field("fromType") int fromType,
//            @Field("pageNo") int pageNo,
//            @Field("pageSize") int pageSize);
//
//    /**
//     * 使用加息卡
//     *
//     * @param id 加息卡ID
//     */
//    @FormUrlEncoded
//    @POST("app/mine/addRate/card/submit")
//    Observable<HuaShengBaseResponse<Object>> useHikeOut(
//            @Field("id") String id
//    );
//
//    /**
//     * 获取运营信息接口
//     *
//     * @param type 0 预留
//     *             1 投资成功运营位
//     *             2 加息利率运营位
//     *             3 转出列表运营位  新增
//     */
//    @GET("app/common/operation/info")
//    Observable<HuaShengBaseResponse<OperationInfoBean>> getOperationInfo(@Query("type") int type);
//
//    /**
//     * 获取app的后台配置接口
//     */
//    @POST("app/common/configure/info")
//    Observable<HuaShengBaseResponse<AppConfiguration>> getAppConfiguration();
//
//    /**
//     * 获得开屏页图片以及相关信息的接口
//     *
//     * @param type 0 默认尺寸      1 iPhoneX尺寸
//     */
//    @FormUrlEncoded
//    @POST("app/v2/common/launchImage/info")
//    Observable<HuaShengBaseResponse<SplashModel>> getLaunchImageInfo(@Field("type") int type);
//
//    /**
//     * 活期加入详情
//     */
//    @POST("app/mine/assets/currentInvestDetail")
//    Observable<HuaShengBaseResponse<CurrentDetailModel>> getCurrentDetail();
//
//    /**
//     * 灵活花生加入详情
//     */
//    @FormUrlEncoded
//    @POST("app/mine/assets/regularInvestDetail")
//    Observable<HuaShengBaseResponse<RegularDetailModel>> getRegularDetail(@Field("type") int type,
//                                                                          @Field("investId") String investId);
//
//    /**
//     * 灵活花生投资列表接口
//     *
//     * @param pageNo   0
//     * @param pageSize 20
//     * @param status   状态
//     */
//    @FormUrlEncoded
//    @POST("app/mine/assets/monthProduct/list")
//    Observable<HuaShengBaseResponse<RegularDetailListModel>> getRegularDetailList(@Field("pageNo") int pageNo,
//                                                                                  @Field("pageSize") int pageSize,
//                                                                                  @Field("status") int status);
//
//    @FormUrlEncoded
//    @POST("app/invest/rollOut/regularInfo")
//    Observable<HuaShengBaseResponse<RegularRollOutInfoModel>> getRegularRollOutInfoModel(
//            @Field("investId") String investId
//    );
//
//    /**
//     * 分享成功上报接口
//     *
//     * @return
//     */
//    @GET
//    Observable<HuaShengBaseResponse> shareReport(
//            @Url String url
//    );
//
//
//    /**
//     * 可转出到的产品列表接口
//     */
//    @POST("app/assetChange/modeList")
//    Observable<HuaShengBaseResponse<AssetChangeModeListBean>> http_getAssetChangeModeList();
//
//    /**
//     * 下载PDF文件
//     */
//    @Streaming
//    @GET
//    Call<ResponseBody> downloadPDF(@Url String fileUrl);

}
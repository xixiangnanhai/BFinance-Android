package com.lexiangkeji.bfinance.app_api.api.service;

import com.lexiangkeji.bfinance.app_api.api.ServiceGenerator;
import com.lexiangkeji.bfinance.response.BitcoinBaseResponse;
import com.lexiangkeji.bfinance.response.HomeResulInforModel;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by fanlei on 2017/12/4.
 * <p>
 * 首页接口的Service
 */

public interface HomeService {

    HomeService INSTANCE = ServiceGenerator.createService(HomeService.class);






//
//    /**
//     * 获取首页数据
//     */
    @POST("app/v3/home/info")
    Observable<BitcoinBaseResponse<HomeResulInforModel>> http_getHomeInfo();

//    /**
//     * 天天花生数据
//     */
//    @POST("app/product/currentDetail")
//    Observable<HuaShengBaseResponse<CurrentInvestDetailsResultModel>> http_getCurrentInvestDetails();
//
//    /**
//     * 获取定期产品列表
//     */
//    @POST("app/product/list")
//    Observable<HuaShengBaseResponse<FinanceListModel>> http_getFinanceProductList();
//
//    /**
//     * 定期产品项目详情页
//     *
//     * @param productId 产品ID
//     */
//    @FormUrlEncoded
//    @POST("app/product/pureRegular/info")
//    Observable<HuaShengBaseResponse<FinanceProductDetailsInfoModel>> http_getFinanceProductDetailsInfo(@Field("productId") String productId);
//
//
//    /**
//     * 定期产品加入记录页
//     */
//    @FormUrlEncoded
//    @POST("app/product/invest/record/list")
//    Observable<HuaShengBaseResponse<FinanceInvestRecordsModel>> http_getFinanceInvestRecordList(@Field("pageSize") int pageSize, @Field("pageNo") int pageNo, @Field("productId") String productId, @Field("type") int type);
//
//
//    /**
//     * 安心花生加入记录列表 --- 对应原型：2.4我的账户页面-》加入记录列表
//     * type 0 未知  1 加入中  2 已到期
//     */
//    @FormUrlEncoded
//    @POST("app/mine/record/invest/pureRegular/list")
//    Observable<HuaShengBaseResponse<PersonInvestRecordListModel>> http_getPersonInvestRecordList(@Field("pageSize") int pageSize, @Field("pageNo") int pageNo, @Field("type") int type);
//
//    /**
//     * 获取首页Tab的接口
//     */
//    @GET("app/common/tabImage/info")
//    Observable<HuaShengBaseResponse<HomeTabImageInfoBean>> http_getTabImageInfo();
//
//    /**
//     * 下载首页Tab资源图片的接口
//     */
//    @Streaming
//    @GET
//    Call<ResponseBody> downloadFileRetrofit(@Url String fileUrl);
}

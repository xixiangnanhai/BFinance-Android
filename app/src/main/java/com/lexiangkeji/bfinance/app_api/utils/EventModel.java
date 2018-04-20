package com.lexiangkeji.bfinance.app_api.utils;

/**
 * Created by Eric.Gao on 2017/11/23.
 */

public class EventModel {

    ////////////////////////////首页///////////////////////////////
    //banner
    public static final String KHomeBanner = "Home_Banner";

    // 邀请好友按钮	        点击次数	Home_Activity	跳转的url
    // 每日抽奖按钮	        点击次数	Home_Activity	跳转的url
    // 风控保障按钮	        点击次数	Home_Activity	跳转的url
    // 消息中心按钮	        点击次数	Home_Activity	跳转的url
    // 天天花生卡片	        点击次数	Home_Product_First
    // 天天花生-立即加入按钮	点击次数	Home_Product_First_Button
    // 灵活花生卡片	        点击次数	Home_Product_Second
    // 灵活花生-立即加入按钮	点击次数	Home_Product_Second_Button
    // 邀请好友卡片	        点击次数	Home_Operation
    // 资金安全卡片	        点击次数	Home_Banner
    // 联想控股卡片	        点击次数	Home_Secure	    跳转的url
    // 加入数据卡片	        点击次数	Home_Secure	    跳转的url
    public static final String KHome_Activity = "Home_Activity";
    public static final String KHome_Product_First = "Home_Product_First";
    public static final String KHome_Product_First_Button = "Home_Product_First_Button";
    public static final String KHome_Product_Second = "Home_Product_Second";
    public static final String KHome_Product_Second_Button = "Home_Product_Second_Button";
    public static final String KHome_Operation = "Home_Operation";
    public static final String KHome_Banner = "Home_Banner";
    public static final String KHome_Secure = "Home_Secure";
    public static final String KHome_Data = "Home_Data";
    public static final String Home_Activity_Pop = "Home_Activity_Pop";  // 活动弹窗点击次数
    //天天花生3月-立即投资按钮
    public static final String KHome_PureRegular_Button = "Home_PureRegular_Button";
    //天天花生3月卡片
    public static final String KHome_PureRegular = "Home_PureRegular";
    //活动公告
    public static final String KHome_Activity_Top = "Home_Activity_Top";

    /////////////////////////////////发现页//////////////////////////////////
    public static final String KDiscovery_Activity = "KDiscovery_Activity";// 发现页  活动点击次数
    public static final String KDiscovery_Hot = "Discovery_Hot";// 发现页  热门活动标签
    public static final String KDiscovery_Info = "Discovery_Info";// 发现页  信息披露标签


    // --------------------- 加入成功页 --------------------
    public static final String KInvest_Success_Continue = "Invest_Success_Continue";
    public static final String KInvest_Success_ToAccount = "Invest_Success_ToAccount";
    public static final String KInvest_Success_Activity = "Invest_Success_Activity";
    public static final String KInvest_Success_Tel = "Invest_Success_Tel";


    ////////////////////////////立即加入页面///////////////////////
    //立即加入按钮
    public static final String KProductInvest = "Product_Invest";

    ///////////////////////////充值////////////////////////////////
    //充值按钮点击
    public static final String KRechargeSubmit = "Recharge_Submit";

    ///////////////////////////提现///////////////////////////////
    //提现按钮点击
    public static final String KWithdrawSubmit = "Withdraw_Submit";

    ///////////////////////////转出///////////////////////////////
    //转出按钮点击
    public static final String KRolloutSubmit = "Rollout_Submit";


    ////////////////////////////更多////////////////////////////
    //登出点击
    public static final String KMineLogout = "Mine_Logout";

    ////////////////////////////我的////////////////////////////
//    微信图标按钮	点击次数	Mine_WeChat
//    黄色大卡片	点击次数	Mine_Top
//    我的总资产栏目	点击次数	Mine_Assets
//    银行存管栏目	点击次数	Mine_Account
//    交易记录栏目	点击次数	Mine_Trade_Record
//    特权本金栏目	点击次数	Mine_Privilege
//    加息券栏目	点击次数	Mine_AddRate
//    邀请好友栏目	点击次数	Mine_Activity
//    常见问题栏目	点击次数	Mine_Question
//    更多栏目	点击次数	Mine_More
//    客服电话	点击次数	Mine_Tel
//    退出登录	点击次数	Mine_Logout
    public static final String KMineWeChat = "Mine_WeChat";
    public static final String KMine_Top = "Mine_Top";
    public static final String KMine_Assets = "Mine_Assets";
    public static final String KMine_Account = "Mine_Account";
    public static final String KMine_Trade_Record = "Mine_Trade_Record";
    public static final String KMine_AddRate = "Mine_AddRate";
    public static final String KMine_Privilege = "Mine_Privilege";
    public static final String KMine_Activity = "Mine_Activity";
    public static final String KMine_Question = "Mine_Question";
    public static final String KMine_More = "Mine_More";
    public static final String KMine_Tel = "Mine_Tel";
    //在线反馈按钮
    public static final String KMine_Feedback = "Mine_Feedback";

    ////////////////////////////特权本金////////////////////////////
    public static final String KPrivilege_Cell = "Privilege_Cell";
    ////////////////////////////银行存管////////////////////////////
    public static final String KAccount_ChangePsd = "Account_ChangePsd";

    ///////////////////////////充值/////////////////////////////////
    //其他银行限额说明
    public static final String KRecharge_Submit_Other = "Recharge_Submit_Other";

    ////////////////////////////活动////////////////////////////////
    //活动	H5内部前往灵活花生详情页事件	点击次数	H5_Goto_RegularDetail	h5Url	H5的界面地址
    public static final String KH5GoToRegularDetail = "H5_Goto_RegularDetail";

    //活动页面-右上角分享按钮	点击次数	H5_Nav_Share
    public static final String KH5NavShare = "H5_Nav_Share";

    //    分享到朋友圈	点击次数	H5_Share_Wechat_TimeLine	h5Url	跳转的url
    public static final String KH5ShareWechatTimeLine = "H5_Share_Wechat_TimeLine";

    //    分享到好友	点击次数	H5_Share_Wechat_Session	h5Url	跳转的url
    public static final String KH5ShareWechatSession = "H5_Share_Wechat_Session";

    // --------------------------- 产品列表的埋点 ----------------------
    public static final String KTab_Product = "Tab_Product";// 产品icon
    public static final String KProduct_Newer = "Product_Newer";// 新手花生卡片
    public static final String KProduct_Newer_Button = "Product_Newer_Button";// 新手花生-抢购按钮
    public static final String KProduct_Current = "Product_Current";// 天天花生卡片
    public static final String KProduct_Current_Button = "Product_Current_Button";// 天天花生-抢购按钮
    public static final String KProduct_Regular = "Product_Regular";// 灵活花生卡片
    public static final String KProduct_Regular_Button = "Product_Regular_Button";// 灵活花生-抢购按钮
    public static final String KProduct_PureRegular = "Product_PureRegular";// 安内花生3月卡片
    public static final String KProduct_PureRegular_Button = "Product_PureRegular_Button";// 安内花生3月-抢购按钮

    // ------------------------- 安心花生产品详情页 ---------------------
    public static final String KPureRegular_Protocol = "PureRegular_Protocol";//协议
    public static final String KPureRegular_Record = "PureRegular_Record";//投资记录选项卡
    public static final String KPureRegular_Invest = "PureRegular_Invest";//立即加入按钮

    // ------------------------ 总资产 安心花生 -----------------------
    public static final String KAssets_PureRegular_Invest = "Assets_PureRegular_Invest";//前往投资按钮
    public static final String KAssets_PureRegular_BorrowedList = "Assets_PureRegular_BorrowedList";//查看资金流向按钮

    /////////////////////////////开屏页/////////////////////////////////
    public static final String KLaunch_Jump = "Launch_Jump";

    // ------------------------ 开户界面的埋点 ------------------------
    public static final String KOpenAccount_BankLimit = "OpenAccount_BankLimit";//右上角银行卡限额
    public static final String KOpenAccount_Recommend = "OpenAccount_Recommend";//顶部推荐银行
    public static final String KOpenAccount_Tel_Tips = "OpenAccount_Tel_Tips";//预留手机号
    public static final String KOpenAccount_Submit = "OpenAccount_Submit";//提交按钮
    public static final String KOpenAccount_Operation = "OpenAccount_Operation";//底部运营位

}

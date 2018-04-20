package com.lexiangkeji.bfinance.constant;

import com.blankj.utilcode.util.AppUtils;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2017/6/29 0029
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public interface Constants {

    int PAGE_SIZE = 20;

    String UM_ALIAS_NAME = "imhuasheng";

    String E_Mail = "service@imhuasheng.com";

    //投诉电话
    String COMPLAIN_TEL = "010-57143812";

    String OUR_WEB = "www.imhuasheng.com";

    String WECHAT_PUBLIC_ACOUNT = "huashenglicaiapp";

    String WeiBo = "花生投";


    class Configs {
        public static String PHONE_NUMBER = "400-086-8278";
    }

    class CommonYesAndNoStatus {
        public static final int UNKNOWN = 0;
        public static final int YES = 1;
        public static final int NO = 2;
    }

    class NewUserInvestedStatus {
        public static final int UNKNOWN = 0;
        public static final int INVESTED = 1;
        public static final int UNINVESTED = 2;//没投过新手标. 其他都当做投过
    }


    /**
     * 定期加入详情, 按钮状态
     * status (Int，状态)
     * 0:未知
     * 1:不可点击（按钮主题色不可点--匹配中，结算中等状态）
     * 2:可点击 （按钮主题色高亮，可以点击--转出：即开放日）
     * 3:灰颜色 （按钮灰色不可点，文字白色--已转出，已到期）
     */
    class RegularDetailStatus {
        public static final int UNKNOWN = 0;
        public static final int DISABLED_NORMAL = 1;
        public static final int ENABLED = 2;
        public static final int DISABLED_GREY = 3;
    }

    /**
     * status (Int，产品状态类型)
     * 0 : 未知
     * 1 : 加入中
     * 2 : 已转出
     * 3 : 已到期
     */
    class RegularDetailListStatus {
        public static final int UNKNOWN = 0;
        public static final int IN_INVEST = 1;
        public static final int WITHDRAWN = 2;
        public static final int EXPIRE = 3;
    }

    /**
     * 0:灵活花生、1:天天产品、2:新手专享产品 3 总的 4 特权本金 5 纯定期
     */
    class FinanceType {
        public static final int REGULAR = 0;
        public static final int CURRENT = 1;
        public static final int NEW_USER = 2;
        public static final int ALL = 3;
        public static final int PRIVILEGE_PRINCIPAL = 4;
        public static final int FINANCE = 5;
    }

    /**
     * 用户类型
     */
    class UserType {
        public static final String OLD_USER = "1"; // 老手
        public static final String NEW_USER = "2"; // 新手
    }

    /**
     * 加入详情item的类型
     * 0 预留  1 特殊类型（特指是加息情况的类型，此时取数组） 2 其他普通类型
     */
    class InvestDetailItemType {
        public static final int RESERVED = 0;
        public static final int SPECIAL = 1;
        public static final int OTHER = 2;
    }

    /**
     * 运营配置的广告位
     */
    class CommonOperationInfoType {
        public static final int INVEST_SUCCESS = 1;// 投资成功底部
        public static final int INTEREST_RATES = 2;// 已获加息利率中间位置运营位
        public static final int OPEN_DEPOSIT = 3;  // 银行开户底部运营位
    }

    /**
     * 0 预留
     * 1 密码登录
     * 2 验证码登录
     * 3 验证码+密码注册
     * 4 修改密码
     * 5 设置密码
     */
    class LoginType {
        public static final int UNKNOWN = 0;
        public static final int PASSWORD = 1;
        public static final int AUTH_CODE = 2;
        public static final int AUTH_PWD = 3;
        public static final int CHANGE_PWD = 4;
        public static final int SET_PWD = 5;
    }

    /**
     * 风险测评状态
     * 1: 隐藏
     * 2:已测评
     * 3:未测评
     */
    class RiskEvaluateType {
        public static final int UNKNOWN = 0;
        public static final int HIDE = 1;
        public static final int EVALUATED = 2;
        public static final int UNEVALUATED = 3;
    }

    enum CodeType {
        /**
         * 注册
         */
        REGISTER, /**
         * 登录
         */
        LOGIN, /**
         * 重置登录密码
         */
        RESETPW, /**
         * 加入
         */
        INVEST,

        /**
         * 转出
         */
        OUTING,

        /**
         * 验证信息
         */
        VERIFYINFO, /**
         * 更换手机号
         */
        CHANGEMOBILE, /**
         * 设置密码
         */
        SETPSD, /**
         * 更换密码
         */
        UPDATEPSD
    }

    enum TradeType {
        /**
         * 充值
         */
        recharge, /**
         * 提现
         */
        withdraw, /**
         * 加入
         */
        invest, /**
         * 转出
         */
        transfer


    }

    enum SrvTxCode {
        /**
         * 开户
         */
        accountOpenPlus, /**
         * 绑卡
         */
        cardBindPlus, /**
         * 电子账户手机号修改
         */
        mobileModifyPlus, /**
         * 重置交易密码
         */
        passwordResetPlus,

        /**
         * 自动债转签约
         */
        autoCreditInvestAuthPlus, /**
         * 短信快捷充值
         */
        directRechargeOnline, /**
         * 电子账户充值
         */
        directRechargePlus, /**
         * 自动投标签约
         */
        autoBidAuthPlus


    }


    class TicketList {
        ;
        /**
         * 未使用
         */
        public static final int UNUSED = 0;
        /**
         * 已使用
         */
        public static final int USED = 1;
        /**
         * 已过期
         */
        public static final int STALE = 2;
    }

    class TickOrCardType {
        /**
         * 加息卷
         */
        public static final int TICK = 2;
        /**
         * 加息卡
         */
        public static final int CARD = 1;
    }

    class URL {

        private static String BASE_URL = HostUtils.getInstance().getCurrentHost();

        /**
         * 重置交易密码
         */
        public static String getPayKeyResetInit() {
            return BASE_URL + "app/v2/account/payKeyResetInit";
        }

        /**
         * 常见问题
         */
        public static String getIssues() {
            return BASE_URL + "html/common/issues.html";
        }

        /**
         * 用户授权协议
         */
        public static String getAuthorizedAgreement() {
            return BASE_URL + "html/agreement.html";
        }

        /**
         * 委托扣款协议
         */
        public static String getLoanAgreement() {
            return BASE_URL + "html/loan_agreement.html";
        }

        /**
         * 分享邀请好友
         */
        public static String getInviteUrl() {
            return BASE_URL + "html/invite.html";
        }

        /**
         * 新手加入项目详情
         */
        public static String getNewUserH5() {
            return BASE_URL + "html/product/newer.html";
        }

        /**
         * 微信关注页面
         */
        public static String getWechatAttention() {
            return BASE_URL + "html/weixin/weixin.html";
        }

        /**
         * 累计回报页面
         */
        public static String getCumulativeRevenue() {
            return BASE_URL + "html/interest/interestList.html?type=3";
        }

        /**
         * 特权本金累计回报
         */
        public static String getPreCumulativeRevenue() {
            return BASE_URL + "/html/interest/interestList.html?type=4";
        }

        /**
         * 灵活花生底部webview  URL
         */
        public static String getRegularBottomUrl() {
            return BASE_URL + "html/monthPeanut/detail.html";
        }

        /**
         * 获取充值界面支付宝链接
         */
        public static String getZhifubaoRepayUrl() {
            return BASE_URL + "html/transfer/zhifubao.html";
        }

        /**
         * 获取充值页面网银转账的URL
         */
        public static String getWangYinRepayUrl() {
            return BASE_URL + "html/transfer/wangyin.html";
        }

        /**
         * 花生投用户协议
         */
        public static String getUserAgreement() {
            return BASE_URL + "html/user_agreement.html";
        }

        /**
         * p2p智能协议
         */
        public static String getP2pIntelligentDepositAgreement() {
            return BASE_URL + "html/agreement/p2pIntelligentDeposit.html";
        }

        /**
         * 江西银行网络资金账户服务第三方协议
         */
        public static String getJxBankThirdPartyAgreement() {
            return BASE_URL + "html/agreement/jxBankThirdParty.html";
        }

        /**
         * 摘花生
         *
         * @return
         */
        public static String getZhaiHS() {
            return BASE_URL + "html/signIn/loading.html?needLogin=1";
        }
    }

    class GLOBE {
        public static String yearRate = "";
        public static String investAmount;
        public static double rollOutAmount;
        public static String earningId;
    }

    class SP {

        /////////////////////////弹窗sp////////////////////////////////////
        public static String SP_POP = "sp_pop";//弹窗sp名
        public static String POP_ID = "pop_id";
        public static final String UPDATE_TIME = "update_time";// 更新时间

        ////////////////////////////用户状态sp////////////////////////
        public static String SP_ACCOUNT_STATUS = "sp_account_status";//用户状态sp名
        public static String IS_INVESTED = "is_invested";

        ////////////////////////切换环境sp//////////////////////////
        public static String SP_HOST = "sp_host";//环境切换sp名
        public static String CURRENT_HOST = "current_host";

        ///////////////////////开屏页/////////////////////////////(为了解决版本升级造成的数据模型不一致的问题,所以后面要拼接上版本号)
        public static final String SP_SPLASH_SCREEN = "sp_splash_screen_" + AppUtils.getAppVersionCode();
        public static final String SPLASH_MODEL = "splash_model_" + AppUtils.getAppVersionCode();

        ///////////////////////隐藏金额////////////////////////////
        public static final String SP_HIDE_MONEY = "sp_hide_money";
        public static final String HIDE_MONEY = "hide_mine";


        ////////////////////////配置/////////////////////////////
        public static final String SP_CONFIGURATION = "sp_configuration";
        public static final String SERVER_PHONE_NUMBER = "server_phone_number";

        ///////////////////////手势密码///////////////////////////
        public static final String SP_GESTURE = "sp_gesture";
        public static final String IS_SET_GESTURE = "is_set_gesture";
        public static final String GESTURE_PWD = "gesture_pwd";

        ////////////////////////缓存文件sp////////////////////////////
        public static final String SP_CACHE_HOST = "sp_cache_host";//缓存文件sp名
        public static final String home_api_catch = "HOME_API_CACHE" + AppUtils.getAppVersionName();// 首页数据缓存
        public static final String MINE_ACCOUNT_INFO = "accountInfo";
        public static final String MINE_ASSETS_INFO = "assetInfo";
        public static final String MINE_COUNT_INFO = "countInfo";
        public static final String CACHE_TOTAL_AMOUNT = "totalAmount";
        public static final String MINE_SET_GUIDE = "MINE_SET_GUIDE";

    }

}

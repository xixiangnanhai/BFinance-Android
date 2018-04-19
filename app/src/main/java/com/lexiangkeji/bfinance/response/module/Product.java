package com.lexiangkeji.bfinance.response.module;

public class Product {


    /**
     * id : 2
     * type : 2
     * title : 币果BTC增币7日期
     * subTitle : 7日
     * rateDes : +10%
     * rateSubDes : 预期年化收益率
     * ruleDes : 到期可取
     * ruleSubDes : 0.1 ETH起投
     */

    private String id;
    private int type;
    private String title;
    private String subTitle;
    private String rateDes;
    private String rateSubDes;
    private String ruleDes;
    private String ruleSubDes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getRateDes() {
        return rateDes;
    }

    public void setRateDes(String rateDes) {
        this.rateDes = rateDes;
    }

    public String getRateSubDes() {
        return rateSubDes;
    }

    public void setRateSubDes(String rateSubDes) {
        this.rateSubDes = rateSubDes;
    }

    public String getRuleDes() {
        return ruleDes;
    }

    public void setRuleDes(String ruleDes) {
        this.ruleDes = ruleDes;
    }

    public String getRuleSubDes() {
        return ruleSubDes;
    }

    public void setRuleSubDes(String ruleSubDes) {
        this.ruleSubDes = ruleSubDes;
    }
}

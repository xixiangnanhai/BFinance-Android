package com.lexiangkeji.bfinance.response;

import com.lexiangkeji.bfinance.response.module.Product;

import java.util.List;

public class HomeResulInforModel extends BaseBean {


    /**
     * data : {"bannerList":[{"imageUrl":"http://image.png","jumpUrl":"http://jump.html"},{"imageUrl":"http://image1.png","jumpUrl":"http://jump1.html"}],"productList":[{"id":"1","type":1,"title":"币果BTC增币活期","subTitle":"活期","rateDes":"+8%","rateSubDes":"预期年化收益率","ruleDes":"随存随取","ruleSubDes":"0.1 BTC起投"},{"id":"2","type":2,"title":"币果BTC增币7日期","subTitle":"7日","rateDes":"+10%","rateSubDes":"预期年化收益率","ruleDes":"到期可取","ruleSubDes":"0.1 ETH起投"}],"investInfo":{"amountDes":"2,725,568,865.28","populationDes":"43,985,582"}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bannerList : [{"imageUrl":"http://image.png","jumpUrl":"http://jump.html"},{"imageUrl":"http://image1.png","jumpUrl":"http://jump1.html"}]
         * productList : [{"id":"1","type":1,"title":"币果BTC增币活期","subTitle":"活期","rateDes":"+8%","rateSubDes":"预期年化收益率","ruleDes":"随存随取","ruleSubDes":"0.1 BTC起投"},{"id":"2","type":2,"title":"币果BTC增币7日期","subTitle":"7日","rateDes":"+10%","rateSubDes":"预期年化收益率","ruleDes":"到期可取","ruleSubDes":"0.1 ETH起投"}]
         * investInfo : {"amountDes":"2,725,568,865.28","populationDes":"43,985,582"}
         */

        private InvestInfoBean investInfo;
        private List<BannerListBean> bannerList;
        private List<Product> productList;

        public InvestInfoBean getInvestInfo() {
            return investInfo;
        }

        public void setInvestInfo(InvestInfoBean investInfo) {
            this.investInfo = investInfo;
        }

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }

        public List<Product> getProductList() {
            return productList;
        }

        public void setProductList(List<Product> productList) {
            this.productList = productList;
        }

        public static class InvestInfoBean {
            /**
             * amountDes : 2,725,568,865.28
             * populationDes : 43,985,582
             */

            private String amountDes;
            private String populationDes;

            public String getAmountDes() {
                return amountDes;
            }

            public void setAmountDes(String amountDes) {
                this.amountDes = amountDes;
            }

            public String getPopulationDes() {
                return populationDes;
            }

            public void setPopulationDes(String populationDes) {
                this.populationDes = populationDes;
            }
        }

        public static class BannerListBean {
            /**
             * imageUrl : http://image.png
             * jumpUrl : http://jump.html
             */

            private String imageUrl;
            private String jumpUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }
        }

        public static class ProductListBean {
            /**
             * id : 1
             * type : 1
             * title : 币果BTC增币活期
             * subTitle : 活期
             * rateDes : +8%
             * rateSubDes : 预期年化收益率
             * ruleDes : 随存随取
             * ruleSubDes : 0.1 BTC起投
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
    }
}

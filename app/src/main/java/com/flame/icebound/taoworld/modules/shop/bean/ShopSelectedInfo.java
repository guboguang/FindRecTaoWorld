package com.flame.icebound.taoworld.modules.shop.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 * 全球精选
 */
public class ShopSelectedInfo {


    private RstBean rst;


    private int timestamp;

    public RstBean getRst() {
        return rst;
    }

    public void setRst(RstBean rst) {
        this.rst = rst;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public static class RstBean {

        private PageInfoBean pageInfo;

        private List<BannerListBean> bannerList;

        private List<StockListBean> stockList;

        public PageInfoBean getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfoBean pageInfo) {
            this.pageInfo = pageInfo;
        }

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }

        public List<StockListBean> getStockList() {
            return stockList;
        }

        public void setStockList(List<StockListBean> stockList) {
            this.stockList = stockList;
        }

        public static class PageInfoBean {
            private boolean hasNext;
            private boolean hasPrev;
            private int num;
            private int page;

            public boolean isHasNext() {
                return hasNext;
            }

            public void setHasNext(boolean hasNext) {
                this.hasNext = hasNext;
            }

            public boolean isHasPrev() {
                return hasPrev;
            }

            public void setHasPrev(boolean hasPrev) {
                this.hasPrev = hasPrev;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }
        }

        public static class BannerListBean {
            private String commonId;
            private String image_path;
            private String pt;
            private String sort;
            private String url;

            public String getCommonId() {
                return commonId;
            }

            public void setCommonId(String commonId) {
                this.commonId = commonId;
            }

            public String getImage_path() {
                return image_path;
            }

            public void setImage_path(String image_path) {
                this.image_path = image_path;
            }

            public String getPt() {
                return pt;
            }

            public void setPt(String pt) {
                this.pt = pt;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class StockListBean {
            private String buyer_id;
            private String country_flag;
            private String country_name;
            private String id;
            private int liked;
            private String name;
            private String original_price;
            private String priceout;
            private int sold_amount;
            private List<String> imgs;

            public String getBuyer_id() {
                return buyer_id;
            }

            public void setBuyer_id(String buyer_id) {
                this.buyer_id = buyer_id;
            }

            public String getCountry_flag() {
                return country_flag;
            }

            public void setCountry_flag(String country_flag) {
                this.country_flag = country_flag;
            }

            public String getCountry_name() {
                return country_name;
            }

            public void setCountry_name(String country_name) {
                this.country_name = country_name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getLiked() {
                return liked;
            }

            public void setLiked(int liked) {
                this.liked = liked;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOriginal_price() {
                return original_price;
            }

            public void setOriginal_price(String original_price) {
                this.original_price = original_price;
            }

            public String getPriceout() {
                return priceout;
            }

            public void setPriceout(String priceout) {
                this.priceout = priceout;
            }

            public int getSold_amount() {
                return sold_amount;
            }

            public void setSold_amount(int sold_amount) {
                this.sold_amount = sold_amount;
            }

            public List<String> getImgs() {
                return imgs;
            }

            public void setImgs(List<String> imgs) {
                this.imgs = imgs;
            }
        }
    }
}

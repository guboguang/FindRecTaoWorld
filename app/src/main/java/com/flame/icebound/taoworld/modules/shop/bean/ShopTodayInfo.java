package com.flame.icebound.taoworld.modules.shop.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
public class ShopTodayInfo  {



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
        private int fileSecKillHit;
        private int redisContentHit;
        private int redisHit;


        private SearchInputBean searchInput;


        private SeckKillBean seckKill;

        private TRecommendBean tRecommend;
        /**
         * moreSecKill : 抢购预告
         * seckillingTitle : 抢购
         */

        private TitlesBean titles;
        /**
         * commonId : https://s29.mogucdn.com/h5/2921/2921.html?aid=2921&tid=23&topicid=86&ref=tsjbanner
         * image_path : /public_upload/operate/day_160729/20160729_17ff317.png
         * pt : url
         * sort : 8
         * url : https://s29.mogucdn.com/h5/2921/2921.html?aid=2921&tid=23&topicid=86&ref=tsjbanner
         */

        private List<BannerListBean> bannerList;


        private List<GroupBuyingBean> groupBuying;

        private List<TopicListBean> topicList;


        public int getFileSecKillHit() {
            return fileSecKillHit;
        }

        public void setFileSecKillHit(int fileSecKillHit) {
            this.fileSecKillHit = fileSecKillHit;
        }

        public int getRedisContentHit() {
            return redisContentHit;
        }

        public void setRedisContentHit(int redisContentHit) {
            this.redisContentHit = redisContentHit;
        }

        public int getRedisHit() {
            return redisHit;
        }

        public void setRedisHit(int redisHit) {
            this.redisHit = redisHit;
        }

        public SearchInputBean getSearchInput() {
            return searchInput;
        }

        public void setSearchInput(SearchInputBean searchInput) {
            this.searchInput = searchInput;
        }

        public SeckKillBean getSeckKill() {
            return seckKill;
        }

        public void setSeckKill(SeckKillBean seckKill) {
            this.seckKill = seckKill;
        }

        public TRecommendBean getTRecommend() {
            return tRecommend;
        }

        public void setTRecommend(TRecommendBean tRecommend) {
            this.tRecommend = tRecommend;
        }

        public TitlesBean getTitles() {
            return titles;
        }

        public void setTitles(TitlesBean titles) {
            this.titles = titles;
        }

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }




        public List<GroupBuyingBean> getGroupBuying() {
            return groupBuying;
        }

        public void setGroupBuying(List<GroupBuyingBean> groupBuying) {
            this.groupBuying = groupBuying;
        }





        public List<TopicListBean> getTopicList() {
            return topicList;
        }

        public void setTopicList(List<TopicListBean> topicList) {
            this.topicList = topicList;
        }

        public static class SearchInputBean {
            private String keyword;
            private String tip;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getTip() {
                return tip;
            }

            public void setTip(String tip) {
                this.tip = tip;
            }
        }

        public static class SeckKillBean {
            private String activityId;
            private String endTime;
            private String hour;
            private int leftTimeForEnd;
            private int leftTimeForStart;
            private int more;
            private String startTime;
            private int status;
            private String title;
            /**
             * activityId : 3169
             * buyerHead : /p1/160605/upload_ifrginrugy3gcm3ghazdambqmeyde_638x640.jpg_90x90.v1cNF.jpg
             * buyerId : 35605
             * buyerName : 流金花海
             * country : 中国香港
             * discount : 7.2折
             * discountNum : 7.2
             * final_order_value : 3400011
             * img : /p1/160728/upload_ifrggyztmi4tqnzqmezdambqmeyde_750x750.jpg_350x350.v1cNF.jpg
             * name : 【我的真爱】兰蔻真爱奇迹女士持久浓香水香氛50ml 花香辛辣调 持久淡雅清新香味
             * originPrice : 675
             * priceOut : 488
             * recommend_mark :
             * stockId : 880136
             * title : 7.2折
             * total : 20
             */

            private List<StockInfoBean> stockInfo;

            public String getActivityId() {
                return activityId;
            }

            public void setActivityId(String activityId) {
                this.activityId = activityId;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getHour() {
                return hour;
            }

            public void setHour(String hour) {
                this.hour = hour;
            }

            public int getLeftTimeForEnd() {
                return leftTimeForEnd;
            }

            public void setLeftTimeForEnd(int leftTimeForEnd) {
                this.leftTimeForEnd = leftTimeForEnd;
            }

            public int getLeftTimeForStart() {
                return leftTimeForStart;
            }

            public void setLeftTimeForStart(int leftTimeForStart) {
                this.leftTimeForStart = leftTimeForStart;
            }

            public int getMore() {
                return more;
            }

            public void setMore(int more) {
                this.more = more;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<StockInfoBean> getStockInfo() {
                return stockInfo;
            }

            public void setStockInfo(List<StockInfoBean> stockInfo) {
                this.stockInfo = stockInfo;
            }

            public static class StockInfoBean implements Serializable {
                private String activityId;
                private String buyerHead;
                private String buyerId;
                private String buyerName;
                private String country;
                private String discount;
                private String discountNum;
                private int final_order_value;
                private String img;
                private String name;
                private String originPrice;
                private String priceOut;
                private String recommend_mark;
                private String stockId;
                private String title;
                private int total;


                public String getActivityId() {
                    return activityId;
                }

                public void setActivityId(String activityId) {
                    this.activityId = activityId;
                }

                public String getBuyerHead() {
                    return buyerHead;
                }

                public void setBuyerHead(String buyerHead) {
                    this.buyerHead = buyerHead;
                }

                public String getBuyerId() {
                    return buyerId;
                }

                public void setBuyerId(String buyerId) {
                    this.buyerId = buyerId;
                }

                public String getBuyerName() {
                    return buyerName;
                }

                public void setBuyerName(String buyerName) {
                    this.buyerName = buyerName;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
                    this.discount = discount;
                }

                public String getDiscountNum() {
                    return discountNum;
                }

                public void setDiscountNum(String discountNum) {
                    this.discountNum = discountNum;
                }

                public int getFinal_order_value() {
                    return final_order_value;
                }

                public void setFinal_order_value(int final_order_value) {
                    this.final_order_value = final_order_value;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getOriginPrice() {
                    return originPrice;
                }

                public void setOriginPrice(String originPrice) {
                    this.originPrice = originPrice;
                }

                public String getPriceOut() {
                    return priceOut;
                }

                public void setPriceOut(String priceOut) {
                    this.priceOut = priceOut;
                }

                public String getRecommend_mark() {
                    return recommend_mark;
                }

                public void setRecommend_mark(String recommend_mark) {
                    this.recommend_mark = recommend_mark;
                }

                public String getStockId() {
                    return stockId;
                }

                public void setStockId(String stockId) {
                    this.stockId = stockId;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTotal() {
                    return total;
                }

                public void setTotal(int total) {
                    this.total = total;
                }

            }





        }

        public static class TRecommendBean {
            private String commonId;
            private String oneTitle;
            private String pt;
            private String sort;
            private String text_content;
            private String twoTitle;
            private String url;

            public String getCommonId() {
                return commonId;
            }

            public void setCommonId(String commonId) {
                this.commonId = commonId;
            }

            public String getOneTitle() {
                return oneTitle;
            }

            public void setOneTitle(String oneTitle) {
                this.oneTitle = oneTitle;
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

            public String getText_content() {
                return text_content;
            }

            public void setText_content(String text_content) {
                this.text_content = text_content;
            }

            public String getTwoTitle() {
                return twoTitle;
            }

            public void setTwoTitle(String twoTitle) {
                this.twoTitle = twoTitle;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TitlesBean {
            private String moreSecKill;
            private String seckillingTitle;

            public String getMoreSecKill() {
                return moreSecKill;
            }

            public void setMoreSecKill(String moreSecKill) {
                this.moreSecKill = moreSecKill;
            }

            public String getSeckillingTitle() {
                return seckillingTitle;
            }

            public void setSeckillingTitle(String seckillingTitle) {
                this.seckillingTitle = seckillingTitle;
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

        public static class GroupBuyingBean {
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

        public static class TopicListBean extends BaseItemInfo{
            private String articleTag;
            private String articleTagColor;
            private String img;
            private String title;
            private String url;

            /**
             * brand_name : rimowa
             * discountName : 6.5折
             * id : 183366
             * imgs : ["/public_upload/4/0/9/4097369352e9391afa591928085acf29_350x350.jpg","/public_upload/4/2/4/4240708b7ee4ad737ad45ce0f8dd5b1a_350x350.jpg","/public_upload/9/5/6/956a925d9397561614c2270ea90b9755_350x350.jpeg","/public_upload/5/e/7/5e78171c32b7c6d3bbfb85ec64ba4fec_350x350.jpeg","/public_upload/e/7/e/e7ea2daeab7dff32d482572701639fd3_350x350.jpeg","/public_upload/9/7/5/9754caf862015bba20d8bd41863277cc_350x350.jpeg","/public_upload/e/1/b/e1bac9f4d581e40acd21e7af7e2b8e5f_350x350.jpeg","/public_upload/f/4/1/f417f18f9caf762ec3ff18ae415e2712_350x350.jpeg"]
             * name : 德国原装Rimowa日默瓦Classic Fllight复古系列旅行托运箱26寸
             * original_price : 6980
             * priceout : 4550
             * priceout_unit : CNY
             */

            private List<StockInfoBean> stockInfo;

            public String getArticleTag() {
                return articleTag;
            }

            public void setArticleTag(String articleTag) {
                this.articleTag = articleTag;
            }

            public String getArticleTagColor() {
                return articleTagColor;
            }

            public void setArticleTagColor(String articleTagColor) {
                this.articleTagColor = articleTagColor;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<StockInfoBean> getStockInfo() {
                return stockInfo;
            }

            public void setStockInfo(List<StockInfoBean> stockInfo) {
                this.stockInfo = stockInfo;
            }

            public static class StockInfoBean {
                private String brand_name;
                private String discountName;
                private String id;
                private String name;
                private String original_price;
                private String priceout;
                private String priceout_unit;
                private List<String> imgs;

                public String getBrand_name() {
                    return brand_name;
                }

                public void setBrand_name(String brand_name) {
                    this.brand_name = brand_name;
                }

                public String getDiscountName() {
                    return discountName;
                }

                public void setDiscountName(String discountName) {
                    this.discountName = discountName;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
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

                public String getPriceout_unit() {
                    return priceout_unit;
                }

                public void setPriceout_unit(String priceout_unit) {
                    this.priceout_unit = priceout_unit;
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
}

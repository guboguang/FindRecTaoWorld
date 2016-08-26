package com.flame.icebound.taoworld.modules.home.bean;

import java.util.List;

/**
 * 首页热门话题分享信息模型类
 * Created by Administrator on 2016/7/30.
 */
public class ShareTopic {

    private RstBean rst;
    private int errno;
    private String err;
    private int timestamp;

    public RstBean getRst() {
        return rst;
    }

    public void setRst(RstBean rst) {
        this.rst = rst;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 内部成员类
     */

    public static class RstBean {
        private String shareIds;

        private PageInfoBean pageInfo;

        private List<ShareListBean> shareList;


        public String getShareIds() {
            return shareIds;
        }

        public void setShareIds(String shareIds) {
            this.shareIds = shareIds;
        }

        public PageInfoBean getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfoBean pageInfo) {
            this.pageInfo = pageInfo;
        }

        public List<ShareListBean> getShareList() {
            return shareList;
        }

        public void setShareList(List<ShareListBean> shareList) {
            this.shareList = shareList;
        }

        /**
         * RstBean的内部实体类，页面信息类
         */
        public static class PageInfoBean {

            private int page;
            private boolean hasNext;
            private boolean hasPrev;
            private int num;

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

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
        }

        /**
         * 分享列表的Item类
         */
        public static class ShareListBean {
            private int id;
            private int user_id;
            private String review_detail;
            private int create_time;
            private String redact_comment;
//            private Tag_infoBean tag_info;
            private String follow;
            private int is_office;
            private String user_name;
            private int is_follow;
            private String user_head;
            private String commentCount;
            private String position;
            private String tips;
            private List<String> imgs;
            private List<CommentBean> comment;
            private List<TagListBean> tagList;
            private List<ShareStockListBean> shareStockList;
            private List<ImgListBean> img_list;



            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getReview_detail() {
                return review_detail;
            }

            public void setReview_detail(String review_detail) {
                this.review_detail = review_detail;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public String getRedact_comment() {
                return redact_comment;
            }

            public void setRedact_comment(String redact_comment) {
                this.redact_comment = redact_comment;
            }

           /* public Tag_infoBean getTag_info() {
                return tag_info;
            }

            public void setTag_info(Tag_infoBean tag_info) {
                this.tag_info = tag_info;
            }*/

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public int getIs_office() {
                return is_office;
            }

            public void setIs_office(int is_office) {
                this.is_office = is_office;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public int getIs_follow() {
                return is_follow;
            }

            public void setIs_follow(int is_follow) {
                this.is_follow = is_follow;
            }

            public String getUser_head() {
                return user_head;
            }

            public void setUser_head(String user_head) {
                this.user_head = user_head;
            }

            public String getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(String commentCount) {
                this.commentCount = commentCount;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public List<String> getImgs() {
                return imgs;
            }

            public void setImgs(List<String> imgs) {
                this.imgs = imgs;
            }

            public List<CommentBean> getComment() {
                return comment;
            }

            public void setComment(List<CommentBean> comment) {
                this.comment = comment;
            }

            public List<TagListBean> getTagList() {
                return tagList;
            }

            public void setTagList(List<TagListBean> tagList) {
                this.tagList = tagList;
            }

            public List<ShareStockListBean> getShareStockList() {
                return shareStockList;
            }

            public void setShareStockList(List<ShareStockListBean> shareStockList) {
                this.shareStockList = shareStockList;
            }

            public List<ImgListBean> getImg_list() {
                return img_list;
            }

            public void setImg_list(List<ImgListBean> img_list) {
                this.img_list = img_list;
            }

            /**
             * 图片的标记信息实体类
             */
           /* public static class Tag_infoBean {
                private List<?> ifrgeodegvswcyrqmezdambqmeyde;
                *//**
                 * tagInfo : {"brand":{"tag_id":"13118","brand_id":"0","name":"优美的背景"},"price":"","location":{"tag_id":"2038","location_id":"1151","name":""},"category":{"tag_id":"1332","category_id":"0","name":" "}}
                 * position : {"x":0.2466667,"y":0.3532246}
                 * style : 13
                 *//*

                private List<IfqwcnlfgvswcyrqmezdambqgyydeBean> ifqwcnlfgvswcyrqmezdambqgyyde;
                *//**
                 * tagInfo : {"brand":{"tag_id":"13121","brand_id":"0","name":"旅行必背包不能少"},"price":"","location":{"tag_id":"2038","location_id":"1151","name":""},"category":{"tag_id":"1332","category_id":"0","name":" "}}
                 * position : {"x":0.3826667,"y":0.3626667}
                 * style : 14
                 *//*

                private List<IfrtcylfgvswcyrqmezdambqhaydeBean> ifrtcylfgvswcyrqmezdambqhayde;
                *//**
                 * tagInfo : {"brand":{"tag_id":"13122","brand_id":"0","name":"秀出你的好身材和bikini"},"price":"","location":{"tag_id":"2038","location_id":"1151","name":""},"category":{"tag_id":"1332","category_id":"0","name":" "}}
                 * position : {"x":0.1346666,"y":0.5857311}
                 * style : 13
                 *//*

                private List<IfrdmzlfgvswcyrqmezdambqmeydeBean> ifrdmzlfgvswcyrqmezdambqmeyde;
                *//**
                 * tagInfo : {"brand":{"tag_id":"13125","brand_id":"0","name":"时髦又实用的墨镜"},"price":"","location":{"tag_id":"2038","location_id":"1151","name":""},"category":{"tag_id":"1332","category_id":"0","name":" "}}
                 * position : {"x":0.6693333,"y":0.8586667}
                 * style : 14
                 *//*

                private List<Ie4tcndggvswcyrqmezdambqgqydeBean> ie4tcndggvswcyrqmezdambqgqyde;

                public List<?> getIfrgeodegvswcyrqmezdambqmeyde() {
                    return ifrgeodegvswcyrqmezdambqmeyde;
                }

                public void setIfrgeodegvswcyrqmezdambqmeyde(List<?> ifrgeodegvswcyrqmezdambqmeyde) {
                    this.ifrgeodegvswcyrqmezdambqmeyde = ifrgeodegvswcyrqmezdambqmeyde;
                }

                public List<IfqwcnlfgvswcyrqmezdambqgyydeBean> getIfqwcnlfgvswcyrqmezdambqgyyde() {
                    return ifqwcnlfgvswcyrqmezdambqgyyde;
                }

                public void setIfqwcnlfgvswcyrqmezdambqgyyde(List<IfqwcnlfgvswcyrqmezdambqgyydeBean> ifqwcnlfgvswcyrqmezdambqgyyde) {
                    this.ifqwcnlfgvswcyrqmezdambqgyyde = ifqwcnlfgvswcyrqmezdambqgyyde;
                }

                public List<IfrtcylfgvswcyrqmezdambqhaydeBean> getIfrtcylfgvswcyrqmezdambqhayde() {
                    return ifrtcylfgvswcyrqmezdambqhayde;
                }

                public void setIfrtcylfgvswcyrqmezdambqhayde(List<IfrtcylfgvswcyrqmezdambqhaydeBean> ifrtcylfgvswcyrqmezdambqhayde) {
                    this.ifrtcylfgvswcyrqmezdambqhayde = ifrtcylfgvswcyrqmezdambqhayde;
                }

                public List<IfrdmzlfgvswcyrqmezdambqmeydeBean> getIfrdmzlfgvswcyrqmezdambqmeyde() {
                    return ifrdmzlfgvswcyrqmezdambqmeyde;
                }

                public void setIfrdmzlfgvswcyrqmezdambqmeyde(List<IfrdmzlfgvswcyrqmezdambqmeydeBean> ifrdmzlfgvswcyrqmezdambqmeyde) {
                    this.ifrdmzlfgvswcyrqmezdambqmeyde = ifrdmzlfgvswcyrqmezdambqmeyde;
                }

                public List<Ie4tcndggvswcyrqmezdambqgqydeBean> getIe4tcndggvswcyrqmezdambqgqyde() {
                    return ie4tcndggvswcyrqmezdambqgqyde;
                }

                public void setIe4tcndggvswcyrqmezdambqgqyde(List<Ie4tcndggvswcyrqmezdambqgqydeBean> ie4tcndggvswcyrqmezdambqgqyde) {
                    this.ie4tcndggvswcyrqmezdambqgqyde = ie4tcndggvswcyrqmezdambqgqyde;
                }

                public static class IfqwcnlfgvswcyrqmezdambqgyydeBean {
                    *//**
                     * brand : {"tag_id":"13118","brand_id":"0","name":"优美的背景"}
                     * price :
                     * location : {"tag_id":"2038","location_id":"1151","name":""}
                     * category : {"tag_id":"1332","category_id":"0","name":" "}
                     *//*

                    private TagInfoBean tagInfo;
                    *//**
                     * x : 0.2466667
                     * y : 0.3532246
                     *//*

                    private PositionBean position;
                    private int style;

                    public TagInfoBean getTagInfo() {
                        return tagInfo;
                    }

                    public void setTagInfo(TagInfoBean tagInfo) {
                        this.tagInfo = tagInfo;
                    }

                    public PositionBean getPosition() {
                        return position;
                    }

                    public void setPosition(PositionBean position) {
                        this.position = position;
                    }

                    public int getStyle() {
                        return style;
                    }

                    public void setStyle(int style) {
                        this.style = style;
                    }

                    public static class TagInfoBean {
                        *//**
                         * tag_id : 13118
                         * brand_id : 0
                         * name : 优美的背景
                         *//*

                        private BrandBean brand;
                        private String price;
                        *//**
                         * tag_id : 2038
                         * location_id : 1151
                         * name :
                         *//*

                        private LocationBean location;
                        *//**
                         * tag_id : 1332
                         * category_id : 0
                         * name :
                         *//*

                        private CategoryBean category;

                        public BrandBean getBrand() {
                            return brand;
                        }

                        public void setBrand(BrandBean brand) {
                            this.brand = brand;
                        }

                        public String getPrice() {
                            return price;
                        }

                        public void setPrice(String price) {
                            this.price = price;
                        }

                        public LocationBean getLocation() {
                            return location;
                        }

                        public void setLocation(LocationBean location) {
                            this.location = location;
                        }

                        public CategoryBean getCategory() {
                            return category;
                        }

                        public void setCategory(CategoryBean category) {
                            this.category = category;
                        }

                        public static class BrandBean {
                            private String tag_id;
                            private String brand_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getBrand_id() {
                                return brand_id;
                            }

                            public void setBrand_id(String brand_id) {
                                this.brand_id = brand_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class LocationBean {
                            private String tag_id;
                            private String location_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getLocation_id() {
                                return location_id;
                            }

                            public void setLocation_id(String location_id) {
                                this.location_id = location_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class CategoryBean {
                            private String tag_id;
                            private String category_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getCategory_id() {
                                return category_id;
                            }

                            public void setCategory_id(String category_id) {
                                this.category_id = category_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }

                    public static class PositionBean {
                        private double x;
                        private double y;

                        public double getX() {
                            return x;
                        }

                        public void setX(double x) {
                            this.x = x;
                        }

                        public double getY() {
                            return y;
                        }

                        public void setY(double y) {
                            this.y = y;
                        }
                    }
                }

                public static class IfrtcylfgvswcyrqmezdambqhaydeBean {
                    *//**
                     * brand : {"tag_id":"13121","brand_id":"0","name":"旅行必背包不能少"}
                     * price :
                     * location : {"tag_id":"2038","location_id":"1151","name":""}
                     * category : {"tag_id":"1332","category_id":"0","name":" "}
                     *//*

                    private TagInfoBean tagInfo;
                    *//**
                     * x : 0.3826667
                     * y : 0.3626667
                     *//*

                    private PositionBean position;
                    private int style;

                    public TagInfoBean getTagInfo() {
                        return tagInfo;
                    }

                    public void setTagInfo(TagInfoBean tagInfo) {
                        this.tagInfo = tagInfo;
                    }

                    public PositionBean getPosition() {
                        return position;
                    }

                    public void setPosition(PositionBean position) {
                        this.position = position;
                    }

                    public int getStyle() {
                        return style;
                    }

                    public void setStyle(int style) {
                        this.style = style;
                    }

                    public static class TagInfoBean {
                        *//**
                         * tag_id : 13121
                         * brand_id : 0
                         * name : 旅行必背包不能少
                         *//*

                        private BrandBean brand;
                        private String price;
                        *//**
                         * tag_id : 2038
                         * location_id : 1151
                         * name :
                         *//*

                        private LocationBean location;
                        *//**
                         * tag_id : 1332
                         * category_id : 0
                         * name :
                         *//*

                        private CategoryBean category;

                        public BrandBean getBrand() {
                            return brand;
                        }

                        public void setBrand(BrandBean brand) {
                            this.brand = brand;
                        }

                        public String getPrice() {
                            return price;
                        }

                        public void setPrice(String price) {
                            this.price = price;
                        }

                        public LocationBean getLocation() {
                            return location;
                        }

                        public void setLocation(LocationBean location) {
                            this.location = location;
                        }

                        public CategoryBean getCategory() {
                            return category;
                        }

                        public void setCategory(CategoryBean category) {
                            this.category = category;
                        }

                        public static class BrandBean {
                            private String tag_id;
                            private String brand_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getBrand_id() {
                                return brand_id;
                            }

                            public void setBrand_id(String brand_id) {
                                this.brand_id = brand_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class LocationBean {
                            private String tag_id;
                            private String location_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getLocation_id() {
                                return location_id;
                            }

                            public void setLocation_id(String location_id) {
                                this.location_id = location_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class CategoryBean {
                            private String tag_id;
                            private String category_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getCategory_id() {
                                return category_id;
                            }

                            public void setCategory_id(String category_id) {
                                this.category_id = category_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }

                    public static class PositionBean {
                        private double x;
                        private double y;

                        public double getX() {
                            return x;
                        }

                        public void setX(double x) {
                            this.x = x;
                        }

                        public double getY() {
                            return y;
                        }

                        public void setY(double y) {
                            this.y = y;
                        }
                    }
                }

                public static class IfrdmzlfgvswcyrqmezdambqmeydeBean {
                    *//**
                     * brand : {"tag_id":"13122","brand_id":"0","name":"秀出你的好身材和bikini"}
                     * price :
                     * location : {"tag_id":"2038","location_id":"1151","name":""}
                     * category : {"tag_id":"1332","category_id":"0","name":" "}
                     *//*

                    private TagInfoBean tagInfo;
                    *//**
                     * x : 0.1346666
                     * y : 0.5857311
                     *//*

                    private PositionBean position;
                    private int style;

                    public TagInfoBean getTagInfo() {
                        return tagInfo;
                    }

                    public void setTagInfo(TagInfoBean tagInfo) {
                        this.tagInfo = tagInfo;
                    }

                    public PositionBean getPosition() {
                        return position;
                    }

                    public void setPosition(PositionBean position) {
                        this.position = position;
                    }

                    public int getStyle() {
                        return style;
                    }

                    public void setStyle(int style) {
                        this.style = style;
                    }

                    public static class TagInfoBean {
                        *//**
                         * tag_id : 13122
                         * brand_id : 0
                         * name : 秀出你的好身材和bikini
                         *//*

                        private BrandBean brand;
                        private String price;
                        *//**
                         * tag_id : 2038
                         * location_id : 1151
                         * name :
                         *//*

                        private LocationBean location;
                        *//**
                         * tag_id : 1332
                         * category_id : 0
                         * name :
                         *//*

                        private CategoryBean category;

                        public BrandBean getBrand() {
                            return brand;
                        }

                        public void setBrand(BrandBean brand) {
                            this.brand = brand;
                        }

                        public String getPrice() {
                            return price;
                        }

                        public void setPrice(String price) {
                            this.price = price;
                        }

                        public LocationBean getLocation() {
                            return location;
                        }

                        public void setLocation(LocationBean location) {
                            this.location = location;
                        }

                        public CategoryBean getCategory() {
                            return category;
                        }

                        public void setCategory(CategoryBean category) {
                            this.category = category;
                        }

                        public static class BrandBean {
                            private String tag_id;
                            private String brand_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getBrand_id() {
                                return brand_id;
                            }

                            public void setBrand_id(String brand_id) {
                                this.brand_id = brand_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class LocationBean {
                            private String tag_id;
                            private String location_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getLocation_id() {
                                return location_id;
                            }

                            public void setLocation_id(String location_id) {
                                this.location_id = location_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class CategoryBean {
                            private String tag_id;
                            private String category_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getCategory_id() {
                                return category_id;
                            }

                            public void setCategory_id(String category_id) {
                                this.category_id = category_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }

                    public static class PositionBean {
                        private double x;
                        private double y;

                        public double getX() {
                            return x;
                        }

                        public void setX(double x) {
                            this.x = x;
                        }

                        public double getY() {
                            return y;
                        }

                        public void setY(double y) {
                            this.y = y;
                        }
                    }
                }

                public static class Ie4tcndggvswcyrqmezdambqgqydeBean {
                    *//**
                     * brand : {"tag_id":"13125","brand_id":"0","name":"时髦又实用的墨镜"}
                     * price :
                     * location : {"tag_id":"2038","location_id":"1151","name":""}
                     * category : {"tag_id":"1332","category_id":"0","name":" "}
                     *//*

                    private TagInfoBean tagInfo;
                    *//**
                     * x : 0.6693333
                     * y : 0.8586667
                     *//*

                    private PositionBean position;
                    private int style;

                    public TagInfoBean getTagInfo() {
                        return tagInfo;
                    }

                    public void setTagInfo(TagInfoBean tagInfo) {
                        this.tagInfo = tagInfo;
                    }

                    public PositionBean getPosition() {
                        return position;
                    }

                    public void setPosition(PositionBean position) {
                        this.position = position;
                    }

                    public int getStyle() {
                        return style;
                    }

                    public void setStyle(int style) {
                        this.style = style;
                    }

                    public static class TagInfoBean {
                        *//**
                         * tag_id : 13125
                         * brand_id : 0
                         * name : 时髦又实用的墨镜
                         *//*

                        private BrandBean brand;
                        private String price;
                        *//**
                         * tag_id : 2038
                         * location_id : 1151
                         * name :
                         *//*

                        private LocationBean location;
                        *//**
                         * tag_id : 1332
                         * category_id : 0
                         * name :
                         *//*

                        private CategoryBean category;

                        public BrandBean getBrand() {
                            return brand;
                        }

                        public void setBrand(BrandBean brand) {
                            this.brand = brand;
                        }

                        public String getPrice() {
                            return price;
                        }

                        public void setPrice(String price) {
                            this.price = price;
                        }

                        public LocationBean getLocation() {
                            return location;
                        }

                        public void setLocation(LocationBean location) {
                            this.location = location;
                        }

                        public CategoryBean getCategory() {
                            return category;
                        }

                        public void setCategory(CategoryBean category) {
                            this.category = category;
                        }

                        public static class BrandBean {
                            private String tag_id;
                            private String brand_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getBrand_id() {
                                return brand_id;
                            }

                            public void setBrand_id(String brand_id) {
                                this.brand_id = brand_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class LocationBean {
                            private String tag_id;
                            private String location_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getLocation_id() {
                                return location_id;
                            }

                            public void setLocation_id(String location_id) {
                                this.location_id = location_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class CategoryBean {
                            private String tag_id;
                            private String category_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getCategory_id() {
                                return category_id;
                            }

                            public void setCategory_id(String category_id) {
                                this.category_id = category_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }

                    public static class PositionBean {
                        private double x;
                        private double y;

                        public double getX() {
                            return x;
                        }

                        public void setX(double x) {
                            this.x = x;
                        }

                        public double getY() {
                            return y;
                        }

                        public void setY(double y) {
                            this.y = y;
                        }
                    }
                }
            }*/

            public static class CommentBean {
                private String time;
                private String support;
                private String message;
                private String cid;
                private String user_id;
                private String id;
                private String userHead;
                private String userName;
                private String type;
                private String authorName;
                private String authorHead;
                private String authorid;

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getSupport() {
                    return support;
                }

                public void setSupport(String support) {
                    this.support = support;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public String getCid() {
                    return cid;
                }

                public void setCid(String cid) {
                    this.cid = cid;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUserHead() {
                    return userHead;
                }

                public void setUserHead(String userHead) {
                    this.userHead = userHead;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getAuthorName() {
                    return authorName;
                }

                public void setAuthorName(String authorName) {
                    this.authorName = authorName;
                }

                public String getAuthorHead() {
                    return authorHead;
                }

                public void setAuthorHead(String authorHead) {
                    this.authorHead = authorHead;
                }

                public String getAuthorid() {
                    return authorid;
                }

                public void setAuthorid(String authorid) {
                    this.authorid = authorid;
                }
            }

            public static class TagListBean {
                private int id;
                private String tag_name;
                private String url;
                private int type;
                private String jump_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getJump_url() {
                    return jump_url;
                }

                public void setJump_url(String jump_url) {
                    this.jump_url = jump_url;
                }
            }

            public static class ShareStockListBean {
                private int id;
                private int share_id;
                private int stock_id;
                private int buyer_id;
                private int user_id;
                private int create_time;
                private int is_delete;
                private int update_time;
                /**
                 * id : 843887
                 * name : Sandro 16春夏 个性涂鸦印花短裤 PURDAY
                 * priceout_unit : CNY
                 * priceout : 820.00
                 * img : /public_upload/4/3/7/4379408f1f362d81ac09933d7a408dfa.jpeg
                 * create_time : 1465266403
                 */

                private StockInfoBean stockInfo;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getShare_id() {
                    return share_id;
                }

                public void setShare_id(int share_id) {
                    this.share_id = share_id;
                }

                public int getStock_id() {
                    return stock_id;
                }

                public void setStock_id(int stock_id) {
                    this.stock_id = stock_id;
                }

                public int getBuyer_id() {
                    return buyer_id;
                }

                public void setBuyer_id(int buyer_id) {
                    this.buyer_id = buyer_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public int getIs_delete() {
                    return is_delete;
                }

                public void setIs_delete(int is_delete) {
                    this.is_delete = is_delete;
                }

                public int getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(int update_time) {
                    this.update_time = update_time;
                }

                public StockInfoBean getStockInfo() {
                    return stockInfo;
                }

                public void setStockInfo(StockInfoBean stockInfo) {
                    this.stockInfo = stockInfo;
                }

                public static class StockInfoBean {
                    private String id;
                    private String name;
                    private String priceout_unit;
                    private String priceout;
                    private String img;
                    private int create_time;

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

                    public String getPriceout_unit() {
                        return priceout_unit;
                    }

                    public void setPriceout_unit(String priceout_unit) {
                        this.priceout_unit = priceout_unit;
                    }

                    public String getPriceout() {
                        return priceout;
                    }

                    public void setPriceout(String priceout) {
                        this.priceout = priceout;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public int getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(int create_time) {
                        this.create_time = create_time;
                    }
                }
            }


            public static class ImgListBean {
                private String img;
                private String tagKey;
                private List<TagBean> tag;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getTagKey() {
                    return tagKey;
                }

                public void setTagKey(String tagKey) {
                    this.tagKey = tagKey;
                }

                public List<TagBean> getTag() {
                    return tag;
                }

                public void setTag(List<TagBean> tag) {
                    this.tag = tag;
                }




                public static class TagBean {


                    /**
                     * brand : {"tag_id":"13118","brand_id":"0","name":"优美的背景"}
                     * price :
                     * location : {"tag_id":"2038","location_id":"1151","name":""}
                     * category : {"tag_id":"1332","category_id":"0","name":" "}
                     */

                    private TagInfoBean tagInfo;
                    /**
                     * x : 0.2466667
                     * y : 0.3532246
                     */

                    private PositionBean position;


                    private int style;

                    public TagInfoBean getTagInfo() {
                        return tagInfo;
                    }

                    public void setTagInfo(TagInfoBean tagInfo) {
                        this.tagInfo = tagInfo;
                    }

                    public PositionBean getPosition() {
                        return position;
                    }

                    public void setPosition(PositionBean position) {
                        this.position = position;
                    }

                    public int getStyle() {
                        return style;
                    }

                    public void setStyle(int style) {
                        this.style = style;
                    }

                    public static class TagInfoBean {
                        /**
                         * tag_id : 13118
                         * brand_id : 0
                         * name : 优美的背景
                         */

                        private BrandBean brand;
                        private String price;
                        /**
                         * tag_id : 2038
                         * location_id : 1151
                         * name :
                         */

                        private LocationBean location;
                        /**
                         * tag_id : 1332
                         * category_id : 0
                         * name :
                         */

                        private CategoryBean category;

                        public BrandBean getBrand() {
                            return brand;
                        }

                        public void setBrand(BrandBean brand) {
                            this.brand = brand;
                        }

                        public String getPrice() {
                            return price;
                        }

                        public void setPrice(String price) {
                            this.price = price;
                        }

                        public LocationBean getLocation() {
                            return location;
                        }

                        public void setLocation(LocationBean location) {
                            this.location = location;
                        }

                        public CategoryBean getCategory() {
                            return category;
                        }

                        public void setCategory(CategoryBean category) {
                            this.category = category;
                        }

                        public static class BrandBean {
                            private String tag_id;
                            private String brand_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getBrand_id() {
                                return brand_id;
                            }

                            public void setBrand_id(String brand_id) {
                                this.brand_id = brand_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class LocationBean {
                            private String tag_id;
                            private String location_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getLocation_id() {
                                return location_id;
                            }

                            public void setLocation_id(String location_id) {
                                this.location_id = location_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }

                        public static class CategoryBean {
                            private String tag_id;
                            private String category_id;
                            private String name;

                            public String getTag_id() {
                                return tag_id;
                            }

                            public void setTag_id(String tag_id) {
                                this.tag_id = tag_id;
                            }

                            public String getCategory_id() {
                                return category_id;
                            }

                            public void setCategory_id(String category_id) {
                                this.category_id = category_id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }

                    public static class PositionBean {
                        private double x;
                        private double y;

                        public double getX() {
                            return x;
                        }

                        public void setX(double x) {
                            this.x = x;
                        }

                        public double getY() {
                            return y;
                        }

                        public void setY(double y) {
                            this.y = y;
                        }
                    }
                }
            }
        }
    }
}

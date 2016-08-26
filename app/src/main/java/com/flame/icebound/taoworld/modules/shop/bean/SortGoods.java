package com.flame.icebound.taoworld.modules.shop.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public class SortGoods {


    /**
     * rst : [{"sort":0,"oneTitle":"焕新妆","twoTitle":"美妆 个护","commonId":0,"category":null,"url":"http://m.taoshij.com/pages/app/customer/sub-category.html?version=2&title=%E7%84%95%E6%96%B0%E5%A6%86&categoryId=10056018&dataId=12856","img":"/p2/160802/19o_680e02igk43fj8hej8cgk819g70lb_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_680e02igk43fj8hej8cgk819g70lb_150x150.jpg","text_content":"美妆 个护"},{"sort":0,"oneTitle":"包包控","twoTitle":"大牌 折扣","commonId":0,"category":null,"url":"amcustomerurl://categorystocklist?super_category_id=10056019&category_id=10056019&title=%E5%8C%85%E5%8C%85%E6%8E%A7","img":"/p2/160802/19o_7eea0d56kffb7j2i619ci06h61881_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_7eea0d56kffb7j2i619ci06h61881_150x150.jpg","text_content":"大牌 折扣"},{"sort":0,"oneTitle":"女鞋","twoTitle":"舒适 完美","commonId":0,"category":null,"url":"amcustomerurl://categorystocklist?super_category_id=10058861&category_id=10058861&title=%E5%A5%B3%E9%9E%8B","img":"/p2/160802/19o_7j540ia257c3h1a7b89735h5kih3h_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_7j540ia257c3h1a7b89735h5kih3h_150x150.jpg","text_content":"舒适 完美"},{"sort":0,"oneTitle":"配饰","twoTitle":"个性 百搭","commonId":0,"category":null,"url":"amcustomerurl://categorystocklist?super_category_id=10058860&category_id=10058860&title=%E9%85%8D%E9%A5%B0","img":"/p2/160802/19o_7jgg6dkf8e27c3gi900glkgc77k8a_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_7jgg6dkf8e27c3gi900glkgc77k8a_150x150.jpg","text_content":"个性 百搭"},{"sort":0,"oneTitle":"面膜","twoTitle":"热销 必备","commonId":0,"category":null,"url":"amcustomerurl://categorystocklist?super_category_id=10056030&category_id=10056030&title=%E9%9D%A2%E8%86%9C","img":"/p2/160802/19o_3a1a56hkkifal0gd296262g0ef8h0_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_3a1a56hkkifal0gd296262g0ef8h0_150x150.jpg","text_content":"热销 必备"},{"sort":0,"oneTitle":"潮穿搭","twoTitle":"出街 最in","commonId":0,"category":null,"url":"amcustomerurl://categorystocklist?super_category_id=10055970&category_id=10055970&title=%E6%BD%AE%E7%A9%BF%E6%90%AD","img":"/p2/160802/19o_11afbdadkli30d620bd8ehh698ck6_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_11afbdadkli30d620bd8ehh698ck6_150x150.jpg","text_content":"出街 最in"},{"sort":0,"oneTitle":"男士","twoTitle":"潮品 鞋子","commonId":0,"category":null,"url":"amcustomerurl://categorystocklist?super_category_id=10058859&category_id=10058859&title=%E7%94%B7%E5%A3%AB","img":"/p2/160802/19o_4a2ehhdb9c412c4532d67bdec9b04_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_4a2ehhdb9c412c4532d67bdec9b04_150x150.jpg","text_content":"潮品 鞋子"},{"sort":0,"oneTitle":"吃吃吃","twoTitle":"健康 食品","commonId":0,"category":null,"url":"amcustomerurl://categorystocklist?super_category_id=10056029&category_id=10056029&title=%E5%90%83%E5%90%83%E5%90%83","img":"/p2/160802/19o_6f38i0gj9e8eb8d5clk0l66jdgh50_150x150.jpg","categoryId":0,"superId":null,"pt":null,"image_path":"/p2/160802/19o_6f38i0gj9e8eb8d5clk0l66jdgh50_150x150.jpg","text_content":"健康 食品"}]
     * errno : 0
     * err : 成功
     * timestamp : 1470188571
     */

    private int errno;
    private String err;
    private int timestamp;


    private List<RstBean> rst;

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

    public List<RstBean> getRst() {
        return rst;
    }

    public void setRst(List<RstBean> rst) {
        this.rst = rst;
    }

    public static class RstBean {
        private int sort;
        private String oneTitle;
        private String twoTitle;
        private int commonId;
        private Object category;
        private String url;
        private String img;
        private int categoryId;
        private Object superId;
        private Object pt;
        private String image_path;
        private String text_content;

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getOneTitle() {
            return oneTitle;
        }

        public void setOneTitle(String oneTitle) {
            this.oneTitle = oneTitle;
        }

        public String getTwoTitle() {
            return twoTitle;
        }

        public void setTwoTitle(String twoTitle) {
            this.twoTitle = twoTitle;
        }

        public int getCommonId() {
            return commonId;
        }

        public void setCommonId(int commonId) {
            this.commonId = commonId;
        }

        public Object getCategory() {
            return category;
        }

        public void setCategory(Object category) {
            this.category = category;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public Object getSuperId() {
            return superId;
        }

        public void setSuperId(Object superId) {
            this.superId = superId;
        }

        public Object getPt() {
            return pt;
        }

        public void setPt(Object pt) {
            this.pt = pt;
        }

        public String getImage_path() {
            return image_path;
        }

        public void setImage_path(String image_path) {
            this.image_path = image_path;
        }

        public String getText_content() {
            return text_content;
        }

        public void setText_content(String text_content) {
            this.text_content = text_content;
        }
    }
}

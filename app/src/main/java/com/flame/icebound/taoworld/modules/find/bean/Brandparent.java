package com.flame.icebound.taoworld.modules.find.bean;

import java.util.List;

/**
 *品质生活
 * Created by hasee on 2016/7/30.
 */
public class Brandparent extends BaseInfo {

    private List<BrandInfo> list;

    public List<BrandInfo> getList() {
        return list;
    }

    public void setList(List<BrandInfo> list) {
        this.list = list;
    }

    /**
     * image_path : /public_upload/operate/day_160719/20160719_e9dfb6c.jpg
     * text_content : NIKE
     * sort : 0
     * oneTitle : NIKE
     * twoTitle :
     * commonId : 532
     * url : AMCustomerURL://sharelistcollection?id=532&title=nike&type=2
     * followCount : 6677
     * shareCount : 113
     * pt : userTag
     */

    public static class BrandInfo {

        private String image_path;
        private String text_content;
        private String sort;
        private String oneTitle;
        private String twoTitle;
        private String url;
        private String followCount;
        private String shareCount;
        private String pt;
        private String commonId;
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

        public String getText_content() {
            return text_content;
        }

        public void setText_content(String text_content) {
            this.text_content = text_content;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFollowCount() {
            return followCount;
        }

        public void setFollowCount(String followCount) {
            this.followCount = followCount;
        }

        public String getShareCount() {
            return shareCount;
        }

        public void setShareCount(String shareCount) {
            this.shareCount = shareCount;
        }

        public String getPt() {
            return pt;
        }

        public void setPt(String pt) {
            this.pt = pt;
        }
    }

}

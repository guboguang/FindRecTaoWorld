package com.flame.icebound.taoworld.modules.find.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.List;

/**
 * viewPager图片对象
 * Created by hasee on 2016/8/2.
 */
public class Banners extends BaseInfo  {

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    /**
     * banners : [{"commonId":"https://s29.mogucdn.com/h5/2952/2952.html?aid=2952&tid=24&topicid=49","image_path":"/public_upload/operate/day_160802/20160802_8f55e5f.jpg","img":"/public_upload/operate/day_160802/20160802_8f55e5f.jpg","jump_url":"https://s29.mogucdn.com/h5/2952/2952.html?aid=2952&tid=24&topicid=49","pt":"url","sort":"8","text_content":"","url":"https://s29.mogucdn.com/h5/2952/2952.html?aid=2952&tid=24&topicid=49"},{"commonId":"http://act.taoshij.com/meiriyice","image_path":"/public_upload/operate/day_160726/20160726_088a6a0.jpg","img":"/public_upload/operate/day_160726/20160726_088a6a0.jpg","jump_url":"http://act.taoshij.com/meiriyice","pt":"url","sort":"7","text_content":"","url":"http://act.taoshij.com/meiriyice"},{"commonId":"https://s29.mogucdn.com/h5/2911/2911.html?aid=2911&tid=21&topicid=49","image_path":"/public_upload/operate/day_160730/20160730_9d86304.png","img":"/public_upload/operate/day_160730/20160730_9d86304.png","jump_url":"https://s29.mogucdn.com/h5/2911/2911.html?aid=2911&tid=21&topicid=49","pt":"url","sort":"6","text_content":"","url":"https://s29.mogucdn.com/h5/2911/2911.html?aid=2911&tid=21&topicid=49"},{"commonId":"https://s29.mogucdn.com/h5/2938/2938.html?aid=2938&tid=24&topicid=49","image_path":"/public_upload/operate/day_160801/20160801_edfe111.jpg","img":"/public_upload/operate/day_160801/20160801_edfe111.jpg","jump_url":"https://s29.mogucdn.com/h5/2938/2938.html?aid=2938&tid=24&topicid=49","pt":"url","sort":"5","text_content":"","url":"https://s29.mogucdn.com/h5/2938/2938.html?aid=2938&tid=24&topicid=49"},{"commonId":"https://s29.mogucdn.com/h5/2936/2936.html?aid=2936&tid=24&topicid=49","image_path":"/public_upload/operate/day_160802/20160802_ba4b080.jpg","img":"/public_upload/operate/day_160802/20160802_ba4b080.jpg","jump_url":"https://s29.mogucdn.com/h5/2936/2936.html?aid=2936&tid=24&topicid=49","pt":"url","sort":"4","text_content":"","url":"https://s29.mogucdn.com/h5/2936/2936.html?aid=2936&tid=24&topicid=49"},{"commonId":"https://s29.mogucdn.com/h5/2900/2900.html?aid=2900&tid=24&topicid=49","image_path":"/public_upload/operate/day_160727/20160727_acbd2ea.jpg","img":"/public_upload/operate/day_160727/20160727_acbd2ea.jpg","jump_url":"https://s29.mogucdn.com/h5/2900/2900.html?aid=2900&tid=24&topicid=49","pt":"url","sort":"3","text_content":"","url":"https://s29.mogucdn.com/h5/2900/2900.html?aid=2900&tid=24&topicid=49"},{"commonId":"https://s29.mogucdn.com/h5/2892/2892.html?aid=2892&tid=24&topicid=49","image_path":"/public_upload/operate/day_160727/20160727_18f652e.jpg","img":"/public_upload/operate/day_160727/20160727_18f652e.jpg","jump_url":"https://s29.mogucdn.com/h5/2892/2892.html?aid=2892&tid=24&topicid=49","pt":"url","sort":"2","text_content":"","url":"https://s29.mogucdn.com/h5/2892/2892.html?aid=2892&tid=24&topicid=49"}]
     * hotBrand : [{"commonId":"274","followCount":"6581","image_path":"/public_upload/operate/day_160802/20160802_b2835f1.jpg","oneTitle":"YSL","pt":"userTag","shareCount":"319","sort":"0","text_content":"YSL","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=274&title=ysl&type=2"},{"commonId":"1095","followCount":"4798","image_path":"/public_upload/operate/day_160802/20160802_ccc328d.jpg","oneTitle":"TORY BURCH","pt":"userTag","shareCount":"89","sort":"0","text_content":"TORY BURCH","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=1095&title=tory burch&type=2"},{"commonId":"288","followCount":"8438","image_path":"/public_upload/operate/day_160802/20160802_905d2f5.jpg","oneTitle":"DIOR","pt":"userTag","shareCount":"431","sort":"0","text_content":"DIOR","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=288&title=dior&type=2"},{"commonId":"2178","followCount":"6041","image_path":"/public_upload/operate/day_160802/20160802_2b48953.jpg","oneTitle":"MOSCHINO","pt":"userTag","shareCount":"86","sort":"0","text_content":"MOSCHINO","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=2178&title=moschino&type=2"}]
     * hotCategory : [{"commonId":"103","followCount":"34","image_path":"/public_upload/operate/day_160621/20160621_539c89f.jpg","oneTitle":"口红","pt":"userTag","shareCount":"1116","sort":"3","text_content":"口红","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=103&title=唇部彩妆&type=3"},{"commonId":"3","followCount":"98","image_path":"/public_upload/operate/day_160623/20160623_12501dc.jpg","oneTitle":"口碑面膜","pt":"userTag","shareCount":"1844","sort":"2","text_content":"口碑面膜","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=3&title=面膜&type=3"},{"commonId":"679","followCount":"5","image_path":"/public_upload/operate/day_160623/20160623_4429e47.jpg","oneTitle":"戒指","pt":"userTag","shareCount":"70","sort":"1","text_content":"戒指","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=679&title=戒指&type=3"}]
     * hotFourCategory : [{"commonId":"566","followCount":"0","image_path":"/public_upload/operate/day_160802/20160802_e0a8332.jpg","oneTitle":"香氛","pt":"userTag","shareCount":"380","sort":"4","text_content":"香氛","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=566&title=香氛&type=3"},{"commonId":"103","followCount":"34","image_path":"/public_upload/operate/day_160802/20160802_a5f5c75.jpg","oneTitle":"唇妆","pt":"userTag","shareCount":"1116","sort":"3","text_content":"唇妆","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=103&title=唇部彩妆&type=3"},{"commonId":"304","followCount":"100","image_path":"/public_upload/operate/day_160802/20160802_558091e.jpg","oneTitle":"包袋","pt":"userTag","shareCount":"313","sort":"2","text_content":"包袋","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=304&title=手提包&type=3"},{"commonId":"248","followCount":"5","image_path":"/public_upload/operate/day_160802/20160802_e6aa43a.jpg","oneTitle":"墨镜","pt":"userTag","shareCount":"226","sort":"1","text_content":"墨镜","twoTitle":"","url":"AMCustomerURL://sharelistcollection?id=248&title=眼镜&type=3"}]
     * titles : {"hotBrand":"品牌热度","hotCategory":"品质生活"}
     */
        private List<BannersBean> banners;


        @Table(name = "BannersBean")
        public static class BannersBean {
            @Column(name = "commonId", isId = true)
            private String commonId;
            @Column(name = "image_path")
            private String image_path;
            @Column(name = "img")
            private String img;
            @Column(name = "jump_url")
            private String jump_url;
            private String pt;
            private String sort;
            @Column(name = "text_content")
            private String text_content;
            @Column(name = "url")
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJump_url() {
                return jump_url;
            }

            public void setJump_url(String jump_url) {
                this.jump_url = jump_url;
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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }



}

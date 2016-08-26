package com.flame.icebound.taoworld.modules.shop.bean;

/**
 * Created by Administrator on 2016/8/3.
 */
public class SortItemInfo extends BaseItemInfo {

    private ShopTodayInfo.RstBean.GroupBuyingBean groupBuyingBean;
    private SortGoods sortGoods;

    public ShopTodayInfo.RstBean.GroupBuyingBean getGroupBuyingBean() {
        return groupBuyingBean;
    }

    public void setGroupBuyingBean(ShopTodayInfo.RstBean.GroupBuyingBean groupBuyingBean) {
        this.groupBuyingBean = groupBuyingBean;
    }

    public SortGoods getSortGoods() {
        return sortGoods;
    }

    public void setSortGoods(SortGoods sortGoods) {
        this.sortGoods = sortGoods;
    }
}

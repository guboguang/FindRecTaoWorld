package com.flame.icebound.taoworld.modules.shop.bean;

/**
 * Created by Administrator on 2016/7/30.
 */
public class DoubleGoodsInfo extends BaseItemInfo {

    private ShopSelectedInfo.RstBean.StockListBean leftStockListBean;
    private ShopSelectedInfo.RstBean.StockListBean rigthStockListBean;

    public ShopSelectedInfo.RstBean.StockListBean getLeftStockListBean() {
        return leftStockListBean;
    }

    public void setLeftStockListBean(ShopSelectedInfo.RstBean.StockListBean leftStockListBean) {
        this.leftStockListBean = leftStockListBean;
    }

    public ShopSelectedInfo.RstBean.StockListBean getRigthStockListBean() {
        return rigthStockListBean;
    }

    public void setRigthStockListBean(ShopSelectedInfo.RstBean.StockListBean rigthStockListBean) {
        this.rigthStockListBean = rigthStockListBean;
    }
}

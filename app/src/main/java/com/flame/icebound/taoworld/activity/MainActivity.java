package com.flame.icebound.taoworld.activity;

import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.modules.find.activity.RecyclerViewFragment;
import com.flame.icebound.taoworld.modules.home.activity.HomeFragment;
import com.flame.icebound.taoworld.modules.me.activity.MeFragment;
import com.flame.icebound.taoworld.modules.message.activity.MessageFragment;
import com.flame.icebound.taoworld.modules.shop.activity.ShopFragment;
import com.flame.icebound.taoworld.widget.ButtonMenu;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private long lastT;
    private ButtonMenu bmHome,bmFind,bmShop,bmMe,bmMessage;
    private HomeFragment homeFragment;
    private ShopFragment shopFragment;
    private MeFragment meFragment;
    private RecyclerViewFragment findFragment;
    private MessageFragment messageFragment;
    private ButtonMenu lastSelectedMenu;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        bmHome = (ButtonMenu) findViewById(R.id.bm_home);
        bmFind = (ButtonMenu) findViewById(R.id.bm_find);
        bmShop = (ButtonMenu) findViewById(R.id.bm_shop);
        bmMessage = (ButtonMenu) findViewById(R.id.bm_message);
        bmMe = (ButtonMenu) findViewById(R.id.bm_mine);

    }

    @Override
    protected void initEvent() {
        bmHome.setOnClickListener(this);
        bmFind.setOnClickListener(this);
        bmShop.setOnClickListener(this);
        bmMe.setOnClickListener(this);
        bmMessage.setOnClickListener(this);
    }

    @Override
    protected void init() {

        //创建frament对象
        homeFragment = new HomeFragment();
        findFragment = new RecyclerViewFragment();
        shopFragment = new ShopFragment();
        messageFragment = new MessageFragment();

        meFragment = new MeFragment();


        bmHome.setFragment(homeFragment);
        bmFind.setFragment(findFragment);
        bmShop.setFragment(shopFragment);
        bmMessage.setFragment(messageFragment);
        bmMe.setFragment(meFragment);


        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.add(R.id.ll_fragment_container, homeFragment);
        transaction.add(R.id.ll_fragment_container, findFragment);
        transaction.add(R.id.ll_fragment_container, shopFragment);
        transaction.add(R.id.ll_fragment_container, messageFragment);
        transaction.add(R.id.ll_fragment_container, meFragment);

        transaction.hide(findFragment);
        transaction.hide(shopFragment);
        transaction.hide(messageFragment);
        transaction.hide(meFragment);

        transaction.commit();
        bmHome.performClick();//模拟点击控件
    }

    @Override
    protected void loadData() {

    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        ButtonMenu bm = (ButtonMenu) v;

        if (lastSelectedMenu == bm) {
            return;
        }

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        bm.selectMenu();
        if (lastSelectedMenu != null) {
            lastSelectedMenu.unSelectMenu();
            transaction.hide(lastSelectedMenu.getFragment());
        }
        transaction.show(bm.getFragment());
        transaction.commit();
        lastSelectedMenu = bm;
        getApplication();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long currenT = System.currentTimeMillis();
        if ((currenT - lastT) < 2000) {
            finish();
        } else {
            lastT = currenT;
            Toast.makeText(MainActivity.this, "再次点击退出应用", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.flame.icebound.taoworld.modules.shop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.widget.TitleBar;

import cn.sharesdk.framework.ShareSDK;
import sharesdk.onekeyshare.themes.OnekeyShare;

public class BannerActivity extends AppCompatActivity {

    private ProgressBar shopProgressBar;
    private WebView shopWebBanner;
    private View line;
    private TitleBar shopBannerTitle;
    private int sreenWith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        shopBannerTitle = (TitleBar) findViewById(R.id.shop_banner_title);
        line = findViewById(R.id.shop_banner_line);
        shopWebBanner = (WebView) findViewById(R.id.shop_webview_banner);
        shopProgressBar = (ProgressBar) findViewById(R.id.shop_banner_progressBar);

        shopBannerTitle.getTvTitle().setTextSize(15);
        shopBannerTitle.getTvTitle().setText("请稍后。。。。。");

        //初始化titlebar
        shopBannerTitle.setIvLeft(R.mipmap.weibosdk_navigationbar_back);
        shopBannerTitle.setIvRight(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);



        //接收传递过来的网址
        Intent intent = getIntent();
        String url=intent.getStringExtra("url");
        //对webview设置
        shopWebBanner.getSettings().setJavaScriptEnabled(true);
        //获得1屏幕宽度
        sreenWith = getResources().getDisplayMetrics().widthPixels;


        shopWebBanner.setWebViewClient(new WebViewClient(){

            //该方法必须重写,并且要加入view.loadUrl(url)代码段,返回值为true
            //这样系统就不会打开内置浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }

            //开始加载1
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                //进度条显示
                shopProgressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            //加载完成
            @Override
            public void onPageFinished(WebView view, String url) {
                shopProgressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }


            //加载失败调用
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                shopProgressBar.setVisibility(View.GONE);
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });

        //获取加载进度，和网址标题
        shopWebBanner.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                setLine(newProgress*1.0f/100);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {

                shopBannerTitle.getTvTitle().setText(title);
            }
        });
        //启动webview加载网页
        shopWebBanner.loadUrl(url);

        shopBannerTitle.getIvLeft().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //点击分享
        shopBannerTitle.getIvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });


    }

    //线性进度条改变
    public void setLine(float progress){
        ViewGroup.LayoutParams layoutParams = line.getLayoutParams();
        layoutParams.width= (int) (progress*sreenWith);
        line.setLayoutParams(layoutParams);
    }

    //返回时结束网页返回
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(shopWebBanner.canGoBack()){
                shopWebBanner.goBack();
            }
            else{
                finish();
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    //点击分享
    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.ssdk_googleplus));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }



}

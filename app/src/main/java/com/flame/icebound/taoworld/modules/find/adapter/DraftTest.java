package com.flame.icebound.taoworld.modules.find.adapter;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flame.icebound.taoworld.R;

/**
 * Created by hasee on 2016/8/8.
 */
public class DraftTest extends AppCompatActivity{

    private int endY;
    private int endX;
    private Button b;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_draft_test);
            DisplayMetrics dm=getResources().getDisplayMetrics();
            final int screenWidth=dm.widthPixels;
            final int screenHeight=dm.heightPixels-50;

        b = (Button)findViewById(R.id.btn);

                assert b != null;
                assert b != null;
                b.setOnTouchListener(new View.OnTouchListener(){

                private int dx;
                int lastX,lastY;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // TODO Auto-generated method stub
                    int ea=event.getAction();
                    Log.i("TAG", "Touch:"+ea);
                    switch(ea){
                        case MotionEvent.ACTION_DOWN:
                            //b.setScaleX();
                            final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(b,"scaleX",0.7f,1.0f);
                            objectAnimator.setDuration(2000);
                            objectAnimator.start();

                            objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator animation) {
                                    float progress = (float) objectAnimator.getAnimatedValue();
                                }
                            });
                            endX = (int) event.getRawX();
                            endY = (int) event.getRawY();


                            Log.e("find", "=====ACTION_DOWN====event.getX()===333========="+event.getX());
                            Log.e("find", "=====ACTION_DOWN====event.getY()===333========="+event.getY());

                            lastX=(int)event.getRawX();//获取触摸事件触摸位置的原始X坐标
                            lastY=(int)event.getRawY();
                            break;

                        case MotionEvent.ACTION_MOVE:

                            //值越大表示移动的距离越远
                            dx = (int)event.getRawX()-lastX;
                            int dy=(int)event.getRawY()-lastY;

                            //控件的长度加上移动的距离
                            int l=v.getLeft()+ dx;

                            int b=v.getBottom()+dy;
                            int r=v.getRight()+ dx;
                            int t=v.getTop()+dy;


                            //下面判断移动是否超出屏幕
                            if(l<0){
                                l=0;
                                r=l+v.getWidth();
                            }

                            if(t<0){
                                t=0;
                                b=t+v.getHeight();
                            }

                            if(r>screenWidth){
                                r=screenWidth;
                                l=r-v.getWidth();
                            }

                            if(b>screenHeight){
                                b=screenHeight;
                                t=b-v.getHeight();
                            }
                            v.layout(l, t, r, b);

                            lastX=(int)event.getRawX();
                            lastY=(int)event.getRawY();
                            Toast.makeText(DraftTest.this,
                                    "当前位置："+l+","+t+","+r+","+b,
                                    Toast.LENGTH_SHORT).show();
                            v.postInvalidate();
                            break;
                        case MotionEvent.ACTION_UP:
                            if(lastX == endX&&lastY == endY) {
                                Log.e("find", "=========您点击了按钮============");
                            }else {
                                Log.e("find", "=========您拖动了按钮============");
                            }
                            break;
                    }
                    return false;
                }});
        }

    //传入包名，判断程序是否安装。
    private boolean isPkgInstalled(String pkgName) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.getPackageManager().getPackageInfo(pkgName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }

        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

}

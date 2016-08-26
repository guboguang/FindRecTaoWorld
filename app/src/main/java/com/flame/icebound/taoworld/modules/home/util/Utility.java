package com.flame.icebound.taoworld.modules.home.util;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.flame.icebound.taoworld.modules.home.i.HomeProtocol;

public class Utility {
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            Log.e(HomeProtocol.TAG,"listAdapter.getCount()="+listAdapter.getCount());
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        Log.e(HomeProtocol.TAG,"totalHeight"+ params.height);
        listView.setLayoutParams(params);
    }
}

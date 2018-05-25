package com.xylitolz.draggingsortdemo;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc RecyclerView帮助类
 * @date 2018-05-14 14:18
 */
public class RecyclerViewUtil {

    public static void vertical(Context context,RecyclerView rv) {
        rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
    }

    public static void horizontal(Context context,RecyclerView rv) {
        rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
    }

    public static void grid(Context context,int spanCount,RecyclerView rv) {
        rv.setLayoutManager(new GridLayoutManager(context,spanCount,GridLayoutManager.VERTICAL,false));
    }
}

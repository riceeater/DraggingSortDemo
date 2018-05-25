package com.xylitolz.draggingsortdemo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.util.Collections;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc RecyclerView拖动帮助类
 * @date 2018-05-25 11:18
 */
public class BookShelfTouchHelper extends ItemTouchHelper {

    private TouchCallback callback;

    public BookShelfTouchHelper(TouchCallback callback) {
        super(callback);
        this.callback = callback;
    }

    @Override
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        super.startDrag(viewHolder);
    }

    public void setEnableDrag(boolean enableDrag) {
        callback.setEnableDrag(enableDrag);
    }

    public void setEnableSwipe(boolean enableSwipe) {
        callback.setEnableSwipe(enableSwipe);
    }
}

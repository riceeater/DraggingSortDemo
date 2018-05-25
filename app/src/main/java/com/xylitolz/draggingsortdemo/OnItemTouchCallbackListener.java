package com.xylitolz.draggingsortdemo;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 滑动或者拖动Item的回调接口
 * @date 2018-05-25 11:40
 */
public interface OnItemTouchCallbackListener {
    /**
     * 当某个Item被滑动删除时回调
     */
    void onSwiped(int adapterPosition);

    /**
     * 当两个Item位置互换的时候被回调(拖拽)
     * @param srcPosition    拖拽的item的position
     * @param targetPosition 目的地的Item的position
     * @return 开发者处理了操作应该返回true，开发者没有处理就返回false
     */
    boolean onMove(int srcPosition, int targetPosition);
}

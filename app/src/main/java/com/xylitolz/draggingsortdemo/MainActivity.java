package com.xylitolz.draggingsortdemo;

import android.app.Service;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnItemTouchCallbackListener, IDragListener {

    @BindView(R.id.rv_books)
    RecyclerView rvBooks;

    private BookShelfAdapter adapter;//适配器
    private BookShelfTouchHelper touchHelper;//拖拽操作帮助类
    private List<Book> books = new ArrayList<>();//数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        RecyclerViewUtil.grid(this,3,rvBooks);
        rvBooks.setHasFixedSize(true);

        adapter = new BookShelfAdapter(this,this);
        rvBooks.setAdapter(adapter);
        touchHelper = new BookShelfTouchHelper(new TouchCallback(this));
        touchHelper.setEnableDrag(false);
        touchHelper.setEnableSwipe(false);
        touchHelper.attachToRecyclerView(rvBooks);
    }

    private void initData() {
        books = DataUtils.getData(DataUtils.DEFAULT_SP_NAME,"books",this);
        if(books.size() == 0) {
            books.add(new Book("放开那个女巫", "好看的魔法小说", 1526293390000L, "二目", ""));
            books.add(new Book("修真世界", "好看的幻想小说", 1526223440000L, "方想", ""));
            books.add(new Book("神雕侠侣", "好看的武侠小说", 1526254320000L, "金庸", ""));
            books.add(new Book("修真聊天群", "好看的架空修真小说", 1526198370000L, "圣骑士的传说", ""));
            books.add(new Book("昆仑", "好看的新武侠小说", 1526098760000L, "凤歌", ""));
            books.add(new Book("天书奇谭", "好看的魔法小说", 1525098760000L, "楚白", ""));
            books.add(new Book("铁器时代", "好看的架空历史小说", 1525098560000L, "骁骑校", ""));
            books.add(new Book("橙红年代", "好看的都市小说", 1525098360000L, "骁骑校", ""));
            books.add(new Book("国士无双", "好看的架空历史小说", 1525098280000L, "骁骑校", ""));
            books.add(new Book("匹夫的逆袭", "好看的都市小说", 1525097450000L, "骁骑校", ""));
            books.add(new Book("穿越者", "好看的幻想小说", 1525096350000L, "骁骑校", ""));
            books.add(new Book("美国众神", "好看的幻想小说", 1525096110000L, "尼尔盖曼", ""));
            books.add(new Book("官居一品", "好看的架空小说", 1525096000000L, "三戒大师", ""));
        }
        adapter.setData(books);
    }

    @Override
    public void onSwiped(int position) {
        //处理划动删除操作
        if(books != null && position >= 0 && position < books.size()) {
            books.remove(position);
            adapter.notifyItemRemoved(position);
        }
    }

    @Override
    public boolean onMove(int srcPosition, int targetPosition) {
        //处理拖拽事件
        if(books == null || books.size() == 0) {
            return false;
        }
        if(srcPosition >= 0 && srcPosition < books.size() && targetPosition >= 0 && targetPosition < books.size()) {
            //交换数据源两个数据的位置
            Collections.swap(books,srcPosition,targetPosition);
            //更新视图
            adapter.notifyItemMoved(srcPosition,targetPosition);
            //消费事件
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void startDrag(RecyclerView.ViewHolder holder) {
        //获取系统震动服务
        Vibrator vib = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        //震动70毫秒
        vib.vibrate(70);
        touchHelper.startDrag(holder);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁前存储数据
        DataUtils.saveData(books,DataUtils.DEFAULT_SP_NAME,"books",this);
    }
}

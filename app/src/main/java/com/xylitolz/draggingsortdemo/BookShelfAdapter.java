package com.xylitolz.draggingsortdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 书架列表适配器
 * @date 2018-05-15 09:52
 */
public class BookShelfAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Book> books = new ArrayList<>();
    private Context context;
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_ADD_BOOK = 1;
    private IDragListener listener;

    public BookShelfAdapter(Context context,IDragListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setData(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_BOOK) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_book_shelf, parent, false);
            return new BookShelfViewHolder(view,listener);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_book_shelf, parent, false);
            return new BookShelfAddViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if(viewType == TYPE_BOOK) {
            ((BookShelfViewHolder) holder).bind(books.get(position));
        } else {

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount() - 1) {
            return TYPE_ADD_BOOK;
        } else {
            return TYPE_BOOK;
        }
    }

    @Override
    public int getItemCount() {
        return books.size() + 1;
    }

    public static class BookShelfViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_book_cover)
        ImageView ivBookCover;
        @BindView(R.id.tv_book_cover_name)
        TextView tvBookCoverName;
        @BindView(R.id.tv_book_name)
        TextView tvBookName;
        @BindView(R.id.tv_last_visit)
        TextView tvLastVisit;


        public BookShelfViewHolder(View itemView,final IDragListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.startDrag(BookShelfViewHolder.this);
                    return true;
                }
            });
        }

        private void bind(Book book) {
            tvBookCoverName.setText(book.getName()+" 作者:"+book.getAuthor());
            tvBookName.setText(book.getName()+" 作者:"+book.getAuthor());
            tvLastVisit.setText(TimeUtil.parseTimeByLatest(book.getLastVisit()));
        }
    }

    public static class BookShelfAddViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_book_cover)
        ImageView ivBookCover;
        @BindView(R.id.tv_book_cover_name)
        TextView tvBookCoverName;
        @BindView(R.id.tv_book_name)
        TextView tvBookName;
        @BindView(R.id.tv_last_visit)
        TextView tvLastVisit;
        private View rootView;


        public BookShelfAddViewHolder(View itemView) {
            super(itemView);
            this.rootView = itemView;
            ButterKnife.bind(this, itemView);
            tvBookCoverName.setText("");
            tvBookName.setText("添加书籍");
            tvLastVisit.setText("");
        }


    }
}

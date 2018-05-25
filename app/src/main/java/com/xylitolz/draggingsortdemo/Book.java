package com.xylitolz.draggingsortdemo;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 书籍实体类
 * @date 2018-05-15 09:53
 */
public class Book {

    public Book() {
    }

    public Book(String name, String desc, long lastVisit, String author, String path) {
        this.name = name;
        this.desc = desc;
        this.lastVisit = lastVisit;
        this.author = author;
        this.path = path;
    }

    private String name;//书名
    private String desc;//书描述
    private long lastVisit;//上次访问时间
    private String author;//作者
    private String path;//存放位置

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(long lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

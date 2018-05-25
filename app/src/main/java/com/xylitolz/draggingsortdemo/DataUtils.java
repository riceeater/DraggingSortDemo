package com.xylitolz.draggingsortdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 保存数据工具类
 * @date 2018-05-25 13:52
 */
public class DataUtils {

    public static final String DEFAULT_SP_NAME = "DEFAULT_SP_NAME";

    public static <T> void saveData(List<T> data, String spName, String key, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String jsonString = gson.toJson(data);
        editor.putString(key,jsonString);
        editor.apply();
    }

    public static List<Book> getData(String spName, String key, Context context) {
        List<Book> data = new ArrayList<Book>();
        SharedPreferences preferences = context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        String jsonString = preferences.getString(key,null);
        if(jsonString == null) {
            return data;
        }
        Log.e("JSON",jsonString + "ssss"+new TypeToken<List<Book>>(){}.getType());
        Gson gson = new Gson();
        data = gson.fromJson(jsonString,new TypeToken<List<Book>>(){}.getType());
        return data;
    }
}

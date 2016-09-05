/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkc.common.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 *
 * @author ppnie
 */
public class JsonUtils 
{
    /**
     * 将对象转换为json 格式数据
     * @param src
     * @return 
     */
    public static String toJson(Object src)
    {
        Gson gson = new Gson();
        return gson.toJson(src);
    }
    
    /**
     * 跳过Html 标签，将对象转换为json 格式数据
     * @param src
     * @return 
     */
    public static String toJsonDisableHtmlEscaping(Object src)
    {
        GsonBuilder gb=new GsonBuilder();
        gb.disableHtmlEscaping();
        return gb.create().toJson(src);
    }
    
    /**
     * 将json字符串转换为实体 对象
     * @param <T>
     * @param json
     * @param typeOfT
     * @return 
     */
    public static <T> T fromJson(String json, Type typeOfT)
    {
         Gson gson = new Gson();
         return gson.fromJson(json, typeOfT);
    }

    /**
     * 将json字符串数组转换为 实体对象数组
     * 
     * @param <T>
     * @param json
     * @param typeOfT
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> fromJsonArray(String json, Type typeOfT)
    {
        Gson gson = new Gson();
        // 创建一个JsonParser
        JsonParser parser = new JsonParser();

        // 通过JsonParser对象可以把json格式的字符串解析成一个JsonElement对象
        JsonElement el = parser.parse(json);

        // 把JsonElement对象转换成JsonArray
        JsonArray jsonArray = null;
        if (el.isJsonArray())
        {
            jsonArray = el.getAsJsonArray();
        }

        // 遍历JsonArray对象
        List<T> list = new ArrayList<T>();
        Iterator<T> it = (Iterator<T>)jsonArray.iterator();
        while (it.hasNext())
        {
            JsonElement e = (JsonElement) it.next();
            // JsonElement转换为JavaBean对象
            T field = gson.fromJson(e, typeOfT);
            list.add(field);
        }
        return list;
    }
}

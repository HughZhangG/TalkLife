package com.gu.cheng.talklife.http;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.MediaType;

/**
 * Created by Guangcheng.Zhang on 2016/6/1 23:13.
 * Email:zhang411988153@163.com
 */

public  class OkHttpManager {
    /**
     * @param url
     * @param cb
     * @param keyword
     * 关键字查询
     */
    public static void okGet(String url,String keyword, Callback cb){
        OkHttpUtils.get()
                .url(url)
                .addParams("q",keyword)
                .build()
                .execute(cb);

    }

    public static void okPost(String url,String json,Callback cb){
        OkHttpUtils.postString()
                .url(url)
                .content(json)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(cb);
    }
}

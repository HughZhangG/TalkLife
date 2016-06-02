package com.gu.cheng.talklife.http;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

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
    public static void okGet(String url, Callback cb,String keyword){
        OkHttpUtils.get()
                .url(url)
                .addParams("q",keyword)
                .build()
                .execute(cb);

    }
}

package com.gu.cheng.talklife.data.source;

/**
 * Created by Guangcheng.Zhang on 2016/6/3 00:03.
 * Email:zhang411988153@163.com
 */

import android.support.annotation.NonNull;

import com.gu.cheng.talklife.data.NewsBean;

import java.util.List;

/**
 * Main entry point for accessing tasks data.
 * <p>
 * For simplicity, only getTasks() and getTask() have callbacks. Consider adding callbacks to other
 * methods to inform the user of network/database errors or successful operations.
 * For example, when a new task is created, it's synchronously stored in cache but usually every
 * operation on database or network should be executed in a different thread.
 */

public interface DataSource {

    interface LoadDataCallback {
        void onDataLoaded(List<NewsBean> newsBeanList);

        void onDataNotAvailable();
    }

    interface GetDataCallback {
        void onDataLoaded(NewsBean newsBean);

        void onDataNotAvailable();
    }


    NewsBean getData(String title);

    List<NewsBean> getDataList(int num);

    void saveData(@NonNull NewsBean bean);

    void refreshDatas();

    void clearCompletedDataList();

    void deleteAllDataList();

    void deleteData(@NonNull String title);


}

package com.gu.cheng.talklife.data.source;

import android.support.annotation.NonNull;

import com.gu.cheng.talklife.data.NewsBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Guangcheng.Zhang on 2016/6/5 21:50.
 * Email:zhang411988153@163.com
 */

public class DataRepository implements DataSource {

    private final DataSource mNewsRemoteDataSource;

    private static DataRepository INSTANCE = null;

    private List<DataRepositoryObserver> mObservers = new ArrayList<DataRepositoryObserver>();


    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    Map<String, NewsBean> mCachedNews;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty;


    private DataRepository(@NonNull DataSource newsRemoteDataSource){
        this.mNewsRemoteDataSource = checkNotNull(newsRemoteDataSource);
    }

    public static DataRepository getInstance(DataSource newsRemoteDataSource){

        if (INSTANCE == null){
            INSTANCE = new DataRepository(newsRemoteDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public void addContentObserver(DataRepositoryObserver observer){
        if (!mObservers.contains(observer))
            mObservers.add(observer);
    }

    public void removeContentObserver(DataRepositoryObserver observer){
        if (mObservers.contains(observer))
            mObservers.remove(observer);
    }

    public void notifyContentObserver(){
        for (DataRepositoryObserver observer: mObservers) {
            observer.onDataChange();
        }
    }



    /**
     * Gets tasks from local data source (sqlite) unless the table is new or empty. In that case it
     * uses the network data source. This is done to simplify the sample.
     */
    @Override
    public NewsBean getData(String title) {

        return null;
    }

    /**
     *
     * Gets tasks from cache, local data source (SQLite) or remote data source, whichever is
     * available first. This is done synchronously because it's used by the {@link TasksLoader},
     * which implements the async mechanism.
     */
    @Override
    public List<NewsBean> getDataList(int num) {

        List<NewsBean> list = null;
        if (!mCacheIsDirty){
            // Respond immediately with cache if available and not dirty
            if (mCachedNews != null){
                list = getCachedNews();
                return list;
            }else {
                // Query the local storage if available.
            }
        }
        // To simplify, we'll consider the local data source fresh when it has data.
        if (list == null || list.isEmpty()){
            // Grab remote data if cache is dirty or local data not available.
            list = mNewsRemoteDataSource.getDataList(num);
            // We copy the data to the device so we don't need to query the network next time
//            saveDataListInLocalDataSource(list);
        }

        processLoadDataList(list);
        return null;
    }

    private void processLoadDataList(List<NewsBean> list) {
        if (list == null){
            mCachedNews = null;
            mCacheIsDirty = true;
            return;
        }
        if (mCachedNews == null){
            mCachedNews = new LinkedHashMap<>();
        }
        mCachedNews.clear();
        for (NewsBean news:list) {
            mCachedNews.put(news.getTitle(),news);
        }
        mCacheIsDirty = false;
    }

    @Override
    public void saveData(@NonNull NewsBean bean) {

    }

    @Override
    public void refreshDatas() {

    }

    @Override
    public void clearCompletedDataList() {

    }

    @Override
    public void deleteAllDataList() {

    }

    @Override
    public void deleteData(@NonNull String title) {

    }

    public List<NewsBean> getCachedNews() {

        return mCachedNews == null ? null : new ArrayList<>(mCachedNews.values());
    }

    public interface DataRepositoryObserver{
        void onDataChange();
    }
}

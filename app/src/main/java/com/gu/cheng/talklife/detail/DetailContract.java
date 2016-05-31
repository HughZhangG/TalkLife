package com.gu.cheng.talklife.detail;

import com.gu.cheng.talklife.BasePresenter;
import com.gu.cheng.talklife.BaseView;

/**
 * Created by Administrator on 2016/5/29 17:25.
 */

public class DetailContract{
    interface View extends BaseView<Presenter> {

        void setTitle(String title);

        void setContent(String content);

        boolean isActive();

    }

    interface Presenter extends BasePresenter{

    }
}

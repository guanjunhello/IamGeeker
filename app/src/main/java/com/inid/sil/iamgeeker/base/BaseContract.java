package com.inid.sil.iamgeeker.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * author: $USER_NAME
 * created on: 2018/2/27 0027 下午 3:20
 * description:
 */
public interface BaseContract {

    interface BasePresenter<T extends BaseView>{
        void attachView(T view);
        void detachView();
    }

    interface BaseView{
        void showLoading();
        void hideLoading();
        void httpSuccess(String result);
        void httpFail(String message);
        void hasNoNet();
        void httpRetry();

        <T>LifecycleTransformer<T> bindToLife();
    }
}

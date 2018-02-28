package com.inid.sil.iamgeeker.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * author: $USER_NAME
 * created on: 2018/2/27 0027 下午 3:17
 * description:
 */
public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends RxAppCompatActivity implements BaseContract.BaseView{

    @Nullable
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        initViews();
    }

    protected abstract int getLayoutResID();
    protected abstract int initViews();
}

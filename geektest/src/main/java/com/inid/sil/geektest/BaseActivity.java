package com.inid.sil.geektest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * created by Guan at 2018/2/28 0028 下午 3:52
 * description:
 */
public abstract class BaseActivity extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar !=null){
            toolbar.setTitle(setTitle());
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initViews();
    }

    protected abstract int getLayoutId();
    protected abstract void initViews();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected String setTitle(){
        return "";
    }
    protected void setTitle(String title){
        if(toolbar!=null){
            toolbar.setTitle(title);
        }
    }


}

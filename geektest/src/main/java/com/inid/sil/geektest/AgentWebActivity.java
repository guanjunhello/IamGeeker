package com.inid.sil.geektest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

public class AgentWebActivity extends BaseActivity implements ChromeClientCallbackManager.ReceivedTitleCallback {


    private AgentWeb mAgentWeb;

    //WebViewClient
    private WebViewClient mWebViewClient=new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
        }
    };
    //WebChromeClient
    private WebChromeClient mWebChromeClient=new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_agent_web;
    }

    @Override
    protected void initViews() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(linearLayout, new LinearLayout.LayoutParams(-1,-1) )//
                .useDefaultIndicator()//
                .defaultProgressBarColor()
                .setReceivedTitleCallback(this)
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecutityType(AgentWeb.SecurityType.strict)
                .createAgentWeb()//
                .ready()
                .go(getUrl());
    }

    private String getUrl() {
        return "https://www.toutiao.com/";
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        setTitle(title);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mAgentWeb.uploadFileResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

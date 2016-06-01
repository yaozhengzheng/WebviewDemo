package com.yao.feicui.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = new WebView(this);
//        mWebView.setWebViewClient(new WebViewClient() {
//            //设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
        //设置WebView属性,运行执行js脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        //调用loadView方法为WebView加入链接
        mWebView.loadUrl("http://www.baidu.com");
        //调用Activity提供的setContentView将webView显示出来
        setContentView(mWebView);
    }

    /**
     * 我们需要重写回退按钮的时间,当用户点击回退按钮：
     * 1.webView.canGoBack()判断网页是否能后退,可以则goback()
     * 2.如果不可以连续点击两次退出App,否则弹出提示Toast
     */
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()){
            mWebView.goBack();
        }else{
            if ((System.currentTimeMillis()-exitTime)>2000){
                //
                Toast.makeText(getApplicationContext(),"再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else{
                super.onBackPressed();
            }
        }
        super.onBackPressed();
    }
}

package com.bawei.chenshuaishuaiyuekaomoni02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import com.bawei.chenshuaishuaiyuekaomoni02.JsToAndroid;
import com.bawei.chenshuaishuaiyuekaomoni02.R;
import com.bawei.chenshuaishuaiyuekaomoni02.base.BaseActivity;

public class SecendActivity extends BaseActivity {

    private WebView webView;
    private Button btn_js;
    private JsToAndroid jsToAndroid=new JsToAndroid();

    @Override
    protected void initdata() {
        webView.loadUrl("file:///android_asset/hellow.html");
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(jsToAndroid,"wo");
    }
    @Override
    protected void initview() {
        webView = (WebView) findViewById(R.id.webview);
        btn_js = (Button) findViewById(R.id.bt_js);
        btn_js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadUrl("javascript:calljs()");
                    }
                });
            }
        });

    }
    @Override
    protected int layoutid() {
        return R.layout.activity_secend;
    }
}

package com.bawei.chenshuaishuaiyuekaomoni02;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.bawei.chenshuaishuaiyuekaomoni02.app.App;

public class JsToAndroid {
    @JavascriptInterface
    public void getData(){
        Toast.makeText(App.getContext(), "我是无参", Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void getData(String name){
        Toast.makeText(App.getContext(), "我是有参"+name, Toast.LENGTH_SHORT).show();
    }
}

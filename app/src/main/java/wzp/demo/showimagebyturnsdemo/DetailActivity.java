package wzp.demo.showimagebyturnsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by wzp on 2017/6/15.
 */

public class DetailActivity extends AppCompatActivity {

    private WebView wvDetail;

    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        wvDetail = (WebView) findViewById(R.id.wv_detail);

        url = getIntent().getStringExtra("url");
        wvDetail.loadUrl(url);
        wvDetail.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        wvDetail.getSettings().setJavaScriptEnabled(true);//启用js
        wvDetail.getSettings().setBlockNetworkImage(false);//解决图片不显示
    }
}

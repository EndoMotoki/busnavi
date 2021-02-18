package net.aquacentral.koyobus.ui.News;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import net.aquacentral.koyobus.R;
import net.aquacentral.koyobus.ui.Heijitu.HomeViewModel;
import net.aquacentral.koyobus.ui.News.NewsViewModel;

//お知らせ
public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;
    //private WebView webView;
    public static WebView dWebView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        //WebView

        dWebView = (WebView) root.findViewById(R.id.webView4);
        dWebView.getSettings().setLoadWithOverviewMode(true);
        dWebView.getSettings().setUseWideViewPort(true);
        dWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        dWebView.setWebViewClient(new WebViewClient());
        //myWebView.clearCache(true);
        //myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //WebViewの画面サイズ調整

        super.onCreate(savedInstanceState);
        dWebView.loadUrl("https://bus.xmilkyway.com/news.html");
        WebSettings webSettings = dWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        dWebView.setVerticalScrollbarOverlay(true);
        dWebView.setWebChromeClient(new WebChromeClient() {
        });
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(dWebView, true);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.flush();
        root.setFocusableInTouchMode(true);

        return root;
    }
}
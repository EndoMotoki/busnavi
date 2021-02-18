package net.aquacentral.koyobus.ui.Nitiyou;

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
import net.aquacentral.koyobus.ui.News.NewsViewModel;

//日曜
public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    //private WebView webView;
    public static WebView aWebView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        //WebView

        aWebView = (WebView) root.findViewById(R.id.webView3);
        aWebView.getSettings().setLoadWithOverviewMode(true);
        aWebView.getSettings().setUseWideViewPort(true);
        aWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        aWebView.setWebViewClient(new WebViewClient());
        //myWebView.clearCache(true);
        //myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //WebViewの画面サイズ調整

        super.onCreate(savedInstanceState);
        aWebView.loadUrl("https://bus.xmilkyway.com/holiday.html");
        WebSettings webSettings = aWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        aWebView.setVerticalScrollbarOverlay(true);
        aWebView.setWebChromeClient(new WebChromeClient() {
        });
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(aWebView, true);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.flush();
        root.setFocusableInTouchMode(true);

        return root;
    }
}
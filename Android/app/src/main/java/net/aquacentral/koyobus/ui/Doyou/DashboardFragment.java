package net.aquacentral.koyobus.ui.Doyou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import net.aquacentral.koyobus.R;
import net.aquacentral.koyobus.ui.Heijitu.HomeViewModel;

//Doyou
public class DashboardFragment extends Fragment {


    private DashboardViewModel dashboardViewModel;
    ProgressBar progressBar;
    //private WebView webView;
    public static WebView bWebView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //WebView

        bWebView = (WebView) root.findViewById(R.id.webView2);
        bWebView.getSettings().setLoadWithOverviewMode(true);
        bWebView.getSettings().setUseWideViewPort(true);
        bWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        bWebView.setWebViewClient(new WebViewClient());
        //myWebView.clearCache(true);
        //myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //WebViewの画面サイズ調整

        super.onCreate(savedInstanceState);
        bWebView.loadUrl("https://bus.xmilkyway.com/saturday.html");
        WebSettings webSettings = bWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        bWebView.setVerticalScrollbarOverlay(true);
        bWebView.setWebChromeClient(new WebChromeClient() {
        });
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(bWebView, true);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.flush();
        root.setFocusableInTouchMode(true);

        return root;
    }
}
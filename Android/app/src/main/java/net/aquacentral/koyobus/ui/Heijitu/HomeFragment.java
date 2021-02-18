package net.aquacentral.koyobus.ui.Heijitu;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
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

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import net.aquacentral.koyobus.R;

//平日

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    //private WebView webView;
    public static WebView cWebView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //WebView

        cWebView = (WebView) root.findViewById(R.id.webView1);
        cWebView.getSettings().setLoadWithOverviewMode(true);
        cWebView.getSettings().setUseWideViewPort(true);
        cWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        cWebView.setWebViewClient(new WebViewClient());
        //myWebView.clearCache(true);
        //myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //WebViewの画面サイズ調整

        super.onCreate(savedInstanceState);
        cWebView.loadUrl("https://bus.xmilkyway.com/bus.html");
        WebSettings webSettings = cWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        cWebView.setVerticalScrollbarOverlay(true);
        cWebView.setWebChromeClient(new WebChromeClient() {
        });
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(cWebView, true);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.flush();
        root.setFocusableInTouchMode(true);

        return root;
    }
}

/*
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cWebView.setWebViewClient(new WebViewClient() {
            private ProgressDialog dialog = null;
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (dialog == null || !dialog.isShowing()) {
                    dialog = new ProgressDialog(getActivity());
                    dialog.setTitle("サーバーからデータ取得中");
                    dialog.show();
                }
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                }
            };
        });
    }
}

 */
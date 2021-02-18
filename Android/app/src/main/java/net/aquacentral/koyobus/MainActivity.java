package net.aquacentral.koyobus;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import net.aquacentral.koyobus.ui.Doyou.DashboardFragment;
import net.aquacentral.koyobus.ui.Heijitu.HomeFragment;
import net.aquacentral.koyobus.ui.News.NewsFragment;
import net.aquacentral.koyobus.ui.Nitiyou.NotificationsFragment;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
//Test:FBBF7BD0F8CA2FD246DEE24EA8F8E6F3
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-3350766982337275~9302395905");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //RequestConfiguration.Builder().setTestDeviceIds


    BottomNavigationView navView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_news)
            .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navView,navController);
}

    @Override
    public void onBackPressed() {
        if (DashboardFragment.bWebView!=null) {
            if (DashboardFragment.bWebView.canGoBack()) {
                DashboardFragment.bWebView.goBack();
            }
        }
        if (NotificationsFragment.aWebView!=null) {
            if (NotificationsFragment.aWebView.canGoBack()) {
                NotificationsFragment.aWebView.goBack();
            }
        }
        if (HomeFragment.cWebView!=null) {
            if (HomeFragment.cWebView.canGoBack()) {
                HomeFragment.cWebView.goBack();
            }
        }
        if (NewsFragment.dWebView!=null) {
            if  (NewsFragment.dWebView.canGoBack()) {
                NewsFragment.dWebView.goBack();
            }
        }
    }

}
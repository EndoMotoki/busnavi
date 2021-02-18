//
//  FourViewController.swift
//  KOYOBUSNAVI
//
//  Created by EndoMotoki on 2020/09/01.
//  Copyright © 2020 EndoMotoki. All rights reserved.
//

import UIKit
import WebKit
import StoreKit
import GoogleMobileAds

class FourViewController: UIViewController,WKUIDelegate,WKNavigationDelegate {
    
    var webView: WKWebView!
    var activityIndicator: UIActivityIndicatorView!
    var bannerView: GADBannerView!
//    let statusBarHeight = UIApplication.shared.statusBarFrame.height

    @IBAction func back(_ sender: Any) {
        self.webView?.goBack()
    }
    @IBAction func refresh(_ sender: Any) {
        self.webView?.reload()
    }
    
    
    override func loadView() {
       /* if #available(iOS 10.3,*) {
            SKStoreReviewController.requestReview()
        }
 */
        super.loadView()
        let webConfiguration = WKWebViewConfiguration()
        webView = WKWebView(frame: .zero,configuration:webConfiguration)
        webView.uiDelegate = self
        webView.navigationDelegate = self
        self.view = webView
        webView.allowsBackForwardNavigationGestures = true
        if #available(iOS 9.0, *) {
        WKWebsiteDataStore.default().removeData(ofTypes: WKWebsiteDataStore.allWebsiteDataTypes(), modifiedSince: Date(timeIntervalSince1970:0), completionHandler: {})
        }
        activityIndicator = UIActivityIndicatorView()
        activityIndicator.frame = CGRect(x: 0, y: 0, width: 50, height: 50)
        // 画面中央に設定
        activityIndicator.center = CGPoint(x: UIScreen.main.bounds.size.width/2, y: UIScreen.main.bounds.size.height/2)
        // インジケータを停止している際は非表示にするように設定
        activityIndicator.hidesWhenStopped = true
        // インジケータのスタイル設定
        activityIndicator.style = UIActivityIndicatorView.Style.gray
        self.view.addSubview(activityIndicator)
        
    }
    
    //3d touch無効化
    @available(iOS 10.0, *)
    func webView(_ webView: WKWebView, shouldPreviewElement elementInfo: WKPreviewElementInfo) -> Bool {
        return false
    }
    
    func webView(_ webView: WKWebView, didStartProvisionalNavigation navigation: WKNavigation!) {
        // クルクル開始
        activityIndicator.startAnimating()
    }
    
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        // クルクル終了
        activityIndicator.stopAnimating()
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let url = URL(string:"https://bus.xmilkyway.com/news.html")
        let request = URLRequest(url: url!)
        webView.load(request)
        // In this case, we instantiate the banner with desired ad size.
            bannerView = GADBannerView(adSize: kGADAdSizeBanner)

            addBannerViewToView(bannerView)
        bannerView.adUnitID = "ca-app-pub-3350766982337275/2207979298"
          bannerView.rootViewController = self
        bannerView.load(GADRequest())
          }

          func addBannerViewToView(_ bannerView: GADBannerView) {
            bannerView.translatesAutoresizingMaskIntoConstraints = false
            view.addSubview(bannerView)
            view.addConstraints(
              [NSLayoutConstraint(item: bannerView,
                                  attribute: .bottom,
                                  relatedBy: .equal,
                                  toItem: bottomLayoutGuide,
                                  attribute: .top,
                                  multiplier: 1,
                                  constant: 0),
               NSLayoutConstraint(item: bannerView,
                                  attribute: .centerX,
                                  relatedBy: .equal,
                                  toItem: view,
                                  attribute: .centerX,
                                  multiplier: 1,
                                  constant: 0)
              ])
           }
    }

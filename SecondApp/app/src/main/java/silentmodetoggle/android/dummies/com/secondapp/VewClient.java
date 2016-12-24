package silentmodetoggle.android.dummies.com.secondapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ADMINN on 05-10-2016.
 */
public class VewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}

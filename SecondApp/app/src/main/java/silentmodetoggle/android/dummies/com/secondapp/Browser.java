package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

/**
 * Created by ADMINN on 05-10-2016.
 */

public class Browser extends Activity implements View.OnClickListener{
    WebView brow;
    Button go,prev,next,refresh,chistory;
    EditText url;
    //InputMethodManager imm;
    public void onCreate(Bundle instances) {

        super.onCreate(instances);
        setContentView(R.layout.browser);
        initialise();
        brow.getSettings().getLoadWithOverviewMode();
        brow.getSettings().setJavaScriptEnabled(true);
        brow.getSettings().setUseWideViewPort(true);
        brow.setWebViewClient(new VewClient());
        brow.loadUrl("https://www.google.com");
    }

    private void initialise() {
        go=(Button)findViewById(R.id.go);
        prev=(Button)findViewById(R.id.previous);
        next=(Button)findViewById(R.id.next);
        refresh=(Button)findViewById(R.id.refresh);
        chistory=(Button)findViewById(R.id.history);
        url=(EditText)findViewById(R.id.url);
        brow=(WebView) findViewById(R.id.brow);
        go.setOnClickListener(this);
        chistory.setOnClickListener(this);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        refresh.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.go:
                    brow.loadUrl(url.getText().toString());
                    InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(url.getWindowToken(),0);
                break;
            case R.id.next:
                    if(brow.canGoForward())
                        brow.goForward();
                break;
            case R.id.previous:
                    if(brow.canGoBack())
                        brow.goBack();
                break;
            case R.id.refresh:
                    brow.reload();

                break;
            case R.id.history:
                brow.clearHistory();

                break;

        }
    }
}

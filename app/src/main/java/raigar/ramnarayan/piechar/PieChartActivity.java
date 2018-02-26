package raigar.ramnarayan.piechar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class PieChartActivity extends AppCompatActivity {

    private static final String TAG = PieChartActivity.class.getSimpleName();
    WebView webViewPieChart;
    int num1, num2, num3, num4, num5, num6, num7,num8,num9 , width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        getWindowSize();
        initializeInt();
        m();



    }

    /* Get height and width of Screen in pixels */

    private void getWindowSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;

        Log.v(TAG, " Width of screen: " + width);
        Log.v(TAG, " Height of screen: " + height);

    }

    /* Initialize int values */

    private void initializeInt() {
        num1 = 20;
        num2 = 30;
        num3 = 40;
        num4 = 20;
        num5 = 20;
        num6 = 20;
        num7 = 20;
        num8 = 20;
        num9 = 20;
    }

    public class WebAppInterface {

        @JavascriptInterface
        public int getNum1() {
            return num1;
        }

        @JavascriptInterface
        public int getNum2() {
            return num2;
        }

        @JavascriptInterface
        public int getNum3() {
            return num3;
        }

        @JavascriptInterface
        public int getNum4() {
            return num4;
        }

        @JavascriptInterface
        public int getNum5() {
            return num5;
        }

        @JavascriptInterface
        public int getNum6() {
            return num6;
        }

        @JavascriptInterface
        public int getNum7() {
            return num7;
        }
        @JavascriptInterface
        public int getNum8() {
            return num8;
        }
        @JavascriptInterface
        public int getNum9() {
            return num9;
        }
        @JavascriptInterface
        public int getNum10() {
            return width;
        }
        @JavascriptInterface
        public int getNum11() {
            return height;
        }
    }

    public void m() {

        webViewPieChart = (WebView) findViewById(R.id.web);
        webViewPieChart.addJavascriptInterface(new WebAppInterface(), "Android");
        webViewPieChart.setPadding(0, 0, 0, 0);
        webViewPieChart.setInitialScale(100);
        webViewPieChart.getSettings().setJavaScriptEnabled(true);
        webViewPieChart.loadUrl("file:///android_asset/adminchart.html");
    }

}

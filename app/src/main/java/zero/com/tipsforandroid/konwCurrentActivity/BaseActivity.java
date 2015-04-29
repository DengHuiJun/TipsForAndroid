package zero.com.tipsforandroid.konwCurrentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import zero.com.tipsforandroid.OutAppAnytime.ActivityCollector;

/**
 * 用Log打印出当前的Activity的Name,利用ActivityCollector来管理
 * Created by zero on 15/4/29.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActiviy",getClass().getSimpleName());

        ActivityCollector.addActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityCollector.removeActivity(this);
    }
}

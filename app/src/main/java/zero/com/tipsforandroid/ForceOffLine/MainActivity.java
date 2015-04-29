package zero.com.tipsforandroid.ForceOffLine;

import android.content.Intent;
import android.os.Bundle;

import zero.com.tipsforandroid.konwCurrentActivity.BaseActivity;

/**
 * Created by luowei on 15/4/29.
 */
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public void offlineBtn(){
        Intent intent = new Intent("com.zero.FORCE_OFFLINE");
        sendBroadcast(intent);
    }
}

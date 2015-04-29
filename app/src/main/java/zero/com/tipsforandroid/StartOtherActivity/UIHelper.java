package zero.com.tipsforandroid.StartOtherActivity;

import android.content.Context;
import android.content.Intent;

import zero.com.tipsforandroid.MainActivity;

/**
 * Created by luowei on 15/4/29.
 */
public class UIHelper {

    /**
     * 实现活动跳转方法，甚至可以加入参数，如Bundle，String等。
     * @param context
     */
    public static void goToMainActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }
}

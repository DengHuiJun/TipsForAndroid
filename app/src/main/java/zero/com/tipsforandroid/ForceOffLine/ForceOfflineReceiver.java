package zero.com.tipsforandroid.ForceOffLine;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

import zero.com.tipsforandroid.OutAppAnytime.ActivityCollector;

/**
 * 由于在ForceOfflineReceiver里弹出了一个系统级别的对话框，因此必须要声明
 * android.permission.SYSTEM_ALERT_WINDOW权限。对ForceOfflineReceiver进行注册，并知道它接受
 * com.zero.FORCE_OFFLINE这条广播
 * Created by luowei on 15/4/29.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning!");
        dialogBuilder.setMessage("You are forced to be offline.");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //销毁所有活动
                        ActivityCollector.finishAllActivity();

                        Intent intent = new Intent(context,LoginActivity.class);

                        //在广播接收器里启动活动的，要给Intent加入FLAG_ACTIVITY_NEW_TASK标志
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        //回到Login页面
                        context.startActivity(intent);
                    }
                });

        AlertDialog alertDialog = dialogBuilder.create();
        //把对话框的类型设为TYPE_SYSTEM_ALERT，不然它无法在广播接收器里弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

    }
}

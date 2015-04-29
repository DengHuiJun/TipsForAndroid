package zero.com.tipsforandroid.OutAppAnytime;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 采用单例模式写一个活动管理类，管理所有打开的Activity，我们需要把相关操作写入到BaseActivity
 * Created by luowei on 15/4/29.
 */
public class ActivityCollector {

    //用链表存储所有活动
    public static List<Activity> activities = new ArrayList<>();

    /**
     * 增加活动
     * @param activity
     */
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * 移除活动
     * @param activity
     */
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /**
     * 关闭所有活动
     */
    public static void finishAllActivity(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

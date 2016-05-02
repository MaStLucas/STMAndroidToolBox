package common.base;

import android.app.Application;
import android.content.Context;

import common.singleton.STMSharedRequestQueue;

/**
 * Created by StephenMa on 16/5/2.
 */
public class STMBaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initSharedRequestQueue();
    }

    public static void exitApplication(Context context){
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    protected void initSharedRequestQueue(){
        STMSharedRequestQueue.getInstance(getApplicationContext());
    }
}

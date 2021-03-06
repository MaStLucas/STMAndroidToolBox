package common.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by StephenMa on 16/4/11.
 */
public class STMSharedRequestQueue {
    private static STMSharedRequestQueue mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private STMSharedRequestQueue(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public static STMSharedRequestQueue getInstance(Context context) {
        if (mInstance == null) {
            synchronized (STMSharedRequestQueue.class){
                if (mInstance == null){
                    mInstance = new STMSharedRequestQueue(context);
                }
            }
        }
        return mInstance;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}

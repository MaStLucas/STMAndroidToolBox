package common.utility;

import android.os.SystemClock;
import android.view.View;

/**
 * Created by StephenMa on 16/3/20.
 */
public abstract class STMMutexOnClickListener implements View.OnClickListener{
    private static long mLastClickTime = 0;
    private static final long THRESHOLD = 500;

    @Override
    final public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < THRESHOLD){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        mutexOnClick(v);
    }

    protected abstract void mutexOnClick(View v);
}

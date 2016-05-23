package common.utility;

import android.os.Build;

/**
 * Created by StephenMa on 16/3/12.
 */
public class DeviceUtility {

    public static int getOsVersion(){
        return Build.VERSION.SDK_INT;
    }

}

package common.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by StephenMa on 5/30/16.
 */
public class PreferencesUtil {
    private static String sPreferenceName;

    public static void setDefaultPreferenceName(String name) {
        sPreferenceName = name;
    }

    public static Editor getEditor(Context context, String preferenceName) {
        return getPreferences(context, preferenceName).edit();
    }

    public static Editor getEditor(Context context)
    {
        return getEditor(context, sPreferenceName);
    }

    public static SharedPreferences getPreferences(Context context, String preferenceName) {
        return context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getPreferences(Context context)
    {
        return getPreferences(context, sPreferenceName);
    }

    public static void saveBooleanValue(Context context, String preferenceName, String key, boolean value) {
        Editor editor = getEditor(context, preferenceName);
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void saveBooleanValue(Context context, String key, boolean value) {
        saveBooleanValue(context, sPreferenceName, key, value);
    }

    public static boolean getBooleanValue(Context context, String preferenceName, String key, boolean defaultValue) {
        return getPreferences(context, preferenceName).getBoolean(key, defaultValue);
    }

    public static boolean getBooleanValue(Context context, String key, boolean defaultValue) {
        return getBooleanValue(context, sPreferenceName, key, defaultValue);
    }

    public static void saveStringValue(Context context, String key, String value) {
        Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringValue(Context context, String key, String defaultValue) {
        return getPreferences(context).getString(key, defaultValue);
    }

    public static void saveIntValue(Context context, String key, int value) {
        Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getIntValue(Context context, String key, int defaultValue) {
        return getPreferences(context).getInt(key, defaultValue);
    }

    public static void saveLongValue(Context context, String preferenceName, String key, long value) {
        Editor editor = getEditor(context, preferenceName);
        editor.putLong(key, value);
        editor.commit();
    }

    public static void saveLongValue(Context context, String key, long value) {
        saveLongValue(context, sPreferenceName, key, value);
    }

    public static long getLongValue(Context context, String preferenceName, String key, long defaultValue) {
        return getPreferences(context, preferenceName).getLong(key, defaultValue);
    }

    public static long getLongValue(Context context, String key, long defaultValue) {
        return getLongValue(context, sPreferenceName, key, defaultValue);
    }
}

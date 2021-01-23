package com.haohaohu.haolog;

import android.util.Log;

/**
 * 打印log的调用层次
 *
 * @author haohao(ronghao3508 @ gmail.com) on 2021/1/22 15:50
 * @version v1.0
 */
public class HaoLog {

    private static final String TAG = "HaoLog";

    private static boolean enable = true;

    public static void setEnable(boolean enable) {
        HaoLog.enable = enable;
    }

    /**
     * 打印日志
     *
     * @param data 待打印日志
     */
    public static void e(String data) {
        e(TAG, true, data, 4);
    }

    /**
     * 打印日志
     *
     * @param condition 条件为true时打印,否则不打印
     * @param data      待打印日志
     */
    public static void e(boolean condition, String data) {
        e(TAG, condition, data, 4);
    }

    /**
     * 打印日志
     *
     * @param tag  自定义tag
     * @param data 待打印日志
     */
    public static void e(String tag, String data) {
        e(tag, true, data, 4);
    }

    /**
     * 打印日志
     *
     * @param tag       自定义tag
     * @param condition 条件为true时打印,否则不打印
     * @param data      待打印日志
     */
    public static void e(String tag, boolean condition, String data) {
        e(tag, condition, data, 4);
    }

    /**
     * 打印log
     *
     * @param tag       自定义tag
     * @param condition 条件为true时打印,否则不打印
     * @param data      待打印日志
     * @param line      默认回调前几行不打印 ,默认为3
     */
    public static void e(String tag, boolean condition, String data, int line) {
        if (!enable || !condition) {
            return;
        }
        StringBuilder value = new StringBuilder("");
        value.append("\n ");
        value.append("\n┌───────────────────────────────────────────"
                + tag
                + "────────────────────────────────────────────────\n");
        value.append("│");
        value.append(data);
        value.append("\n");
        value.append(
                "│┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄调用层次┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n");
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st.length < line + 1) {
            value = new StringBuilder(
                    "└──────────────────────────────────────────────────────────────────────────────────────────────────\n");
        } else {
            for (int i = line; i < st.length; i++) {
                value.append("│  ").append(st[i]).append("\n");
            }
            value.append(
                    "└──────────────────────────────────────────────────────────────────────────────────────────────────\n");
        }

        Log.e(tag, value.toString());
    }
}

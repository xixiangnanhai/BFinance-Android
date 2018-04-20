package com.lexiangkeji.bfinance.app_api.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.support.v4.os.EnvironmentCompat;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class FilePathUtil {

    private static final String TAG = FilePathUtil.class.getSimpleName();

    private static final String MOUNTED = "MEDIA_MOUNTED";
    private static final String PATH = "MEDIA_PATH";

    private static final String activeFilePath = "active_image_path";// 活动图的存放地址
    private static final String homeTabZipFilePath = "home_tab_zip";// 首页Tab文件存放地址
    private static final String homeTabImageCurrentPath = "home_tab_image_current";// 首页Tab图片的存放地址(当前)
    private static final String homeTabImageNextPath = "home_tab_image_next";// 首页Tab图片的存放地址(下一个)

//
//    /**
//     * 内部存储，存在于手机固有存储，会随应用卸载而被删除 ,通常对应data/data/包名/files
//     */
//    public static final int TYPE_INTERNAL = 0;
//
//    /**
//     * 外部私有存储，存在于手机固有存储，会随应用卸载而被删除 ,通常对应/storage/emulated/0/Android/data/包名/xxx
//     */
//    public static final int TYPE_EXTERNAL_PRIVATE_INTRINSIC = 1;
//
//    /**
//     * 外部私有存储，存在于SD/TF卡，会随应用卸载而被删除 ，通常对应/SD卡的路径名/Android/data/包名/xxx
//     */
//    public static final int TYPE_EXTERNAL_PRIVATE_SD = 2;
//
//    /**
//     * 外部公有存储，存在于手机固有存储，不会随应用卸载而被删除 ,通常对应/storage/emulated/0/xxx
//     */
//    public static final int TYPE_EXTERNAL_PUBLIC_INTRINSIC = 3;
//
//    /**
//     * 外部公有存储，存在于SD/TF卡，不会随应用卸载而被删除 ,通常对应/SD卡的路径名/包名
//     */
//    public static final int TYPE_EXTERNAL_PUBLIC_SD = 4;

    private static Map<String, String> sdCardMap;

    /**
     * 优先取SD卡存储路径，若没有则取手机固有存储路径
     *
     * @param filePathType 只能取CachePathType.CACHE  CachePathType.IMAGE  CachePathType.LOGS  FilePathType.DATA四个常量之一
     * @return 路径字符串
     */
    public static String getDirectoryPriorSD(Context context, String filePathType) {
        return getDirectoryPriorSD(context, filePathType, false);
    }

    // 获得活动图片存放路径
    public static String getHuashengActiveImgDirectory(Context context) {
        return getDirectoryPriorSD(context, CachePathType.CACHE) + activeFilePath + "/";
    }

    // 获得首页Tab压缩包的存放地址
    public static String getHuaShengHomeTabZipDirectory(Context context) {
        File tempDir = new File(getDirectoryPriorSD(context, CachePathType.CACHE) + homeTabZipFilePath + "/");
        if (!tempDir.exists()){
            tempDir.mkdirs();
        }
        return getDirectoryPriorSD(context, CachePathType.CACHE) + homeTabZipFilePath + "/";
    }

    // 获得首页Tab图片的存放地址(当前)
    public static String getHuaShengHomeTabImgCurrentDirectory(Context context) {
        File tempDir = new File(getDirectoryPriorSD(context, CachePathType.CACHE) + homeTabImageCurrentPath + "/");
        if (!tempDir.exists()){
            tempDir.mkdirs();
        }
        return getDirectoryPriorSD(context, CachePathType.CACHE) + homeTabImageCurrentPath + "/";
    }

    // 获得首页Tab图片的存放地址(下一个)
    public static String getHuaShengHomeTabImgNextDirectory(Context context) {
        File tempDir = new File(getDirectoryPriorSD(context, CachePathType.CACHE) + homeTabImageNextPath + "/");
        if (!tempDir.exists()){
            tempDir.mkdirs();
        }
        return getDirectoryPriorSD(context, CachePathType.CACHE) + homeTabImageNextPath + "/";
    }

    /**
     * 优先取手机固有存储路径，若没有则取SD卡存储路径
     *
     * @param filePathType 只能取CachePathType.CACHE  CachePathType.IMAGE  CachePathType.LOGS  FilePathType.DATA四个常量之一
     * @return 路径字符串
     */
    public static String getDirectoryPriorInstinct(Context context, String filePathType) {
        return getDirectoryPriorInstinct(context, filePathType, false);
    }

    /**
     * 优先取SD卡外部存储，若没有则取手机固有外部存储，若还是没有则取内部存储
     *
     * @param context
     * @param remainAble 是否随应用一起被卸载
     * @return 返回空值表示获取失败
     */
    private static String getDirectoryPriorSD(Context context, String filePathType, boolean remainAble) {
        File file = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (sdCardMap == null) {
                getStorageData(context.getApplicationContext());
            }
            if (sdCardMap != null && sdCardMap.get(MOUNTED).equals(Environment.MEDIA_MOUNTED)) {
                if (remainAble) {
                    file = new File(sdCardMap.get(PATH), filePathType);
                } else {
                    if ( FilePathType.DATA.equals(filePathType)) {
                        file = new File(sdCardMap.get(PATH), "Android/data/" + context.getApplicationContext().getPackageName() + "/files/" + filePathType);
                    } else {
                        file = new File(sdCardMap.get(PATH), "Android/data/" + context.getApplicationContext().getPackageName() + "/cache/" + filePathType);
                    }
                }
            } else {
                if (remainAble) {
                    file = Environment.getExternalStoragePublicDirectory(filePathType);
                } else {
                    if ( FilePathType.DATA.equals(filePathType)) {
                        file = context.getApplicationContext().getExternalFilesDir(filePathType);
                    } else {
                        file = new File(context.getApplicationContext().getExternalCacheDir(), filePathType);
                    }
                }
            }

        } else {
            file = context.getApplicationContext().getFilesDir();
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file.getPath() + "/";
    }

    /**
     * 优先取手机固有外部存储，若没有则取SD卡外部存储，若还是没有则取内部存储
     *
     * @param context
     * @param remainAble 是否随应用一起被卸载
     * @return 返回空值表示获取失败
     */
    private static String getDirectoryPriorInstinct(Context context, String filePathType, boolean remainAble) {
        File file = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (sdCardMap == null) {
                getStorageData(context.getApplicationContext());
            }
            if (remainAble) {
                file = Environment.getExternalStoragePublicDirectory(filePathType);
            } else {
                if ( FilePathType.DATA.equals(filePathType)) {
                    file = context.getApplicationContext().getExternalFilesDir(filePathType);
                } else {
                    file = new File(context.getApplicationContext().getExternalCacheDir(), filePathType);
                }
            }
            if (file != null && !file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                return file.getPath() + "/";
            }
            if (sdCardMap != null
                    && sdCardMap.get(MOUNTED).equals(Environment.MEDIA_MOUNTED)) {
                if (remainAble) {
                    file = new File(sdCardMap.get(PATH), filePathType);
                } else {
                    if ( FilePathType.DATA.equals(filePathType)) {
                        file = new File(sdCardMap.get(PATH), "Android/data/" + context.getApplicationContext().getPackageName() + "/files/" + filePathType);
                    } else {
                        file = new File(sdCardMap.get(PATH), "Android/data/" + context.getApplicationContext().getPackageName() + "/cache/" + filePathType);
                    }
                }
            } else {
                file = context.getApplicationContext().getFilesDir();
            }

        } else {
            file = context.getApplicationContext().getFilesDir();
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file.getPath() + "/";
    }

    @SuppressLint("NewApi")
    private static void getStorageData(Context pContext) {
        final StorageManager storageManager = (StorageManager) pContext.getSystemService(Context.STORAGE_SERVICE);
        try {
            //得到StorageManager中的getVolumeList()方法的对象
            final Method getVolumeList = storageManager.getClass().getMethod("getVolumeList");
            //---------------------------------------------------------------------

            //得到StorageVolume类的对象
            final Class<?> storageValumeClazz = Class.forName("android.os.storage.StorageVolume");
            //---------------------------------------------------------------------
            //获得StorageVolume中的一些方法
            final Method getPath = storageValumeClazz.getMethod("getPath");
            Method isRemovable = storageValumeClazz.getMethod("isRemovable");

            Method mGetState = null;
            //getState 方法是在4.4_r1之后的版本加的，之前版本（含4.4_r1）没有
            // （http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.4_r1/android/os/Environment.java/）
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                try {
                    mGetState = storageValumeClazz.getMethod("getState");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            //---------------------------------------------------------------------

            //调用getVolumeList方法，参数为：“谁”中调用这个方法
            final Object invokeVolumeList = getVolumeList.invoke(storageManager);
            //---------------------------------------------------------------------
            final int length = Array.getLength(invokeVolumeList);
            for (int i = 0; i < length; i++) {
                final Object storageValume = Array.get(invokeVolumeList, i);//得到StorageVolume对象
                final String path = (String) getPath.invoke(storageValume);
                final boolean removable = (Boolean) isRemovable.invoke(storageValume);
                String state = null;
                if (mGetState != null) {
                    state = (String) mGetState.invoke(storageValume);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        state = Environment.getStorageState(new File(path));
                    } else {
                        if (removable) {
                            state = EnvironmentCompat.getStorageState(new File(path));
                        } else {
                            //不能移除的存储介质，一直是mounted
                            state = Environment.MEDIA_MOUNTED;
                        }
                        final File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    }
                }
                if (removable) {
                    sdCardMap = new HashMap<String, String>();
                    sdCardMap.put(PATH, path);
                    sdCardMap.put(MOUNTED, state);
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对应Android/data/包名/cache
     */
    public static class CachePathType {
        /*  Android/data/包名/cache/cache  */
        public static final String CACHE = "cache";

        /*  Android/data/包名/cache/image  */
        public static final String IMAGE = "image";

        /*  Android/data/包名/cache/logs  */
        public static final String LOGS = "logs";
    }

    /**
     * 对应Android/data/包名/files
     */
    public static class FilePathType {
        /* Android/data/包名/files/data */
        public static final String DATA = "data";
    }
}

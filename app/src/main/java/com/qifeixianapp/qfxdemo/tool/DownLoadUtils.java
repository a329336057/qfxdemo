package com.qifeixianapp.qfxdemo.tool;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;

public class DownLoadUtils {
    public class DownloadUtils {

        private static final String TAG = "DownloadUtils";


        //下载器
        private DownloadManager downloadManager;
        //上下文
        private Context mContext;
        //下载的ID
        private long downloadId;

        public DownloadUtils(Context context) {
            this.mContext = context;
        }


        public void downloadApk(String downLoadUrl, String description) {

            String apkName = downLoadUrl.substring(downLoadUrl.lastIndexOf("/") + 1);
            DownloadManager.Request request;
            try {
                request = new DownloadManager.Request(Uri.parse(downLoadUrl));
            } catch (Exception e) {

                return;
            }

            request.setTitle("起飞线APP");
            request.setDescription(description);

            //在通知栏显示下载进度
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

            //设置保存下载apk保存路径
            request.setDestinationInExternalPublicDir("/Download/", apkName);

            //获取DownloadManager
            downloadManager = (DownloadManager) mContext.getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

            //将下载请求加入下载队列，加入下载队列后会给该任务返回一个long型的id，通过该id可以取消任务，重启任务、获取下载的文件等等
            downloadId = downloadManager.enqueue(request);

            //注册广播接收者，监听下载状态
            mContext.registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        }

        //广播监听下载的各个状态
        private BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                    Uri downloadFileUri = downloadManager.getUriForDownloadedFile(downloadId);
                    installApk(downloadFileUri, context);
                }
            }
        };


        private String getRealFilePath(Context context, Uri uri) {
            if (null == uri) return null;
            final String scheme = uri.getScheme();
            String data = null;
            if (scheme == null)
                data = uri.getPath();
            else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
                data = uri.getPath();
            } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
                Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
                if (null != cursor) {
                    if (cursor.moveToFirst()) {
                        int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                        if (index > -1) {
                            data = cursor.getString(index);
                        }
                    }
                    cursor.close();
                }
            }
            return data;
        }


        private void installApk(Uri downLoadApkUri, Context context) {

            if (downLoadApkUri == null) {

                return;
            } else {

            }

            //获取待安装的apk文件
            File apkFile = new File(getRealFilePath(context, downLoadApkUri));
            if (!apkFile.exists()) {

                return;
            }

            //调用系统安装apk
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //7.0版本以上
                Uri uriForFile = FileProvider.getUriForFile(context, "com.example.app.fileProvider", apkFile);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");

            } else {
                Uri uri = Uri.fromFile(apkFile);
                intent.setDataAndType(uri, "application/vnd.android.package-archive");

            }

            try {
                context.startActivity(intent);
            } catch (Exception e) {
                Log.e("错误",e.getLocalizedMessage());
            }

        }
    }

}

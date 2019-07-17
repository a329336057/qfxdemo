package com.qifeixianapp.qfxdemo.Activitiy;

import android.app.ProgressDialog;
import android.content.Intent;

import android.net.Uri;

import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.UI.PopupPrivateCustomized;
import com.qifeixianapp.qfxdemo.tool.FileUtil;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.yalantis.ucrop.UCrop;
import com.zhy.base.fileprovider.FileProvider7;


import java.io.File;




public class UpLoadHeadImageActivity extends AppCompatActivity implements View.OnClickListener, OnTitleBarListener {

    private RelativeLayout mActivityMain;
    private ImageView mImageView;
    private Button mBtnPhoto;
    private Button mBtnCamera;
    private Button mUploadbutton;
    private Button mUploadUpdate;
    private ProgressDialog pd;
    private File filepath;//返回的文件地址
    TitleBar titleBar;
    public static final int RC_TAKE_PHOTO = 1;
    public static final int RC_CHOOSE_PHOTO = 2;

    private String mTempPhotoPath;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_load_head_image);
        initView();

    }

    private void initView() {
        titleBar=findViewById(R.id.Upload_bar);
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
        mImageView = (ImageView) findViewById(R.id.upload_head);
        mUploadbutton = (Button) findViewById(R.id.upload_image_button);

        mUploadUpdate = (Button) findViewById(R.id.upload_image_update);
        titleBar.setOnTitleBarListener(this);
       mUploadbutton.setOnClickListener(this);
       mUploadUpdate.setOnClickListener(this);
    }
    //摄像机拍照
    private void choosePhoto() {
        Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
        intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

        startActivityForResult(intentToPickPic, RC_CHOOSE_PHOTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            //拍照
            case RC_CHOOSE_PHOTO:

                if(data!=null){
                    Uri uri = data.getData();

                String filePath = FileUtil.getFilePathByUri(this, uri);

                if (!TextUtils.isEmpty(filePath)) {
                    RequestOptions requestOptions1 = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
                    //开始剪裁
                    FileUtil.startUCrop(UpLoadHeadImageActivity.this,uri,1,1);

                    }
                }
                break;

            case RC_TAKE_PHOTO:

                //开始剪裁
                FileUtil.startUCrop(UpLoadHeadImageActivity.this,imageUri,1,1);

                break;
            case UCrop.REQUEST_CROP://剪切返回

                if(data!=null){
                    mUploadUpdate.setVisibility(View.VISIBLE);
                    Uri resultUri = UCrop.getOutput(data);
                    RequestOptions requestOption2 = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
                    //剪切返回，显示剪切的图片到布局
                    Glide.with(this).load(resultUri).apply(requestOption2).into(mImageView);
                }

                break;
            default:
                mUploadUpdate.setVisibility(View.INVISIBLE);
                ToastUtils.show(UpLoadHeadImageActivity.this,"选择照片失败 请重新试一下");
        }
    }
    //选择相册
    private void takePhoto() {
        Intent intentToTakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File fileDir = new File(Environment.getExternalStorageDirectory() + File.separator + "qfxTravel" + File.separator);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        File photoFile = new File(fileDir, "photo.jpeg");
        mTempPhotoPath = photoFile.getAbsolutePath();
        imageUri = FileProvider7.getUriForFile(this, photoFile);
        intentToTakePhoto.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intentToTakePhoto, RC_TAKE_PHOTO);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.upload_image_button:

                new XPopup.Builder(UpLoadHeadImageActivity.this)
                        //.maxWidth(600)
                        .asCenterList("选择上传图片方式", new String[]{"拍照", "选择照片"},
                                new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                       if(position==0){
                                           takePhoto();
                                       }
                                       if(position==1){
                                           choosePhoto();

                                       }
                                    }
                                })
                        .show();


                break;
            case R.id.upload_image_update:
                ToastUtils.show(UpLoadHeadImageActivity.this,"上传接口待定");
                break;
        }
    }

    @Override
    public void onLeftClick(View v) {
        UpLoadHeadImageActivity.this.finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}

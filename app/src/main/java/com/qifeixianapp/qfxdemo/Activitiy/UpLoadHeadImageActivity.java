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
import android.widget.RelativeLayout;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.FileUtil;
import com.yalantis.ucrop.UCrop;
import com.zhy.base.fileprovider.FileProvider7;


import java.io.File;




public class UpLoadHeadImageActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mActivityMain;
    private ImageView mImageView;
    private Button mBtnPhoto;
    private Button mBtnCamera;
    private ProgressDialog pd;
    private File filepath;//返回的文件地址

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
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
        mImageView = (ImageView) findViewById(R.id.uploadhead);
        mBtnPhoto = (Button) findViewById(R.id.btn_photo);
        mBtnPhoto.setOnClickListener(this);
        mBtnCamera = (Button) findViewById(R.id.btn_camera);
        mBtnCamera.setOnClickListener(this);


    }
    private void choosePhoto() {
        Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
        intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intentToPickPic, RC_CHOOSE_PHOTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RC_CHOOSE_PHOTO:
                Uri uri = data.getData();
                String filePath = FileUtil.getFilePathByUri(this, uri);

                if (!TextUtils.isEmpty(filePath)) {
                    RequestOptions requestOptions1 = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
                    //开始剪裁
                    FileUtil.startUCrop(UpLoadHeadImageActivity.this,uri,1,1);

                }
                break;

            case RC_TAKE_PHOTO:

                //开始剪裁
                FileUtil.startUCrop(UpLoadHeadImageActivity.this,imageUri,1,1);

                break;
            case UCrop.REQUEST_CROP://剪切返回
                Uri resultUri = UCrop.getOutput(data);
                RequestOptions requestOption2 = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
                //剪切返回，显示剪切的图片到布局
                Glide.with(this).load(resultUri).apply(requestOption2).into(mImageView);
                break;

        }
    }
    private void takePhoto() {
        Intent intentToTakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File fileDir = new File(Environment.getExternalStorageDirectory() + File.separator + "photoTest" + File.separator);
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
            case R.id.btn_photo:
                choosePhoto();

                break;
            case R.id.btn_camera:
                takePhoto();

                break;
        }
    }
}

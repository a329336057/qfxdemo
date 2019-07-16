package com.qifeixianapp.qfxdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.OnConfirmListener;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.UI.PopupPrivateCustomized;
import com.qifeixianapp.qfxdemo.tool.DownLoadUtils;
import com.qifeixianapp.qfxdemo.tool.FileUtil;


public class PersonalTailorFragment extends Fragment {
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_personal_tailor, container, false);
        find(v);
        return  v;
    }

    private void find(View v) {
        button=v.findViewById(R.id.personal_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(getContext())
                        .offsetY(900)
                        .isCenterHorizontal(true)
                        .asCustom(new PopupPrivateCustomized(getContext()))
                        .show();
//                DownLoadUtils downLoadUtils=new DownLoadUtils();
//                DownLoadUtils.DownloadUtils ddownloadUtils = downLoadUtils.new DownloadUtils(getContext());
//                ddownloadUtils.downloadApk("http://47.106.13.142:8080/pdf/qfx.apk","这个是描述");
            }
        });
    }


}

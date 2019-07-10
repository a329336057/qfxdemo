package com.qifeixianapp.qfxdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.TraveReserveDateBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.GetTImeDay;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ResversDateFragment extends Fragment {
    TextView text;
    List<Integer> OnDayMonth;
    TraveReserveDateBean traveReserveDateBean;
    public ResversDateFragment(List<Integer> OnDayMonth,TraveReserveDateBean traveReserveDateBean) {
        super();
        this.OnDayMonth=OnDayMonth;
        this.traveReserveDateBean=traveReserveDateBean;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


      View v=inflater.inflate(R.layout.fragment_resvers_date, container, false);
      find(v);
      return v;
    }

    private void find(View v) {


    }


}

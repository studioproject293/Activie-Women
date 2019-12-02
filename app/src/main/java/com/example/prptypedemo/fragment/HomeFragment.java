package com.example.prptypedemo.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.example.prptypedemo.Constant;
import com.example.prptypedemo.R;

public class HomeFragment extends BaseFragment  {

    private View rootView;
    LinearLayout bhugtaanKaViwran, anusansa,maasikPartivedan,report;
    public HomeFragment() { }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        anusansa = rootView.findViewById(R.id.anusansa);
        maasikPartivedan = rootView.findViewById(R.id.maasikPartivedan);
        report = rootView.findViewById(R.id.report);
        bhugtaanKaViwran = rootView.findViewById(R.id.bhugtaanKaViwran);
        maasikPartivedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(Constant.ENTRY_FORM_FRAGNMENT,null);
            }
        });
        return rootView;
    }


}


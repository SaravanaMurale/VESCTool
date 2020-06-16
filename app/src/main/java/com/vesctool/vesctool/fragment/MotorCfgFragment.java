package com.vesctool.vesctool.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.vesctool.vesctool.R;

public class MotorCfgFragment extends Fragment {

    Spinner selectSpinner1, selectSpinner2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.layout_motorcfg_fragment,container,false);

        selectSpinner1 = (Spinner) view.findViewById(R.id.selectSpinner1);
        selectSpinner2 = (Spinner) view.findViewById(R.id.selectSpinner2);

        return view;
    }

}

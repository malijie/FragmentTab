package com.social.mobile.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.social.mobile.R;

/**
 * Created by malijie on 2016/12/8.
 */

public class AskShareFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.tab_fenda, container, false);
        return messageLayout;
    }

}
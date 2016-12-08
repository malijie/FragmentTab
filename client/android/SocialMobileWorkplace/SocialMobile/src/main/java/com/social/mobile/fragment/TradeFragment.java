package com.social.mobile.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.social.mobile.R;

/**
 * Created by malijie on 2016/12/8.
 */

public class TradeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.tab_jiaoyi, container, false);
        return messageLayout;
    }

}
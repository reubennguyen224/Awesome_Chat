package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rikkei.training.morkproject.awesomechat.BuildConfig;
import com.rikkei.training.morkproject.awesomechat.R;

public class PersonalFragment extends Fragment {

    View view;
    Context context;
    TextView tv_version_number;

    public PersonalFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal, container, false);
        Init();

        tv_version_number.setText(BuildConfig.VERSION_NAME);
        return view;
    }

    void Init(){
        tv_version_number = view.findViewById(R.id.tv_version_number);
    }
}

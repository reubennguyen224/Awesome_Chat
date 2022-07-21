package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rikkei.training.morkproject.awesomechat.R;

public class LoginFragment extends Fragment {

    View view;
    TextView btnRegisterLog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        Init();

        btnRegisterLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    void Init(){
        btnRegisterLog = view.findViewById(R.id.btnRegisterLogin);
    }
}

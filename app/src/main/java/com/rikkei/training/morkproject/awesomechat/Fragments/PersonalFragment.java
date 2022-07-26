package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    ImageView btn_update_profile;

    public PersonalFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal, container, false);
        Init();

        tv_version_number.setText(BuildConfig.VERSION_NAME);

        btn_update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.home_container, new UpdateInformationFragment(context)).addToBackStack(null).commit();
            }
        });
        return view;
    }

    void Init(){
        btn_update_profile = view.findViewById(R.id.btn_update_profile);
        tv_version_number = view.findViewById(R.id.tv_version_number);
    }
}

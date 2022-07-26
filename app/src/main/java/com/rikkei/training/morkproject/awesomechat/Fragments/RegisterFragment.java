package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.rikkei.training.morkproject.awesomechat.R;

public class RegisterFragment extends Fragment {
    View view;
    Toolbar toolbar;
    TextView btnLoginReg;
    Context context;
    ImageView btnBack;

    public RegisterFragment(){}
    public RegisterFragment(Context context){
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        Init();
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle(null);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home_container, new LoginFragment(context)).addToBackStack("Login").commit();
            }
        });

        btnLoginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().beginTransaction().replace(R.id.home_container, new LoginFragment(context)).addToBackStack("Login").commit();
                }
            }
        });


        return view;
    }

    void Init(){
        toolbar = view.findViewById(R.id.toolbar);
        btnLoginReg = view.findViewById(R.id.btnLoginReg);
        btnBack = view.findViewById(R.id.btnBack);
    }



}

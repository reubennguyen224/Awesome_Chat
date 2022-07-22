package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rikkei.training.morkproject.awesomechat.R;

public class HomeFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);


        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).addToBackStack("message").commit();
        return view;
    }
}

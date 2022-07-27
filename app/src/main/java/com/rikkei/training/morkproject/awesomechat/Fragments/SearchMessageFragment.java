package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rikkei.training.morkproject.awesomechat.R;

public class SearchMessageFragment extends Fragment {

    View view;
    Context context;
    TextView btn_cancel;

    public SearchMessageFragment() {
    }

    public SearchMessageFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_message, container, false);

        init();

        btn_cancel.setOnClickListener(v -> getFragmentManager().popBackStack());

        return view;
    }

    void init(){
        btn_cancel = view.findViewById(R.id.btn_cancel_search_message);
    }
}

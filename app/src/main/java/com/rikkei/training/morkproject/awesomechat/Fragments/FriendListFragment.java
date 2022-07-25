package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.rikkei.training.morkproject.awesomechat.R;

public class FriendListFragment extends Fragment {

    Context context;
    View view;
    TabLayout tabLayout;

    public FriendListFragment(Context context) {
        this.context = context;
    }

    public FriendListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_child_friend, container, false);
        Init();
        tabLayout.addOnTabSelectedListener(onTabSelectedListener);

        return view;
    }

    void Init(){
        tabLayout = view.findViewById(R.id.tab_layout_friend);
    }

    private final TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getId()){
                case R.id.all_friend:
                    break;
                case R.id.friend_list:
                    getChildFragmentManager().beginTransaction().replace(R.id.friend_container, new FriendFragment(context)).commit();
                    break;
                case R.id.friend_request:
                    break;

            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}

package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rikkei.training.morkproject.awesomechat.Adapter.MessageAdapter;
import com.rikkei.training.morkproject.awesomechat.Model.User;
import com.rikkei.training.morkproject.awesomechat.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View view;
    BottomNavigationView nav_bottom;
    RecyclerView recyclerView;
    Toolbar toolbar;
    TextView title;
    Context context;
    SearchView searchView;

    FrameLayout fragment_container;
    ImageView img_icon;

    public HomeFragment(){}
    public HomeFragment(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();

        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment(context)).addToBackStack("message").commit();

        nav_bottom.setItemHorizontalTranslationEnabled(true);
        nav_bottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Drawable res;
            switch (item.getItemId()){
                case R.id.message_view:
                    res = getResources().getDrawable(getResources().getIdentifier("@drawable/ic_create_message", null, getActivity().getPackageName()));
                    img_icon.setImageDrawable(res);
                    title.setText("Tin nhắn");
                    title.setVisibility(View.VISIBLE);
                    img_icon.setVisibility(View.VISIBLE);
                    searchView.setVisibility(View.VISIBLE);
                    getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment(context)).addToBackStack(null).commit();
                    return true;
                case R.id.friend_view:
                    title.setText("Bạn bè   ");
                    title.setVisibility(View.VISIBLE);
                    img_icon.setVisibility(View.VISIBLE);
                    searchView.setVisibility(View.VISIBLE);
                    res = getResources().getDrawable(getResources().getIdentifier("@drawable/ic_add_friend", null, getActivity().getPackageName()));
                    img_icon.setImageDrawable(res);
                    getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new FriendListFragment(context)).addToBackStack(null).commit();
                    return true;
                case R.id.personal_view:
                    fragment_container.layout(0,283,0,0);
                    title.setVisibility(View.GONE);
                    img_icon.setVisibility(View.GONE);
                    searchView.setVisibility(View.GONE);
                    getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new PersonalFragment(context)).addToBackStack(null).commit();
                    return true;
            }

            return false;
        }
    };

    void init(){
        nav_bottom = view.findViewById(R.id.nav_bottom);
        recyclerView = view.findViewById(R.id.recycler_message);
        toolbar = view.findViewById(R.id.toolbar);
        title = view.findViewById(R.id.toolbar_title);
        img_icon = view.findViewById(R.id.img_icon);
        searchView = view.findViewById(R.id.search_toolbar);
        fragment_container = view.findViewById(R.id.fragment_container);
    }


}

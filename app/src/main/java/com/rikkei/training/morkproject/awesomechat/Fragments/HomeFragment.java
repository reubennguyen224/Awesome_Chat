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
import android.widget.RelativeLayout;
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
    RelativeLayout block_personal, block_special, searchView;
    RecyclerView recyclerView;
    Toolbar toolbar;
    TextView title, search_title;
    Context context;
    int id_nav = 1;

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

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callBlock();
                block_personal.setVisibility(View.VISIBLE);
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_container_2, new SearchMessageFragment(context)).addToBackStack(null).commit();
            }
        });

        nav_bottom.setItemHorizontalTranslationEnabled(true);
        nav_bottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        hideBlock();
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
                    hideBlock();
                    search_title.setText("Tìm kiếm tin nhắn...");
                    id_nav = 1;
                    getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment(context)).addToBackStack(null).commit();
                    return true;
                case R.id.friend_view:
                    hideBlock();
                    title.setText("Bạn bè   ");
                    search_title.setText("Tìm kiếm bạn bè...");
                    res = getResources().getDrawable(getResources().getIdentifier("@drawable/ic_add_friend", null, getActivity().getPackageName()));
                    img_icon.setImageDrawable(res);
                    id_nav = 2;
                    getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new FriendListFragment(context)).addToBackStack(null).commit();
                    return true;
                case R.id.personal_view:
                    callBlock();
                    id_nav = 3;
                    getChildFragmentManager().beginTransaction().replace(R.id.fragment_container_2, new PersonalFragment(context, nav_bottom)).addToBackStack(null).commit();
                    return true;
            }
            return false;
        }
    };

    private RelativeLayout.OnClickListener searchListener = new RelativeLayout.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (id_nav == 1){
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_container_2, new SearchMessageFragment(context)).addToBackStack(null).commit();
            }
        }
    };

    void callBlock(){
        block_personal.setVisibility(View.VISIBLE);

        title.setVisibility(View.GONE);
        img_icon.setVisibility(View.GONE);
        searchView.setVisibility(View.GONE);
    }

    public void hideBlock(){
        block_personal.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);
        img_icon.setVisibility(View.VISIBLE);
        searchView.setVisibility(View.VISIBLE);
    }

    void init(){
        nav_bottom = view.findViewById(R.id.nav_bottom);
        recyclerView = view.findViewById(R.id.recycler_message);
        toolbar = view.findViewById(R.id.toolbar);
        title = view.findViewById(R.id.toolbar_title);
        img_icon = view.findViewById(R.id.img_icon);
        searchView = view.findViewById(R.id.search);
        fragment_container = view.findViewById(R.id.fragment_container);
        block_personal = view.findViewById(R.id.block_personal);
        block_special = view.findViewById(R.id.block_special);
        search_title = view.findViewById(R.id.searchbar_title);
        block_personal.setVisibility(View.GONE);

    }

    public BottomNavigationView getNav_bottom() {
        return nav_bottom;
    }

    public void setNav_bottom(BottomNavigationView nav_bottom) {
        this.nav_bottom = nav_bottom;
    }
}

package com.rikkei.training.morkproject.awesomechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rikkei.training.morkproject.awesomechat.Fragments.LoginFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new LoginFragment()).addToBackStack("LoginFragment").commit();
    }
}
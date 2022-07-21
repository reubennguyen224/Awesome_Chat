package com.rikkei.training.morkproject.awesomechat.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.rikkei.training.morkproject.awesomechat.R;

public class LoginFragment extends Fragment {

    View view;
    TextView btnRegisterLog, btnForgot;
    MaterialButton btnLogin;
    TextInputLayout txtEmail, txtPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        Init();

        btnRegisterLog.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.home_container, new RegisterFragment()).addToBackStack("RegisterFragment").commit();
            }
        });

        txtPassword.getEditText().addTextChangedListener(new CustomTextListener());

        return view;
    }

    void Init(){
        btnRegisterLog = view.findViewById(R.id.btnRegisterLogin);
        txtPassword = view.findViewById(R.id.txtPassword);
        txtEmail = view.findViewById(R.id.txtEmail);
        btnLogin = view.findViewById(R.id.btnLogin);
    }

    class CustomTextListener implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            boolean isChecked = txtEmail.getEditText().getText().toString().length() > 5;
            btnLogin.setEnabled(isChecked); //kich hoat nut khi mat khau nhap toi thieu 1 ky tu va email tối thieu 5 ky tu
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    void checkedLogin(){

    }
}

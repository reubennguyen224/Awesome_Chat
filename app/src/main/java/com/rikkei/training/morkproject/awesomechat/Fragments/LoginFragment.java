package com.rikkei.training.morkproject.awesomechat.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.rikkei.training.morkproject.awesomechat.R;

public class LoginFragment extends Fragment {

    TextInputLayout txtEmail, txtPassword;
    TextView btnForgot, btnRegister;
    MaterialButton btnLogin;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity().getActionBar() != null) getActivity().getActionBar().hide();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        Init();

        txtPassword.getEditText().addTextChangedListener(new CustomTextWatcher());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home_container, new RegisterFragment()).addToBackStack("RegisterFragment").commit();
            }
        });
        return view;
    }

    void Init(){
        txtEmail = view.findViewById(R.id.txtEmail);
        txtPassword = view.findViewById(R.id.txtPassword);
        btnForgot = view.findViewById(R.id.btnForgot);
        btnRegister = view.findViewById(R.id.btnRegisterLogin);
        btnLogin = view.findViewById(R.id.btnLogin);
    }

    class CustomTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            boolean isChecked = txtEmail.getEditText().getText().toString().length() > 8;
            btnLogin.setEnabled(isChecked);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
package com.example.classattendance;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {
    private TextView RegText;
    private EditText Username,Password;
    private Button loginbtn;
    OnLoginFormActivityListener loginFormActivityListener;

    public interface OnLoginFormActivityListener{
        public void performRegister();
        public void performLoginact(String name);
        public void performLecLoginAct(String name);
        public void performAdminLoginAct(String name);
    }

    public LoginFragment(){}

 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1=inflater.inflate(R.layout.fragment_login,container,false);
        RegText=view1.findViewById(R.id.register);
        Username=view1.findViewById(R.id.user_namel);
        Password=view1.findViewById(R.id.passwordl);
        loginbtn=view1.findViewById(R.id.loginbutton);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFormActivityListener.performRegister();
            }
        });
        return view1;
    }

@Override
    public void onAttach(Context context){
        super.onAttach(context);
    Activity activity=(Activity) context;
    loginFormActivityListener=(OnLoginFormActivityListener) activity;
}

private  void performLogin(){
        String user_name=Username.getText().toString();
        String password=Password.getText().toString();

    Call<User> call=MainActivity.apiInterface.performUserLogin(user_name,password);
    call.enqueue(new Callback<User>() {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {
            if(response.body().getResponse().equals("student login successful")){
                MainActivity.prefConfig.writeLoginStatus(true);
                loginFormActivityListener.performLoginact(response.body().getName());

            }
            else if(response.body().getResponse().equals("lec login successful")){
                MainActivity.prefConfig.writeLoginStatus(true);
                loginFormActivityListener.performLecLoginAct(response.body().getName());

            }
             else if(response.body().getResponse().equals("admin login successful")){
                MainActivity.prefConfig.writeLoginStatus(true);
                loginFormActivityListener.performAdminLoginAct(response.body().getName());

            }
           else if(response.body().getResponse().equals("login failed")){
                MainActivity.prefConfig.display("Login failed,try again");

            }
        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {

        }
    });
    Username.setText("");
    Password.setText("");
}
}

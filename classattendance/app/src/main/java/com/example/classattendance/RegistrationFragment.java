package com.example.classattendance;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationFragment extends Fragment {
    private EditText Name,User_type,User_name,Password;
    private Button btnRegister;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1=inflater.inflate(R.layout.fragment_registration,container,false);
        Name=view1.findViewById(R.id.name);
        User_type=view1.findViewById(R.id.user_type);
        User_name=view1.findViewById(R.id.user_name);
        Password=view1.findViewById(R.id.password);
        btnRegister=view1.findViewById(R.id.registerbutton);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });
        return view1;
    }

    public void performRegistration(){
        String name=Name.getText().toString();
        String user_type=User_type.getText().toString();
        String user_name=User_name.getText().toString();
        String password=Password.getText().toString();
        Call<User> call=MainActivity.apiInterface.performRegistration(name,user_type,user_name,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("saved successfully")){
                    MainActivity.prefConfig.display("Registration was successful");
                }
                else if(response.body().getResponse().equals("user exist")){
                    MainActivity.prefConfig.display("The user already exists");
                }
                else if(response.body().getResponse().equals("error")){
                    MainActivity.prefConfig.display("Registration not successful");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        Name.setText("");
        User_type.setText("");
        User_name.setText("");
        Password.setText("");
    }
}

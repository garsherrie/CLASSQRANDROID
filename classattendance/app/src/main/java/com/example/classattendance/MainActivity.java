package com.example.classattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginFormActivityListener,WelcomeFragment.OnLogoutListener{

    public static  PrefConfig prefConfig;
    public static  ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefConfig=new PrefConfig(this);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            if(prefConfig.readLoginStatus()){
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new WelcomeFragment()).commit();
            }
            else {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new LoginFragment()).commit();
            }
        }
    }

    @Override
    public void performRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationFragment()).addToBackStack(null).commit();
    }

    @Override
    public void performLoginact(String name) {

        prefConfig.writeName(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new WelcomeFragment()).commit();
    }

    @Override
    public void performLecLoginAct(String name) {
        prefConfig.writeName(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new WelcomeLecFragment()).commit();
    }

    @Override
    public void performAdminLoginAct(String name) {
        prefConfig.writeName(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AdminFragment()).commit();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void logoutPerformed() {
        prefConfig.writeLoginStatus(false);
        prefConfig.writeName("User");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LoginFragment()).commit();


}

    @Override
    public void mydetPerformed() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Mydetails()).commit();

    }

    @Override
    public void myUnits() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MyUnits()).commit();
    }

    @Override
    public void myAtt() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Myattendance()).commit();
    }

    @Override
    public void Scancode() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Scanqr()).commit();
    }


}

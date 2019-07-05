package com.example.classattendance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {

    RelativeLayout myDetails,myUnits,myAtt,Scancode;
    private TextView textView;
    private Button btnlogout;

    OnLogoutListener logoutListener;
    public interface OnLogoutListener{
        public  void logoutPerformed();
        public void mydetPerformed();
        public void myUnits();
        public void myAtt();
        public void Scancode();


    }

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_welcome,container, false);
        textView=view.findViewById(R.id.welc);
        textView.setText("Welcome " +MainActivity.prefConfig.readName());
        btnlogout=view.findViewById(R.id.logoutbutton);
        myDetails=view.findViewById(R.id.rellay_Mydet);
        myUnits=view.findViewById(R.id.rellay_myunits);
        myAtt=view.findViewById(R.id.rellay_Myatt);
        Scancode=view.findViewById(R.id.rellay_qr);


        myDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutListener.mydetPerformed();
            }
        });
        myUnits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutListener.myUnits();
            }
        });
        myAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutListener.myAtt();
            }
        });
        Scancode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutListener.Scancode();
            }
        });




        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutListener.logoutPerformed();
            }
        });
        return view;
    }



    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity=(Activity) context;
        logoutListener=(OnLogoutListener) activity;

    }


}

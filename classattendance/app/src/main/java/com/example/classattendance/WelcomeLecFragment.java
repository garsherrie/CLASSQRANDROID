package com.example.classattendance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeLecFragment extends Fragment {
    private TextView textView;

    public WelcomeLecFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_welcome_lec,container, false);
        textView=view.findViewById(R.id.welclec);
        textView.setText("Welcome " +MainActivity.prefConfig.readName());
        return view;
    }

}

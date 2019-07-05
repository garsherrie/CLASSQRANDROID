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
public class Mydetails extends Fragment {
    private TextView textView;

    public Mydetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mydetails,container, false);
        textView=view.findViewById(R.id.mydet);
        textView.setText(MainActivity.prefConfig.readName()+" details");
        return view;
    }

}

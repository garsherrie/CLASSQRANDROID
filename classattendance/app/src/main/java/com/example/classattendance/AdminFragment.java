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
public class AdminFragment extends Fragment {
    private TextView textView;

    public AdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_admin,container, false);
        textView=view.findViewById(R.id.welcadm);
        textView.setText("Welcome admin " +MainActivity.prefConfig.readName());
        return view;
    }

}

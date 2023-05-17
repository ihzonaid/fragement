package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BmiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BmiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BmiFragment() {
        // Required empty public constructor


    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BmiFragment.
     */

    // TODO: Rename and change types and number of parameters
    public static BmiFragment newInstance(String param1, String param2) {
        BmiFragment fragment = new BmiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    View myView;
    EditText weight, height;
    TextView result;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_bmi, container, false);

        weight = myView.findViewById(R.id.weightEditText);
        height = myView.findViewById(R.id.heightEditText);
        result = myView.findViewById(R.id.bmi_result);
        button = myView.findViewById(R.id.bmiButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBmi(view);
            }
        });
        return myView;
    }

    public  void calculateBmi(View view) {
        double height_value = Double.parseDouble(height.getText().toString());
        double weight_value = Double.parseDouble(weight.getText().toString());
        double  res = height_value / (weight_value * weight_value);
        result.setText("Your BMI is: "+  res);

    }
}
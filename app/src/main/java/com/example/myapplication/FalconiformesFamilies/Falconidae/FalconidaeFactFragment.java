package com.example.myapplication.FalconiformesFamilies.Falconidae;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.FalconiformesFamilies.Falconidae.FalconidaeFactFragment;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FalconidaeFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FalconidaeFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FalconidaeFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FalconidaeFactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FalconidaeFactFragment newInstance(String param1, String param2) {
        FalconidaeFactFragment fragment = new FalconidaeFactFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_falconidae_fact, container, false);

        ImageView closeImageView = rootView.findViewById(R.id.iv_close);
        TextView fact = rootView.findViewById(R.id.tv_fact);
        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the current fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(FalconidaeFactFragment.this).commit();
            }
        });

        Bundle args = getArguments();
        String data = args.getString("iFact");
        fact.setText(data);
        return rootView;
    }

    public static FalconidaeFactFragment newInstance(String data) {
        FalconidaeFactFragment fragment = new FalconidaeFactFragment();
        Bundle args = new Bundle();
        args.putString("iFact", data);
        fragment.setArguments(args);
        return fragment;
    }
}
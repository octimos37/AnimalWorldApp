package com.example.myapplication.PasseriformesFamilies.Turdidae;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.PasseriformesFamilies.Turdidae.TurdidaeFactFragment;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TurdidaeFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TurdidaeFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TurdidaeFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TurdidaeFactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TurdidaeFactFragment newInstance(String param1, String param2) {
        TurdidaeFactFragment fragment = new TurdidaeFactFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_turdidae_fact, container, false);

        ImageView closeImageView = rootView.findViewById(R.id.iv_close);
        TextView fact = rootView.findViewById(R.id.tv_fact);
        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the current fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(TurdidaeFactFragment.this).commit();
            }
        });

        Bundle args = getArguments();
        String data = args.getString("iFact");
        fact.setText(data);
        return rootView;
    }

    public static TurdidaeFactFragment newInstance(String data) {
        TurdidaeFactFragment fragment = new TurdidaeFactFragment();
        Bundle args = new Bundle();
        args.putString("iFact", data);
        fragment.setArguments(args);
        return fragment;
    }
}
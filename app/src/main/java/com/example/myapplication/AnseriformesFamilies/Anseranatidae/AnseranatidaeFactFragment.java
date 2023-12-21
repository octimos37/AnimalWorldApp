package com.example.myapplication.AnseriformesFamilies.Anseranatidae;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnseranatidaeFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnseranatidaeFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnseranatidaeFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnseranatidaeFactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnseranatidaeFactFragment newInstance(String param1, String param2) {
        AnseranatidaeFactFragment fragment = new AnseranatidaeFactFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_anseranatidae_fact, container, false);

        ImageView closeImageView = rootView.findViewById(R.id.iv_close);
        TextView fact = rootView.findViewById(R.id.tv_fact);
        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the current fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(AnseranatidaeFactFragment.this).commit();
            }
        });

        Bundle args = getArguments();
        String data = args.getString("iFact");
        fact.setText(data);
        return rootView;
    }

    public static AnseranatidaeFactFragment newInstance(String data) {
        AnseranatidaeFactFragment fragment = new AnseranatidaeFactFragment();
        Bundle args = new Bundle();
        args.putString("iFact", data);
        fragment.setArguments(args);
        return fragment;
    }
}
package com.example.myapplication.Birds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Mammals.LearnMammalsFragment;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearnBirdsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearnBirdsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearnBirdsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearnBirdsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearnBirdsFragment newInstance(String param1, String param2) {
        LearnBirdsFragment fragment = new LearnBirdsFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_learn_birds, container, false);


        TextView learn = rootView.findViewById(R.id.tv_learn);

        Bundle args = getArguments();
        String data = args.getString("descriptionClass");
        learn.setText(data);
        return rootView;
    }

    public static LearnBirdsFragment newInstance(String data) {
        LearnBirdsFragment fragment = new LearnBirdsFragment();
        Bundle args = new Bundle();
        args.putString("descriptionClass", data);
        fragment.setArguments(args);
        return fragment;
    }
}

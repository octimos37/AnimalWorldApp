package com.example.myapplication.CarnivoraFamilies.Canidae;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanidaeVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanidaeVideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CanidaeVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CanidaeVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CanidaeVideoFragment newInstance(String param1, String param2) {
        CanidaeVideoFragment fragment = new CanidaeVideoFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_canidae_video, container, false);

        ImageView close = rootView.findViewById(R.id.iv_close);
        VideoView video = rootView.findViewById(R.id.vv_video);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(CanidaeVideoFragment.this).commit();
            }
        });

        Bundle args = getArguments();
        String data = args.getString("AnimalVideo");
        video.setVideoPath(data);
        video.start();

        return rootView;
    }

    public static CanidaeVideoFragment newInstance(String data) {
        CanidaeVideoFragment fragment = new CanidaeVideoFragment();
        Bundle args = new Bundle();
        args.putString("AnimalVideo", data);
        fragment.setArguments(args);
        return fragment;
    }
}
package com.example.myapplication.LepidopteraFamilies.Papilionidae;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.myapplication.LepidopteraFamilies.Papilionidae.PapilionidaeVideoFragment;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PapilionidaeVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PapilionidaeVideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PapilionidaeVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PapilionidaeVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PapilionidaeVideoFragment newInstance(String param1, String param2) {
        PapilionidaeVideoFragment fragment = new PapilionidaeVideoFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_papilionidae_video, container, false);

        ImageView close = rootView.findViewById(R.id.iv_close);
        VideoView video = rootView.findViewById(R.id.vv_video);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(PapilionidaeVideoFragment.this).commit();
            }
        });

        Bundle args = getArguments();
        String data = args.getString("AnimalVideo");
        video.setVideoPath(data);
        video.start();

        return rootView;
    }

    public static PapilionidaeVideoFragment newInstance(String data) {
        PapilionidaeVideoFragment fragment = new PapilionidaeVideoFragment();
        Bundle args = new Bundle();
        args.putString("AnimalVideo", data);
        fragment.setArguments(args);
        return fragment;
    }
}
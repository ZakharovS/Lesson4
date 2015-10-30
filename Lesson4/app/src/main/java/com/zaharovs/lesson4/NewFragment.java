package com.zaharovs.lesson4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 555 on 28.10.2015.
 */
public class NewFragment extends Fragment {

    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        Bundle bundle = this.getArguments();
        String text = bundle.getString("RESULT");
        ((TextView) view.findViewById(R.id.textShow)).setText(text.toString());
        return view;
    }

}

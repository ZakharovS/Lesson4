package com.zaharovs.lesson4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 555 on 28.10.2015.
 */
public class MainFragment extends Fragment {

    private Button next;
    private Button previous;

    private WorkInterface workInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            workInterface = (WorkInterface) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString() + " Must implement MakeWorkInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        next = (Button) view.findViewById(R.id.next);
        previous = (Button) view.findViewById(R.id.previous);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workInterface.showNext();
            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workInterface.showPrevious();
            }
        });

    }
}


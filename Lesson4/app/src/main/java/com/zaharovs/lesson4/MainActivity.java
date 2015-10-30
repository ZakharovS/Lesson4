package com.zaharovs.lesson4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class MainActivity extends BaseActivity implements WorkInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    boolean isAddFragment() {
        return true;
    }

    @Override
    void addFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.mainActivity, new MainFragment()).commit();
    }

    @Override
    public void showNext() {
        Fragment newFragment = new NewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("RESULT", "Next");
        newFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, newFragment).addToBackStack(null).commit();
    }

    @Override
    public void showPrevious() {
        Fragment newFragment = new NewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("RESULT", "Previous");
        newFragment.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainFragment, newFragment).addToBackStack(null).commit();
    }
}

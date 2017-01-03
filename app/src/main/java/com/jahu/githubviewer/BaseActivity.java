package com.jahu.githubviewer;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

  protected void showFragment(int containerId, Fragment fragment) {
    getSupportFragmentManager()
        .beginTransaction()
        .add(containerId, fragment)
        .commit();
  }

}

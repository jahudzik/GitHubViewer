package com.jahu.githubviewer.userdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.jahu.githubviewer.BaseActivity;
import com.jahu.githubviewer.R;
import com.jahu.githubviewer.data.users.User;

public class UserDetailsActivity extends BaseActivity {

    public static final String BUNDLE_USER = "bundle_user";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        UserDetailsFragment fragment = (UserDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.user_details_container);
        if (fragment == null) {
            User user = (User) getIntent().getSerializableExtra(BUNDLE_USER);
            fragment = UserDetailsFragment.newInstance(user);
            showFragment(R.id.user_details_container, fragment);
        }
    }

}

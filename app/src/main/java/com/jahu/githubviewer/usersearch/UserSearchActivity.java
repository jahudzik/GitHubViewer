package com.jahu.githubviewer.usersearch;


import android.os.Bundle;
import android.support.annotation.Nullable;
import com.jahu.githubviewer.BaseActivity;
import com.jahu.githubviewer.Injection;
import com.jahu.githubviewer.R;

public class UserSearchActivity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_search);
    UserSearchFragment fragment = (UserSearchFragment) getSupportFragmentManager().findFragmentById(R.id.user_search_container);
    if (fragment == null) {
      fragment = UserSearchFragment.newInstance();
      showFragment(R.id.user_search_container, fragment);
    }
    new UserSearchPresenter(fragment, Injection.provideUserDataSource());
  }

}

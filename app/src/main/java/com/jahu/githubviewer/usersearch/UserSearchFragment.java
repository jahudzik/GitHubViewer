package com.jahu.githubviewer.usersearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jahu.githubviewer.BasePresenter;
import com.jahu.githubviewer.R;
import com.jahu.githubviewer.data.users.User;

public class UserSearchFragment extends Fragment implements UserSearchContract.View {

  @BindView(R.id.account_name_input)
  EditText accountNameEditText;

  @BindView(R.id.search_account_loading)
  ProgressBar loadingProgressBar;

  private UserSearchContract.Presenter presenter;

  public static UserSearchFragment newInstance() {
    return new UserSearchFragment();
  }

  @Override
  public void setPresenter(BasePresenter presenter) {
    this.presenter = (UserSearchContract.Presenter) presenter;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_user_search, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @OnClick(R.id.search_account_button)
  public void onSearchAccountButtonClick() {
    String userName = accountNameEditText.getText().toString();
    presenter.findUser(userName);
  }

  @Override
  public void showLoading() {
    loadingProgressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void stopLoading() {
    loadingProgressBar.setVisibility(View.GONE);
  }

  @Override
  public void showError(String errorMessage) {
    Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
  }

  @Override
  public void showUserDetails(String message, User user) {
    Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
  }
}

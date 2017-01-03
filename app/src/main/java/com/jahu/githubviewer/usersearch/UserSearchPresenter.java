package com.jahu.githubviewer.usersearch;

import com.jahu.githubviewer.BasePresenter;
import com.jahu.githubviewer.data.users.User;
import com.jahu.githubviewer.data.users.UsersDataSource;

class UserSearchPresenter implements BasePresenter, UserSearchContract.Presenter, UsersDataSource.FindUserCallback {

  private UserSearchContract.View view;
  private UsersDataSource usersDataSource;

  UserSearchPresenter(UserSearchContract.View view, UsersDataSource usersDataSource) {
    this.view = view;
    this.view.setPresenter(this);
    this.usersDataSource = usersDataSource;
  }

  @Override
  public void start() {}

  @Override
  public void findUser(String username) {
    if (username == null || username.isEmpty()) {
      view.showError("User name cannot be empty");
    } else {
      view.showLoading();
      usersDataSource.findUser(username, this);
    }
  }

  @Override
  public void onUserFound(User user) {
    view.stopLoading();
    view.showUserDetails("User found: " + user.getName(), user);
  }

  @Override
  public void onUserNotFound() {
    view.stopLoading();
    view.showError("User not found");
  }

  @Override
  public void onError(String errorMessage) {
    view.stopLoading();
    view.showError(errorMessage);
  }

}

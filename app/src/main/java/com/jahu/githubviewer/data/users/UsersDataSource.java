package com.jahu.githubviewer.data.users;

public interface UsersDataSource {

  void findUser(String username, FindUserCallback callback);

  interface FindUserCallback {

    void onUserFound(User user);

    void onUserNotFound();

    void onError(String errorMessage);

  }

}

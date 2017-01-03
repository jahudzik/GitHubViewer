package com.jahu.githubviewer;

import com.jahu.githubviewer.data.users.UsersDataSource;
import com.jahu.githubviewer.data.users.UsersTestRepository;

public class Injection {

  private static UsersDataSource usersDataSource;

  public static UsersDataSource provideUserDataSource() {
    if (usersDataSource == null) {
      usersDataSource = new UsersTestRepository();
    }
    return usersDataSource;
  }

}

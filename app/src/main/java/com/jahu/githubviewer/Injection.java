package com.jahu.githubviewer;

import com.jahu.githubviewer.data.GitHubRepository;
import com.jahu.githubviewer.data.users.UsersDataSource;

public class Injection {

    private static UsersDataSource usersDataSource;

    public static UsersDataSource provideUserDataSource() {
        if (usersDataSource == null) {
            usersDataSource = new GitHubRepository();
        }
        return usersDataSource;
    }

}

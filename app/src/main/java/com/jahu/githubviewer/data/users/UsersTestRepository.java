package com.jahu.githubviewer.data.users;

import android.os.Handler;
import java.util.Date;

public class UsersTestRepository implements UsersDataSource {

    private static final int LOADING_TIMEOUT = 1000;

    @Override
    public void findUser(final String username, final FindUserCallback callback) {
        new Handler().postDelayed(() -> userSearch(username, callback), LOADING_TIMEOUT);
    }

    private void userSearch(String username, FindUserCallback callback) {
        switch (username) {
            case "john":
                callback.onUserFound(new User("John Blacksmith", "jb", "", "Stanley", "New York", 1, new Date(2010, 3, 1), 4));
                break;
            case "mary":
                callback.onUserFound(new User("Mary Adams", "mary", "", "HB", "Haiti", 14, new Date(2014, 6, 11), 0));
                break;
            case "error":
                callback.onError("Some error");
                break;
            default:
                callback.onUserNotFound();
        }
    }

}

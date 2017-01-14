package com.jahu.githubviewer.usersearch;

import com.jahu.githubviewer.BaseView;
import com.jahu.githubviewer.data.users.User;

interface UserSearchContract {

    interface View extends BaseView {

        void showLoading();

        void stopLoading();

        void showError(String errorMessage);

        void showUserDetails(String message, User user);

    }

    interface Presenter {

        void findUser(String username);

    }

}

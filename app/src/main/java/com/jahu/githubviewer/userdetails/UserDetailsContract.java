package com.jahu.githubviewer.userdetails;

import com.jahu.githubviewer.BaseView;

public class UserDetailsContract {

    interface View extends BaseView {

        void showLoadingAvatar();

        void showAvatar();

    }

    interface Presenter {

        void getRepositories();

    }

}

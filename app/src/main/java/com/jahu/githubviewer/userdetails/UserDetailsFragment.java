package com.jahu.githubviewer.userdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jahu.githubviewer.R;
import com.jahu.githubviewer.data.users.User;

public class UserDetailsFragment extends Fragment {

    @BindView(R.id.user_name)
    TextView userNameView;
    @BindView(R.id.user_company)
    TextView userCompanyView;
    @BindView(R.id.user_location)
    TextView userLocationView;

    public static UserDetailsFragment newInstance(User user) {
        UserDetailsFragment fragment = new UserDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UserDetailsActivity.BUNDLE_USER, user);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_user_details, container, false);
        ButterKnife.bind(this, view);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(UserDetailsActivity.BUNDLE_USER)) {
            User user = (User) arguments.getSerializable(UserDetailsActivity.BUNDLE_USER);
            if (user != null) {
                userNameView.setText(user.getName());
                userCompanyView.setText(user.getCompany());
                userLocationView.setText(user.getLocation());
            }
        }

        return view;
    }
}

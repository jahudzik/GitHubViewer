package com.jahu.githubviewer.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jahu.githubviewer.data.users.User;
import com.jahu.githubviewer.data.users.UsersDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import timber.log.Timber;

public class GitHubRepository implements UsersDataSource {

    private final GitHubApi gitHubApi;

    public GitHubRepository() {
        Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GitHubApi.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
        gitHubApi = retrofit.create(GitHubApi.class);
    }

    @Override
    public void findUser(String username, FindUserCallback callback) {
        gitHubApi.getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    callback.onUserFound(response.body());
                } else {
                    callback.onUserNotFound();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                Timber.e("Failed to get the user", throwable);
                callback.onError(throwable.getMessage());
            }
        });
    }

    interface GitHubApi {

        String ENDPOINT = "https://api.github.com";

        @GET("/users/{username}")
        Call<User> getUser(@Path("username") String username);

    }

}

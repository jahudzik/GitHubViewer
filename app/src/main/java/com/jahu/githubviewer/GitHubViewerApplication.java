package com.jahu.githubviewer;

import android.app.Application;
import timber.log.Timber;


public class GitHubViewerApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}

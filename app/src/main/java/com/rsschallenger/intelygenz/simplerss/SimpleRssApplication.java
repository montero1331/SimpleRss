package com.rsschallenger.intelygenz.simplerss;

import android.app.Application;

import com.rsschallenger.intelygenz.sharedresources.dependency.DependencyManager;
import com.rsschallenger.intelygenz.simplerss.dependencyStarter.AppDependency;
import com.rsschallenger.intelygenz.simplerss.dependencyStarter.SharedDependency;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class SimpleRssApplication extends Application {

    @Override
    public void onCreate() {
        DependencyManager.initializeApp(new AppDependency(this), new SharedDependency());
    }

}

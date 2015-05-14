package com.rsschallenger.intelygenz.simplerss.dependencyStarter;

import android.content.Context;

import com.rsschallenger.intelygenz.simplerss.SimpleRssApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Luis on 14/05/2015.
 */
import dagger.Module;
import dagger.Provides;

@Module(injects = {Context.class})
public class AppDependency {


    private SimpleRssApplication app;

    public AppDependency(SimpleRssApplication app) {
        this.app = app;
    }

    @Provides
    public Context provideAppContext() {
        return app;
    }
}


package com.rsschallenger.intelygenz.simplerss.dependencyStarter;

import android.content.Context;

import com.rsschallenger.intelygenz.database.DataBaseHelper;
import com.rsschallenger.intelygenz.network.Network;
import com.rsschallenger.intelygenz.sharedresources.linker.DataBaseManager;
import com.rsschallenger.intelygenz.sharedresources.linker.VolleyManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Luis on 14/05/2015.
 */
@Module(injects = {DataBaseManager.class, VolleyManager.class}, complete = false)
public class SharedDependency {

    @Provides
    @Singleton
    public DataBaseManager getDataBaseManager(Context context) {
        return new DataBaseHelper(context);
    }

    @Provides
    @Singleton
    public VolleyManager getVolleyManager(Context context) {
        return new Network(context);
    }
}


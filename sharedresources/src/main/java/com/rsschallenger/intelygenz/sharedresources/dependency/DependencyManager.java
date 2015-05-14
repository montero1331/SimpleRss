package com.rsschallenger.intelygenz.sharedresources.dependency;

import dagger.ObjectGraph;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class DependencyManager {

    private static ObjectGraph dependencyManager;

    public static void initializeApp(Object... dependecies) {
        dependencyManager = ObjectGraph.create(dependecies);
    }

    public static ObjectGraph getInjector() {
        return dependencyManager;
    }

}

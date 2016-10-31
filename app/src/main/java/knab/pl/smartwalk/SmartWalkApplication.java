package knab.pl.smartwalk;


import android.app.Application;

import javax.inject.Inject;

import knab.pl.smartwalk.dagger.DaggerRuntimeSmartWalkComponent;
import knab.pl.smartwalk.dagger.DependencyInjector;
import knab.pl.smartwalk.dagger.RuntimeAppModule;
import knab.pl.smartwalk.dagger.SmartWalkComponent;

public class SmartWalkApplication extends Application {

    private SmartWalkComponent smartWalkComponent;

    @Inject
    DependencyInjector dependencyInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        smartWalkComponent = DaggerRuntimeSmartWalkComponent.builder()
                .runtimeAppModule(new RuntimeAppModule(this))
                .build();
        smartWalkComponent.inject(this);

    }

    public SmartWalkComponent getSmartWalkComponent() {
        return smartWalkComponent;
    }


    public DependencyInjector provideDependencyInjector() {
        return dependencyInjector;
    }
}

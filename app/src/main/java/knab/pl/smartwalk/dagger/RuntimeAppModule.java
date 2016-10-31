package knab.pl.smartwalk.dagger;


import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SignalAdapter;

@Module
public class RuntimeAppModule implements AppModule {

    private SmartWalkApplication application;

    public RuntimeAppModule(SmartWalkApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @Override
    public Application providesApplication() {
        return application;
    }

    @Override
    @Provides
    @Singleton
    public SmartWalkApplication providesSmartWalkApplication() {
        return application;
    }

    @Override
    @Provides
    @Singleton
    public SignalAdapter providesSignalAdapter() {
        return new SignalAdapter();
    }

    @Override
    @Provides
    @Singleton
    public DependencyInjector providesDependencyInjector() {
        return new RuntimeDependencyInjector();
    }
}

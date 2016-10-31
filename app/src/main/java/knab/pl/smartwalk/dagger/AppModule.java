package knab.pl.smartwalk.dagger;


import android.app.Application;

import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SignalAdapter;

public interface AppModule {

    SmartWalkApplication providesSmartWalkApplication();

    SignalAdapter providesSignalAdapter();
    Application providesApplication();
    DependencyInjector providesDependencyInjector();
}

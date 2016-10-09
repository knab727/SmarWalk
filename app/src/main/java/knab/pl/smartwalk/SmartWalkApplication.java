package knab.pl.smartwalk;


import android.app.Application;

import knab.pl.smartwalk.dagger.AppModule;
import knab.pl.smartwalk.dagger.DaggerSignalComponent;
import knab.pl.smartwalk.dagger.SignalComponent;
import knab.pl.smartwalk.dagger.SignalModule;

public class SmartWalkApplication extends Application {

    private SignalComponent signalComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        signalComponent = DaggerSignalComponent.builder()
                .appModule(new AppModule(this))
                .signalModule(new SignalModule())
                .build();

    }

    public SignalComponent getSignalComponent() {
        return signalComponent;
    }
}

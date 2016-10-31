package knab.pl.smartwalk.dagger;


import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SignalAdapter;

public interface SmartWalkComponent {
    void inject(SmartWalkApplication smartWalkApplication);

    SignalAdapter provideSignalAdapter();
}

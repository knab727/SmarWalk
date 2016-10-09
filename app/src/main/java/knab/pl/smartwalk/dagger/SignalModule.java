package knab.pl.smartwalk.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import knab.pl.smartwalk.model.SignalAdapter;

@Module
public class SignalModule {

    @Provides
    @Singleton
    SignalAdapter providesSignalAdapter() {
        return new SignalAdapter();
    }
}

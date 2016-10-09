package knab.pl.smartwalk.dagger;

import javax.inject.Singleton;

import dagger.Component;
import knab.pl.smartwalk.ui.MainActivity;
import knab.pl.smartwalk.ui.fragments.GoniometerFragment;
import knab.pl.smartwalk.ui.fragments.SoleSensorGraphFragment;
import knab.pl.smartwalk.ui.fragments.SolesFragment;

@Singleton
@Component(modules = {AppModule.class, SignalModule.class})
public interface SignalComponent {
    void inject(MainActivity mainActivity);
    void inject(GoniometerFragment goniometerFragment);
    void inject(SoleSensorGraphFragment soleSensorGraphFragment);
    void inject(SolesFragment solesFragment);
}

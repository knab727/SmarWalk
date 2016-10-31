package knab.pl.smartwalk.dagger;


import knab.pl.smartwalk.ui.fragments.goniometer.GoniometerFragment;
import knab.pl.smartwalk.ui.fragments.soles.SolesFragment;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.SoleSensorGraphFragment;

public interface DependencyInjector {

    void inject(SoleSensorGraphFragment soleSensorGraphFragment);
    void inject(GoniometerFragment goniometerFragment);
    void inject(SolesFragment solesFragment);

}

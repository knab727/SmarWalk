package knab.pl.smartwalk.dagger;


import android.app.Activity;
import android.support.v4.app.Fragment;


import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.ui.fragments.goniometer.GoniometerFragment;
import knab.pl.smartwalk.ui.fragments.goniometer.dagger.DaggerRuntimeGoniometerFragmentComponent;
import knab.pl.smartwalk.ui.fragments.goniometer.dagger.RuntimeGoniometerFragmentModule;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.dagger.DaggerRuntimeSoleSensorFragmentComponent;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.dagger.RuntimeSoleSensorGraphFragmentModule;
import knab.pl.smartwalk.ui.fragments.soles.SolesFragment;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.SoleSensorGraphFragment;
import knab.pl.smartwalk.ui.fragments.soles.dagger.DaggerRuntimeSolesFragmentComponent;
import knab.pl.smartwalk.ui.fragments.soles.dagger.RuntimeSolesFragmentModule;

public class RuntimeDependencyInjector implements DependencyInjector {

    @Override
    public void inject(SoleSensorGraphFragment soleSensorGraphFragment) {
        DaggerRuntimeSoleSensorFragmentComponent.builder()
                .smartWalkComponent(getSmartWalkComponent(soleSensorGraphFragment))
                .runtimeSoleSensorGraphFragmentModule(new RuntimeSoleSensorGraphFragmentModule(soleSensorGraphFragment))
                .build()
                .inject(soleSensorGraphFragment);
    }

    @Override
    public void inject(GoniometerFragment goniometerFragment) {
        DaggerRuntimeGoniometerFragmentComponent.builder()
                .smartWalkComponent(getSmartWalkComponent(goniometerFragment))
                .runtimeGoniometerFragmentModule(new RuntimeGoniometerFragmentModule())
                .build()
                .inject(goniometerFragment);
    }

    @Override
    public void inject(SolesFragment solesFragment) {
        DaggerRuntimeSolesFragmentComponent.builder()
                .smartWalkComponent(getSmartWalkComponent(solesFragment))
                .runtimeSolesFragmentModule(new RuntimeSolesFragmentModule())
                .build()
                .inject(solesFragment);
    }

    private SmartWalkComponent getSmartWalkComponent(Activity activity) {
        return ((SmartWalkApplication) activity.getApplication()).getSmartWalkComponent();
    }

    private SmartWalkComponent getSmartWalkComponent(Fragment fragment) {
        return ((SmartWalkApplication) fragment.getActivity().getApplication()).getSmartWalkComponent();
    }
}

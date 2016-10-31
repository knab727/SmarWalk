package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.dagger;

import dagger.Component;
import knab.pl.smartwalk.dagger.SmartWalkComponent;
import knab.pl.smartwalk.dagger.scopes.ActivityScope;

@ActivityScope
@Component(modules = RuntimeSoleSensorGraphFragmentModule.class, dependencies = SmartWalkComponent.class)
public interface RuntimeSoleSensorFragmentComponent extends SoleSensorGraphFragmentComponent{
}

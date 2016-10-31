package knab.pl.smartwalk.ui.fragments.goniometer.dagger;

import dagger.Component;
import knab.pl.smartwalk.dagger.SmartWalkComponent;
import knab.pl.smartwalk.dagger.scopes.ActivityScope;

@ActivityScope
@Component(modules = RuntimeGoniometerFragmentModule.class, dependencies = SmartWalkComponent.class)
public interface RuntimeGoniometerFragmentComponent extends GoniometerFragmentComponent{
}

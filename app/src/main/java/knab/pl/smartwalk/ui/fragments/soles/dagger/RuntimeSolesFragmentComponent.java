package knab.pl.smartwalk.ui.fragments.soles.dagger;

import dagger.Component;
import knab.pl.smartwalk.dagger.SmartWalkComponent;
import knab.pl.smartwalk.dagger.scopes.ActivityScope;

@ActivityScope
@Component(modules = RuntimeSolesFragmentModule.class, dependencies = SmartWalkComponent.class)
public interface RuntimeSolesFragmentComponent extends SolesFragmentComponent {
}

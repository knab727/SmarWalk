package knab.pl.smartwalk.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RuntimeAppModule.class})
public interface RuntimeSmartWalkComponent extends SmartWalkComponent {
}

package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.dagger;

import dagger.Module;
import dagger.Provides;
import knab.pl.smartwalk.dagger.scopes.ActivityScope;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphMVP;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphModel;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphPresenter;

@Module
public class RuntimeSoleSensorGraphFragmentModule implements SoleSensorGraphFragmentModule {

    private SoleSensorGraphMVP.View view;

    public RuntimeSoleSensorGraphFragmentModule(SoleSensorGraphMVP.View view) {
        this.view = view;
    }

    @Override
    @Provides
    @ActivityScope
    public SoleSensorGraphMVP.Presenter provideSoleSensorGraphPresenter(SoleSensorGraphModel model) {
        return new SoleSensorGraphPresenter(model, view);
    }
}

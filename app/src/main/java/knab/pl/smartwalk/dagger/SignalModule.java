package knab.pl.smartwalk.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import knab.pl.smartwalk.model.SignalAdapter;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphMVP;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphModel;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphPresenter;

@Module
public class SignalModule {

    private SoleSensorGraphMVP.View soleGraphView;

    public SignalModule(SoleSensorGraphMVP.View soleGraphView) {
        this.soleGraphView = soleGraphView;
    }

    @Provides
    @Singleton
    public SignalAdapter providesSignalAdapter() {
        return new SignalAdapter();
    }

    @Provides
    @Singleton
    public SoleSensorGraphMVP.Presenter provideSoleSensorGraphPresenter(SoleSensorGraphModel model,
                                                                        SoleSensorGraphMVP.View view){
        return new SoleSensorGraphPresenter(model, view);
    }
}

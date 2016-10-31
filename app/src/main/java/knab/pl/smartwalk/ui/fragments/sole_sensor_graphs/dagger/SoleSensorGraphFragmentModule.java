package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.dagger;


import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphMVP;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphModel;

public interface SoleSensorGraphFragmentModule {

    SoleSensorGraphMVP.Presenter provideSoleSensorGraphPresenter(SoleSensorGraphModel model);
}

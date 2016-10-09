package knab.pl.smartwalk.model;


public class SignalSampleSensorWrapper extends SignalSample {
    public String sensorName;

    public SignalSampleSensorWrapper(String sensorName) {
        this.sensorName = sensorName;
    }

    public SignalSampleSensorWrapper(String sensorName, long milis, int value) {
        this.value = value;
        this.milis = milis;
        this.sensorName = sensorName;
    }
}

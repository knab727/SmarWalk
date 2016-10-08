package knab.pl.smartwalk.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignalAdapter {
    private List<Message> rawSignal = new ArrayList<>();
    private Map<String, List<SignalSample>> sensorSignals = new HashMap<>();

    public void addMessage(Message message) {
        rawSignal.add(message);
        adapt(message);
    }

    private void adapt(Message message) {

    }

    public void clearAdapter() {
        rawSignal.clear();
        sensorSignals.clear();
    }

    public List<SignalSample> getSignalForSensor(String sensorName) {
        return sensorSignals.get(sensorName);
    }
}

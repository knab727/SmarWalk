package knab.pl.smartwalk.model;


import org.junit.Test;

import java.util.List;

import knab.pl.smartwalk.UnitTest;

import static knab.pl.smartwalk.model.SignalAdapterTestHelper.provideMessage;
import static org.junit.Assert.assertTrue;

public class SignalAdapterTest extends UnitTest {

    private SignalAdapter signalAdapter;

    @Override
    protected void onSetup() {
        signalAdapter = new SignalAdapter();
    }

    @Test
    public void testReceiveMessage() {
        List<SignalSampleSensorWrapper> message = provideMessage();
        for(SignalSampleSensorWrapper signal : message)
            signalAdapter.addMessage(signal);

        List<SignalSample> sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_TOP);
        assertTrue(sensorSignal.get(0).milis == message.get(0).milis);
        assertTrue(sensorSignal.get(0).value == message.get(0).value);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_ONE_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.get(1).milis);
        assertTrue(sensorSignal.get(0).value == message.get(1).value);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_ONE_INNER);
        assertTrue(sensorSignal.get(0).milis == message.get(2).milis);
        assertTrue(sensorSignal.get(0).value == message.get(2).value);

    }


}

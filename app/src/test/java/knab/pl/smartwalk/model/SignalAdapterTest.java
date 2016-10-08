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
        Message message = provideMessage();
        signalAdapter.addMessage(message);

        List<SignalSample> sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_TOP);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_top);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_ONE_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_1_outer);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_ONE_INNER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_1_inner);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_TWO_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_2_outer);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_TWO_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_2_inner);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_THREE_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_3_outer);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_THREE_INNER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_3_inner);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.LEFT_BOTTOM);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.left_bottom);

        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_TOP);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_top);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_ONE_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_1_outer);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_ONE_INNER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_1_inner);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_TWO_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_2_outer);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_TWO_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_2_inner);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_THREE_OUTER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_3_outer);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_THREE_INNER);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_3_inner);
        sensorSignal = signalAdapter.getSignalForSensor(SensorNames.RIGHT_BOTTOM);
        assertTrue(sensorSignal.get(0).milis == message.milis);
        assertTrue(sensorSignal.get(0).value == message.right_bottom);

    }


}

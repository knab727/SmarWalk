package knab.pl.smartwalk.model;


public class SignalSample {
    public long milis;
    public int value;

    public SignalSample() {
    }

    public SignalSample(long milis, int value) {
        this.milis = milis;
        this.value = value;
    }
}

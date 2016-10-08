package knab.pl.smartwalk.model;


public class SignalAdapterTestHelper {

    public static Message provideMessage() {
        Message message = new Message();
        message.milis = 1;
        message.left_top = 2;
        message.left_1_inner = 3;
        message.left_1_outer = 4;
        message.left_2_inner = 5;
        message.left_2_outer = 6;
        message.left_3_inner = 7;
        message.left_3_outer = 8;
        message.left_bottom = 9;

        message.right_top = 2;
        message.right_1_inner = 3;
        message.right_1_outer = 4;
        message.right_2_inner = 5;
        message.right_2_outer = 6;
        message.right_3_inner = 7;
        message.right_3_outer = 8;
        message.right_bottom = 9;
        return message;
    }
}

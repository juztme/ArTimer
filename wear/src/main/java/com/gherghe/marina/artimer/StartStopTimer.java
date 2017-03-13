package com.gherghe.marina.artimer;

import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

/**
 * Button listener for starting and stopping the usage of a {@link Vibrator}, respectively.
 *
 * @author Marina Gherghe
 */
public final class StartStopTimer implements View.OnClickListener {
    private static final long DELAY = 30000; // ms, 30 secs
    private static final long SHORT_VIBRATION = 150; // ms
    private static final long LONG_VIBRATION = 300; // ms
    private static final int DO_NOT_REPEAT = -1;
    private final Vibrator vibrator;
    private final long[] vibrationPattern;

    public StartStopTimer(Vibrator vibrator) {
        this.vibrator = vibrator;
        this.vibrationPattern = new long[]{DELAY, SHORT_VIBRATION, DELAY, LONG_VIBRATION};
    }

    @Override
    public void onClick(View v) {
        Button startStopButton = (Button) v;

        vibrator.vibrate(vibrationPattern, DO_NOT_REPEAT);

        if (startStopButton.getText().equals("Stop")) {
            vibrator.cancel();
            startStopButton.setText("Start");
        } else {
            startStopButton.setText("Stop");
        }
    }
}

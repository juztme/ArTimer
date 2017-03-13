package com.gherghe.marina.artimer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;

/**
 * @author Marina Gherghe
 */
public final class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_main);

        Button startStopButton = (Button) findViewById(R.id.startStopButton);
        StartStopTimer timerClickListener = new StartStopTimer((Vibrator) getSystemService(Context.VIBRATOR_SERVICE));
        startStopButton.setOnClickListener(timerClickListener);
    }
}

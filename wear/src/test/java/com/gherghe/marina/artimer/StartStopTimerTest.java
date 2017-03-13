package com.gherghe.marina.artimer;

import android.os.Vibrator;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Marina Gherghe
 */
public class StartStopTimerTest {
    private Vibrator vibrator;
    private StartStopTimer startStopTimer;
    private Button button;

    @Before
    public void setup() {
        vibrator = mock(Vibrator.class);
        startStopTimer = new StartStopTimer(vibrator);
        button = mock(Button.class);
    }

    @Test
    public void shouldChangeTextToStopOnStartButtonTap() {
        when(button.getText()).thenReturn("Start");
        startStopTimer.onClick(button);
        verify(button, times(1)).setText("Stop");
    }

    @Test
    public void shouldChangeTextToStartOnStopButtonTap() {
        when(button.getText()).thenReturn("Stop");
        startStopTimer.onClick(button);
        verify(button, times(1)).setText("Start");
    }

    @Test
    public void shouldCancelVibrationOnStopButtonTap() {
        when(button.getText()).thenReturn("Stop");
        startStopTimer.onClick(button);
        verify(vibrator, times(1)).cancel();
    }

    @Test
    public void shouldVibrateOnStartButtonTap() {
        int doNotRepeat = -1;
        when(button.getText()).thenReturn("Start");
        startStopTimer.onClick(button);
        verify(vibrator).vibrate(any(), eq(doNotRepeat));
    }
}
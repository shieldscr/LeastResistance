package com.shields.leastresistance;

import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LeastResistanceActivityTest {
    @Test
    public void leastResistanceActivityContainsRowInput() {
        LeastResistanceActivity activity = Robolectric.setupActivity(LeastResistanceActivity.class);
        View editTextFragment = activity.findViewById(R.id.row_input);
        assertNotNull(editTextFragment);
    }
}

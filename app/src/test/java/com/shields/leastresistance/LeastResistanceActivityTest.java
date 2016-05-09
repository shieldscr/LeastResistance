package com.shields.leastresistance;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LeastResistanceActivityTest {

    LeastResistanceActivity leastResistanceActivity;
    EditText editTextButton;
    Button runFlowButton;
    TextView outputText;

    @Before
    public void setUp() {
        leastResistanceActivity = Robolectric.setupActivity(LeastResistanceActivity.class);
        editTextButton = (EditText)leastResistanceActivity.findViewById(R.id.row_input);
        runFlowButton = (Button)leastResistanceActivity.findViewById(R.id.run_flow_button);
        outputText = (TextView)leastResistanceActivity.findViewById(R.id.text_output);
    }

    @Test
    public void leastResistanceActivityContainsRowInput() {
        assertNotNull(editTextButton);
    }

    @Test
    public void leastResistanceActivityContainsRunFlowButton() {
        assertNotNull(runFlowButton);
        assertEquals(runFlowButton.getText(), "Run Flow");
    }

    @Test
    public void leastResistanceActivityContainsTextOutput() {
        assertNotNull(outputText);
        assertEquals(outputText.getText(), "");
    }
}

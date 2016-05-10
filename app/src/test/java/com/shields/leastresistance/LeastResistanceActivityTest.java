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
    EditText editTextField;
    Button runFlowButton;
    TextView outputText;

    @Before
    public void setUp() {
        leastResistanceActivity = Robolectric.setupActivity(LeastResistanceActivity.class);
        editTextField = (EditText)leastResistanceActivity.findViewById(R.id.row_input);
        runFlowButton = (Button)leastResistanceActivity.findViewById(R.id.run_flow_button);
        outputText = (TextView)leastResistanceActivity.findViewById(R.id.text_output);
    }

    @Test
    public void leastResistanceActivityContainsRowInput() {
        assertNotNull(editTextField);
    }

    @Test
    public void leastResistanceActivityContainsRunFlowButton() {
        assertNotNull(runFlowButton);
        assertEquals("Run Flow", runFlowButton.getText());
    }

    @Test
    public void leastResistanceActivityContainsTextOutput() {
        assertNotNull(outputText);
        assertEquals("", outputText.getText());
    }

    @Test
    public void runFlowButtonReturnsErrorTextWhenPressedWithNoRow() {
        runFlowButton.performClick();
        assertEquals("Please enter grid", outputText.getText());
    }

    @Test
    public void runFlowButtonReturnsLengthErrorTextWhenPressedWithInvalidRowLength() {
        editTextField.setText("1 2 3");
        runFlowButton.performClick();
        assertEquals("Grid must be at least 5 columns long", outputText.getText());
    }

    @Test
    public void runFlowButtonReturnsSuccessfulFlowIndicatorWhenPressedWithValidRowLength() {
        editTextField.setText("1 2 3 4 5");
        runFlowButton.performClick();
        assertTrue(outputText.getText().toString().contains("Yes"));
    }

    @Test
    public void runFlowButtonReturnsTotalFlowCostWhenPressedWithValidRowLength() {
        editTextField.setText("1 2 3 4 5");
        runFlowButton.performClick();
        assertTrue(outputText.getText().toString().contains("15"));
    }

    @Test
    public void runFlowButtonReturnsPathTakenWhenPressedWithValidRowLength() {
        editTextField.setText("1 2 3 4 5");
        runFlowButton.performClick();
        assertTrue(outputText.getText().toString().contains("1 1 1 1 1"));
    }
}

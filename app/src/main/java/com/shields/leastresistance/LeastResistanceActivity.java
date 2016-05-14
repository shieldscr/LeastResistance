package com.shields.leastresistance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class LeastResistanceActivity extends AppCompatActivity {

    protected LeastResistance leastResistance;
    private EditText editTextField;
    private Button runFlowButton;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_least_resistance);

        editTextField = (EditText) findViewById(R.id.row_input);
        runFlowButton = (Button) findViewById(R.id.run_flow_button);
        outputText = (TextView) findViewById(R.id.text_output);

        runFlowButton.setOnClickListener(new RunFlowListener());
    }

    private class RunFlowListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String editTextFieldText = editTextField.getText().toString();
            if(!editTextFieldText.isEmpty()) {
                List<int[]> arrayList = buildLineIntegerList(editTextFieldText);
                int[][] inputList = build2dArray(arrayList);

                leastResistance = new LeastResistance(inputList);

                String message;
                try {
                    message = buildOutputMessage();
                } catch (ArrayIndexOutOfBoundsException exception) {
                    message = "Each must be at least 5 columns long";
                }

                outputText.setText(message);
            } else {
                outputText.setText("Please enter grid");
            }
        }

        private List<int[]> buildLineIntegerList(String editTextFieldText) {
            String[] lines = editTextFieldText.split("\n");

            List<int[]> arrayList = new ArrayList<>();
            for(String line : lines) {
                arrayList.add(getNumberArray(line));
            }
            return arrayList;
        }

        private int[][] build2dArray(List<int[]> arrayList) {
            return arrayList.toArray(new int[arrayList.size()][]);
        }

        private String buildOutputMessage() throws ArrayIndexOutOfBoundsException {
            String message;
            if (!leastResistance.isGridValid())
                message = "Grid must be at least 5 columns long";
            else {
                Integer resistance = leastResistance.findResistance();
                message = leastResistance.flowSucceeded() + "\n"
                        + resistance.toString() + "\n"
                        + leastResistance.getPathTaken();
            }
            return message;
        }

        private int[] getNumberArray(String line) {
            List<Integer> rowList = new ArrayList<>();

            for (String item : line.split(" ")) {
                rowList.add(Integer.parseInt(item));
            }

            return ArrayUtils.toPrimitive(rowList.toArray(new Integer[0]));
        }

    }
}

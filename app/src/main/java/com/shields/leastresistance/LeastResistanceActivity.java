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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_least_resistance);

        final EditText editTextField = (EditText)findViewById(R.id.row_input);
        final Button runFlowButton = (Button)findViewById(R.id.run_flow_button);
        final TextView outputText = (TextView)findViewById(R.id.text_output);

        runFlowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> rowList = new ArrayList<>();

                String editTextFieldText = editTextField.getText().toString();
                if(!editTextFieldText.isEmpty()) {
                    for (String item : editTextField.getText().toString().split(" ")) {
                        rowList.add(Integer.parseInt(item));
                    }

                    int[] input = ArrayUtils.toPrimitive(rowList.toArray(new Integer[0]));
                    int[][] inputList = new int[][]{input};

                    leastResistance = new LeastResistance(inputList);

                    String message = "";
                    if (!leastResistance.isGridValid())
                        message = "Grid must be at least 5 columns long";

                    outputText.setText(message);
                } else {
                    outputText.setText("Please enter grid");
                }
            }
        });
    }
}

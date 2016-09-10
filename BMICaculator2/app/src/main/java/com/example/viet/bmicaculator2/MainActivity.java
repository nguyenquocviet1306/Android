package com.example.viet.bmicaculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private EditText etWeight;
    private EditText etHeight;
    private Button btCaculatorBMI;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLayoutReferences();
        btCaculatorBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());
                float bmi = caculatorBMI(weight,height);
                tvResult.setText(String.format("Your BMI : %.0f - %s", bmi,showResult(bmi)));

                Log.d(TAG, String.format("btCaculatorBMI.onClick: %s %s",
                        etWeight.getText().toString(), etHeight.getText().toString()));
                Log.d(TAG, String.format("btCaculatorBMI.onClick : bmi = %f",bmi));
//                tvResult.setText(showResult(bmi));
            }
        });

    }

    float caculatorBMI(float weight, float height) {
        height = height / 100;
        return weight / ( height * height );
    }

    String showResult(float bmi) {
        if(bmi <16){
            return "Gầy";
        }else if(bmi< 18.5){
            return "Thiếu Cân";
        }else if(bmi<25){
            return "Cân đối";
        }else if(bmi<30){
            return "Hơi thừa cân";
        }else {
            return "Béo phì";
        }
    }

    void getLayoutReferences() {
        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);
        btCaculatorBMI = (Button) findViewById(R.id.btn_caclulate_bmi);
        tvResult = (TextView) findViewById(R.id.tv_bmi_result);
    }
}

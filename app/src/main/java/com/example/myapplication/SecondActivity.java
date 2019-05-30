package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.myapplication.FirstActivity.FIRST_DATA_KEY;

/**
 * @author jere
 */
public class SecondActivity extends AppCompatActivity {
    public static final String SECOND_DATA_KEY = "SECOND_DATA_KEY";
    private Intent mIntent;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mIntent = new Intent();

        Bundle bundle = getIntent().getExtras();
        String firstActivityData = bundle.getString(FIRST_DATA_KEY);

        TextView textView = findViewById(R.id.second_tv);
        textView.setText(firstActivityData);

        mEditText = findViewById(R.id.second_et);

        Button okBtn = findViewById(R.id.second_ok_btn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextString = mEditText.getText().toString();
                if (!TextUtils.isEmpty(editTextString)) {
                    mIntent.putExtra(SECOND_DATA_KEY, mEditText.getText().toString());
                    setResult(Activity.RESULT_OK, mIntent);
                    finish();
                }
            }
        });
    }
}

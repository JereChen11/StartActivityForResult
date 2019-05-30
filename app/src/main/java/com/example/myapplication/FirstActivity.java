package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.myapplication.SecondActivity.SECOND_DATA_KEY;

/**
 * @author jere
 */
public class FirstActivity extends AppCompatActivity {
    public static final String FIRST_DATA_KEY = "FIRST_DATA_KEY";
    private EditText mEditText;
    private Intent mIntent;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mTextView = findViewById(R.id.first_tv);
        mEditText = findViewById(R.id.first_et);

        mIntent = new Intent(this, SecondActivity.class);
        Button okBtn = findViewById(R.id.first_ok_btn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextString = mEditText.getText().toString();
                if (!TextUtils.isEmpty(editTextString)) {
                    mIntent.putExtra(FIRST_DATA_KEY, editTextString);
                    startActivityForResult(mIntent, 1);
                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra(SECOND_DATA_KEY);
                mTextView.setText(result);
            }
        }
    }

    public void hideKeyboardFrom() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

}

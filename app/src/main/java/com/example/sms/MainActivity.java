package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText msg;
    TextView byteCnt;
    Button btnSend;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (EditText) findViewById(R.id.msg);
        byteCnt = (TextView) findViewById(R.id.byteCnt);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnClose = (Button) findViewById(R.id.btnSend);

        msg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                InputFilter[] filter = new InputFilter[1];
                filter[0] = new InputFilter.LengthFilter(80);
                //쓸 수 있는 글자 수 최대 80자로 제한.
                msg.setFilters(filter);

                int currentBytes = s.toString().getBytes().length;
                String txt = String.valueOf(currentBytes) + "/80바이트";
                byteCnt.setText(txt);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void onButtonSend(View v){
        Toast.makeText(getApplicationContext(), (CharSequence) msg.getText(), Toast.LENGTH_LONG).show();
    }

    public void onButtonClose(View v){
        finish();
    }
}
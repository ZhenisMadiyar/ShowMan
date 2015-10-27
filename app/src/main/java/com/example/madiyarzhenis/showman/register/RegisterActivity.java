package com.example.madiyarzhenis.showman.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.madiyarzhenis.showman.R;

/**
 * Created by madiyarzhenis on 20.10.15.
 */
public class RegisterActivity extends Activity {
    Button nextBtn;
    EditText editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        nextBtn = (Button) findViewById(R.id.buttonNext);
        editTextPhone = (EditText) findViewById(R.id.editTextNumber);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, VerifyCode.class);
                intent.putExtra("phoneNumber", editTextPhone.getText().toString());
                startActivity(intent);
            }
        });

    }
}

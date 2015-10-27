package com.example.madiyarzhenis.showman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madiyarzhenis.showman.artist.ArtistMainTabActivity;
import com.example.madiyarzhenis.showman.customer.MainTabActivity;
import com.example.madiyarzhenis.showman.register.RegisterActivity;

/**
 * Created by madiyarzhenis on 20.10.15.
 */
public class LoginActivity extends Activity {
    TextView textViewRegister;
    Button loginBtn;
    EditText editTextPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        textViewRegister = (TextView) findViewById(R.id.textViewRegister);
        loginBtn = (Button) findViewById(R.id.buttonLogin);
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextPhoneNumber.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Number incorrect, please try again!", Toast.LENGTH_SHORT).show();
                } else {
                    if (Utils.getDefaults(LoginActivity.this, Utils.TAG_Name) != null) {
                        if (Utils.getTypeId(LoginActivity.this, Utils.TAG_Type_Id) == 1) {//ShowMan
                            Intent intent = new Intent(LoginActivity.this, ArtistMainTabActivity.class);
                            startActivity(intent);
                        } else {//Customer
                            Intent intent = new Intent(LoginActivity.this, MainTabActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Please first register!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}

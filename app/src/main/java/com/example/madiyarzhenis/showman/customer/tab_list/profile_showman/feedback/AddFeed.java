package com.example.madiyarzhenis.showman.customer.tab_list.profile_showman.feedback;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madiyarzhenis.showman.R;

/**
 * Created by madiyarzhenis on 22.10.15.
 */
public class AddFeed extends Activity {

    EditText editTextTitle;
    EditText editTextContent;
    Button addFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_feed);

        getActionBar().setTitle("Оставить отзыв");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextContent = (EditText) findViewById(R.id.editTextContent);
        addFeed = (Button) findViewById(R.id.buttonAddFeed);

        addFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editTextContent.getText().toString().equals("") && !editTextTitle.getText().toString().equals("")) {

                } else {
                    Toast.makeText(getApplicationContext(), "Загаловок или отзыв пусто!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();;
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        }
        return super.onOptionsItemSelected(item);
    }
}

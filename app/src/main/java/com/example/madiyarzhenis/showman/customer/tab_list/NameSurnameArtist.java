package com.example.madiyarzhenis.showman.customer.tab_list;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.madiyarzhenis.showman.R;

/**
 * Created by madiyarzhenis on 27.10.15.
 */
public class NameSurnameArtist extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_zayavka_name_surname);

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}

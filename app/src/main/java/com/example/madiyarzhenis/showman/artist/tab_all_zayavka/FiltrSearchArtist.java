package com.example.madiyarzhenis.showman.artist.tab_all_zayavka;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.madiyarzhenis.showman.MultiSpinner;
import com.example.madiyarzhenis.showman.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madiyarzhenis on 21.10.15.
 */
public class FiltrSearchArtist extends Activity implements MultiSpinner.MultiSpinnerListener {

    Spinner spinnerRegion;
    MultiSpinner spinnerLanguage;
    EditText editTextOt;
    EditText editTextDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_filtr_search);

        getActionBar().setTitle("Фильтр");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        spinnerRegion = (Spinner) findViewById(R.id.spinnerRegion);
        spinnerLanguage = (MultiSpinner) findViewById(R.id.spinnerLanguage);
        editTextOt = (EditText) findViewById(R.id.editTextOt);
        editTextDo = (EditText) findViewById(R.id.editTextDo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.region, R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinnerRegion.setAdapter(adapter);
        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Log.i("Selected", item.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        List<String> items = new ArrayList<String>();
        items.add("Kazakh");
        items.add("Russian");
        items.add("English");

        spinnerLanguage.setItems(items, "Language", this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void onItemsSelected(boolean[] selected) {
        Log.i("Boolean", selected.length+"");
        Log.i("Boolean", selected[0]+"");
    }
}

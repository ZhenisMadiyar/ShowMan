package com.example.madiyarzhenis.showman.customer.tab_list;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.example.madiyarzhenis.showman.MultiSpinner;
import com.example.madiyarzhenis.showman.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by madiyarzhenis on 21.10.15.
 */
public class AddZayavka extends Activity implements MultiSpinner.MultiSpinnerListener {

    Button btnData;
    DatePicker datePicker;
    Calendar calendar;
    int year, month, day;

    Spinner spinnerRegion, spinnerEvent;
    MultiSpinner spinnerLanguage;
    Button btnSend1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_zayavka);

        getActionBar().setTitle("Оставить заявку");
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerRegion = (Spinner) findViewById(R.id.spinnerRegion);
        spinnerLanguage = (MultiSpinner) findViewById(R.id.spinnerLanguage);
        spinnerEvent = (Spinner) findViewById(R.id.spinnerMeropriyati);
        btnSend1 = (Button) findViewById(R.id.buttonSend);

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

//        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this,
//                R.array.language, R.layout.simple_spinner_item);
//        // Определяем разметку для использования при выборе элемента
//        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Применяем адаптер к элементу spinner
//        spinnerLanguage.setAdapter(adapterLanguage);
//        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Object item = parent.getItemAtPosition(position);
//                Log.i("Selected", item.toString());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });


        List<String> items = new ArrayList<String>();
        items.add("Kazakh");
        items.add("Russian");
        items.add("English");
        spinnerLanguage.setItems(items, "Language", this);

        ArrayAdapter<CharSequence> adapterEvent = ArrayAdapter.createFromResource(this,
                R.array.event, R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapterEvent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinnerEvent.setAdapter(adapterEvent);
        spinnerEvent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Log.i("Selected", item.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnData = (Button) findViewById(R.id.date_picker_button);
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(999);
            }
        });

        btnSend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddZayavka.this, NameSurnameArtist.class);
                startActivity(intent);
            }
        });

    }

    private void showDate(int year, int month, int day) {
        btnData.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int month, int date) {
            showDate(year, month+1, date);
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
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
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

    @Override
    public void onItemsSelected(boolean[] selected) {

    }
}

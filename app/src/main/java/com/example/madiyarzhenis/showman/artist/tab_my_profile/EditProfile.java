package com.example.madiyarzhenis.showman.artist.tab_my_profile;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.madiyarzhenis.showman.MultiSpinner;
import com.example.madiyarzhenis.showman.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by madiyarzhenis on 22.10.15.
 */
public class EditProfile extends Activity implements MultiSpinner.MultiSpinnerListener {

    Button editPhotoBtn;
    private static int RESULT_LOAD_IMAGE = 1;
    Spinner spinnerCategory, spinnerRegion, spinnerOpyt;
    MultiSpinner spinnerLanguage;

    //VideoSsylka
    ListView listViewVideo;
    AdapterVideoUrl adapterVideoUrl;
    ArrayList<String> url;
    Button btnAddUrl;
    EditText editTextVideoCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_edit_profile);

        getActionBar().setTitle("Редактировать профиль");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        listViewVideo = (ListView) findViewById(R.id.listViewVideo);
        url = new ArrayList<>();
        url.add("url 3");
        url.add("url 2");
        url.add("url 1");
        url.add("url 4");

        adapterVideoUrl = new AdapterVideoUrl(this, url);
        listViewVideo.setAdapter(adapterVideoUrl);

        listViewVideo.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        editPhotoBtn = (Button) findViewById(R.id.buttonEditPhoto);
        spinnerCategory = (Spinner) findViewById(R.id.spinnerCategory);
        spinnerRegion = (Spinner) findViewById(R.id.spinnerRegion);
        spinnerLanguage = (MultiSpinner) findViewById(R.id.spinnerLanguage);
        spinnerOpyt = (Spinner) findViewById(R.id.spinnerOpyt);
        btnAddUrl = (Button) findViewById(R.id.btnAddVideoUrl);
        editTextVideoCode = (EditText) findViewById(R.id.editTextVideo);


        ArrayAdapter<CharSequence> adapterCategory = ArrayAdapter.createFromResource(this,
                R.array.category, R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinnerCategory.setAdapter(adapterCategory);
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Log.i("Selected", item.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapterRegion = ArrayAdapter.createFromResource(this,
                R.array.region, R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinnerRegion.setAdapter(adapterRegion);
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

        ArrayAdapter<CharSequence> adapterOpyt = ArrayAdapter.createFromResource(this,
                R.array.opyt, R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapterOpyt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinnerOpyt.setAdapter(adapterOpyt);
        spinnerOpyt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        editPhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        btnAddUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editTextVideoCode.getText().toString().equals("")) {
                    url.add(editTextVideoCode.getText().toString());
                    adapterVideoUrl.notifyDataSetChanged();
                }
            }
        });

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imageViewProfile);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }

    @Override
    public void onItemsSelected(boolean[] selected) {

    }

    private class AdapterVideoUrl extends BaseAdapter {
        Activity activity;
        ArrayList<String> url;
        LayoutInflater inflater;
        public AdapterVideoUrl(Activity activity, ArrayList<String> url) {
            this.activity = activity;
            this.url = url;
            inflater = LayoutInflater.from(activity);
        }

        @Override
        public int getCount() {
            return url.size();
        }

        @Override
        public Object getItem(int position) {
            return url.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder view;
            if (convertView == null) {
                view = new ViewHolder();
                convertView = inflater.inflate(R.layout.artist_item_video_ulr, null);
                view.urlText = (TextView) convertView.findViewById(R.id.textViewVideoUrl);
                view.btnDelete = (Button) convertView.findViewById(R.id.buttonDelete);
                convertView.setTag(view);
            } else {
                view = (ViewHolder) convertView.getTag();
            }
            view.urlText.setText(url.get(position));
            view.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url.remove(position);
                    adapterVideoUrl.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        public class ViewHolder {
            public TextView urlText;
            public Button btnDelete;
        }
    }
}

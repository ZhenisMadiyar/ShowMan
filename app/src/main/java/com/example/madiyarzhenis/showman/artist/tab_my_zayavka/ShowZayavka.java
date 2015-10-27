package com.example.madiyarzhenis.showman.artist.tab_my_zayavka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.madiyarzhenis.showman.R;
import com.example.madiyarzhenis.showman.artist.ArtistAdapterZayavkaShow;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by madiyarzhenis on 23.10.15.
 */
public class ShowZayavka extends Activity implements
        AdapterView.OnItemClickListener, StickyListHeadersListView.OnHeaderClickListener,
        StickyListHeadersListView.OnStickyHeaderOffsetChangedListener,
        StickyListHeadersListView.OnStickyHeaderChangedListener{

    StickyListHeadersListView stickyList;

    String[] header = {"Ф.И.О","Регион","Язык ведения","Стоимость","Дата","Мероприятие","Телефон", "Комментарий"};
    String[] body = {"Мадияр Женис", "Алматы","Каз, Рус","5000-10.000","29.10.2015","Свадьба", "8 708 949 56 40", "2 кунге"};
    ArtistAdapterZayavkaShow adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_show_zayavka);

        Intent intent = getIntent();
        getActionBar().setTitle(intent.getStringExtra("title"));
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new ArtistAdapterZayavkaShow(this, header, body);
        stickyList = (StickyListHeadersListView) findViewById(R.id.listZayavka);
        stickyList.setOnItemClickListener(this);
        stickyList.setClickable(false);
        stickyList.setOnStickyHeaderChangedListener(this);
        stickyList.setOnStickyHeaderOffsetChangedListener(this);

        stickyList.setDrawingListUnderStickyHeader(true);
        stickyList.setAreHeadersSticky(true);
        stickyList.setAdapter(adapter);

//        stickyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 7) {
//                    startActivity(new Intent(ShowZayavka.this, CommentZayavka.class));
//                }
//            }
//        });

    }

    @Override
    public void onHeaderClick(StickyListHeadersListView stickyListHeadersListView, View view, int i, long l, boolean b) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onStickyHeaderChanged(StickyListHeadersListView stickyListHeadersListView, View view, int i, long l) {

    }

    @Override
    public void onStickyHeaderOffsetChanged(StickyListHeadersListView stickyListHeadersListView, View view, int i) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
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
}

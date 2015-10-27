package com.example.madiyarzhenis.showman.artist.tab_my_profile.feedback;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.madiyarzhenis.showman.R;

/**
 * Created by madiyarzhenis on 22.10.15.
 */
public class ShowFeedbacks extends Activity {

    ListView listView;
    Button addFeed;
    RelativeLayout layoutText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_feedback);

        getActionBar().setTitle("Отзывы");
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listViewFeed);
        addFeed = (Button) findViewById(R.id.buttonAddFeed);
        layoutText = (RelativeLayout) findViewById(R.id.textLay);

        if (listView == null) {
            listView.setVisibility(View.GONE);
            layoutText.setVisibility(View.VISIBLE);
        } else {
            //adapter
        }
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

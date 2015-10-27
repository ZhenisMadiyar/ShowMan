package com.example.madiyarzhenis.showman.artist.tab_my_zayavka;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.madiyarzhenis.showman.R;

import java.util.ArrayList;

/**
 * Created by madiyarzhenis on 27.10.15.
 */
public class CommentZayavka extends Activity {

    ListView listView;
    CommentAdapter adapter;
    ArrayList<ElementComment> comments;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_comment_zayavka);

        getActionBar().setTitle("Comments");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        layout = (RelativeLayout) findViewById(R.id.textLay);
        comments = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewComment);
        if (comments.size() == 0) {
            listView.setVisibility(View.GONE);
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
            adapter = new CommentAdapter(this, comments);
            listView.setAdapter(adapter);
        }

    }

    private class CommentAdapter extends BaseAdapter {
        Activity activity;
        ArrayList<ElementComment> comments;
        LayoutInflater inflater;
        public CommentAdapter(Activity activity, ArrayList<ElementComment> comments) {
            this.activity = activity;
            this.comments = comments;
            inflater = LayoutInflater.from(activity);
        }

        @Override
        public int getCount() {
            return comments.size();
        }

        @Override
        public Object getItem(int position) {
            return comments.get(position);
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
                convertView = inflater.inflate(R.layout.artist_item_my_zayavka, null);
                view.title = (TextView) convertView.findViewById(R.id.textViewMyZayavkaTitle);
                convertView.setTag(view);
            } else {
                view = (ViewHolder) convertView.getTag();
            }
            view.title.setText(comments.get(position).getContent());
            return convertView;
        }

        public class ViewHolder {
            public TextView title;
            RelativeLayout backgroundItem;
        }
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

package com.example.madiyarzhenis.showman.customer.tab_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.madiyarzhenis.showman.customer.MainTabActivity;
import com.example.madiyarzhenis.showman.R;
import com.example.madiyarzhenis.showman.customer.tab_list.profile_showman.ShowManProfile;

import java.util.ArrayList;

/**
 * Created by madiyarzhenis on 19.10.15.
 */
public class ListShowMan extends Activity {
    AdapterShowMan adapter;
    ListView listView;
    ArrayList<ShowMan> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_showman);

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("ShowMan");

        arrayList = new ArrayList<>();
        arrayList.add(new ShowMan("Name1", "SubName1", "", ""));
        arrayList.add(new ShowMan("Name2", "SubName2", "", ""));
        arrayList.add(new ShowMan("Name3", "SubName3", "", ""));
        arrayList.add(new ShowMan("Name4", "SubName4", "", ""));
        listView = (ListView) findViewById(R.id.listViewShowMan);
        adapter = new AdapterShowMan(this, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListShowMan.this, ShowManProfile.class);
                startActivity(intent);
            }
        });
    }

    private class AdapterShowMan extends BaseAdapter {
        Activity activity;
        ArrayList<ShowMan> arrayList;
        LayoutInflater inflater;
        public AdapterShowMan(Activity activity, ArrayList<ShowMan> arrayList) {
            this.activity = activity;
            this.arrayList = arrayList;
            inflater = LayoutInflater.from(activity);
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
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
                convertView = inflater.inflate(R.layout.item_showman_list, null);
                view.name = (TextView) convertView.findViewById(R.id.textViewShowManName);
                view.subName = (TextView) convertView.findViewById(R.id.textViewSubNameShowMan);
                convertView.setTag(view);
            } else {
                view = (ViewHolder) convertView.getTag();
            }
            view.name.setText(arrayList.get(position).getName());
            view.subName.setText(arrayList.get(position).getUsername());

            return convertView;
        }

        public class ViewHolder {
            public TextView name;
            public TextView subName;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(getApplicationContext(), MainTabActivity.class));
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}

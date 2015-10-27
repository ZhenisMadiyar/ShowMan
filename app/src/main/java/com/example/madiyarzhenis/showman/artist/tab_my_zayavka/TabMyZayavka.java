package com.example.madiyarzhenis.showman.artist.tab_my_zayavka;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.madiyarzhenis.showman.R;

import java.util.ArrayList;

/**
 * Created by madiyarzhenis on 19.10.15.
 */
public class TabMyZayavka extends Fragment {

    ListView listViewMyZayavka;
    MyZayavkaAdapter adapter;
    ArrayList<MyZayavka> myZayavka;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout._artist_tab_my_zayavka_fragment, container, false);

        myZayavka = new ArrayList<>();

        myZayavka.add(new MyZayavka("Заявка 1", true));
        myZayavka.add(new MyZayavka("Заявка 2", false));
        myZayavka.add(new MyZayavka("Заявка 3", false));
        myZayavka.add(new MyZayavka("Заявка 4", true));
        myZayavka.add(new MyZayavka("Заявка 4", true));
        myZayavka.add(new MyZayavka("Заявка 5", false));
        myZayavka.add(new MyZayavka("Заявка 6", false));
        myZayavka.add(new MyZayavka("Заявка 7", false));
        myZayavka.add(new MyZayavka("Заявка 8", false));
        myZayavka.add(new MyZayavka("Заявка 9", false));

        listViewMyZayavka = (ListView) view.findViewById(R.id.listViewMyZayavka);
        adapter = new MyZayavkaAdapter(getActivity(), myZayavka);
        listViewMyZayavka.setAdapter(adapter);

        listViewMyZayavka.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myZayavka.get(position).setNewZayavka(false);
                Intent intent = new Intent(getActivity(), ShowZayavka.class);
                intent.putExtra("title", myZayavka.get(position).getTitle());
                startActivity(intent);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    private class MyZayavkaAdapter extends BaseAdapter {
        Activity activity;
        ArrayList<MyZayavka> myZayavka;
        LayoutInflater inflater;
        public MyZayavkaAdapter(Activity activity, ArrayList<MyZayavka> myZayavka) {
            this.activity = activity;
            this.myZayavka = myZayavka;
            inflater = LayoutInflater.from(activity);
        }

        @Override
        public int getCount() {
            return myZayavka.size();
        }

        @Override
        public Object getItem(int position) {
            return myZayavka.get(position);
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
                view.backgroundItem = (RelativeLayout) convertView.findViewById(R.id.item_background);
                convertView.setTag(view);
            } else {
                view = (ViewHolder) convertView.getTag();
            }
            view.title.setText(myZayavka.get(position).getTitle());
            if (myZayavka.get(position).isNewZayavka()) {
                //new zayavka
                view.title.setTypeface(Typeface.DEFAULT_BOLD);
                view.title.setTextColor(Color.parseColor("#000000"));
                view.backgroundItem.setBackgroundColor(Color.parseColor("#ffffff"));
            } else {
                //old zayavka
                view.title.setTypeface(Typeface.DEFAULT);
                view.backgroundItem.setBackgroundColor(Color.parseColor("#ececec"));
            }

            return convertView;
        }

        public class ViewHolder {
            public TextView title;
            RelativeLayout backgroundItem;
        }
    }
}

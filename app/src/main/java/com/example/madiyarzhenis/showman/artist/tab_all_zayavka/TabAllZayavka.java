package com.example.madiyarzhenis.showman.artist.tab_all_zayavka;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.madiyarzhenis.showman.R;
import com.example.madiyarzhenis.showman.artist.tab_my_zayavka.ShowZayavka;

import java.util.ArrayList;

/**
 * Created by madiyarzhenis on 19.10.15.
 */
public class TabAllZayavka extends Fragment {

    ListView listAllZayavka;
    AdapterAllZayavka adapter;
    ArrayList<AllZayavka> allZayavka;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout._artist_tab_all_zayavka_fragment, container, false);
        setHasOptionsMenu(true);

        allZayavka = new ArrayList<>();
        allZayavka.add(new AllZayavka("Заявка 1", false));
        allZayavka.add(new AllZayavka("Заявка 2", false));
        allZayavka.add(new AllZayavka("Заявка 3", false));
        allZayavka.add(new AllZayavka("Заявка 4", false));
        allZayavka.add(new AllZayavka("Заявка 4", true));
        allZayavka.add(new AllZayavka("Заявка 5", false));
        allZayavka.add(new AllZayavka("Заявка 6", true));
        allZayavka.add(new AllZayavka("Заявка 7", false));
        allZayavka.add(new AllZayavka("Заявка 8", false));
        allZayavka.add(new AllZayavka("Заявка 9", false));

        listAllZayavka = (ListView) view.findViewById(R.id.listViewAllZayavka);
        adapter = new AdapterAllZayavka(getActivity(), allZayavka);
        listAllZayavka.setAdapter(adapter);

        listAllZayavka.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), ShowZayavka.class);
                intent.putExtra("title", allZayavka.get(position).getTitle());
                startActivity(intent);
                allZayavka.get(position).setNewZayavka(false);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        if (null != searchView) {
            searchView.setSearchableInfo(
                    searchManager.getSearchableInfo(getActivity().getComponentName()));
        }
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                Toast.makeText(getActivity(), "TEXT:" + s, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                SearchAdapter(s);
                return false;
            }
        };
        searchView.setOnQueryTextListener(queryTextListener);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.filtr) {
            startActivity(new Intent(getActivity(), FiltrSearchArtist.class));
            getActivity().overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        }

        return super.onOptionsItemSelected(item);
    }

    private class AdapterAllZayavka extends BaseAdapter {
        Activity activity;
        ArrayList<AllZayavka> zayavka;
        LayoutInflater inflater;
        public AdapterAllZayavka(Activity activity, ArrayList<AllZayavka> zayavka) {
            this.activity = activity;
            this.zayavka = zayavka;
            inflater = LayoutInflater.from(activity);
        }

        @Override
        public int getCount() {
            return zayavka.size();
        }

        @Override
        public Object getItem(int position) {
            return zayavka.get(position);
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
                convertView = inflater.inflate(R.layout.artist_item_all_zayavka, null);
                view.title = (TextView) convertView.findViewById(R.id.textViewAllZayavkaTitle);
                view.backgroundItem = (RelativeLayout) convertView.findViewById(R.id.backgroundItem);
                convertView.setTag(view);
            } else {
                view = (ViewHolder) convertView.getTag();
            }
            view.title.setText(zayavka.get(position).getTitle());

            if (allZayavka.get(position).isNewZayavka()) {
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

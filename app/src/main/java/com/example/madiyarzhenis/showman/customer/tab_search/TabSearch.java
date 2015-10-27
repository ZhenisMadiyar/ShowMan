package com.example.madiyarzhenis.showman.customer.tab_search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.madiyarzhenis.showman.R;

/**
 * Created by madiyarzhenis on 19.10.15.
 */
public class TabSearch extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_search_fragment, container, false);
        setHasOptionsMenu(true);
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
            startActivity(new Intent(getActivity(), FiltrSearch.class));
            getActivity().overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        }

        return super.onOptionsItemSelected(item);
    }

//    private void SearchAdapter(String str) {
//        if (str == null) {
//            category.clear();
//            listAdapter.notifyDataSetChanged();
//            gridAdapter.notifyDataSetChanged();
//        } else {
//            category.clear();
//            for (int i = 0; i < arrayStr.length; i++) {
//                if (arrayStr[i].toLowerCase().contains(str.toString().toLowerCase())) {
//                    category.add(arrayStr[i]);
//                }
//                listAdapter.notifyDataSetChanged();
//                gridAdapter.notifyDataSetChanged();
//            }
//        }
//    }
}

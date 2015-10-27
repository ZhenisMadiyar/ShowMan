package com.example.madiyarzhenis.showman.customer.tab_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.madiyarzhenis.showman.R;

/**
 * Created by madiyarzhenis on 19.10.15.
 */
public class TabList extends Fragment {
    ViewPager viewPager;
    CustomPagerAdapter pagerAdapter;
    ListView listView;
    MyAdapter adapter;
    String[] language= {"Ведущие", "Эстрада", "Шоу", "Машины","Ведущие", "Эстрада", "Шоу", "Машины"};

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_list_fragment, container, false);
        setHasOptionsMenu(true);

        viewPager = (ViewPager) view.findViewById(R.id.myviewpager);
        pagerAdapter = new CustomPagerAdapter(getActivity());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        listView = (ListView) view.findViewById(R.id.listViewLanguage);
        adapter = new MyAdapter(getActivity(), language);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ListShowMan.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Activity context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return language.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.main_pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMainPage);
            imageView.setImageResource(R.mipmap.ic_launcher);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }

    private class MyAdapter extends BaseAdapter {
        Activity activity;
        String language[];
        LayoutInflater inflater;
        public MyAdapter(Activity activity, String[] language) {
            this.activity = activity;
            this.language = language;
            inflater = LayoutInflater.from(activity);
        }

        @Override
        public int getCount() {
            return language.length;
        }

        @Override
        public Object getItem(int position) {
            return language[position];
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
                convertView = inflater.inflate(R.layout.item_main_list_view, null);
                view.language = (TextView) convertView.findViewById(R.id.textViewLanguage);
                view.count = (TextView) convertView.findViewById(R.id.textViewCount);
                convertView.setTag(view);
            } else {
                view = (ViewHolder) convertView.getTag();
            }
            view.language.setText(language[position]);
            view.count.setText(language[position]);

            return convertView;
        }

        public class ViewHolder {
            public TextView language;
            public TextView count;
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_note) {
            startActivity(new Intent(getActivity(), AddZayavka.class));
            getActivity().overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        }

        return super.onOptionsItemSelected(item);
    }
}

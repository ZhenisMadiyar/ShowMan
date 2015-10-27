package com.example.madiyarzhenis.showman.customer.tab_list.profile_showman;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.madiyarzhenis.showman.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class ProfileAdapter extends BaseAdapter implements
        StickyListHeadersAdapter, SectionIndexer {

    private final Activity mContext;
    private String[] mCountries;
    private int[] mSectionIndices;
    private Character[] mSectionLetters;
    private LayoutInflater mInflater;
    String[] header;
    String[] body;
    MediaPagerAdapter pagerAdapter;

    public ProfileAdapter(Activity context, String[] header, String[] body) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mCountries = context.getResources().getStringArray(R.array.countries);
//        mSectionIndices = getSectionIndices();
//        mSectionLetters = getSectionLetters();
        this.header = header;
        this.body = body;
    }

//    private int[] getSectionIndices() {
//        ArrayList<Integer> sectionIndices = new ArrayList<Integer>();
//        char lastFirstChar = mCountries[0].charAt(0);
//        sectionIndices.add(0);
//        for (int i = 1; i < mCountries.length; i++) {
//            if (mCountries[i].charAt(0) != lastFirstChar) {
//                lastFirstChar = mCountries[i].charAt(0);
//                sectionIndices.add(i);
//            }
//        }
//        int[] sections = new int[sectionIndices.size()];
//        for (int i = 0; i < sectionIndices.size(); i++) {
//            sections[i] = sectionIndices.get(i);
//        }
//        return sections;
//    }
//
//    private Character[] getSectionLetters() {
//        Character[] letters = new Character[mSectionIndices.length];
//        for (int i = 0; i < mSectionIndices.length; i++) {
//            letters[i] = mCountries[mSectionIndices[i]].charAt(0);
//        }
//        return letters;
//    }

    @Override
    public int getCount() {
        return header.length;
    }

    @Override
    public Object getItem(int position) {
        return header[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (header[position].equals("Медиафайлы")) {
            Log.i("here", "mediafile");
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.profile_media_list_item_layout, parent, false);
            holder.viewPager = (ViewPager) convertView.findViewById(R.id.viewPager);
            pagerAdapter = new MediaPagerAdapter(mContext, body[position]);
            holder.viewPager.setAdapter(pagerAdapter);

            holder.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        } else if (header[position].equals("Социальные сети")){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.profile_social_list_item, parent, false);
        } else {
            Log.i("here", "not mediafile");
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.profile_list_item_layout, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
            holder.text.setText(body[position]);
        }
        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;

        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = mInflater.inflate(R.layout.header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        // set header text as first char in name
//        CharSequence headerChar = mCountries[position].subSequence(0, 1);
        holder.text.setText(header[position]);

        return convertView;
    }

    /**
     * Remember that these have to be static, postion=1 should always return
     * the same Id that is.
     */
    @Override
    public long getHeaderId(int position) {
        // return the first character of the country as ID because this is what
        // headers are based upon
        return header[position].subSequence(0, 1).charAt(0);
    }

    @Override
    public int getPositionForSection(int section) {
        if (mSectionIndices.length == 0) {
            return 0;
        }

        if (section >= mSectionIndices.length) {
            section = mSectionIndices.length - 1;
        } else if (section < 0) {
            section = 0;
        }
        return mSectionIndices[section];
    }

    @Override
    public int getSectionForPosition(int position) {
        for (int i = 0; i < mSectionIndices.length; i++) {
            if (position < mSectionIndices[i]) {
                return i - 1;
            }
        }
        return mSectionIndices.length - 1;
    }

    @Override
    public Object[] getSections() {
        return mSectionLetters;
    }

    public void clear() {
        mCountries = new String[0];
        mSectionIndices = new int[0];
        mSectionLetters = new Character[0];
        notifyDataSetChanged();
    }

//    public void restore() {
//        mCountries = mContext.getResources().getStringArray(R.array.countries);
//        mSectionIndices = getSectionIndices();
//        mSectionLetters = getSectionLetters();
//        notifyDataSetChanged();
//    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder {
        TextView text;
        ViewPager viewPager;
    }

    private class MediaPagerAdapter extends PagerAdapter {

        Activity mContext;
        LayoutInflater mLayoutInflater;
        String url;
        String[] videoCode;

        public MediaPagerAdapter(Activity context, String url) {
            this.url = url;
            mContext = context;
            videoCode = url.split(",");
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return videoCode.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.media_pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMedia);
            imageView.setImageResource(R.mipmap.ic_launcher);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }
}

package com.example.madiyarzhenis.showman.artist.tab_my_profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.madiyarzhenis.showman.R;
import com.example.madiyarzhenis.showman.artist.tab_my_profile.feedback.ShowFeedbacks;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by madiyarzhenis on 19.10.15.
 */
public class TabMyProfile extends Fragment  implements
        AdapterView.OnItemClickListener, StickyListHeadersListView.OnHeaderClickListener,
        StickyListHeadersListView.OnStickyHeaderOffsetChangedListener,
        StickyListHeadersListView.OnStickyHeaderChangedListener {

    private StickyListHeadersListView stickyList;
    private ShowProfileAdapter mAdapter;

    String[] header = {"Категория", "Опыт работы","Регион","Язык ведения","Стоимость","Рейтинг","О себе","Медиафайлы","Контакные данные",
            "Социальные сети", "Отзывы"};
    String[] body = {"Ведущий", "3 года","Весь Казахстан","Каз,Рус,Анг","5000$","Mega Super","Android («Андро́ид») — операционная система для " +
            "смартфонов, планшетных компьютеров, электронных книг, цифровых проигрывателей, наручных часов, игровых " +
            "приставок, нетбуков, смартбуков, очков Google[3], телевизоров[4] и других устройств. В будущем планируется" +
            " поддержка автомобилей[5] и бытовых роботов. Основана на ядре Linux[6] и собственной реализации виртуальной" +
            " машины Java от Google. Изначально разрабатывалась компанией Android Inc., которую затем купила Google." +
            " Впоследствии Google инициировала создание альянса Open Handset Alliance (OHA), который сейчас занимается " +
            "поддержкой и дальнейшим развитием платформы. Android позволяет создавать Java-приложения, управляющие " +
            "устройством через разработанные Google библиотеки. Android Native Development Kit позволяет портировать " +
            "(но не отлаживать) библиотеки и компоненты приложений, написанные на Си и других языках."
            ,"Photos and Videos,asdasd,asd,asd","8 708 949 56 40","vk.com", "Посмотреть"};
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout._artist_tab_profile_fragment, container, false);

        setHasOptionsMenu(true);

        mAdapter = new ShowProfileAdapter(getActivity(), header, body);

        stickyList = (StickyListHeadersListView) view.findViewById(R.id.listProfileShowMan);
        stickyList.setOnItemClickListener(this);
        stickyList.setOnHeaderClickListener(this);
        stickyList.setOnStickyHeaderChangedListener(this);
        stickyList.setOnStickyHeaderOffsetChangedListener(this);

        View headerView = getActivity().getLayoutInflater().inflate(R.layout.list_header, null);
        ImageView imageView = (ImageView) headerView.findViewById(R.id.imageViewShowMan);
        imageView.setImageResource(R.mipmap.ic_launcher);
        stickyList.addHeaderView(headerView);
//        stickyList.addFooterView(getLayoutInflater().inflate(R.layout.list_footer, null));
//        stickyList.setEmptyView(findViewById(R.id.empty));
        stickyList.setDrawingListUnderStickyHeader(true);
        stickyList.setAreHeadersSticky(true);
        stickyList.setAdapter(mAdapter);

        stickyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 11) {
                    Intent intent = new Intent(getActivity(), ShowFeedbacks.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                }
            }
        });

        return view;
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.artistit_menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.edit_profile) {
            startActivity(new Intent(getActivity(), EditProfile.class));
            getActivity().overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        }

        return super.onOptionsItemSelected(item);
    }

}

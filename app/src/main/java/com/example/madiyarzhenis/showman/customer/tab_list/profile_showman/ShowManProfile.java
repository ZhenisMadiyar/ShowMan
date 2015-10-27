package com.example.madiyarzhenis.showman.customer.tab_list.profile_showman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.madiyarzhenis.showman.R;
import com.example.madiyarzhenis.showman.customer.tab_list.ListShowMan;
import com.example.madiyarzhenis.showman.customer.tab_list.profile_showman.feedback.Feedbacks;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by madiyarzhenis on 20.10.15.
 */
public class ShowManProfile extends Activity  implements
        AdapterView.OnItemClickListener, StickyListHeadersListView.OnHeaderClickListener,
        StickyListHeadersListView.OnStickyHeaderOffsetChangedListener,
        StickyListHeadersListView.OnStickyHeaderChangedListener {

    private StickyListHeadersListView stickyList;
    private ProfileAdapter mAdapter;

    String[] header = {"Категория","Опыт работы","Регион","Язык ведения","Стоимость","Рейтинг","О себе","Медиафайлы","Контакные данные",
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
            ,"Photos and Videos,asdasd,asd,asd","8 708 949 56 40","vk.com", "Посмотреть/Оставить"};
    ImageButton imageButtonBack, imageButtonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_showman_profile);

        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBack);
        imageButtonShare = (ImageButton) findViewById(R.id.imageButtonShare);

        mAdapter = new ProfileAdapter(this, header, body);

        stickyList = (StickyListHeadersListView) findViewById(R.id.list);
        stickyList.setOnItemClickListener(this);
        stickyList.setOnHeaderClickListener(this);
        stickyList.setOnStickyHeaderChangedListener(this);
        stickyList.setOnStickyHeaderOffsetChangedListener(this);

        View headerView = getLayoutInflater().inflate(R.layout.list_header, null);
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
                    Intent intent = new Intent(ShowManProfile.this, Feedbacks.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                }
            }
        });

        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowManProfile.this, ListShowMan.class));
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
            }
        });

        imageButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, body[1]);
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Example text");
                startActivity(Intent.createChooser(shareIntent, "Share with"));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ShowManProfile.this, ListShowMan.class));
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
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
}
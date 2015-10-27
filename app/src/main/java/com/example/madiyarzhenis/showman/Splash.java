package com.example.madiyarzhenis.showman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.madiyarzhenis.showman.artist.ArtistMainTabActivity;
import com.example.madiyarzhenis.showman.customer.MainTabActivity;

/**
 * Created by madiyarzhenis on 22.10.15.
 */
public class Splash extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_name);

        if (Utils.getDefaults(this, Utils.TAG_Name) == null) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            if (Utils.getTypeId(this, Utils.TAG_Type_Id) == 1) {
                startActivity(new Intent(this, ArtistMainTabActivity.class));
            } else {
                startActivity(new Intent(this, MainTabActivity.class));
            }
        }
    }
}
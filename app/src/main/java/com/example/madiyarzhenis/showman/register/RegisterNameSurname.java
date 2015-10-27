package com.example.madiyarzhenis.showman.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.madiyarzhenis.showman.artist.ArtistMainTabActivity;
import com.example.madiyarzhenis.showman.customer.MainTabActivity;
import com.example.madiyarzhenis.showman.R;
import com.example.madiyarzhenis.showman.Utils;


/**
 * Created by madiyarzhenis on 14.10.15.
 */
public class RegisterNameSurname extends Activity {
    EditText editTextName;
    Button btnRegister;
    //    private static AsyncHttpClient client = new AsyncHttpClient();
    RadioButton radioButton;
//    RadioButton checkBoxUser;
    RadioGroup radioGroup;
    int idType;
    String phone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_name);

        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");

        editTextName = (EditText) findViewById(R.id.editTextName);
        btnRegister = (Button) findViewById(R.id.buttonRegister);
//        checkBoxUser = (RadioButton) findViewById(R.id.checkBoxUser);
//        checkBoxShowMan = (RadioButton) findViewById(R.id.checkBoxShowMan);
        radioGroup = (RadioGroup) findViewById(R.id.type);


//        Intent intent = getIntent();
//        phone = intent.getStringExtra("phone");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (editTextName.getText() != null){
//                    JSONObject jsonCommand = new JSONObject();
//                    JSONObject jsonParams = new JSONObject();
//                    RequestParams requestParams = new RequestParams();
//                    try {
//                        jsonCommand.put("command", "register");
//                        jsonCommand.put("params", jsonParams);
//
//                        jsonParams.put("name", editTextName.getText().toString());
//                        jsonParams.put("phone", "7" + phone);
//
//                        requestParams.add("data", jsonCommand.toString());
//                        Log.i("JsonStr", jsonCommand.toString());
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    client.post(RegisterNameSurname.this, "http://88.198.48.246:9017/app/run", requestParams, new TextHttpResponseHandler() {
//                        @Override
//                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                            Log.e("statusCode", statusCode + "");
//                        }
//
//                        @Override
//                        public void onSuccess(int statusCode, Header[] headers, String responseString) {
//                            Log.i("statusCode", statusCode + "");
//                            Log.i("Response", responseString);
//                            try {
//                                JSONObject jsonObject = new JSONObject(responseString);
//                                if (jsonObject.getInt("status") == 200) {
//
//                                    JSONArray jsonArray = jsonObject.getJSONArray("list");
//                                    JSONObject jsonUser = jsonArray.getJSONObject(0);
//
//                                    RegisterUtils.setDefaults(RegisterNameSurname.this, jsonUser.getString("name"), jsonUser.getString("phone"),
//                                            jsonUser.getString("privateKey"), jsonUser.getInt("id"), jsonUser.getString("userCode"));
//
//                                    Intent intentName = new Intent(RegisterNameSurname.this, TabsActivity.class);
//                                    startActivity(intentName);
//                                    overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
//                                } else {
//                                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//                }

                int selectedId = radioGroup.getCheckedRadioButtonId();
                Log.i("SelectedID", selectedId+"");
                radioButton= (RadioButton) findViewById(selectedId);
                Log.i("RadioButton", radioButton.getText().toString());
                if (radioButton.getText().toString().equals("ShowMan")) {
                    idType = 1;//ShowMan
                } else {
                    idType = 0;//User
                }

                Utils.setDefaults(getApplicationContext(), editTextName.getText().toString(),
                        phone, idType);

                if (idType == 1) {//ShowMan
                    Intent intentName = new Intent(RegisterNameSurname.this, ArtistMainTabActivity.class);
                    startActivity(intentName);
                } else {//Customer
                    Intent intentName = new Intent(RegisterNameSurname.this, MainTabActivity.class);
                    startActivity(intentName);
                }
            }
        });

    }
}

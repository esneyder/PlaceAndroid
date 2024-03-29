/*
 * Copyright (C) 2015 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.unauto.dev.playservices.UnAuto;



import android.content.Intent;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.unauto.android.common.activities.MisSitiosActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
@Bind(R.id.edtNombreUsuario)
EditText txtusuario;
@Bind(R.id.edtContrasena)
EditText txtContrasena;
@Bind(R.id.btnIngresar)
Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }
@OnClick(R.id.btnIngresar) void onClick() {
    String mUserName=txtusuario.getText().toString();
    String mPassword=txtContrasena.getText().toString();

    ParseUser.logInInBackground(mUserName, mPassword, new LogInCallback() {
        public void done(ParseUser user, ParseException e) {
            if (user != null) {
                startActivity(new Intent(getApplicationContext(),MisSitiosActivity.class));
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Sorry! datos de usuario incorrectos!..  "+ e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });
}

}

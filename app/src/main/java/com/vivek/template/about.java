package com.vivek.template;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

/**
 * Created by Shiva on 10-06-2015.
 */
public class about extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.about);


        Button f = (Button) findViewById(R.id.facebook);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fa = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/vivek1neel?ref=tn_tnmn"));
                startActivity(fa);
            }
        });
        Button g = (Button)findViewById(R.id.google);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fa = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://plus.google.com/102055595954380143572"));
                startActivity(fa);
            }

        });

        Button t = (Button) findViewById(R.id.twitter);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fa = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://twitter.com/vivek2neel"));
                startActivity(fa);
            }
        });

        CardView apps = (CardView)findViewById(R.id.card2);
        apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/developer?id=Neel+World&hl=en"));
                startActivity(a);
            }
        });

        CardView a = (CardView)findViewById(R.id.xda);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.xda)));
                startActivity(f);
            }
        });
    }
}

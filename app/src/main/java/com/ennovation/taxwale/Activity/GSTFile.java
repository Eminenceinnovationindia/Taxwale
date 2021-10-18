package com.ennovation.taxwale.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ennovation.taxwale.Fragment.GSTAllFileFragment;
import com.ennovation.taxwale.Fragment.GSTReceivedFileFragment;
import com.ennovation.taxwale.Fragment.GSTSentFileFragment;
import com.ennovation.taxwale.Fragment.ITRAllFileFragment;
import com.ennovation.taxwale.Fragment.ITRReceivedFileFragment;
import com.ennovation.taxwale.Fragment.ITRSendFileFragment;
import com.ennovation.taxwale.R;

public class GSTFile extends AppCompatActivity {
    ImageView back_img;
    LinearLayout allLayout,sentLayout,receivedLayout;
    FrameLayout framGSTContainer;
    View allView,sentView,receivedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_s_t_file);

        back_img = findViewById(R.id.back_img);
        allLayout = findViewById(R.id.allLayout);
        sentLayout = findViewById(R.id.sentLayout);
        receivedLayout = findViewById(R.id.receivedLayout);
        allView = findViewById(R.id.allView);
        sentView = findViewById(R.id.sentView);
        receivedView = findViewById(R.id.receivedView);
        framGSTContainer = findViewById(R.id.framGSTContainer);

        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ChangeFragmemt(new GSTAllFileFragment(), getSupportFragmentManager(), false);
        allView.setVisibility(View.VISIBLE);
        sentView.setVisibility(View.GONE);
        receivedView.setVisibility(View.GONE);

        allLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeFragmemt(new GSTAllFileFragment(), getSupportFragmentManager(), false);
                allView.setVisibility(View.VISIBLE);
                sentView.setVisibility(View.GONE);
                receivedView.setVisibility(View.GONE);

            }
        });

        sentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeFragmemt(new GSTSentFileFragment(), getSupportFragmentManager(), false);
                allView.setVisibility(View.GONE);
                sentView.setVisibility(View.VISIBLE);
                receivedView.setVisibility(View.GONE);
            }
        });

        receivedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeFragmemt(new GSTReceivedFileFragment(), getSupportFragmentManager(), false);
                allView.setVisibility(View.GONE);
                sentView.setVisibility(View.GONE);
                receivedView.setVisibility(View.VISIBLE);
            }
        });


    }

    public void ChangeFragmemt(Fragment fragment, FragmentManager fm, Boolean addtobackstag) {
        FragmentTransaction tr = fm.beginTransaction();
        tr.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        if (addtobackstag) {
            tr.replace(R.id.framGSTContainer, fragment).addToBackStack("a").commit();
        } else {
            tr.replace(R.id.framGSTContainer, fragment).commit();
        }
    }

    public void back(View view) {
        onBackPressed();
    }
}
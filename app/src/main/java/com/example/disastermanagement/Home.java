package com.example.disastermanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;


public class Home extends AppCompatActivity {



    TabLayout tabs;
    Toolbar tools;
    ViewPager view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        view = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        tools = findViewById(R.id.toolbar);

        setSupportActionBar(tools);
        getSupportActionBar().setTitle("Home");

        Page_Adapter pagerAdapter = new Page_Adapter(getSupportFragmentManager());
        frag_one fragmentone = new frag_one();
        pagerAdapter.addFragments(fragmentone,"Disasters");

        frag_two fragmenttwo = new frag_two();
        pagerAdapter.addFragments(fragmenttwo,"Accidents");
        view.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(view);

        frag_three fragmentthree = new frag_three();
        pagerAdapter.addFragments(fragmentthree,"Assistance");
        view.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(view);
    }


    public  void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LoginForm.class));
        finish();
    }

    public void start_Heart_Attack(View view)
    {
       startActivity(new Intent(getApplicationContext(),Heart_attack.class));
    }

}

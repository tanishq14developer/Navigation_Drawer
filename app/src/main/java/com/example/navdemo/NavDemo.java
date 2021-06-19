 package com.example.navdemo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;


public class NavDemo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   private DrawerLayout drawer;
    private Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_demo);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener((DrawerLayout.DrawerListener) toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new fragment_Android()).commit();
            navigationView.setCheckedItem(R.id.nav_android);
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (item.getItemId()){
            case R.id.nav_android:
                Fragment f = getSupportFragmentManager().findFragmentById(R.id.framelayout);
                if (!(f instanceof fragment_Android)){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new fragment_Android()).addToBackStack(null).commit();
                }
                break;
            case R.id.nav_java:
                Fragment r = getSupportFragmentManager().findFragmentById(R.id.framelayout);
                if (!(r instanceof fragment)) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new fragment()).addToBackStack(null).commit();
                }
                break;
            case R.id.nav_kotlin:
                Fragment a = getSupportFragmentManager().findFragmentById(R.id.framelayout);
                if ( !(a instanceof fragment_kotlin)) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new fragment_kotlin()).addToBackStack(null).commit();
                }
                break;
            case R.id.linkedin:
                String url = "https://www.linkedin.com/company/wappgo/mycompany/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.website:
                String web = "https://wappgo.com/";
                Intent webi = new Intent(Intent.ACTION_VIEW);
                webi.setData(Uri.parse(web));
                startActivity(webi);

            case R.id.discord:
                String urli = "https://discord.gg/wz5HgR5N";
                Intent ii = new Intent(Intent.ACTION_VIEW);
                ii.setData(Uri.parse(urli));
                startActivity(ii);
                break;
            case R.id.email:
                String eurl = "mailto:info@wappgo.com";
                Intent ei = new Intent(Intent.ACTION_VIEW);
                ei.setData(Uri.parse(eurl));
                startActivity(ei);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

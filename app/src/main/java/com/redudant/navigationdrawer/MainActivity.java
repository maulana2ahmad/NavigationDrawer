package com.redudant.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //setOnclick item menu navigation
        navigationView.setNavigationItemSelectedListener(this);

        //open navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,  (R.string.open), (R.string.close));
        drawerLayout.setDrawerListener(toggle);

        //toolbar.setNavigationIcon(R.drawable.ic_account); //custome icon navigation
        toggle.syncState(); //use navigation icon burger
    }


    /*
    method from implements NavigationView.OnNavigationItemSelectedListener
    so that menu items can be click on
    */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.inbox_id:
                Toast.makeText(getApplicationContext(), "Inbox", Toast.LENGTH_LONG).show();

                break;

            case R.id.starred_id:
                Toast.makeText(getApplicationContext(), "Starred", Toast.LENGTH_LONG).show();
                break;

            case R.id.send_id:
                Toast.makeText(getApplicationContext(), "Send", Toast.LENGTH_LONG).show();
                break;

            case R.id.drafts_id:
                Toast.makeText(getApplicationContext(), "Drafts", Toast.LENGTH_LONG).show();
                break;

            case R.id.allmail_id:
                Toast.makeText(getApplicationContext(), "All Email", Toast.LENGTH_LONG).show();
                break;

            case R.id.trash_id:
                Toast.makeText(getApplicationContext(), "Trash", Toast.LENGTH_LONG).show();
                break;

            case R.id.spam_id:
                Toast.makeText(getApplicationContext(), "Spam", Toast.LENGTH_LONG).show();
                break;
        }

        //close nav drawer
        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }
}

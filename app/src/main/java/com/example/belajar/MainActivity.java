package com.example.belajar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.belajar.contextmenu.ContextMenuFragment;
import com.example.belajar.extras.ExtrasFragment;
import com.example.belajar.fourth.FourthFragment;
import com.example.belajar.result.ResultsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNavigation_main);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContextMenuFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_contextMenu:
                            selectedFragment = new ContextMenuFragment();
                            break;
                        case R.id.nav_extras:
                            selectedFragment = new ExtrasFragment();
                            break;
                        case R.id.nav_fragment3:
                            selectedFragment = new ResultsFragment();
                            break;
                        case R.id.nav_fragment4:
                            selectedFragment = new FourthFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}
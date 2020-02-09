package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameFrag, new FragmentOne()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment mFragment = null;

                switch (item.getItemId()) {
                    case R.id.homeNav:
                        mFragment = new FragmentOne();
                        break;
                    case R.id.storeNav:
                        mFragment = new FragmentTwo();
                        break;
                    case R.id.homeSearch:
                        mFragment = new FragmentThree();
                        break;
                    case R.id.homeAccount:
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.putExtra(Intent.EXTRA_SUBJECT, "Hello There");
                        share.putExtra(Intent.EXTRA_TEXT, "https://general.kenobi");
                        startActivity(Intent.createChooser(share, null));
                        return false;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameFrag, mFragment).commit();

                return true;
            }
        });
    }
}

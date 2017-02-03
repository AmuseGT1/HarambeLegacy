package com.example.itcapstone.harambeslegacy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
* Created by Mohamed Hassenjee,
* Date 12/9/2016
*
* For: University of Central Florida
* Class: IT Capstone
* Professor: Mahendra Gossai
*
* */



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.itcapstone.harambeslegacy.R.layout.activity_main);
    }

    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() != 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void QuestionActivity(View v){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    public void AboutUs(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        AboutUs fragment = new AboutUs();
        fragmentTransaction.add(com.example.itcapstone.harambeslegacy.R.id.main_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chat(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MainChatFragment fragment = new MainChatFragment();
        fragmentTransaction.add(com.example.itcapstone.harambeslegacy.R.id.main_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void ContactUs(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ContactUs fragment = new ContactUs();
        fragmentTransaction.add(com.example.itcapstone.harambeslegacy.R.id.main_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}

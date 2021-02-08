package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.calculate.Tools;
import com.example.myapplication.proxy.ProxySubject;
import com.example.myapplication.proxy.RealSubject;
import com.example.myapplication.proxy.Subject;
import com.example.myapplication.recyclerView.RecyclerActivity;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Tools().changeRomeToNum("MCMXCIV");
                new Tools().getPublicPrefix("flower","flow","flight");
                new Tools().isPalindrome(12321);
            }
        });
        findViewById(R.id.btn_2_recycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.proxy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subject subject = new RealSubject();
                ProxySubject proxySubject=new ProxySubject(subject);
                Subject sub = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                        subject.getClass().getInterfaces(), proxySubject);
                sub.operation();



            }
        });



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}
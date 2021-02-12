package com.example.myapplication.mvvm;

import android.app.Activity;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMvvmBinding;
import com.example.myapplication.mvvm.model.UserBean;

import androidx.databinding.DataBindingUtil;

public class MVVMActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setUser(new UserBean("张三",33));


    }
}

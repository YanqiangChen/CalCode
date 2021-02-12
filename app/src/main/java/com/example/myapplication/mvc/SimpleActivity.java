package com.example.myapplication.mvc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.mvc.callback.Callback1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleActivity extends AppCompatActivity {
    private SimpleModel sampleModel;
    Button button;
    TextView tvAge,tvName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        sampleModel=new SimpleModel();
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleModel.getUserInfo("", new Callback1<SimpleModel.UserInfo>() {
                    @Override
                    public void onCallback(SimpleModel.UserInfo userInfo) {
                        setDataToView(userInfo);
                    }
                });

            }
        });
    }
    /**
     * 设置用户信息到view
     */
    private void setDataToView(SimpleModel.UserInfo userInfo) {
        tvAge.setText(userInfo.getAge());
        tvName.setText(userInfo.getName());
    }

}

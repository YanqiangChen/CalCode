package com.example.myapplication.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.mvc.callback.Callback1;
import com.example.myapplication.mvp.model.UserInfo;
import com.example.myapplication.mvp.presenter.BasePresenter;
import com.example.myapplication.mvp.presenter.Presenter;
import com.example.myapplication.mvp.view.MvpView;

public class MvpActivity extends Activity implements MvpView {

    public BasePresenter mPresenter;
    public Button button;
    public TextView tvAge,tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        setPresenter(new Presenter());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getUserInfo();
            }
        });
        mPresenter.attachView(this);
        bindDataToView();


    }

    @Override
    public void showError() {
        tvAge.setText("");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void bindDataToView() {
        tvAge.setText("");
    }
}

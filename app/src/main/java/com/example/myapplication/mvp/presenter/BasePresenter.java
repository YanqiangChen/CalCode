package com.example.myapplication.mvp.presenter;

import com.example.myapplication.mvp.view.BaseView;

public interface BasePresenter{
    void onDestory();
    void attachView(BaseView baseView);
    void getUserInfo();
}

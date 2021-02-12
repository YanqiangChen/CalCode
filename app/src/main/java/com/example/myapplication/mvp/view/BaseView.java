package com.example.myapplication.mvp.view;

import com.example.myapplication.mvp.presenter.BasePresenter;

public interface BaseView<P extends BasePresenter>{
    void setPresenter(P presenter);
    void showError();
}

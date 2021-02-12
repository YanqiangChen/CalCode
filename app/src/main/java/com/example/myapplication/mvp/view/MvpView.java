package com.example.myapplication.mvp.view;

import com.example.myapplication.mvp.model.UserInfo;
import com.example.myapplication.mvp.presenter.Presenter;

public interface MvpView extends BaseView<Presenter>{

    public void bindDataToView();

}

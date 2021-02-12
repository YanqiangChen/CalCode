package com.example.myapplication.mvp.presenter;

import com.example.myapplication.mvc.callback.Callback1;
import com.example.myapplication.mvc.model.SimpleModel;
import com.example.myapplication.mvp.model.UserInfo;
import com.example.myapplication.mvp.view.BaseView;

public class Presenter implements BasePresenter{
    BaseView baseView;
    @Override
    public void onDestory() {

    }


    @Override
    public void attachView(BaseView baseView) {
        this.baseView=baseView;
    }

    public void getUserInfo(String uid, Callback1<UserInfo> callback) {
        UserInfo userInfo=new UserInfo();
        callback.onCallback(userInfo);
        showError();
    }

    @Override
    public void getUserInfo() {
        UserInfo userInfo=new UserInfo();
        showError();
    }

    public void showError(){
        baseView.showError();
    }


}

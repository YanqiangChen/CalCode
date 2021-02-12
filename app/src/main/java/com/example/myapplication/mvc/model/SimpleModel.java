package com.example.myapplication.mvc.model;

import com.example.myapplication.mvc.callback.Callback1;

public class SimpleModel implements BaseModel {

    @Override
    public void onDestory() {

    }

    public void getUserInfo(String uid, Callback1<UserInfo> callback) {
        UserInfo userInfo= new UserInfo(); //从网络获取数据
        callback.onCallback(userInfo);
    }

    public class UserInfo
    {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

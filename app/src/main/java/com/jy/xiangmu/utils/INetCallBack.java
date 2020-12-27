package com.jy.xiangmu.utils;

public interface INetCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String err);
}

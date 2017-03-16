package com.ultraman.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;


/**
 * Created by kangzhe on 16/4/7.
 */
public class Contributor extends BaseObservable {

    private String login;
    private int contributions;

    @Bindable
    public String getLogin(){
        return login;
    }

    @Bindable
    public int getContributions(){
        return contributions;
    }

    public void setLogin(String login){
        this.login = login;
        notifyPropertyChanged(BR.login);
    }

    public void setContributions(int contributions){
        this.contributions = contributions;
        notifyPropertyChanged(BR.contributions);
    }

    @Override
    public String toString() {
        return login + ", " + contributions;
    }
}

package com.ultraman;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import com.ultraman.common.view.ProcessDialog;
import com.ultraman.presenter.ContributorPresenter;
import com.ultraman.presenter.ContributorView;
import com.ultraman.viewmodel.Contributor;

import com.ultraman.databinding.ActivityMainBinding;


public class MainActivity extends MvpActivity<ContributorView,ContributorPresenter>  implements ContributorView {

    private ActivityMainBinding mBinding;
    private ProcessDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @NonNull
    @Override
    public ContributorPresenter createPresenter() {
        return new ContributorPresenter();
    }

    public void get(View view){
        getPresenter().get("square", "retrofit");
    }

    public void change(View view){
        if(mBinding.getContributor() != null){
            mBinding.getContributor().setLogin("zjutkz");
        }
    }

    @Override
    public void onLoadContributorStart() {
        showProgress();
    }

    @Override
    public void onLoadContributorComplete(Contributor contributor) {
        mBinding.setContributor(contributor);
        dismissProgress();
    }

    public void showProgress(){
        if(mProgressDialog == null){
            mProgressDialog = new ProcessDialog(this);
        }

        mProgressDialog.showMessage("正在加载...");
    }

    public void dismissProgress(){
        if(mProgressDialog == null){
            mProgressDialog = new ProcessDialog(this);
        }
        mProgressDialog.dismiss();
    }
}

package com.ultraman.presenter;


import com.hannesdorfmann.mosby.mvp.MvpView;

import com.ultraman.viewmodel.Contributor;

/**
 * Created by kangzhe on 16/4/7.
 */
public interface ContributorView extends MvpView {

    void onLoadContributorStart();

    void onLoadContributorComplete(Contributor topContributor);
}

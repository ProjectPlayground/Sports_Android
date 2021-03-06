package com.wentongwang.mysports.views.fragment.personinfo;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.wentongwang.mysports.R;
import com.wentongwang.mysports.views.BaseFragment;
import com.wentongwang.mysports.views.activity.persondetail.PersonDetailActivity;

import butterknife.BindView;


/**
 * Created by Wentong WANG on 2016/9/17.
 */
public class PersonInfoFragment extends BaseFragment implements PersonInfoView {
    @BindView(R.id.test)
    protected Button btn;


    private PersonInfoPresenter mPresenter = new PersonInfoPresenter(this);

    @Override
    public int getLayoutId() {
        return R.layout.personinfo_fragment_layout;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initEvents() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.goToDetailActivity();
            }
        });
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    /**
     * go to persondetail activity
     */
    @Override
    public void goToDetail() {
        Intent it = new Intent();
        it.setClass(getActivity(), PersonDetailActivity.class);
        startActivity(it);
    }
}

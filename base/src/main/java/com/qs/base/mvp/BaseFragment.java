package com.qs.base.mvp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：V层
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    protected P mPresenter;

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    protected abstract P onCreatePresenter();

    protected boolean isActive = true;

    @Override
    public void onResume() {
        super.onResume();
        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    @Override
    public void finishThis() {
        ((Activity) getContext()).finish();
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

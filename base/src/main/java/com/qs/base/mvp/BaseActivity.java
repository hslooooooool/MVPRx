package com.qs.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.qs.base.utils.LogUtil;


/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：V层
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;
    protected int cusId;
    protected boolean isActive;

    @Override
    protected void onStart() {
        super.onStart();
        isActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i("创建:" + getLocalClassName());

        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i("当前:" + getLocalClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i("暂停:" + getLocalClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i("销毁:" + getLocalClassName());
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    protected abstract P onCreatePresenter();

    public Context getContext() {
        return this;
    }

    public void showToast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void finishThis() {
        finish();
    }

    public boolean isActive() {
        return isActive;
    }
}

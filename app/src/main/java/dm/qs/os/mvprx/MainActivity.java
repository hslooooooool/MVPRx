package dm.qs.os.mvprx;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.qs.base.mvp.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：界面
 */
@Route(path = "/mvp/main/")
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.main_tv)
    TextView mainTv;
    @BindView(R.id.main_empty_view)
    QMUIEmptyView mainEmptyView;

    @NonNull
    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_main);
        }

        mainEmptyView.setVisibility(View.VISIBLE);
        mainEmptyView.show(true, "loading", "请等待", null, null);

        mPresenter.getData("content");
    }

    @Override
    public void showDialog(String msg) {

    }

    @Override
    public void getDataSuccess(List<Gank> result) {

        mainEmptyView.setVisibility(View.GONE);

        mainTv.setText(new Gson().toJson(result));
    }
}

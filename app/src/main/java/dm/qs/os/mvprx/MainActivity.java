package dm.qs.os.mvprx;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.qs.base.mvp.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dm.qs.os.mvprx.entity.Gank;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：界面
 */
//@Route(path = "/mvp/main/")
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.main_rv)
    RecyclerView mainRv;
    @BindView(R.id.main_empty_view)
    QMUIEmptyView mainEmptyView;

    private List<Gank> ganks;
    private BaseAdapter baseAdapter;
    private LinearLayoutManager layoutManager;

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

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_main);
        }

        ganks = new ArrayList<>();
        baseAdapter = new BaseAdapter(getContext(), ganks);
        layoutManager = new LinearLayoutManager(getContext());
        mainRv.setLayoutManager(layoutManager);
        mainRv.setAdapter(baseAdapter);

        mainEmptyView.setVisibility(View.VISIBLE);
        mainEmptyView.show(true, "loading", "请等待", null, null);

        mPresenter.getData("1");
    }

    @Override
    public void showDialog(String msg) {

    }

    @Override
    public void getDataSuccess(List<Gank> result) {

        mainEmptyView.setVisibility(View.GONE);

        ganks.addAll(result);
        baseAdapter.notifyDataSetChanged();
    }
}

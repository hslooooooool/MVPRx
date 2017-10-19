package dm.qs.os.mvprx;

import android.support.annotation.NonNull;

import com.u7plus.service.http.RxSubscriber;
import com.u7plus.service.http.entity.ApiException;

import java.util.List;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：控制层
 */
public class MainPresenter extends MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel();
    }

    public MainPresenter(MainModel model, MainContract.View view) {
        mView = view;
        mModel = model;
    }

    @Override
    public void getData(String key) {
        addSubscribe(
                mModel.getData(key)
                        .subscribe(new RxSubscriber<List<Gank>>() {

                            @Override
                            public void onStart() {
                            }

                            @Override
                            protected void onError(@NonNull ApiException ex) {
                                mView.showToast(ex.getDisplayMessage());
                                onCompleted();
                            }

                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onNext(List<Gank>  result) {
                                mView.getDataSuccess(result);
                            }
                        })
        );
    }
}

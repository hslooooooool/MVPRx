package dm.qs.os.mvprx;

import com.qs.base.http.ApiEngine;
import com.qs.base.http.ObservableService;

import rx.Observable;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：业务逻辑
 */
class MainModel implements MainContract.Model {

    private ApiService service = ApiEngine.getInstance("https://gank.io/api/data/Android/").create(ApiService.class);

    @Override
    public Observable getData(String page) {
        return ObservableService.setObservable(service.getData(page));
    }
}

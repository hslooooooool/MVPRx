package dm.qs.os.mvprx;

import com.u7plus.service.http.ApiEngine;
import com.u7plus.service.http.ObservableService;

import rx.Observable;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：业务逻辑
 */
class MainModel implements MainContract.Model {

    private ApiService service = ApiEngine.getInstance("http://gank.io/api/history/").create(ApiService.class);

    @Override
    public Observable getData(String key) {
        return ObservableService.setObservable(service.getData(key));
    }
}

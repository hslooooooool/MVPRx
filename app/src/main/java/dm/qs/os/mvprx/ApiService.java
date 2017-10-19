package dm.qs.os.mvprx;

import com.qs.base.entity.BaseResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：接口集合
 */
interface ApiService {

    /**
     * 数据请求
     *
     * @param key 请求参数
     * @return 请求结果
     */
    @GET("{key}/10/1")
    Observable<BaseResult<List<Gank>>> getData(@Path("key") String key);
}

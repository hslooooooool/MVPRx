package dm.qs.os.mvprx;

import com.qs.base.entity.BaseResult;

import java.util.List;

import dm.qs.os.mvprx.entity.Gank;
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
     * @param page 请求页码
     * @return 请求结果
     */
    @GET("20/{page}")
    Observable<BaseResult<List<Gank>>> getData(@Path("page") String page);
}

package dm.qs.os.mvprx;

import com.qs.base.mvp.BaseModel;
import com.qs.base.mvp.BasePresenter;
import com.qs.base.mvp.BaseView;

import java.util.List;

import dm.qs.os.mvprx.entity.Gank;
import rx.Observable;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：契约
 */
public interface MainContract {

    interface View extends BaseView {
        /**
         * 成功获取数据
         *
         * @param result 返回结果
         */
        void getDataSuccess(List<Gank> result);
    }

    interface Model extends BaseModel {
        /**
         * 获取数据
         *
         * @param page 页码
         * @return Observable 被观察者
         */
        Observable getData(String page);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        /**
         * 获取数据
         * *@param key 数据类型关键字
         */
        abstract void getData(String page);
    }
}

package dm.qs.os.mvprx;

import com.qs.base.utils.RxUnitTestUtil;
import com.u7plus.service.http.ApiEngine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.when;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：
 */
public class MainPresenterTest {

    @Mock
    MainModel model;

    @Mock
    MainContract.View view;

    MainPresenter presenter;

    @Before
    public void setUp() throws Exception {
        ApiEngine.isUnitTest = true;
        RxUnitTestUtil.openRxTools();

        MockitoAnnotations.initMocks(this);

        when(view.isActive()).thenReturn(true);

        presenter = new MainPresenter(model, view);

    }

    @Test
    public void getData() throws Exception {
       String key="test";
       List<Gank> req=new ArrayList<>();

        when(model.getData(key)).thenReturn(Observable.just(req));

        presenter.getData(key);

        Mockito.verify(model).getData(key);
        Mockito.verify(view).getDataSuccess(req);

        Assert.assertEquals(req.size(), 0);

        System.out.println("测试通过getData");
    }
}
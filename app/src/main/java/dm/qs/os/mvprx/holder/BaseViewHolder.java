package dm.qs.os.mvprx.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qs.base.listener.OnTListener;

import java.util.List;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindView(Context context, List<T> data, int position);

    public abstract void onListener(OnTListener onTListener);

}

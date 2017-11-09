package dm.qs.os.mvprx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qs.base.entity.DataType;

import java.util.List;

import dm.qs.os.mvprx.holder.BaseViewHolder;
import dm.qs.os.mvprx.holder.GankHoder;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：普通列表
 */
public class BaseAdapter<T extends DataType> extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<T> data;

    BaseAdapter(Context context, List<T> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.item_gank, parent, false);
            return new GankHoder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindView(context, data, position);
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}

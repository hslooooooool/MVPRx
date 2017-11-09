package dm.qs.os.mvprx.holder;

import android.content.Context;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qs.base.listener.OnTListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dm.qs.os.mvprx.R;
import dm.qs.os.mvprx.entity.Gank;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：干货集中营实体
 */
public class GankHoder extends BaseViewHolder<Gank> {
    @BindView(R.id.gank_tv)
    TextView gankTv;
    @BindView(R.id.gank_iv)
    ImageView gankIv;
    @BindView(R.id.gank_cv)
    CardView gankCv;

    private Context context;
    private OnTListener onTListener;
    private QMUIDialog dialog;
    private int[] colors = {R.color.cadetblue, R.color.emphasize, R.color.firebrick
            , R.color.indianred, R.color.white, R.color.navajowhite, R.color.red
            , R.color.violet, R.color.wheat, R.color.yellow};

    public GankHoder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(Context context, List<Gank> data, int position) {
        this.context = context;
        Gank gank = data.get(position);
        gankTv.setText(gank.getTitle());

        setColor(gankCv, position);

        gankTv.setOnClickListener(view -> {
            if (onTListener != null) {
                onTListener.getItem(position);
            }
            getDialog().setTitle(gank.getTitle());
            TextView content = new TextView(context);
            content.setWidth(300);
            content.setHeight(500);
            content.setBackgroundColor(colors[4]);
            content.setText(gank.getContent());
            dialog.setContentView(content);
            dialog.setCancelable(true);
            dialog.show();
        });
    }

    @Override
    public void onListener(OnTListener onTListener) {
        this.onTListener = onTListener;
    }

    private void setColor(CardView gankCv, int position) {
        gankCv.setCardBackgroundColor(AppCompatResources.getColorStateList(context, colors[position % colors.length]));
    }

    private QMUIDialog getDialog() {
        if (dialog == null) {
            dialog = new QMUIDialog(context);
        }
        return dialog;
    }
}

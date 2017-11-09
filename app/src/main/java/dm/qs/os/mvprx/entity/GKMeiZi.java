package dm.qs.os.mvprx.entity;

import com.google.gson.Gson;
import com.qs.base.entity.DataType;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：妹纸图
 */
public class GKMeiZi implements DataType {

    /**
     * _id : 5a011452421aa90fe7253606
     * createdAt : 2017-11-07T10:02:58.73Z
     * desc : 11-7
     * publishedAt : 2017-11-08T11:00:50.559Z
     * source : chrome
     * type: "福利"
     * url : http://7xi8d6.com1.z0.glb.clouddn.com/20171107100244_0fbENB_yyannwong_7_11_2017_10_2_5_982.jpeg
     * used : true
     * who : daimajia
     */
    /**
     * id
     */
    private String _id;
    /**
     * 创建日期
     */
    private String createdAt;
    /**
     * 创建月日
     */
    private String desc;
    /**
     * 出版日期
     */
    private String publishedAt;
    /**
     * 浏览器类型
     */
    private String source;
    /**
     * 类型
     */
    private String type;
    /**
     * 图片地址
     */
    private String url;
    /**
     * 被使用
     */
    private boolean used;
    /**
     * 作者
     */
    private String who;

    GKMeiZi() {

    }

    /**
     * 转实体
     *
     * @param str json数据
     * @return 实体
     */
    public static GKMeiZi objectFromData(String str) {

        return new Gson().fromJson(str, GKMeiZi.class);
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String get_id() {
        return _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public boolean getUsed() {
        return used;
    }

    public String getWho() {
        return who;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GKMeiZi{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }

    @Override
    public int getViewType() {
        return 1;
    }
}

package dm.qs.os.mvprx.entity;

import com.google.gson.Gson;
import com.qs.base.entity.DataType;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：干货集中营-Android数据
 */
public class GanKAndroid implements DataType {

    /**
     * _id : 5a000a51421aa90fef203504
     * createdAt : 2017-11-06T15:08:01.257Z
     * desc :  使用CMake来进行Android NDK开发
     * publishedAt : 2017-11-08T11:00:50.559Z
     * source : chrome
     * type : Android
     * url : http://blog.csdn.net/qq_34902522/article/details/78104610
     * used : true
     * who : 宇宝守护神
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

    GanKAndroid() {

    }

    public static GanKAndroid objectFromData(String str) {

        return new Gson().fromJson(str, GanKAndroid.class);
    }

    @Override
    public int getViewType() {
        return 1;
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

    public void setType(String type) {
        this.type = type;
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

    public String getType() {
        return type;
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

    @Override
    public String toString() {
        return "GanKAndroid{" +
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
}

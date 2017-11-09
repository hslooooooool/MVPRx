package dm.qs.os.mvprx.entity;

import com.qs.base.entity.DataType;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：干货集中营数据，测试用用
 */
public class Gank implements DataType {

    private String _id;
    private String created_at;
    private String publishedAt;
    private String content;
    private String rand_id;
    private String title;
    private String updated_at;

    Gank() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getRand_id() {
        return rand_id;
    }

    public void setRand_id(String rand_id) {
        this.rand_id = rand_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getViewType() {
        return 1;
    }

    @Override
    public String toString() {
        return "Gank{" +
                "_id='" + _id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                ", rand_id='" + rand_id + '\'' +
                ", title='" + title + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}

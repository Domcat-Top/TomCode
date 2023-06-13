package com.tom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tom
 * @since 2023-06-13
 */
@TableName("blog")
public class Blog extends Model<Blog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String blogName;

    private String label;

    private String comeForm;

    private String introduction;

    private String blogContent;

    private String url;

    private Integer view;

    private Integer version;

    /**
     * 默认0，未删除状态，1是已删除状态
     */
    private Integer deleted;

    private Date create_time;

    private Date update_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public String getComeForm() {
        return comeForm;
    }

    public void setComeForm(String comeForm) {
        this.comeForm = comeForm;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Blog{" +
        "id=" + id +
        ", blogName=" + blogName +
        ", label=" + label +
        ", comeForm=" + comeForm +
        ", introduction=" + introduction +
        ", blogContent=" + blogContent +
        ", url=" + url +
        ", view=" + view +
        ", version=" + version +
        ", deleted=" + deleted +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        "}";
    }
}

package com.qxm.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

public class Menue implements Serializable {

    @TableId
    private Long id;
    private String icon;
    private String label;
    private String name;
    private String path;
    private String url;
    @TableField(exist = false) //不参与查询
    private List<Menue> children;
    private String staus;

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    @Override
    public String toString() {
        return "Menue{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }

    public List<Menue> getChildren() {
        return children;
    }

    public void setChildren(List<Menue> children) {
        this.children = children;
    }

    public Menue() {
    }

    public Menue(Long id, String icon, String label, String name, String path, String url) {
        this.id = id;
        this.icon = icon;
        this.label = label;
        this.name = name;
        this.path = path;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

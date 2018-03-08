package com.inid.sil.geektest;

/**
 * created by Guan at 2018/3/8 0008 下午 3:23
 * description:
 */
public class AppInfo {
    private String icon;
    private String name;
    private String description;
    private String size;
    private String url;

    public AppInfo(String icon, String name, String description, String size, String url) {
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.size = size;
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

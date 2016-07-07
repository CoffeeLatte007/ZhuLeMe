package com.taotao.rest.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by lz on 2016/6/12.
 */
public class ItemCat {
    //转换成json数据时使用u作为key
    @JsonProperty("u")
    private String url;
    //转换成json数据时使用n作为key
    @JsonProperty("n")
    private String name;
    @JsonProperty("i")
    private List<?> item;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }
}

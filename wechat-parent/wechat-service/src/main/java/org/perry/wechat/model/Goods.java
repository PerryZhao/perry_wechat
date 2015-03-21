package org.perry.wechat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Goods {

    @Id
    private String id;
    private String name;
    private String readOnly;

    public Goods() {
        super();
    }

    public Goods(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Goods(String id, String name, String readOnly) {
        super();
        this.id = id;
        this.name = name;
        this.readOnly = readOnly;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

}

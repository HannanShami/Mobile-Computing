package com.example.customizedlistview;

public class Student {
    private String name;
    private String id;
    private int imageid;

    public Student(String name, String id, int imageid) {
        this.name = name;
        this.id = id;
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}

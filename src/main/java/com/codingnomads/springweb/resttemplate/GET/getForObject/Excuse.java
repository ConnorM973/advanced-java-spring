package com.codingnomads.springweb.resttemplate.GET.getForObject;


public class Excuse {
    private int id;
    private String excuse;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExcuse() {
        return excuse;
    }

    public void setExcuse(String excuse) {
        this.excuse = excuse;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Excuse{" +
                "id=" + id +
                ", excuse='" + excuse + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

package com.example.unext;

public class CaruNextItem {
    private int ImageId;
    private String description;
    private String value;

    public CaruNextItem(String description) {
        this.description = description;
    }

    public CaruNextItem(int imageId, String description, String value) {
        this.ImageId = imageId;
        this.description = description;
        this.value = value;
    }

    public int getImageId() {
        return ImageId;
    } public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getDescription() {
        return description;
    }public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }public void setValue(String value) {
        this.value = value;
    }
}

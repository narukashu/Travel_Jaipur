package com.example.traveljaipur;

public class Item {
    private String itemTitle;
    private int itemImageResourceId;
    private String placeLocation;
    private String[] place_Highlights;
    private String itemProvider;

    public Item(String title, int imageResourceId, String location) {
        itemTitle = title;
        itemImageResourceId = imageResourceId;
        placeLocation = location;
    }

    public Item(String title, int imageResourceId, String location, String[] highlights, String provider) {
        itemTitle = title;
        itemImageResourceId = imageResourceId;
        placeLocation = location;
        place_Highlights = highlights;
        itemProvider = provider;
    }


    public String[] getHighlights() {
        return place_Highlights;
    }


    public String getProvider() {
        return itemProvider;
    }


    public String getTitle() {
        return itemTitle;
    }


    public int getImageResourceId() {
        return itemImageResourceId;
    }


    public String getLocation() {
        return placeLocation;
    }

}

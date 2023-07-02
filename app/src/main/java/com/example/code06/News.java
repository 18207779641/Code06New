package com.example.code06;

public class News {
    private String mTitle;
    private String mAuthor;
    private String mContent;
    private int mImageId;

    public String getTitle() {
    return mTitle;
    }

     public void setTitle(String title) {
         this.mTitle = title;
     }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String Author) {
        this.mAuthor = Author;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int mImageId) {
        this.mImageId = mImageId;
    }
}

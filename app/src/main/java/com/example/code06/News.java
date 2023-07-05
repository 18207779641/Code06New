package com.example.code06;

import android.graphics.Bitmap;

public class News {
    private String mTitle;
    private String mAuthor;
    private String mContent;
    private Bitmap mImageId;

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

    public Bitmap getImageId() {
        return mImageId;
    }

    public void setImageId(Bitmap mImageId) {
        this.mImageId = mImageId;
    }


    public void setImage(Bitmap bitmap) {
        this.mImageId=bitmap;
    }

}

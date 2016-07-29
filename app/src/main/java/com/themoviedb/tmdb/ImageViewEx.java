package com.themoviedb.tmdb;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class ImageViewEx extends ImageView {
    private float aspectRatio;

    public ImageViewEx(Context context) {
        super(context);
    }

    public ImageViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int requiredHeight = (int) (getMeasuredWidth() * 1.4);
        setMeasuredDimension(getMeasuredWidth(), requiredHeight > 0 ? requiredHeight : getMeasuredHeight());
    }
}

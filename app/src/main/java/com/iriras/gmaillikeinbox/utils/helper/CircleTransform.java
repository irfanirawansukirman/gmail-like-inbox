package com.iriras.gmaillikeinbox.utils.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by irfan on 28/02/17.
 */

public class CircleTransform extends BitmapTransformation {
    public CircleTransform(Context context) {
        super(context);
    }

    public CircleTransform(BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool, toTransform);
    }

    private static Bitmap circleCrop(BitmapPool mBitmapPool, Bitmap mBitmap) {
        if (mBitmap == null) return null;

        int mSize = Math.min(mBitmap.getWidth(), mBitmap.getHeight());
        int x = (mBitmap.getWidth() - mSize) / 2;
        int y = (mBitmap.getHeight() - mSize) / 2;

        //TODO this could be acquired from the pool too
        Bitmap mSquared = Bitmap.createBitmap(mBitmap, x, y, mSize, mSize);
        Bitmap mResult = mBitmapPool.get(mSize, mSize, Bitmap.Config.ARGB_8888);
        if (mResult == null) {
            mResult = Bitmap.createBitmap(mSize, mSize, Bitmap.Config.ARGB_8888);
        }

        Canvas mCanvas = new Canvas(mResult);
        Paint mPaint = new Paint();
        mPaint.setShader(new BitmapShader(mSquared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        mPaint.setAntiAlias(true);
        float r = mSize / 2f;
        mCanvas.drawCircle(r, r, r, mPaint);
        return mResult;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}

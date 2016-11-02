package com.violin.readingnews.kit.image;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.violin.readingnews.R;

/**
 * Created by whl on 2016/11/1.
 */

public class ImageUtils {
    public static void loadImage(Context context, String url, final ImageView imageView) {
        imageView.setTag(TAG_KEY, ImageState.loading);
        if (url.endsWith(".gif")) {
            Glide.with(context).load(url)
                    .asGif()
                    .thumbnail(0.1f)
                    .animate(R.anim.item_alpha_in)
                    .error(R.drawable.image_reload)
                    .placeholder(R.drawable.image_loading)
                    .listener(new RequestListener<String, GifDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
                            imageView.setTag(TAG_KEY, ImageState.error);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            imageView.setTag(TAG_KEY, ImageState.success);
                            return false;
                        }
                    })
                    .into(imageView);
        } else {

            Glide.with(context)
                    .load(url)
                    .thumbnail(0.1f)//设置加载缩略图
                    .animate(R.anim.item_alpha_in)//设置加载动画
                    .error(R.drawable.image_reload)
                    .placeholder(R.drawable.image_loading)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            imageView.setTag(TAG_KEY, ImageState.error);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            imageView.setTag(TAG_KEY, ImageState.success);
                            return false;
                        }
                    })
                    .into(imageView);
        }

    }

    //图片加载的三种状态
    public enum ImageState {
        loading, success, error;
    }

    public static int TAG_KEY = -100;


}

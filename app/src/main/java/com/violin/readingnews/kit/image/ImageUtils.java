package com.violin.readingnews.kit.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by whl on 2016/11/1.
 */

public class ImageUtils {
    public static void loadImage(Context context, String url, ImageView imageView) {
        if (isEmpty()) return;
        Glide.with(context).load(url).into(imageView);

    }

    private static boolean isEmpty(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                return true;
            }

        }

        return false;
    }
}

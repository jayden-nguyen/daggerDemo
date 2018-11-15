package com.example.admin.daggerretrofitproject1.modules.home.adapter

import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget

class ImageHandler(private val mCakeIcon: ImageView) : SimpleTarget<GlideDrawable>() {

    override fun onResourceReady(resource: GlideDrawable?, glideAnimation: GlideAnimation<in GlideDrawable>?) {
        mCakeIcon.setImageDrawable(resource)
        val drawable = mCakeIcon.drawable.current as GlideBitmapDrawable
        val bitmap = drawable.bitmap
    }

}

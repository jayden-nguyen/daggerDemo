package com.example.admin.daggerretrofitproject1.modules.details

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.admin.daggerretrofitproject1.R
import com.example.admin.daggerretrofitproject1.base.BaseActivity
import com.example.admin.daggerretrofitproject1.modules.home.adapter.ImageHandler
import com.example.admin.daggerretrofitproject1.mvp.model.Cake
import org.w3c.dom.Text

class DetailActivity: BaseActivity() {
    @BindView(R.id.cakeImage) protected lateinit var mCakeImage: ImageView
    @BindView(R.id.cakeTitle) protected lateinit var mCakeTitle: TextView
    @BindView(R.id.cakeDescription) protected lateinit var mCakeDescription: TextView

    override fun getContentView(): Int = R.layout.activity_detail
    override fun onViewReady(savesInstanceState: Bundle?, intent: Intent) {
        super.onViewReady(savesInstanceState, intent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCakeImage.setTransitionName("cakeImageAnimation")
        }

        showBackArrow()

        val cake = intent.getSerializableExtra(Companion.CAKE) as Cake
        title = "Cake Detail"

        mCakeTitle.text = cake.title
        mCakeDescription.text = cake.detailDescription

        Glide.with(this).load(cake.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(ImageHandler(mCakeImage))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val CAKE = "cake"
    }


}
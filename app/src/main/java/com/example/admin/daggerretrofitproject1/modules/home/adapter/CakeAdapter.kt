package com.example.admin.daggerretrofitproject1.modules.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.admin.daggerretrofitproject1.R
import com.example.admin.daggerretrofitproject1.mvp.model.Cake

class CakeAdapter(private val mLayoutInflater: LayoutInflater): RecyclerView.Adapter<CakeAdapter.Holder>() {
    private var mCakeList = ArrayList<Cake>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(mLayoutInflater.inflate(R.layout.list_item_layout,parent, false))
    }

    override fun getItemCount(): Int {
        return mCakeList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(mCakeList[position])
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {

        }

        @BindView(R.id.cake_icon) protected lateinit var mCakeIcon: ImageView
        @BindView(R.id.textview_title) protected lateinit var mCakeTitle: TextView
        @BindView(R.id.textview_preview_description) protected lateinit var mCakePreviewDescription: TextView

        lateinit var mContext: Context
        lateinit var mCake: Cake

        init {
            itemView.setOnClickListener(this)
            mContext = itemView.context
            ButterKnife.bind(this, itemView)
        }

        fun bind(cake: Cake) {
            mCake = cake
            mCakeTitle.text = cake.title
            mCakePreviewDescription.text = cake.previewDescription

            Glide.with(mContext).load(cake.imageUrl).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(ImageHandler(mCakeIcon))
        }
    }

    fun setCakeListener(listener: OnCakeClickListener) {
        if (mCakeClickListener != null) {
            mCakeClickListener = listener
        }
    }

    fun addCakes(cakes: List<Cake>) {
        mCakeList.addAll(cakes)
        notifyDataSetChanged()
    }

    fun clearCakes() {
        mCakeList.clear()
        notifyDataSetChanged()
    }

    private lateinit var mCakeClickListener: OnCakeClickListener
    interface OnCakeClickListener {
        fun onClick(v: View, cake: Cake, position: Int)
    }

}
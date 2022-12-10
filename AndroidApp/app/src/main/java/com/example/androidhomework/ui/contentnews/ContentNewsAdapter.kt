package com.example.androidhomework.ui.contentnews

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidhomework.databinding.GuardianNewsBinding
import com.guardian.guardian.news.data.NewsResultDto

class ContentNewsAdapter: RecyclerView.Adapter<ContentNewsAdapter.BaseViewHolder>() {

    private val items: MutableList<NewsResultDto> = mutableListOf()

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(GuardianNewsBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    private var onItemClickListener: ((NewsResultDto) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<NewsResultDto>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: NewsResultDto)
    }

    inner class NewsViewHolder(private val binding: GuardianNewsBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: NewsResultDto) {
            binding.guardianNewsTextView1.text = item.sectionName
            binding.guardianNewsTextView2.text = item.webTitle
            binding.guardianNewsTextView3.text = item.webPublicationDate
            item.fields.thumbnail.let {
                Glide.with(context).load(item.fields.thumbnail).centerCrop()
                    .into(binding.guardianNewsImageView)
            }
            itemView.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }
        }
    }

    fun setOnItemClickListener(listener: (NewsResultDto) -> Unit) {
        onItemClickListener = listener
    }
}
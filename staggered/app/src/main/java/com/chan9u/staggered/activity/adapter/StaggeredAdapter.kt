package com.chan9u.staggered.activity.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chan9u.staggered.R
import com.chan9u.staggered.databinding.ItemStaggeredListBinding
import com.chan9u.staggered.utils.bind
import com.chan9u.staggered.utils.loadRound

class StaggeredAdapter: RecyclerView.Adapter<StaggeredAdapter.StaggeredViewHolder>() {

    private var adapterItemList: MutableList<StaggeredListData> = mutableListOf()

    inner class StaggeredViewHolder (
            val binding: ItemStaggeredListBinding
    ): RecyclerView.ViewHolder(
        binding.root
    ){
        fun bindViewHolder(pos: Int) {
            with(adapterItemList[pos]) {
                binding.ivItem.loadRound(this.imgStr.toString(), 10)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredViewHolder
            = StaggeredViewHolder(parent.bind(R.layout.item_staggered_list))

    override fun getItemCount(): Int = adapterItemList.size

    override fun onBindViewHolder(holder: StaggeredViewHolder, position: Int) {
        holder.bindViewHolder(position)
    }

    fun addItemList(list: MutableList<StaggeredListData>) {
        adapterItemList.clear()
        adapterItemList.addAll(list)
        notifyDataSetChanged()
    }
}
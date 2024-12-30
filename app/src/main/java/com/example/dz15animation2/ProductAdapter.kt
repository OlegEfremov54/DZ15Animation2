package com.example.dz15animation2

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.support.v4.os.IResultReceiver._Parcel
import android.view.LayoutInflater
import android.view.ViewGroup

class ProductAdapter(private val context: Context, private val list: List<Product>) : RecyclerView.Adapter<ProductAdapter.ItemViewHolder>() {

    private var _productClickListener: OnItemClickListener? = null;

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTV: TextView = itemView.findViewById(R.id.tv_name)
        private val imageIV: ImageView = itemView.findViewById(R.id.iv_image)
        private val priceTV: TextView = itemView.findViewById(R.id.tv_price)

        fun bind(product: Product) {
            nameTV.text = product.name
            imageIV.setImageResource(product.imageResource)
            priceTV.text = "${product.price} $"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewHolder = ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = list[position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            _productClickListener?.onItemClick(position);
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        _productClickListener = itemClickListener
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}
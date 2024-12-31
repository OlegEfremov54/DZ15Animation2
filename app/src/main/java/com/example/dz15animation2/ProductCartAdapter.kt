package com.example.dz15animation2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductCartAdapter (private val context: Context, private var map: Map<Product, Int>) : RecyclerView.Adapter<ProductCartAdapter.ItemViewHolder>() {

    private var _productClickListener: OnItemClickListener? = null;

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTV: TextView = itemView.findViewById(R.id.tv_name)
        private val imageIV: ImageView = itemView.findViewById(R.id.iv_image)
        private val priceTV: TextView = itemView.findViewById(R.id.tv_price)
        private val countTV: TextView = itemView.findViewById(R.id.tv_count)

        fun onBind(product: Product, count: Int) {
            countTV.text = "${count} шт."
            nameTV.text = product.name
            imageIV.setImageResource(product.imageResource)
            priceTV.text = "${product.price * count} $"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewHolder = ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_cart, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = map.toList()[position]
        holder.onBind(currentItem.first, currentItem.second)
        holder.itemView.setOnClickListener {
            _productClickListener?.onItemClick(position);
        }
    }
    //Размер массива
    override fun getItemCount(): Int {
        return map.size
    }
    //ИНтерфейс клика по позиции
    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        _productClickListener = itemClickListener
    }
    //Обновление экрана
    fun updateMap(updatedMap: Map<Product, Int>) {
        map = updatedMap
        notifyDataSetChanged()
    }
}
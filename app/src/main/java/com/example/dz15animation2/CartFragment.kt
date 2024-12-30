package com.example.dz15animation2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class CartFragment : Fragment() {
    private lateinit var itemsRV: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: ProductCartAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsRV = view.findViewById(R.id.rv_items_cart)
        fab = view.findViewById(R.id.fab_cart)

        adapter = ProductCartAdapter(requireContext(), Products.getCartWithCount())
        itemsRV.adapter = adapter

        adapter.setOnItemClickListener {
            val item = Products.getCartWithCount().toList()[it]
            val dialog = AlertDialog.Builder(requireContext())
            dialog.setTitle("Внимание!")
                .setMessage("Вы хотите удалить ${item.first.name} из корзины?")
                .setPositiveButton("Удалить") { dialog, _ ->
                    deleteFromCart(item)
                    dialog.dismiss()
                }
                .setNeutralButton("Отмена", null)
                .create().show()
        }

        fab.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.cl_main, CheckFragment())
                .commit()
        }
    }

    private fun deleteFromCart(item: Pair<Product, Int>) {
        val index = Products.cart.indexOf(item.first)
        Products.cart.removeAt(index)
        adapter.updateMap(Products.getCartWithCount())
    }
}
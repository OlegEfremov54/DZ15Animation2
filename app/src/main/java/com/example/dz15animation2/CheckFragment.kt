package com.example.dz15animation2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class CheckFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkTV = view.findViewById<TextView>(R.id.tv_check)
        checkTV.text = generateCheck()
    }

    private fun generateCheck(): String {

        return getString(R.string.tv_check) + (1..10000).random() +
                "\n\n" + toString(Products.getCartWithCount()) +
                "\n\n" + "ИТОГО: ${getSummaryOfCart(Products.getCartWithCount())} $"


    }

    private fun toString(map: Map<Product, Int>) : String {
        val stringBuilder = StringBuilder()
        var counter = 0
        for (entry in map) {
            counter++
            stringBuilder.append("$counter) ${entry.key.name} - ${entry.value} шт.: ${entry.value * entry.key.price} $\n")
        }
        return stringBuilder.toString()
    }

    private fun getSummaryOfCart(map: Map<Product, Int>) : Int {
        var sum = 0
        map.forEach {key, value ->
            sum += key.price * value
        }
        return sum
    }

}
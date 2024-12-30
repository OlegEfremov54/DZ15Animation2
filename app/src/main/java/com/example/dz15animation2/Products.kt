package com.example.dz15animation2

object Products {
    val list = mutableListOf(
        Product("Яблоко красное", 20, R.drawable.apllered),
        Product("Яблоко зеленое", 15, R.drawable.apllegrin),
        Product("Груша ", 30, R.drawable.grusha),
        Product("Огурцы тепличные", 120, R.drawable.ogurec),
        Product("Перец рамиро", 50, R.drawable.perecramiro),
        Product("Перец Чили горький", 12, R.drawable.perecchili),
        Product("Перец красный ", 10, R.drawable.perecred),
        Product("Перец ласточка болгарский зеленый", 25, R.drawable.perecyelloy),
        Product("Перец оранжевый", 8, R.drawable.perecorand),
        Product("Банан", 40, R.drawable.banaan),
        Product("Манго", 40, R.drawable.mango)
    )

    val cart = mutableListOf<Product>()

    fun getCartWithCount() : Map<Product, Int> {
        return cart.groupingBy { it }.eachCount()
    }
}
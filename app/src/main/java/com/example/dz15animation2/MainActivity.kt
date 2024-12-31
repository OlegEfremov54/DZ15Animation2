package com.example.dz15animation2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar
    private lateinit var startBtn:Button
    private lateinit var headerTV:TextView
    private lateinit var logoIV:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Тулбар
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "  Продовольственная корзина"
        toolbarMain.subtitle = " Версия 1. Анимация 2"
        toolbarMain.setLogo(R.drawable.shop)
        //Привязываем кнопки и поля
        startBtn = findViewById(R.id.btn_start)
        headerTV = findViewById(R.id.tv_header)
        logoIV = findViewById(R.id.iv_logo)
        //Запускаем анимацию заставки
        headerTV.translationY = -400f
        headerTV.animate().apply {
            duration = 1000
            translationY(0f)
        }
        //Анимация логотипа магазина
        logoIV.rotationY = -360f
        logoIV.animate().apply {
            startDelay = 1000
            duration = 2000
            rotationY(0f)
        }
        //Анимация кнопки
        startBtn.alpha = 0f
        startBtn.animate().apply {
            startDelay = 3000
            duration = 1000
            alphaBy(1f)
        }
        //Обработка кнопки
        startBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.cl_main, MarketFragment())
                .commit()
            startBtn.visibility = View.GONE
            headerTV.visibility = View.GONE
            logoIV.visibility = View.GONE
        }
    }

    //Инициализация Меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.infoMenuMain -> {
                Toast.makeText(
                    applicationContext, "Автор Ефремов О.В. Создан 30.12.2024",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG
                ).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
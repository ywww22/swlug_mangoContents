package com.example.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBookmark = findViewById<Button>(R.id.btnBookmark)
        btnBookmark.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/jG8XSroH_X",
                "https://mp-seoul-image-production-s3.mangoplate.com/717736_1635120984417495.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "떡도리탕"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/HaMU0-Z406da",
                "https://mp-seoul-image-production-s3.mangoplate.com/2161246_1642408422985197.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "전풍호텔라운지"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/oL28gVfQOloE",
                "https://mp-seoul-image-production-s3.mangoplate.com/354535/875156_1604216679973_6751?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "익선주택"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/DgcYNZUpqiQ_",
                "https://mp-seoul-image-production-s3.mangoplate.com/345847/972691_1587864771110_20882?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "몽상가크레이프"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/tgyp7YA2_27R",
                "https://mp-seoul-image-production-s3.mangoplate.com/2178805_1650330603353553.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "용곱창"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/FhaXbQOGyRik",
                "https://mp-seoul-image-production-s3.mangoplate.com/664803_1615113157238443.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "르몽블랑"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/94yYaaTGoSt9",
                "https://mp-seoul-image-production-s3.mangoplate.com/1533710_1648725882874218.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "띵크프룻"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Md_Y8DfKN5Hr",
                "https://mp-seoul-image-production-s3.mangoplate.com/1593527_1596799317512109.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "랫댓"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object : RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("imageUrl", items[position].imageUrl)
                intent.putExtra("title", items[position].titleText)
                startActivity(intent)
            }
        }
        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }
}
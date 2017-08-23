package com.site11.jugomo.zooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_detail.*
import kotlinx.android.synthetic.main.animal_cell.*

class AnimalDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)

        var bundle = intent.extras
        var name = bundle.getString("name")
        var description = bundle.getString("description")
        var image = bundle.getInt("image")

        tvNameDetail.text = name
        tvDescriptionDetail.text = description
        ivImageDetail.setImageResource(image)

    }
}

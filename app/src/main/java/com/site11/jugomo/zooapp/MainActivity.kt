package com.site11.jugomo.zooapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_cell.*
import kotlinx.android.synthetic.main.animal_cell.view.*

class MainActivity : AppCompatActivity() {

    var listAnimal = ArrayList<Animal>()
    var adapter: AnimalsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load animals
        listAnimal.add(
                Animal("Baboon", "babon es un mono monisimo", R.drawable.baboon, false))
        listAnimal.add(
                Animal("Bulldog", "Bulldog es un perro monisimo", R.drawable.bulldog, false))
        listAnimal.add(
                Animal("Panda", "Panda es un oso monisimo", R.drawable.panda, false))
        listAnimal.add(
                Animal("Swallow", "Swallow es un pajaro monisimo", R.drawable.swallow_bird, false))
        listAnimal.add(
                Animal("Tiger", "Tiger es un tigre monisimo", R.drawable.white_tiger, true))
        listAnimal.add(
                Animal("Zebra", "Zebra es un burro monisimo", R.drawable.zebra, false))

        adapter = AnimalsAdapter(applicationContext, listAnimal)
        lvListAnimal.adapter = adapter
    }

    fun delete(position: Int) {
        listAnimal.removeAt(position)
        adapter!!.notifyDataSetChanged()
    }

    fun add(position: Int) {
        listAnimal.add(position, listAnimal[position])
        adapter!!.notifyDataSetChanged()
    }

    inner class AnimalsAdapter: BaseAdapter {
        var listAnimal = ArrayList<Animal>()
        var context: Context

        constructor(context: Context, listAnimal: ArrayList<Animal>) : super() {
            this.listAnimal = listAnimal
            this.context = context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listAnimal[p0]
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView: View?

            if (animal.isKiller) {
                myView = inflater.inflate(R.layout.animal_killer_cell, null)
            } else {
                myView = inflater.inflate(R.layout.animal_cell, null)
            }

            myView.tvName.text = animal.name!!
            myView.tvDescription.text = animal.description!!
            myView.ivName.setImageResource(animal.image!!)

            myView.setOnClickListener {
                val intent = Intent(context, AnimalDetail::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("description", animal.description)
                intent.putExtra("image", animal.image!!)

                context.startActivity(intent)
            }

            myView.ivName.setOnClickListener {
                add(p0)
            }

            myView.btDelete.setOnClickListener {
                delete(p0)
            }

            return myView
        }

        override fun getItem(p0: Int): Any {
            return listAnimal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listAnimal.size
        }

    }

}

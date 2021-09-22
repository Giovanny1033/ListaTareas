package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    val itemlist = arrayListOf<String>("Tarea1, tarea2, tarea3, tarea4")
    var adapter: ArrayAdapter<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Agregar los elementos a la lista cuando se presiona el botón Agregar
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlist)
        val addListView = findViewById<ListView>(R.id.listView)
        addListView.adapter = adapter
        val editText = findViewById<EditText>(R.id.editText)
        val add = findViewById<Button>(R.id.add)

        add.setOnClickListener {
            itemlist.add(editText.text.toString())
            adapter?.notifyDataSetChanged()
        }





        fun agregarTexto() {
            itemlist.add("Otra tarea")
            adapter?.notifyDataSetChanged()
        }

        fun eliminarTexto() {
            itemlist.removeAt(itemlist.size - 1)
            adapter?.notifyDataSetChanged()

        }
    }
}

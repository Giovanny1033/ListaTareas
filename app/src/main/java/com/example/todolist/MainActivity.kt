package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    val itemlist = arrayListOf<String>("Tarea1, tarea2, tarea3, tarea4")
    var adapter = ArrayAdapter<String>(
        this,
        android.R.layout.simple_list_item_multiple_choice, itemlist
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Agregar los elementos a la lista cuando se presiona el botón Agregar
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlist)
        val addListView = findViewById<ListView>(R.id.listView)
        addListView.adapter = adapter
        addListView.setOnClickListener {


            itemlist.add(editText.text.toString())
            val listView = null
            listView.adapter = adapter
            adapter.notifyDataSetChanged()

            // Seleccionar y eliminar elementos de la lista cuando se presiona el botón Eliminar
            val deleteListView = findViewById<ListView>(R.id.listView)
            deleteListView.setOnClickListener {
                val position: SparseBooleanArray = listView.checkedItemPositions
                val count = listView.count
                var item = count - 1
                while (item >= 0) {
                    if (position.get(item)) {
                        adapter.remove(itemlist.get(item))
                    }
                    item--
                }
                position.clear()
                adapter.notifyDataSetChanged()
            }
            val miBoton = findViewById<Button>(R.id.add)
            miBoton.setOnClickListener {
                agregarTexto()
            }
            val miBoton2 = findViewById<Button>(R.id.delete)
            miBoton2.setOnClickListener {
                eliminarTexto()
            }
        }

        }
    fun agregarTexto(){
        itemlist.add("Otra tarea")
        adapter?.notifyDataSetChanged()
    }

    fun eliminarTexto() {
        itemlist.removeAt(itemlist.size-1)
        adapter?.notifyDataSetChanged()

    }
    }

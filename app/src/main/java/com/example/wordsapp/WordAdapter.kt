/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.objects.Skin
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_skin.view.*

/**
 * Adapter for the [RecyclerView] in [DetailActivity].
 */
class WordAdapter(private var lista: ArrayList<Skin>,private var contexto: Context) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    //private val filteredWords: List<String>

    /*init {
        // Retrieve the list of words from res/values/arrays.xml
        val words = context.resources.getStringArray(R.array.words).toList()

        filteredWords = words
            // Returns items in a collection if the conditional clause is true,
            // in this case if an item starts with the given letter,
            // ignoring UPPERCASE or lowercase.
            .filter { it.startsWith(letterId, ignoreCase = true) }
            // Returns a collection that it has shuffled in place
            .shuffled()
            // Returns the first n items as a [List]
            .take(5)
            // Returns a sorted version of that [List]
            .sorted()
    }*/


    // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
    /*holder.button.setOnClickListener {
        val queryUrl: Uri = Uri.parse("${WordListFragment.SEARCH_PREFIX}${item}")
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        context.startActivity(intent)
    }*/
    // Setup custom accessibility delegate to set the text read with
    // an accessibility service
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.look_up_word)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }
    }

    class ViewHolder(var vista:View, var contexto: Context):RecyclerView.ViewHolder(vista){
        fun bind(skin: Skin) {
            vista.titulo.text = skin.nombre
            vista.precio.text = skin.descripcion

            vista.setOnClickListener{
                val queryUrl: Uri = Uri.parse("${skin.url}")
                val intent = Intent(Intent.ACTION_VIEW, queryUrl)
                contexto.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_skin,parent,false),contexto)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = lista[position]
        Picasso.get().load(item.imagen).into(holder.vista.imagen)
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}
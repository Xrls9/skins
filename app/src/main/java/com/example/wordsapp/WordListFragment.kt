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

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentWordListBinding
import com.example.wordsapp.objects.Skin


/**
 * Displays a [RecyclerView] of words with search buttons to look them up.
 */
class WordListFragment : Fragment() {

    /**
     * Provides global access to these variables from anywhere in the app
     * via DetailListFragment.<variable> without needing to create
     * a DetailListFragment instance.
     */
    companion object {
        val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private var _binding: FragmentWordListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var genero: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve the LETTER from the Fragment arguments
        arguments?.let {
            genero = it.getString(LETTER).toString()
        }
    }

    private fun generarSkins():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"SG 553 | Integrale","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/SG_553_Integrale.webp","https://www.csgodatabase.com/skins/sg-553-integrale/",1))
       // skins.add(Skin(2,"Dual Berettas | Twin Turbo","$2.94","https://www.csgodatabase.com/images/skins/webp/Dual_Berettas_Twin_Turbo.webp",1))
//        skins.add(Skin(3,"AK-47 | Safety Net","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/AK-47_Safety_Net.webp",1))
//        skins.add(Skin(4,"P250 | Vino Primo","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/P250_Vino_Primo.webp",1))
//        skins.add(Skin(5,"MP7 | Fade","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/MP7_Fade.webp",1))
//        skins.add(Skin(6,"USP-S | Check Engine","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/USP-S_Check_Engine.webp",1))
//        skins.add(Skin(7,"M4A4 | Converter","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/M4A4_Converter.webp",1))
//        skins.add(Skin(8,"SSG 08 | Hand Brake","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/SSG_08_Hand_Brake.webp",1))
//        skins.add(Skin(9,"Sawed-Off | Brake Light","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/Sawed-Off_Brake_Light.webp",1))
//        skins.add(Skin(10,"Glock-18 | High Beam","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/Glock-18_High_Beam.webp",1))
        return skins
    }
    private fun generarSkinsCol2():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
  //      skins.add(Skin(11,"M4A1-S | Control Panel","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/M4A1-S_Control_Panel.webp",2))
//        skins.add(Skin(12,"Tec-9 | Remote Control","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/Tec-9_Remote_Control.webp",2))
//        skins.add(Skin(13,"Glock-18 | Nuclear Garden","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/Glock-18_Nuclear_Garden.webp",2))
//        skins.add(Skin(14,"MAG-7 | Core Breach","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/MAG-7_Core_Breach.webp",2))
//        skins.add(Skin(15,"AUG | Random Access","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/AUG_Random_Access.webp",2))
//        skins.add(Skin(16,"AWP | Acheron","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/AWP_Acheron.webp",2))
//        skins.add(Skin(17,"P250 | Exchanger","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/P250_Exchanger.webp",2))
//        skins.add(Skin(18,"MP5-SD | Co-Processor","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/MP5-SD_Co-Processor.webp",2))
//        skins.add(Skin(19,"P90 | Facility Negative","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/P90_Facility_Negative.webp",2))
//        skins.add(Skin(20,"Galil AR | Cold Fusion","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/Galil_AR_Cold_Fusion.webp",2))
//        skins.add(Skin(21,"Negev | Bulkhead","No Pricing Available","https://www.csgodatabase.com/images/skins/webp/Negev_Bulkhead.webp",2))
        return skins
    }

    private fun PeliculasAccion():ArrayList<Pelicula>{
        var lista = ArrayList<Pelicula>()
        lista.add(Pelicula(R.drawable.el_rey_escorpion,"El Rey Escorpion"))
        lista.add(Pelicula(R.drawable.john_wick_2,"John Wick 2"))
        lista.add(Pelicula(R.drawable.rapido_y_furiosos,"Rapido y Furiosos"))
        return lista
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var list : ArrayList<Skin> =  ArrayList<Skin>();
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        Log.d("asas",genero.toString())
        if (genero.equals("The 2018 Inferno Collection")){
            list = generarSkins()
        }else if(genero.equals("The 2018 Nuke Collection")){
            list = generarSkinsCol2()
        }else if(genero.equals("The Bank Collection")){

        }else if(genero.equals("The Dust 2 Collection")){

        }else if(genero.equals("The Italy Collection")){

        }else if(genero.equals("The Lake Collection")){

        }else if(genero.equals("The Safehouse Collection")){

        }else if(genero.equals("The Train Collection")){

        }
        
        recyclerView.adapter = WordAdapter(list, requireContext())

        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

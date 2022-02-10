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

    private fun genInfernoCollection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()

        skins.add(Skin(1,"SG 553 | Integrale","https://www.csgodatabase.com/images/skins/SG_553_Integrale.png","https://www.csgodatabase.com/skins/sg-553-integrale/","No Pricing Available",1))
        skins.add(Skin(2,"Dual Berettas | Twin Turbo","https://www.csgodatabase.com/images/skins/Dual_Berettas_Twin_Turbo.png","https://www.csgodatabase.com/skins/dual-berettas-twin-turbo/","$14.99",1))
        skins.add(Skin(3,"AK-47 | Safety Net","https://www.csgodatabase.com/images/skins/AK-47_Safety_Net.png","https://www.csgodatabase.com/skins/ak-47-safety-net/","No Pricing Available",1))
        skins.add(Skin(4,"P250 | Vino Primo","https://www.csgodatabase.com/images/skins/P250_Vino_Primo.png","https://www.csgodatabase.com/skins/p250-vino-primo/","No Pricing Available",1))
        skins.add(Skin(5,"MP7 | Fade","https://www.csgodatabase.com/images/skins/MP7_Fade.png","https://www.csgodatabase.com/skins/mp7-fade/","No Pricing Available",1))
        skins.add(Skin(6,"USP-S | Check Engine","https://www.csgodatabase.com/images/skins/USP-S_Check_Engine.png","https://www.csgodatabase.com/skins/usp-s-check-engine/","No Pricing Available",1))
        skins.add(Skin(7,"M4A4 | Converter","https://www.csgodatabase.com/images/skins/M4A4_Converter.png","https://www.csgodatabase.com/skins/m4a4-converter/","No Pricing Available",1))
        skins.add(Skin(8,"SSG 08 | Hand Brake","https://www.csgodatabase.com/images/skins/SSG_08_Hand_Brake.png","https://www.csgodatabase.com/skins/ssg-08-hand-brake/","No Pricing Available",1))
        skins.add(Skin(9,"Sawed-Off | Brake Light","https://www.csgodatabase.com/images/skins/Sawed-Off_Brake_Light.png","https://www.csgodatabase.com/skins/sawed-off-brake-light/","No Pricing Available",1))
        skins.add(Skin(10,"Glock-18 | High Beam","https://www.csgodatabase.com/images/skins/Glock-18_High_Beam.png","https://www.csgodatabase.com/skins/glock-18-high-beam/","No Pricing Available",1))
        skins.add(Skin(11,"R8 Revolver | Nitro","https://www.csgodatabase.com/images/skins/R8_Revolver_Nitro.png","https://www.csgodatabase.com/skins/r8-revolver-nitro/","$0.09",1))
        skins.add(Skin(12,"MAC-10 | Calf Skin","https://www.csgodatabase.com/images/skins/MAC-10_Calf_Skin.png","https://www.csgodatabase.com/skins/mac-10-calf-skin/","No Pricing Available",1))
        skins.add(Skin(13,"PP-Bizon | Candy Apple","https://www.csgodatabase.com/images/skins/PP-Bizon_Candy_Apple.png","https://www.csgodatabase.com/skins/pp-bizon-candy-apple/","No Pricing Available",1))
        skins.add(Skin(14,"MP5-SD | Dirt Drop","https://www.csgodatabase.com/images/skins/MP5-SD_Dirt_Drop.png","https://www.csgodatabase.com/skins/mp5-sd-dirt-drop/","No Pricing Available",1))
        skins.add(Skin(15,"MP9 | Slide","https://www.csgodatabase.com/images/skins/MP9_Slide.png","https://www.csgodatabase.com/skins/mp9-slide/","No Pricing Available",1))
        skins.add(Skin(16,"AUG | Sweeper","https://www.csgodatabase.com/images/skins/AUG_Sweeper.png","https://www.csgodatabase.com/skins/aug-sweeper/","No Pricing Available",1))
        skins.add(Skin(17,"UMP-45 | Mudder","https://www.csgodatabase.com/images/skins/UMP-45_Mudder.png","https://www.csgodatabase.com/skins/ump-45-mudder/","No Pricing Available",1))
        skins.add(Skin(18,"MAG-7 | Rust Coat","https://www.csgodatabase.com/images/skins/MAG-7_Rust_Coat.png","https://www.csgodatabase.com/skins/mag-7-rust-coat/","No Pricing Available",1))

        return skins
    }
    private fun genNukeCollection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"M4A1-S | Control Panel","https://www.csgodatabase.com/images/skins/M4A1-S_Control_Panel.png","https://www.csgodatabase.com/skins/m4a1-s-control-panel/","No Pricing Available",2))
        skins.add(Skin(2,"Tec-9 | Remote Control","https://www.csgodatabase.com/images/skins/Tec-9_Remote_Control.png","https://www.csgodatabase.com/skins/tec-9-remote-control/","No Pricing Available",2))
        skins.add(Skin(3,"Glock-18 | Nuclear Garden","https://www.csgodatabase.com/images/skins/Glock-18_Nuclear_Garden.png","https://www.csgodatabase.com/skins/glock-18-nuclear-garden/","No Pricing Available",2))
        skins.add(Skin(4,"MAG-7 | Core Breach","https://www.csgodatabase.com/images/skins/MAG-7_Core_Breach.png","https://www.csgodatabase.com/skins/mag-7-core-breach/","No Pricing Available",2))
        skins.add(Skin(5,"AUG | Random Access","https://www.csgodatabase.com/images/skins/AUG_Random_Access.png","https://www.csgodatabase.com/skins/aug-random-access/","No Pricing Available",2))
        skins.add(Skin(6,"AWP | Acheron","https://www.csgodatabase.com/images/skins/AWP_Acheron.png","https://www.csgodatabase.com/skins/awp-acheron/","No Pricing Available",2))
        skins.add(Skin(7,"P250 | Exchanger","https://www.csgodatabase.com/images/skins/P250_Exchanger.png","https://www.csgodatabase.com/skins/p250-exchanger/","No Pricing Available",2))
        skins.add(Skin(8,"MP5-SD | Co-Processor","https://www.csgodatabase.com/images/skins/MP5-SD_Co-Processor.png","https://www.csgodatabase.com/skins/mp5-sd-co-processor/","No Pricing Available",2))
        skins.add(Skin(9,"P90 | Facility Negative","https://www.csgodatabase.com/images/skins/P90_Facility_Negative.png","https://www.csgodatabase.com/skins/p90-facility-negative/","No Pricing Available",2))
        skins.add(Skin(10,"Galil AR | Cold Fusion","https://www.csgodatabase.com/images/skins/Galil_AR_Cold_Fusion.png","https://www.csgodatabase.com/skins/galil-ar-cold-fusion/","No Pricing Available",2))
        skins.add(Skin(11,"Negev | Bulkhead","https://www.csgodatabase.com/images/skins/Negev_Bulkhead.png","https://www.csgodatabase.com/skins/negev-bulkhead/","No Pricing Available",2))
        skins.add(Skin(12,"MP7 | Motherboard","https://www.csgodatabase.com/images/skins/MP7_Motherboard.png","https://www.csgodatabase.com/skins/mp7-motherboard/","$0.09",2))
        skins.add(Skin(13,"M4A4 | Mainframe","https://www.csgodatabase.com/images/skins/M4A4_Mainframe.png","https://www.csgodatabase.com/skins/m4a4-mainframe/","No Pricing Available",2))
        skins.add(Skin(14,"Nova | Mandrel","https://www.csgodatabase.com/images/skins/Nova_Mandrel.png","https://www.csgodatabase.com/skins/nova-mandrel/","No Pricing Available",2))
        skins.add(Skin(15,"Five-SeveN | Coolant","https://www.csgodatabase.com/images/skins/Five-SeveN_Coolant.png","https://www.csgodatabase.com/skins/five-seven-coolant/","No Pricing Available",2))
        skins.add(Skin(16,"UMP-45 | Facility Dark","https://www.csgodatabase.com/images/skins/UMP-45_Facility_Dark.png","https://www.csgodatabase.com/skins/ump-45-facility-dark/","No Pricing Available",2))
        skins.add(Skin(17,"P250 | Facility Draft","https://www.csgodatabase.com/images/skins/P250_Facility_Draft.png","https://www.csgodatabase.com/skins/p250-facility-draft/","No Pricing Available",2))
        skins.add(Skin(18,"PP-Bizon | Facility Sketch","https://www.csgodatabase.com/images/skins/PP-Bizon_Facility_Sketch.png","https://www.csgodatabase.com/skins/pp-bizon-facility-sketch/","No Pricing Available",2))
        return skins
    }
    private fun genBankCollection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"P250 | Franklin","https://www.csgodatabase.com/images/skins/P250_Franklin.png","https://www.csgodatabase.com/skins/p250-franklin/","No Pricing Available",3))
        skins.add(Skin(2,"AK-47 | Emerald Pinstripe","https://www.csgodatabase.com/images/skins/AK-47_Emerald_Pinstripe.png","https://www.csgodatabase.com/skins/ak-47-emerald-pinstripe/","No Pricing Available",3))
        skins.add(Skin(3,"CZ75-Auto | Tuxedo","https://www.csgodatabase.com/images/skins/CZ75-Auto_Tuxedo.png","https://www.csgodatabase.com/skins/cz75-auto-tuxedo/","No Pricing Available",3))
        skins.add(Skin(4,"Galil AR | Tuxedo","https://www.csgodatabase.com/images/skins/Galil_AR_Tuxedo.png","https://www.csgodatabase.com/skins/galil-ar-tuxedo/","No Pricing Available",3))
        skins.add(Skin(5,"Desert Eagle | Meteorite","https://www.csgodatabase.com/images/skins/Desert_Eagle_Meteorite.png","https://www.csgodatabase.com/skins/desert-eagle-meteorite/","No Pricing Available",3))
        skins.add(Skin(6,"G3SG1 | Green Apple","https://www.csgodatabase.com/images/skins/G3SG1_Green_Apple.png","https://www.csgodatabase.com/skins/g3sg1-green-apple/","No Pricing Available",3))
        skins.add(Skin(7,"Glock-18 | Death Rattle","https://www.csgodatabase.com/images/skins/Glock-18_Death_Rattle.png","https://www.csgodatabase.com/skins/glock-18-death-rattle/","$0.17",3))
        skins.add(Skin(8,"MAC-10 | Silver","https://www.csgodatabase.com/images/skins/MAC-10_Silver.png","https://www.csgodatabase.com/skins/mac-10-silver/","No Pricing Available",3))
        skins.add(Skin(9,"Nova | Caged Steel","https://www.csgodatabase.com/images/skins/Nova_Caged_Steel.png","https://www.csgodatabase.com/skins/nova-caged-steel/","No Pricing Available",3))
        skins.add(Skin(10,"UMP-45 | Carbon Fiber","https://www.csgodatabase.com/images/skins/UMP-45_Carbon_Fiber.png","https://www.csgodatabase.com/skins/ump-45-carbon-fiber/","No Pricing Available",3))
        skins.add(Skin(11,"R8 Revolver | Bone Mask","https://www.csgodatabase.com/images/skins/R8_Revolver_Bone_Mask.png","https://www.csgodatabase.com/skins/r8-revolver-bone-mask/","No Pricing Available",3))
        skins.add(Skin(12,"MP7 | Forest DDPAT","https://www.csgodatabase.com/images/skins/MP7_Forest_DDPAT.png","https://www.csgodatabase.com/skins/mp7-forest-ddpat/","No Pricing Available",3))
        skins.add(Skin(13,"Sawed-Off | Forest DDPAT","https://www.csgodatabase.com/images/skins/Sawed-Off_Forest_DDPAT.png","https://www.csgodatabase.com/skins/sawed-off-forest-ddpat/","No Pricing Available",3))
        skins.add(Skin(14,"Tec-9 | Urban DDPAT","https://www.csgodatabase.com/images/skins/Tec-9_Urban_DDPAT.png","https://www.csgodatabase.com/skins/tec-9-urban-ddpat/","No Pricing Available",3))
        skins.add(Skin(15,"Negev | Army Sheen","https://www.csgodatabase.com/images/skins/Negev_Army_Sheen.png","https://www.csgodatabase.com/skins/negev-army-sheen/","No Pricing Available",3))
        skins.add(Skin(16,"SG 553 | Army Sheen","https://www.csgodatabase.com/images/skins/SG_553_Army_Sheen.png","https://www.csgodatabase.com/skins/sg-553-army-sheen/","No Pricing Available",3))
        return skins
    }
    private fun genDust2Collection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"R8 Revolver | Amber Fade","https://www.csgodatabase.com/images/skins/R8_Revolver_Amber_Fade.png","https://www.csgodatabase.com/skins/r8-revolver-amber-fade/","No Pricing Available",4))
        skins.add(Skin(2,"P2000 | Amber Fade","https://www.csgodatabase.com/images/skins/P2000_Amber_Fade.png","https://www.csgodatabase.com/skins/p2000-amber-fade/","No Pricing Available",4))
        skins.add(Skin(3,"M4A1-S | VariCamo","https://www.csgodatabase.com/images/skins/M4A1-S_VariCamo.png","https://www.csgodatabase.com/skins/m4a1-s-varicamo/","No Pricing Available",4))
        skins.add(Skin(4,"SG 553 | Damascus Steel","https://www.csgodatabase.com/images/skins/SG_553_Damascus_Steel.png","https://www.csgodatabase.com/skins/sg-553-damascus-steel/","No Pricing Available",4))
        skins.add(Skin(5,"PP-Bizon | Brass","https://www.csgodatabase.com/images/skins/PP-Bizon_Brass.png","https://www.csgodatabase.com/skins/pp-bizon-brass/","No Pricing Available",4))
        skins.add(Skin(6,"Sawed-Off | Snake Camo","https://www.csgodatabase.com/images/skins/Sawed-Off_Snake_Camo.png","https://www.csgodatabase.com/skins/sawed-off-snake-camo/","No Pricing Available",4))
        skins.add(Skin(7,"Five-SeveN | Orange Peel","https://www.csgodatabase.com/images/skins/Five-SeveN_Orange_Peel.png","https://www.csgodatabase.com/skins/five-seven-orange-peel/","No Pricing Available",4))
        skins.add(Skin(8,"Tec-9 | VariCamo","https://www.csgodatabase.com/images/skins/Tec-9_VariCamo.png","https://www.csgodatabase.com/skins/tec-9-varicamo/","No Pricing Available",4))
        skins.add(Skin(9,"AK-47 | Safari Mesh","https://www.csgodatabase.com/images/skins/AK-47_Safari_Mesh.png","https://www.csgodatabase.com/skins/ak-47-safari-mesh/","$4.84",4))
        skins.add(Skin(10,"MAC-10 | Palm","https://www.csgodatabase.com/images/skins/MAC-10_Palm.png","https://www.csgodatabase.com/skins/mac-10-palm/","No Pricing Available",4))
        skins.add(Skin(11,"P250 | Sand Dune","https://www.csgodatabase.com/images/skins/P250_Sand_Dune.png","https://www.csgodatabase.com/skins/p250-sand-dune/","No Pricing Available",4))
        skins.add(Skin(12,"SCAR-20 | Sand Mesh","https://www.csgodatabase.com/images/skins/SCAR-20_Sand_Mesh.png","https://www.csgodatabase.com/skins/scar-20-sand-mesh/","No Pricing Available",4))
        skins.add(Skin(13,"Nova | Predator","https://www.csgodatabase.com/images/skins/Nova_Predator.png","https://www.csgodatabase.com/skins/nova-predator/","No Pricing Available",4))
        skins.add(Skin(14,"G3SG1 | Desert Storm","https://www.csgodatabase.com/images/skins/G3SG1_Desert_Storm.png","https://www.csgodatabase.com/skins/g3sg1-desert-storm/","No Pricing Available",4))
        skins.add(Skin(15,"MP9 | Sand Dashed","https://www.csgodatabase.com/images/skins/MP9_Sand_Dashed.png","https://www.csgodatabase.com/skins/mp9-sand-dashed/","No Pricing Available",4))
        skins.add(Skin(16,"P90 | Sand Spray","https://www.csgodatabase.com/images/skins/P90_Sand_Spray.png","https://www.csgodatabase.com/skins/p90-sand-spray/","No Pricing Available",4))
        return skins
    }
    private fun genItalyCollection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"AWP | Pit Viper","https://www.csgodatabase.com/images/skins/AWP_Pit_Viper.png","https://www.csgodatabase.com/skins/awp-pit-viper/","No Pricing Available",5))
        skins.add(Skin(2,"Sawed-Off | Full Stop","https://www.csgodatabase.com/images/skins/Sawed-Off_Full_Stop.png","https://www.csgodatabase.com/skins/sawed-off-full-stop/","No Pricing Available",5))
        skins.add(Skin(3,"Glock-18 | Candy Apple","https://www.csgodatabase.com/images/skins/Glock-18_Candy_Apple.png","https://www.csgodatabase.com/skins/glock-18-candy-apple/","No Pricing Available",5))
        skins.add(Skin(4,"MP7 | Anodized Navy","https://www.csgodatabase.com/images/skins/MP7_Anodized_Navy.png","https://www.csgodatabase.com/skins/mp7-anodized-navy/","No Pricing Available",5))
        skins.add(Skin(5,"M4A1-S | Boreal Forest","https://www.csgodatabase.com/images/skins/M4A1-S_Boreal_Forest.png","https://www.csgodatabase.com/skins/m4a1-s-boreal-forest/","No Pricing Available",5))
        skins.add(Skin(6,"Nova | Candy Apple","https://www.csgodatabase.com/images/skins/Nova_Candy_Apple.png","https://www.csgodatabase.com/skins/nova-candy-apple/","No Pricing Available",5))
        skins.add(Skin(7,"UMP-45 | Gunsmoke","https://www.csgodatabase.com/images/skins/UMP-45_Gunsmoke.png","https://www.csgodatabase.com/skins/ump-45-gunsmoke/","No Pricing Available",5))
        skins.add(Skin(8,"XM1014 | CaliCamo","https://www.csgodatabase.com/images/skins/XM1014_CaliCamo.png","https://www.csgodatabase.com/skins/xm1014-calicamo/","No Pricing Available",5))
        skins.add(Skin(9,"Dual Berettas | Stained","https://www.csgodatabase.com/images/skins/Dual_Berettas_Stained.png","https://www.csgodatabase.com/skins/dual-berettas-stained/","No Pricing Available",5))
        skins.add(Skin(10,"P2000 | Granite Marbleized","https://www.csgodatabase.com/images/skins/P2000_Granite_Marbleized.png","https://www.csgodatabase.com/skins/p2000-granite-marbleized/","No Pricing Available",5))
        skins.add(Skin(11,"Nova | Sand Dune","https://www.csgodatabase.com/images/skins/Nova_Sand_Dune.png","https://www.csgodatabase.com/skins/nova-sand-dune/","No Pricing Available",5))
        skins.add(Skin(12,"AUG | Contractor","https://www.csgodatabase.com/images/skins/AUG_Contractor.png","https://www.csgodatabase.com/skins/aug-contractor/","No Pricing Available",5))
        skins.add(Skin(13,"Tec-9 | Groundwater","https://www.csgodatabase.com/images/skins/Tec-9_Groundwater.png","https://www.csgodatabase.com/skins/tec-9-groundwater/","No Pricing Available",5))
        skins.add(Skin(14,"FAMAS | Colony","https://www.csgodatabase.com/images/skins/FAMAS_Colony.png","https://www.csgodatabase.com/skins/famas-colony/","No Pricing Available",5))
        skins.add(Skin(15,"PP-Bizon | Sand Dashed","https://www.csgodatabase.com/images/skins/PP-Bizon_Sand_Dashed.png","https://www.csgodatabase.com/skins/pp-bizon-sand-dashed/","No Pricing Available",5))
        return skins
    }
    private fun genLakeCollection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"Dual Berettas | Cobalt Quartz","https://www.csgodatabase.com/images/skins/Dual_Berettas_Cobalt_Quartz.png","https://www.csgodatabase.com/skins/dual-berettas-cobalt-quartz/","No Pricing Available",6))
        skins.add(Skin(2,"USP-S | Night Ops","https://www.csgodatabase.com/images/skins/USP-S_Night_Ops.png","https://www.csgodatabase.com/skins/usp-s-night-ops/","No Pricing Available",6))
        skins.add(Skin(3,"SG 553 | Anodized Navy","https://www.csgodatabase.com/images/skins/SG_553_Anodized_Navy.png","https://www.csgodatabase.com/skins/sg-553-anodized-navy/","No Pricing Available",6))
        skins.add(Skin(4,"P90 | Teardown","https://www.csgodatabase.com/images/skins/P90_Teardown.png","https://www.csgodatabase.com/skins/p90-teardown/","No Pricing Available",6))
        skins.add(Skin(5,"AWP | Safari Mesh","https://www.csgodatabase.com/images/skins/AWP_Safari_Mesh.png","https://www.csgodatabase.com/skins/awp-safari-mesh/","No Pricing Available",6))
        skins.add(Skin(6,"XM1014 | Blue Steel","https://www.csgodatabase.com/images/skins/XM1014_Blue_Steel.png","https://www.csgodatabase.com/skins/xm1014-blue-steel/","No Pricing Available",6))
        skins.add(Skin(7,"Desert Eagle | Mudder","https://www.csgodatabase.com/images/skins/Desert_Eagle_Mudder.png","https://www.csgodatabase.com/skins/desert-eagle-mudder/","No Pricing Available",6))
        skins.add(Skin(8,"FAMAS | Cyanospatter","https://www.csgodatabase.com/images/skins/FAMAS_Cyanospatter.png","https://www.csgodatabase.com/skins/famas-cyanospatter/","No Pricing Available",6))
        skins.add(Skin(9,"PP-Bizon | Night Ops","https://www.csgodatabase.com/images/skins/PP-Bizon_Night_Ops.png","https://www.csgodatabase.com/skins/pp-bizon-night-ops/","No Pricing Available",6))
        skins.add(Skin(10,"P250 | Boreal Forest","https://www.csgodatabase.com/images/skins/P250_Boreal_Forest.png","https://www.csgodatabase.com/skins/p250-boreal-forest/","No Pricing Available",6))
        skins.add(Skin(11,"AUG | Storm","https://www.csgodatabase.com/images/skins/AUG_Storm.png","https://www.csgodatabase.com/skins/aug-storm/","No Pricing Available",6))
        skins.add(Skin(12,"XM1014 | Blue Spruce","https://www.csgodatabase.com/images/skins/XM1014_Blue_Spruce.png","https://www.csgodatabase.com/skins/xm1014-blue-spruce/","$0.03",6))
        skins.add(Skin(13,"G3SG1 | Jungle Dashed","https://www.csgodatabase.com/images/skins/G3SG1_Jungle_Dashed.png","https://www.csgodatabase.com/skins/g3sg1-jungle-dashed/","No Pricing Available",6))
        skins.add(Skin(14,"Galil AR | Sage Spray","https://www.csgodatabase.com/images/skins/Galil_AR_Sage_Spray.png","https://www.csgodatabase.com/skins/galil-ar-sage-spray/","No Pricing Available",6))
        skins.add(Skin(15,"SG 553 | Waves Perforated","https://www.csgodatabase.com/images/skins/SG_553_Waves_Perforated.png","https://www.csgodatabase.com/skins/sg-553-waves-perforated/","No Pricing Available",6))
        return skins
    }
    private fun genSafehouseCollection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"M4A1-S | Nitro","https://www.csgodatabase.com/images/skins/M4A1-S_Nitro.png","https://www.csgodatabase.com/skins/m4a1-s-nitro/","No Pricing Available",7))
        skins.add(Skin(2,"Five-SeveN | Silver Quartz","https://www.csgodatabase.com/images/skins/Five-SeveN_Silver_Quartz.png","https://www.csgodatabase.com/skins/five-seven-silver-quartz/","No Pricing Available",7))
        skins.add(Skin(3,"FAMAS | Teardown","https://www.csgodatabase.com/images/skins/FAMAS_Teardown.png","https://www.csgodatabase.com/skins/famas-teardown/","No Pricing Available",7))
        skins.add(Skin(4,"SSG 08 | Acid Fade","https://www.csgodatabase.com/images/skins/SSG_08_Acid_Fade.png","https://www.csgodatabase.com/skins/ssg-08-acid-fade/","No Pricing Available",7))
        skins.add(Skin(5,"USP-S | Forest Leaves","https://www.csgodatabase.com/images/skins/USP-S_Forest_Leaves.png","https://www.csgodatabase.com/skins/usp-s-forest-leaves/","No Pricing Available",7))
        skins.add(Skin(6,"M249 | Gator Mesh","https://www.csgodatabase.com/images/skins/M249_Gator_Mesh.png","https://www.csgodatabase.com/skins/m249-gator-mesh/","No Pricing Available",7))
        skins.add(Skin(7,"AUG | Condemned","https://www.csgodatabase.com/images/skins/AUG_Condemned.png","https://www.csgodatabase.com/skins/aug-condemned/","No Pricing Available",7))
        skins.add(Skin(8,"G3SG1 | VariCamo","https://www.csgodatabase.com/images/skins/G3SG1_VariCamo.png","https://www.csgodatabase.com/skins/g3sg1-varicamo/","No Pricing Available",7))
        skins.add(Skin(9,"Galil AR | VariCamo","https://www.csgodatabase.com/images/skins/Galil_AR_VariCamo.png","https://www.csgodatabase.com/skins/galil-ar-varicamo/","No Pricing Available",7))
        skins.add(Skin(10,"MP9 | Orange Peel","https://www.csgodatabase.com/images/skins/MP9_Orange_Peel.png","https://www.csgodatabase.com/skins/mp9-orange-peel/","No Pricing Available",7))
        skins.add(Skin(11,"SCAR-20 | Contractor","https://www.csgodatabase.com/images/skins/SCAR-20_Contractor.png","https://www.csgodatabase.com/skins/scar-20-contractor/","No Pricing Available",7))
        skins.add(Skin(12,"Tec-9 | Army Mesh","https://www.csgodatabase.com/images/skins/Tec-9_Army_Mesh.png","https://www.csgodatabase.com/skins/tec-9-army-mesh/","No Pricing Available",7))
        skins.add(Skin(13,"Dual Berettas | Contractor","https://www.csgodatabase.com/images/skins/Dual_Berettas_Contractor.png","https://www.csgodatabase.com/skins/dual-berettas-contractor/","No Pricing Available",7))
        skins.add(Skin(14,"SSG 08 | Blue Spruce","https://www.csgodatabase.com/images/skins/SSG_08_Blue_Spruce.png","https://www.csgodatabase.com/skins/ssg-08-blue-spruce/","No Pricing Available",7))
        skins.add(Skin(15,"MP7 | Army Recon","https://www.csgodatabase.com/images/skins/MP7_Army_Recon.png","https://www.csgodatabase.com/skins/mp7-army-recon/","No Pricing Available",7))
        return skins
    }
    private fun genTrainCollection():ArrayList<Skin>{
        var skins = ArrayList<Skin>()
        skins.add(Skin(1,"Tec-9 | Red Quartz","https://www.csgodatabase.com/images/skins/Tec-9_Red_Quartz.png","https://www.csgodatabase.com/skins/tec-9-red-quartz/","No Pricing Available",8))
        skins.add(Skin(2,"Sawed-Off | Amber Fade","https://www.csgodatabase.com/images/skins/Sawed-Off_Amber_Fade.png","https://www.csgodatabase.com/skins/sawed-off-amber-fade/","No Pricing Available",8))
        skins.add(Skin(3,"Desert Eagle | Urban Rubble","https://www.csgodatabase.com/images/skins/Desert_Eagle_Urban_Rubble.png","https://www.csgodatabase.com/skins/desert-eagle-urban-rubble/","No Pricing Available",8))
        skins.add(Skin(4,"P250 | Metallic DDPAT","https://www.csgodatabase.com/images/skins/P250_Metallic_DDPAT.png","https://www.csgodatabase.com/skins/p250-metallic-ddpat/","No Pricing Available",8))
        skins.add(Skin(5,"SCAR-20 | Carbon Fiber","https://www.csgodatabase.com/images/skins/SCAR-20_Carbon_Fiber.png","https://www.csgodatabase.com/skins/scar-20-carbon-fiber/","No Pricing Available",8))
        skins.add(Skin(6,"MAG-7 | Metallic DDPAT","https://www.csgodatabase.com/images/skins/MAG-7_Metallic_DDPAT.png","https://www.csgodatabase.com/skins/mag-7-metallic-ddpat/","No Pricing Available",8))
        skins.add(Skin(7,"M4A4 | Urban DDPAT","https://www.csgodatabase.com/images/skins/M4A4_Urban_DDPAT.png","https://www.csgodatabase.com/skins/m4a4-urban-ddpat/","No Pricing Available",8))
        skins.add(Skin(8,"MAC-10 | Candy Apple","https://www.csgodatabase.com/images/skins/MAC-10_Candy_Apple.png","https://www.csgodatabase.com/skins/mac-10-candy-apple/","No Pricing Available",8))
        skins.add(Skin(9,"P90 | Ash Wood","https://www.csgodatabase.com/images/skins/P90_Ash_Wood.png","https://www.csgodatabase.com/skins/p90-ash-wood/","No Pricing Available",8))
        skins.add(Skin(10,"Nova | Polar Mesh","https://www.csgodatabase.com/images/skins/Nova_Polar_Mesh.png","https://www.csgodatabase.com/skins/nova-polar-mesh/","No Pricing Available",8))
        skins.add(Skin(11,"UMP-45 | Urban DDPAT","https://www.csgodatabase.com/images/skins/UMP-45_Urban_DDPAT.png","https://www.csgodatabase.com/skins/ump-45-urban-ddpat/","No Pricing Available",8))
        skins.add(Skin(12,"Five-SeveN | Forest Night","https://www.csgodatabase.com/images/skins/Five-SeveN_Forest_Night.png","https://www.csgodatabase.com/skins/five-seven-forest-night/","No Pricing Available",8))
        skins.add(Skin(13,"Dual Berettas | Colony","https://www.csgodatabase.com/images/skins/Dual_Berettas_Colony.png","https://www.csgodatabase.com/skins/dual-berettas-colony/","No Pricing Available",8))
        skins.add(Skin(14,"G3SG1 | Polar Camo","https://www.csgodatabase.com/images/skins/G3SG1_Polar_Camo.png","https://www.csgodatabase.com/skins/g3sg1-polar-camo/","No Pricing Available",8))
        skins.add(Skin(15,"PP-Bizon | Urban Dashed","https://www.csgodatabase.com/images/skins/PP-Bizon_Urban_Dashed.png","https://www.csgodatabase.com/skins/pp-bizon-urban-dashed/","No Pricing Available",8))
        return skins
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
            list = genInfernoCollection()
        }else if(genero.equals("The 2018 Nuke Collection")){
            list = genNukeCollection()
        }else if(genero.equals("The Bank Collection")){
            list = genBankCollection()
        }else if(genero.equals("The Dust 2 Collection")){
            list = genDust2Collection()
        }else if(genero.equals("The Italy Collection")){
            list = genItalyCollection()
        }else if(genero.equals("The Lake Collection")){
            list = genLakeCollection()
        }else if(genero.equals("The Safehouse Collection")){
            list = genSafehouseCollection()
        }else if(genero.equals("The Train Collection")){
            list = genTrainCollection()
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

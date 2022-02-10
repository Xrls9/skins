package com.example.wordsapp.objects

import java.io.Serializable

class Skin {
    val id: Int
    val nombre: String
    val descripcion: String
    val imagen: String
    val url: String
    val idTipo: Int


    constructor(
        _id: Int,
        _nombre: String,
        _descripcion: String,
        _imagen: String,
        _url: String,
        _idTipo: Int
    ) {
        this.id = _id
        this.nombre = _nombre
        this.descripcion = _descripcion
        this.imagen = _imagen
        this.url = _url
        this.idTipo = _idTipo
    }
}
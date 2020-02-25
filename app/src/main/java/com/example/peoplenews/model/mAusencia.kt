package com.example.peoplenews.model

data class mAusencia(
    val ausenciaid: Int?, val tipoausenciaid: Int, val estadoid: Int, val personaid: Int,
    val descripcion: String, val desde: String, val hasta: String)
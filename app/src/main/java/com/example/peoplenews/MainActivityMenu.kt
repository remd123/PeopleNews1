package com.example.peoplenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.peoplenews.fragment.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.context_activity.*
import py.edu.uca.peoplenews.R

class MainActivityMenu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        //encargado de mostrar nuestro toolbar
        setSupportActionBar(my_tolbar as Toolbar)
        // con que icono mostramos
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        // y asignamos que muestre el boton
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // es para que escuche a esta actividad
        nav_view.setNavigationItemSelectedListener (this)
        // aca se carga por defecto un fragment

        //cambiarFragment(Inicio.newInstance())

        // boton que se encuentra en el menu que es para salir
//        boton_salir.setOnClickListener {
//            finish()
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> drawer.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {

        //al hacer clic sobre un item de menu
        // Toast.makeText(this,"Clic en el menu", Toast.LENGTH_LONG).show()
        // es para cerrar el menu

        when(menu.itemId){
//            R.id.menu_inicio -> cambiarFragment(Inicio.newInstance())
//            R.id.menu_vacacion -> cambiarFragment(SolicitudVacaciones.newInstance())
//            R.id.menu_dat_personal -> cambiarFragment(DatosPersonales.newInstance())
//            R.id.menu_permisos -> cambiarFragment(Menu_permisos.newInstance())
//            R.id.menu_reposos -> cambiarFragment(Menu_reposos.newInstance())
//            R.id.menu_notificaciones -> cambiarFragment(NotificacionesFragment.newInstance())
//            R.id.menu_estado_solicit -> cambiarFragment(EstadoSolicitud.newInstance())
//            R.id.menu_ausencia -> cambiarFragment(JustificarAusencia.newInstance())


            //R.id.menu_opcion2 -> cambiarFragment(Fragment2.newInstance())
            R.id.menu_inicio-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.inicio)
            R.id.menu_reposos-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.menu_reposos2)
            R.id.menu_vacacion-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.solicitudVacaciones)
            R.id.menu_dat_personal-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.datosPersonales2)
            R.id.menu_permisos-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.menu_permisos2)
            R.id.menu_notificaciones-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.notificacionesFragment)
            R.id.menu_estado_solicit-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.estadoSolicitud)
            R.id.menu_ausencia-> Navigation.findNavController(this,R.id.nav_host).navigate(R.id.justificarAusencia)

        }

        drawer.closeDrawers()
        return true

    }


//    private fun cambiarFragment(fragment: Fragment) {
//        //Toast.makeText(this, "Clic en $item", Toast.LENGTH_LONG).show()
//
//        // sirve para cargar llamar el fragment
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.contenedor, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
}

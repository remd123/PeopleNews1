package com.example.appmenu

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmenu.adapter.AlphaAdapter
import com.example.appmenu.model.AlphaChart

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var recyclerView: RecyclerView ?= null
    private var gridLayoutManager: GridLayoutManager ?=  null
    private var arrayList: ArrayList<AlphaChart> ?= null
    private  var alphaAdapter: AlphaAdapter ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu1 ID as a set of Ids because each
        // menu1 should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_notificaciones, R.id.nav_dat_personal, R.id.nav_permisos,
                R.id.nav_reposos, R.id.nav_form_vacacion, R.id.nav_estado_solicit
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        recyclerView= findViewById(R.id.my_recycler_view)
        gridLayoutManager = GridLayoutManager(applicationContext, 3,LinearLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapter = AlphaAdapter(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu1; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

    private fun setDataInList(): ArrayList<AlphaChart>{
        var items: ArrayList<AlphaChart> = ArrayList()


        items.add(AlphaChart(R.drawable.person_icon,"Texto A"))
        items.add(AlphaChart(R.drawable.person_icon,"Texto b"))
        items.add(AlphaChart(R.drawable.person_icon,"Texto c"))
        items.add(AlphaChart(R.drawable.person_icon,"Texto d"))
        return items
    }
}

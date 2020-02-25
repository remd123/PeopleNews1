package com.example.peoplenews.fragment

import android.os.Bundle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peoplenews.adapter.NotiAdapter
import com.example.peoplenews.model.mNotificacion
import com.example.peoplenews.recursos.connector
import com.example.peoplenews.request.rNotifacion
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_notificaciones.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*
import py.edu.uca.peoplenews.R



/**
 * A simple [Fragment] subclass.
 */
class NotificacionesFragment : Fragment(){


        private lateinit var mCompositeDisposable : CompositeDisposable


        companion object{
            fun newInstance(): NotificacionesFragment = NotificacionesFragment()
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            // Inflate the layout for this fragment
            val view= inflater.inflate(R.layout.fragment_notificaciones, container, false)
            //(activity as AppCompatActivity).setSupportActionBar(view.title_toolbar)
            return view
        }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            //title_toolbar.setTitle("Notificaciones")

            mCompositeDisposable = CompositeDisposable()

            loadJsonNotificacion()

        }

        private fun loadJsonNotificacion(){

            val retrofit = connector().create(rNotifacion::class.java)
            mCompositeDisposable.add(
                retrofit.getNotificaciones()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleNotificacion, this::handleError)
            )

        }
        private fun handleNotificacion(lnotificacion : ArrayList<mNotificacion>){

            lista_notificaciones.layoutManager = LinearLayoutManager(this.context)
            lista_notificaciones.adapter = NotiAdapter (lnotificacion)



        }







        private fun handleError(ex : Throwable){

            Toast.makeText(this.context, "Error ${ex.localizedMessage}", Toast.LENGTH_LONG).show()
            Log.d("Error Consumo","Error ${ex.localizedMessage}",ex )

        }
        override fun onDestroy() {
            super.onDestroy()

            mCompositeDisposable.clear()
            mCompositeDisposable.dispose()
        }


    }



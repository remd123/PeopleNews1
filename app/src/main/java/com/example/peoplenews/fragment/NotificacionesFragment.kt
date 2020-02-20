package com.example.peoplenews.fragment

import android.os.Bundle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.peoplenews.model.mNotificacion
import com.example.peoplenews.recursos.connector
import com.example.peoplenews.request.rNotifacion
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_notificaciones.*
import py.edu.uca.peoplenews.R



/**
 * A simple [Fragment] subclass.
 */
class NotificacionesFragment : Fragment(){


        private lateinit var mCompositeDisposable : CompositeDisposable


        companion object{
            fun newInstance(): Inicio = Inicio()
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_notificaciones, container, false)
        }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            mCompositeDisposable = CompositeDisposable()

            loadJsonNotificacion()

        }

        private fun loadJsonNotificacion(){

            val retrofit = connector().create(rNotifacion::class.java)
            mCompositeDisposable.add(
                retrofit.getNotificacion(1)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleNotificacion, this::handleError)
            )

        }
        private fun handleNotificacion(mnotificacion : mNotificacion){

        tvNoti_descripcion.text = "${mnotificacion.descripcion} "
        tvNoti_fecha.text = "${mnotificacion.fecha}"

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



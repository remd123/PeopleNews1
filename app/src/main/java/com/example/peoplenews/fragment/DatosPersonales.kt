package com.example.peoplenews.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.peoplenews.model.mPersona
import com.example.peoplenews.recursos.connector
import com.example.peoplenews.request.rPersona
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_datos_personales.*
import kotlinx.android.synthetic.main.fragment_inicio.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*
import py.edu.uca.peoplenews.R

/**
 * A simple [Fragment] subclass.
 */
class DatosPersonales : Fragment() {
    companion object{
        fun newInstance(): DatosPersonales = DatosPersonales()
    }

    private lateinit var mCompositeDisposable : CompositeDisposable



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_datos_personales, container, false)
       // (activity as AppCompatActivity).setSupportActionBar(view.title_toolbar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCompositeDisposable = CompositeDisposable()
        //title_toolbar.setTitle("notificaciones")

        loadJsonPersona()

    }

    private fun loadJsonPersona(){

        val retrofit = connector().create(rPersona::class.java)
        mCompositeDisposable.add(
            retrofit.getPersona(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handlePersona, this::handleError)
        )

    }

    private fun handlePersona(mpersona:mPersona){

        nombre_persona.text = "${mpersona.nombre} ${mpersona.apellido} "
        //apellido_persona.text= "${mpersona.apellido} "
        documento_persona.text= "${mpersona.ci} "
        direccion_persona.text= "${mpersona.direccion} "
        telefono_persona.text= "${mpersona.telefono} "


    }

    private fun handleError(ex : Throwable){

        Toast.makeText(this.context, "Error ${ex.localizedMessage}", Toast.LENGTH_LONG).show()
        Log.d("Error Consumo","Erro ${ex.localizedMessage}",ex )

    }

    override fun onDestroy() {
        super.onDestroy()

        mCompositeDisposable.clear()
        mCompositeDisposable.dispose()
    }

}

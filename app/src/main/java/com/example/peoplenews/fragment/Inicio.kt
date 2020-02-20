package com.example.peoplenews.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.peoplenews.model.mPersona
import com.example.peoplenews.recursos.connector
import com.example.peoplenews.request.rPersona
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_inicio.*
import py.edu.uca.peoplenews.R

/**
 * A simple [Fragment] subclass.
 */
class Inicio : Fragment() {

    private lateinit var mCompositeDisposable : CompositeDisposable

    companion object{
        fun newInstance(): Inicio = Inicio()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCompositeDisposable = CompositeDisposable()

        loadJsonPersona()

    }

    private fun loadJsonPersona(){

        val retrofit = connector().create(rPersona::class.java)
        mCompositeDisposable.add(
            retrofit.getPersona(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handlePersona, this::handleError)
        )

    }

    private fun handlePersona(mpersona : mPersona){

        tvPrueba.text = "${mpersona.nombre} ${mpersona.apellido}"

    }

    private fun handleError(ex : Throwable){

        Toast.makeText(this.context, "Erro ${ex.localizedMessage}", Toast.LENGTH_LONG).show()
        Log.d("Error Consumo","Erro ${ex.localizedMessage}",ex )

    }

    override fun onDestroy() {
        super.onDestroy()

        mCompositeDisposable.clear()
        mCompositeDisposable.dispose()
    }
}

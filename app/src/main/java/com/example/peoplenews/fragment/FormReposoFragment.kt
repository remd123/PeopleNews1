package com.example.peoplenews.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.peoplenews.model.mAusencia
import com.example.peoplenews.recursos.connector
import com.example.peoplenews.request.rAusencia
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_form_reposo.*

import py.edu.uca.peoplenews.R

/**
 * A simple [Fragment] subclass.
 */
class FormReposoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_form_reposo, container, false)
        //(activity as AppCompatActivity).setSupportActionBar(view.title_toolbar)

        return view
    }
    companion object{
        val tipoausenciaid=1
        val estadoid=1
        val personaid=1
    }

    private lateinit var mCompositeDisposable: CompositeDisposable


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_enviar.setOnClickListener{
            btnRegistrar()
        }
    }
fun btnRegistrar(){
    Toast.makeText(this.context, "Primer cuadro", Toast.LENGTH_LONG).show()
    var mAusencia = mAusencia(null,
        tipoausenciaid,
        estadoid,
        personaid,input_detalle_ausencia.text.toString(),f_final_ausencia.text.toString(),f_inicial_ausencia.text.toString())

    postJsonAusencia(mAusencia)
}
    private fun postJsonAusencia(mAusencia: mAusencia){

        val retrofit = connector().create(rAusencia::class.java)
        mCompositeDisposable.add(
            retrofit.postAusencia(mAusencia)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handlePost,this::handleError)
        )


    }
    private fun handlePost(){

        Toast.makeText(this.context, "Se Posteo", Toast.LENGTH_LONG).show()

                //Toast.makeText(requireContext(), "Hubo un error al obtener el reposo $call", Toast.LENGTH_SHORT).show()



    }
    private fun handleError(error: Throwable) {

        Toast.makeText(this.context, "Error ${error.localizedMessage}", Toast.LENGTH_LONG).show()
        Log.d("Text","Hubo un erro al obtener reposo  ${error.localizedMessage}")

    }

    override fun onDestroy() {
        super.onDestroy()

        mCompositeDisposable!!.clear()
        mCompositeDisposable!!.dispose()
    }



//    override fun ReposoClicked(reposo: ReposoModel) {
//         Toast.makeText(requireContext(), "Se obtuvo la pelicula con id:", Toast.LENGTH_SHORT).show()
//        val action=Menu_repososDirections.actionMenuReposos2ToFormReposoFragment(reposo.id_titulo)
//        Navigation.findNavController(lista_reposos).navigate(action)
//    }
//    private lateinit var listaRepososRv:RecyclerView
//    private lateinit var linearLayoutManager:LinearLayoutManager
//    private lateinit var adapter:ReposoAdapter
//    private  val reposos: MutableList<ReposoModel> = mutableListOf()
//    var idReposo: Int = -1
//
////    private val repososApi by lazy {
////        RepososApi.create()
////    }
//
//    companion object {
//        val value = 1
//        val motivoRep = "Enfermedad"
//        //val API_KEY = "7ac3ca0156061195fead747e09bd53a1"
//        //val CATEGORY = "popular"
//    }
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//       // return inflater.inflate(R.layout.fragment_form_reposo, container, false)
//        val view= inflater.inflate(R.layout.fragment_form_reposo,container,false)
//        listaRepososRv = view.findViewById(R.id.lista_reposos)
//        linearLayoutManager = LinearLayoutManager(requireContext())
//        listaRepososRv.layoutManager= linearLayoutManager
//
//        adapter = ReposoAdapter(requireContext(),
//            reposos as ArrayList<ReposoModel>,
//            this)
//        listaRepososRv.adapter= adapter
//        Toast.makeText(context, "El id del reposo es ", Toast.LENGTH_LONG).show()
//        return view
//    }
//
//   override fun onStart() {
//        super.onStart()
//        if (reposos.isEmpty()){
//            reposos.add(ReposoModel(1,"estoy enferma","20 de enero"))
//            reposos.add(ReposoModel(2,"estoy super enferma","12 de marzo"))
//            adapter.notifyItemInserted(reposos.size-1)
//        }
//    }
//
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        obtenerReposos()
//    }
//
//    private fun obtenerReposos() {
//        Log.d("Text","Entro a obtener reposos")
//        val call = repososApi.getReposos()
//        call.enqueue(object : Callback<RepososResult> {
//            override fun onFailure(call: retrofit2.Call<RepososResult>, t: Throwable) {
//                //Toast.makeText(requireContext(), "Hubo un error al obtener el reposo $call", Toast.LENGTH_SHORT).show()
//                Log.d("Text","Hubo un erro al obtener reposo  ${t.localizedMessage}")
//            }
//
//
//            override fun onResponse(
//                //call: retrofit2.Call<PeliculaResult>,
//                //response: retrofit2.Response<PeliculaResult>
//                call: Call<RepososResult>,
//                response: Response<RepososResult>
//
//            ) {
//                val misRepos = response.body()
//                misRepos?.results?.let { reposos.addAll(it) }
//                adapter.notifyItemInserted(reposos.size - 1)
//                Log.d("Text","Mis reposos son ${reposos.size}")
//            }
//
//        })
//
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        arguments?.let {
//            val arguments = FormReposoFragmentArgs.fromBundle(it)
//            idReposo = arguments.idPermiso
//
//            Toast.makeText(context, "El id del reposo es $idReposo", Toast.LENGTH_LONG).show()
//        }
//    }


}

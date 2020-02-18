package com.example.peoplenews.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplenews.adapter.ReposoAdapter
import com.example.peoplenews.adapter.ReposoInterface
import com.example.peoplenews.model.ReposoModel
import com.example.peoplenews.model.RepososResult
import com.example.peoplenews.network.RepososApi
import kotlinx.android.synthetic.main.fragment_form_reposo.*
import py.edu.uca.peoplenews.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class FormReposoFragment : Fragment(),ReposoInterface {
    override fun ReposoClicked(reposo: ReposoModel) {
         Toast.makeText(requireContext(), "Se obtuvo la pelicula con id:", Toast.LENGTH_SHORT).show()
        val action=Menu_repososDirections.actionMenuReposos2ToFormReposoFragment(reposo.id_titulo)
        Navigation.findNavController(lista_reposos).navigate(action)
    }
    private lateinit var listaRepososRv:RecyclerView
    private lateinit var linearLayoutManager:LinearLayoutManager
    private lateinit var adapter:ReposoAdapter
    private  val reposos: MutableList<ReposoModel> = mutableListOf()
    var idReposo: Int = -1

    private val repososApi by lazy {
        RepososApi.create()
    }

    companion object {
        val value = 1
        val motivoRep = "Enfermedad"
        //val API_KEY = "7ac3ca0156061195fead747e09bd53a1"
        //val CATEGORY = "popular"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_form_reposo, container, false)
        val view= inflater.inflate(R.layout.fragment_form_reposo,container,false)
        listaRepososRv = view.findViewById(R.id.lista_reposos)
        linearLayoutManager = LinearLayoutManager(requireContext())
        listaRepososRv.layoutManager= linearLayoutManager

        adapter = ReposoAdapter(requireContext(),
            reposos as ArrayList<ReposoModel>,
            this)
        listaRepososRv.adapter= adapter
        Toast.makeText(context, "El id del reposo es ", Toast.LENGTH_LONG).show()
        return view
    }

   override fun onStart() {
        super.onStart()
        if (reposos.isEmpty()){
            reposos.add(ReposoModel(1,"estoy enferma","20 de enero"))
            reposos.add(ReposoModel(2,"estoy super enferma","12 de marzo"))
            adapter.notifyItemInserted(reposos.size-1)
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        obtenerReposos()
    }

    private fun obtenerReposos() {
        Log.d("Text","Entro a obtener reposos")
        val call = repososApi.getReposos()
        call.enqueue(object : Callback<RepososResult> {
            override fun onFailure(call: retrofit2.Call<RepososResult>, t: Throwable) {
                //Toast.makeText(requireContext(), "Hubo un error al obtener el reposo $call", Toast.LENGTH_SHORT).show()
                Log.d("Text","Hubo un erro al obtener reposo  ${t.localizedMessage}")
            }


            override fun onResponse(
                //call: retrofit2.Call<PeliculaResult>,
                //response: retrofit2.Response<PeliculaResult>
                call: Call<RepososResult>,
                response: Response<RepososResult>

            ) {
                val misRepos = response.body()
                misRepos?.results?.let { reposos.addAll(it) }
                adapter.notifyItemInserted(reposos.size - 1)
                Log.d("Text","Mis reposos son ${reposos.size}")
            }

        })

    }

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

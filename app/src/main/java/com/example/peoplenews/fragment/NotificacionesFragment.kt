package com.example.peoplenews.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplenews.adapter.NotificacionAdapter
import com.example.peoplenews.adapter.NotificacionInterface
import com.example.peoplenews.model.NotificacionModel
import kotlinx.android.synthetic.main.fragment_notificaciones.*
import py.edu.uca.peoplenews.R

/**
 * A simple [Fragment] subclass.
 */
class NotificacionesFragment : Fragment(), NotificacionInterface {


    override fun NotificacionClicked(notificacion: NotificacionModel) {
        val action= InicioDirections.actionInicioToNotificacionesFragment()
        Navigation.findNavController(lista_notificaciones).navigate(action)
    }
    private lateinit var listaNotificacionesRv: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: NotificacionAdapter
    private  val notificaciones: MutableList<NotificacionModel> = mutableListOf()

    companion object{
        fun newInstance(): NotificacionesFragment = NotificacionesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_notificaciones,container,false)
        listaNotificacionesRv = view.findViewById(R.id.lista_notificaciones)
        linearLayoutManager = LinearLayoutManager(requireContext())
        listaNotificacionesRv.layoutManager= linearLayoutManager

        adapter = NotificacionAdapter(requireContext(),
            notificaciones as ArrayList<NotificacionModel>,
            this)
        listaNotificacionesRv.adapter= adapter
        Toast.makeText(context, "El id del notificacion es ", Toast.LENGTH_LONG).show()
        return view
    }

    override fun onStart() {
        super.onStart()
        if (notificaciones.isEmpty()){
            notificaciones.add(NotificacionModel(1,"Notificación importarte","30 de octubre"))
            notificaciones.add(NotificacionModel(2,"Capacitación","12 de marzo"))
            adapter.notifyItemInserted(notificaciones.size-1)
        }
    }


}



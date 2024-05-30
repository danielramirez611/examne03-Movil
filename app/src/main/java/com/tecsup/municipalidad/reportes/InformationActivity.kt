package com.tecsup.municipalidad.reportes

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tecsup.municipalidad.R
import com.tecsup.municipalidad.database.Information
import com.tecsup.municipalidad.muniview.InformationViewModel

class InformationActivity: AppCompatActivity() {

    private lateinit var informationViewModel: InformationViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_municipalidad_libros)

        informationViewModel = run {
            ViewModelProvider(this)[InformationViewModel::class.java]
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerInformations)

        val adapter = InformationAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        informationViewModel.informations?.observe(this){ informations ->
            informations?.let {
                adapter.setInformation(informations)
            }
        }

        val floatingNota = findViewById<FloatingActionButton>(R.id.floatingInformation)
        floatingNota.setOnClickListener{
            registerAndUpdateNote()
        }


            //layoutManager =  LinearLayoutManager(context)
            //layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        supportActionBar?.hide()

    }

    private fun registerAndUpdateNote() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_information, null)

        val titleAlertNote = "Formulario de Reporte"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(titleAlertNote)

        val mAlertDialog = mBuilder.show()

        val buttonCreate  = mDialogView.findViewById<Button>(R.id.btnCreate)
        val editTextNamesCreate  = mDialogView.findViewById<EditText>(R.id.edtPlace)
        val editTextPhoneCreate  = mDialogView.findViewById<EditText>(R.id.edtTitle)
        val editTextEmailCreate  = mDialogView.findViewById<EditText>(R.id.edtComent)
        val editTextEditorialCreate  = mDialogView.findViewById<EditText>(R.id.edtEditorial)
        val editTextGeneroCreate  = mDialogView.findViewById<EditText>(R.id.edtGenero)

        buttonCreate.setOnClickListener {

            mAlertDialog.dismiss()

            val textNames = editTextNamesCreate.text.toString()
            val textPhone = editTextPhoneCreate.text.toString()
            val textEmail = editTextEmailCreate.text.toString()
            val textCategoria = editTextEditorialCreate.text.toString()
            val textGenero = editTextGeneroCreate.text.toString()

            var informationVM = Information(textNames, textPhone, textGenero,textCategoria,textEmail,)
            informationViewModel.saveInformations(informationVM)

        }


    }



}
package com.tecsup.municipalidad.repository

import androidx.lifecycle.LiveData
import android.app.Application
import  com.tecsup.municipalidad.database.InformationDatabase
import com.tecsup.municipalidad.database.Information
import com.tecsup.municipalidad.reportes.InformationDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InformationRepository (application: Application) {

    private val informationDAO: InformationDAO?= InformationDatabase.getInstance(application)?.informationDAO()

    suspend fun  insertNoteWithCoroutines(information: Information){
        processInsertNote(information)
    }

    private suspend fun  processInsertNote(information: Information){
        withContext(Dispatchers.Default) {
            informationDAO?.insert(information)
        }
    }

    fun getNotes(): LiveData<List<Information>>?{
        return informationDAO?.getNota()
    }

}
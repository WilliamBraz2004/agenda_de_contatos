package br.com.williambraz.agenda_de_contatos.repository

import android.content.Context
import br.com.williambraz.agenda_de_contatos.dao.ContactDAO
import br.com.williambraz.agenda_de_contatos.dao.DataBaseHelper
import br.com.williambraz.agenda_de_contatos.model.Contact

class ContactRepository(context: Context) {
    private val dbHelper = DataBaseHelper(context)
    private val dao = ContactDAO(dbHelper.connectionSource)

    fun insert(contact: Contact):Int{
        val result = dao.create(contact)
        dao.connectionSource.close()
        return result
    }

    fun findAll() = dao.queryForAll()
}
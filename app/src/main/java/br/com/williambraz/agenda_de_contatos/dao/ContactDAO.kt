package br.com.williambraz.agenda_de_contatos.dao

import br.com.williambraz.agenda_de_contatos.model.Contact
import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource

class ContactDAO(connectionSource: ConnectionSource?) : BaseDaoImpl<Contact,Int>(Contact::class.java) {
    init {
       setConnectionSource(connectionSource)
        initialize()
    }
}
package br.com.williambraz.agenda_de_contatos.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.com.williambraz.agenda_de_contatos.model.Contact
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class DataBaseHelper(context: Context) : OrmLiteSqliteOpenHelper(context,db,null,version) {
    companion object{
        private const val db = "contacts.db"
        private const val version = 1
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTable(connectionSource,Contact::class.java)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {}
}
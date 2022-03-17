package br.com.williambraz.agenda_de_contatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.williambraz.agenda_de_contatos.databinding.ActivityMainBinding
import br.com.williambraz.agenda_de_contatos.model.ContactAdapter
import br.com.williambraz.agenda_de_contatos.repository.ContactRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabNewContact.setOnClickListener {
            val intent = Intent(applicationContext,NewContactActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.setTitle(R.string.title_home)
    }

    override fun onStart() {
        super.onStart()
        val repository = ContactRepository(applicationContext)
        val contacts = repository.findAll()
        binding.rvContacts.adapter = ContactAdapter(contacts)
        binding.rvContacts.hasFixedSize()
        binding.rvContacts.layoutManager = LinearLayoutManager(applicationContext)
    }
}
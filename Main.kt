package com.lazday.kotlinroommvvm.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fp.R
import com.example.fp.activity.EditActivity
import com.example.fp.activity.BeritaAdapter
import com.example.fp.room.Constant
import com.example.fp.room.Berita
import com.example.fp.room.BeritaDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupListener()
        setupRecyclerView()
    }

    private val db by lazy { BeritaDB(this) }
    private lateinit var BeritaAdapter: BeritaAdapter

    override fun onResume() {
        super.onResume()
        loadData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadData(){
        CoroutineScope(Dispatchers.IO).launch {
            BeritaAdapter.setData(db.beritaDao().getBeritaall())
            withContext(Dispatchers.Main) {
                BeritaAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun setupView (){
        supportActionBar!!.apply {
            title = "Catatan"
        }
    }

    private fun setupListener(){
        button_create.setOnClickListener {
            intentEdit(Constant.TYPE_CREATE, 0)
        }
    }

    private fun setupRecyclerView () {

        BeritaAdapter = BeritaAdapter(
            arrayListOf(),
            object : BeritaAdapter.OnAdapterListener {
                override fun onClick(beritax: Berita) {
                    intentEdit(Constant.TYPE_READ, beritax.id)
                }

                override fun onUpdate(beritax: Berita) {
                    intentEdit(Constant.TYPE_UPDATE, beritax.id)
                }

                override fun onDelete(beritax: Berita) {
                    deleteAlert(beritax)
                }

            })

        list_note.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = BeritaAdapter
        }

    }

    private fun intentEdit(intent_type: Int, note_id: Int) {
        startActivity(
            Intent(this, EditActivity::class.java)
                .putExtra("intent_type", intent_type)
                .putExtra("berita_id", note_id)
        )

    }

    private fun deleteAlert(berita: Berita){
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi Hapus")
            setMessage("Yakin hapus ${berita.title}?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                CoroutineScope(Dispatchers.IO).launch {
                    db.beritaDao().deleteBerita(berita)
                    dialogInterface.dismiss()
                    loadData()
                }
            }
        }

        dialog.show()
    }
}
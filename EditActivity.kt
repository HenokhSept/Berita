package com.example.fp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fp.R
import com.example.fp.room.Constant
import com.example.fp.room.Berita
import com.example.fp.room.BeritaDB
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    private val db by lazy { BeritaDB(this) }
    private var beritaId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setupView()
        setupLstener()
    }

    private fun setupView(){
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        when (intentType()) {
            Constant.TYPE_CREATE -> {
                supportActionBar!!.title = "BUAT BARU"
                button_save.visibility = View.VISIBLE
                button_update.visibility = View.GONE
            }
            Constant.TYPE_READ -> {
                supportActionBar!!.title = "BACA"
                button_save.visibility = View.GONE
                button_update.visibility = View.GONE
                getBerita()
            }
            Constant.TYPE_UPDATE -> {
                supportActionBar!!.title = "EDIT"
                button_save.visibility = View.GONE
                button_update.visibility = View.VISIBLE
                getBerita()
            }
        }
    }

    private fun setupLstener(){
        button_save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.beritaDao().addBerita(
                    Berita(
                        0,
                        edit_title.text.toString(),
                        edit_note.text.toString()
                    )
                )
                finish()
            }
        }
        button_update.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.beritaDao().updateBerita(
                    Berita(
                        beritaId,
                        edit_title.text.toString(),
                        edit_note.text.toString()
                    )
                )
                finish()
            }
        }
    }

    private fun getBerita(){
        beritaId = intent.getIntExtra("berita_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
            val beritas = db.beritaDao().getBerita(beritaId).get(0)
            edit_title.setText( beritas.title )
            edit_note.setText( beritas.berita )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun intentType(): Int {
        return intent.getIntExtra("intent_type", 0)
    }
}
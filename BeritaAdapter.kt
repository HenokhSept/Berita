package com.example.fp.activity


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fp.R
import com.example.fp.room.Berita
import kotlinx.android.synthetic.main.adapter_main.view.*

class  BeritaAdapter (var beritas: ArrayList<Berita>, var listener: OnAdapterListener) :
    RecyclerView.Adapter<BeritaAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.adapter_main,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() = beritas.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val Berita = beritas[position]
        holder.view.text_title.text = Berita.title
        holder.view.text_title.setOnClickListener {
            listener.onClick(Berita)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(Berita)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(Berita)
        }
    }

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(newList: List<Berita>) {
        beritas.clear()
        beritas.addAll(newList)
    }

    interface OnAdapterListener {
        fun onClick(beritax: Berita)
        fun onUpdate(beritax: Berita)
        fun onDelete(beritax: Berita)
    }
}
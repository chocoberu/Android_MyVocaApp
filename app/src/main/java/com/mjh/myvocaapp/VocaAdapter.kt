package com.mjh.myvocaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mjh.myvocaapp.model.Voca

class VocaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var englishTextView : TextView = itemView.findViewById(R.id.english_textView)
    var koreanTextView : TextView = itemView.findViewById(R.id.koreanTextView)

}

class VocaAdapter : RecyclerView.Adapter<VocaViewHolder>() {
    private var mItems : List<Voca> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocaViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_voca, parent, false)
        return VocaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VocaViewHolder, position: Int) {
        val voca = mItems[position]
        holder.englishTextView.text = voca.english
        holder.koreanTextView.text = voca.korean

    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun updateItems(items : List<Voca>)
    {
        mItems = items
        notifyDataSetChanged()
    }

}
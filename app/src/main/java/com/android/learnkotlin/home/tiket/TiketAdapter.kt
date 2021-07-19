package com.android.learnkotlin.home.tiket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.learnkotlin.R
import com.android.learnkotlin.model.Checkout
import com.bumptech.glide.Glide
import java.text.NumberFormat
import java.util.*

class TiketAdapter   (private var data: List<Checkout>,
                      private val listener: (Checkout) -> Unit)
    : RecyclerView.Adapter<TiketAdapter.ViewHolder>() {

    lateinit var contextAddapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TiketAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAddapter = parent.context
        val inflaterView = layoutInflater.inflate(R.layout.row_item_checkout_gray, parent, false)
        return ViewHolder(inflaterView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TiketAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAddapter)
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        private val tvTitle:TextView = view.findViewById(R.id.tv_kursi)

        fun bindItem(data:Checkout, listener: (Checkout) -> Unit, context: Context) {

            tvTitle.setText("Seat No. "+data.kursi)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }
}

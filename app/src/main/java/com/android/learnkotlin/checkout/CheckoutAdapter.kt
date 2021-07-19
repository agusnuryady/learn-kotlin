package com.android.learnkotlin.checkout

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

class CheckoutAdapter   (private var data: List<Checkout>,
                      private val listener: (Checkout) -> Unit)
    : RecyclerView.Adapter<CheckoutAdapter.ViewHolder>() {

    lateinit var contextAddapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CheckoutAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAddapter = parent.context
        val inflaterView = layoutInflater.inflate(R.layout.row_item_checkout, parent, false)
        return ViewHolder(inflaterView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CheckoutAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAddapter)
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        private val tvTitle:TextView = view.findViewById(R.id.tv_kursi)
        private val tvHarga:TextView = view.findViewById(R.id.tv_harga)

        fun bindItem(data:Checkout, listener: (Checkout) -> Unit, context: Context) {

            val localId = Locale("id", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localId)

            tvHarga.setText(formatRupiah.format(data.harga!!.toDouble()))

            if (data.kursi!!.startsWith("Total")) {
                tvTitle.setText(data.kursi)
                tvTitle.setCompoundDrawables(null,null,null,null)
            } else {
                tvTitle.setText("Seat No. "+data.kursi)
            }

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }
}

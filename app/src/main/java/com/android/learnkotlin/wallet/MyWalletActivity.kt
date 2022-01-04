package com.android.learnkotlin.wallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.learnkotlin.R
import com.android.learnkotlin.model.Wallet
import kotlinx.android.synthetic.main.activity_my_wallet.*

class MyWalletActivity : AppCompatActivity() {

    private var dataList = ArrayList<Wallet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet)

        dataList.add(
            Wallet(
                "Avenger Infinity War",
                "Sabtu, 23 Juli 2021",
                70000.0,
                "0"
            )
        )
        dataList.add(
            Wallet(
                "Top Up",
                "Sabtu, 23 Juli 2021",
                170000.0,
                "1"
            )
        )
        dataList.add(
            Wallet(
                "Avenger Infinity War",
                "Sabtu, 23 Juli 2021",
                70000.0,
                "0"
            )
        )

        rv_transaksi.layoutManager = LinearLayoutManager(this)
        rv_transaksi.adapter = WalletAdapter(dataList) {

        }

        btn_top_up.setOnClickListener {

        }

    }
}

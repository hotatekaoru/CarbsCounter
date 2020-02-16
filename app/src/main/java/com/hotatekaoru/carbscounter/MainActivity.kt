package com.hotatekaoru.carbscounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val interactor = CarbsInteractor(this)

    private lateinit var totalCountTextView: TextView
    private lateinit var riceCountTextView: TextView
    private lateinit var snackCountTextView: TextView
    private lateinit var juiceCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        totalCountTextView = findViewById(R.id.total_count)
        riceCountTextView = findViewById(R.id.rice_count)
        snackCountTextView = findViewById(R.id.snack_count)
        juiceCountTextView = findViewById(R.id.juice_count)
        reloadLabels()

        if (intent != null) {
            val intentActionName = intent.action
            print(intentActionName)
        }
    }

    fun onRicePressed(_view: View) {
        val riceCount = riceCountTextView.text.toString().toInt()
        interactor.saveRiceCount(riceCount + 1)
        reloadLabels()
    }

    fun onSnackPressed(_view: View) {
        val snackCount = snackCountTextView.text.toString().toInt()
        interactor.saveSnackCount(snackCount + 1)
        reloadLabels()
    }

    fun onJuicePressed(_view: View) {
        val juiceCount = juiceCountTextView.text.toString().toInt()
        interactor.saveJuiceCount(juiceCount + 1)
        reloadLabels()
    }

    private fun reloadLabels() {
        val carbs = interactor.loadCarbs()
        riceCountTextView.text = carbs.rice.toString()
        snackCountTextView.text = carbs.snack.toString()
        juiceCountTextView.text = carbs.juice.toString()
        totalCountTextView.text = (carbs.rice + carbs.snack + carbs.juice).toString()
    }
}

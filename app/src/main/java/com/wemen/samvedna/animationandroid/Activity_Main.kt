package com.wemen.samvedna.animationandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

import java.util.ArrayList

class Activity_Main : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var spinner: Spinner? = null
    private var imageView: ImageView? = null
    private var categories: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner) as Spinner
        imageView = findViewById(R.id.image) as ImageView
        spinner!!.onItemSelectedListener = this

        // Spinner Drop down elements
        categories = ArrayList<String>()
        categories!!.add("Fade In")
        categories!!.add("Fade Out")
        categories!!.add("Cross Fade")
        categories!!.add("Blink")
        categories!!.add("Zoom In")
        categories!!.add("Zoom Out")
        categories!!.add("Rotate")
        categories!!.add("Move")
        categories!!.add("Slide Up")
        categories!!.add("Slide Down")
        categories!!.add("Bounce")
        categories!!.add("Sequential")
        categories!!.add("Together")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories!!)

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = dataAdapter

    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        Toast.makeText(this, adapterView.selectedItem.toString() + "is Selected", Toast.LENGTH_SHORT).show()
        startAnimation(adapterView.selectedItem)
    }

    private fun startAnimation(i: Any) {
        val anim: Animation
        var animRes = R.anim.fade_in
        when (i.toString()) {
            "Fade In" -> animRes = R.anim.fade_in
            "Fade Out" -> animRes = R.anim.fade_out
            "Cross Fade" -> animRes = R.anim.fade_in
            "Blink" -> animRes = R.anim.blink
            "Zoom In" -> animRes = R.anim.zoom_in
            "Zoom Out" -> animRes = R.anim.zoom_out
            "Rotate" -> animRes = R.anim.rotate
            "Slide Up" -> animRes = R.anim.slide_up
            "Move" -> animRes = R.anim.move
            "Slide Down" -> animRes = R.anim.slide_down
            "Bounce" -> animRes = R.anim.bounce
            "Sequential" -> animRes = R.anim.sequential
            "Together" -> animRes = R.anim.together
        }
        anim = AnimationUtils.loadAnimation(this, animRes)
        imageView!!.startAnimation(anim)
    }

    override fun onNothingSelected(adapterView: AdapterView<*>) {

    }
}

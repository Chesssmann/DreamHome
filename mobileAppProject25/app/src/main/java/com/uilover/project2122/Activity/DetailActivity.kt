package com.uilover.project2122.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.uilover.project2122.Model.ItemsDomain
import com.uilover.project2122.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var property: ItemsDomain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getBundles()
        setVariable()
    }

    private fun setVariable() {
        binding.backBtn.setOnClickListener { finish() }
        val drawableResouceId = resources.getIdentifier(property.pickPath, "drawable", packageName)
        Glide.with(this@DetailActivity)
            .load(drawableResouceId)
            .into(binding.picDetail)

        binding.titleAddressTxt.text = "${property.title} in ${property.address}"
        binding.typeTxt.text = property.type
        binding.descriptionTxt.text = property.description
        binding.priceTxt.text = "$${property.price}"
        binding.bedTxt.text = "${property.bed} Bedroom"
        binding.bathTxt.text = "${property.bath} Bathroom"
        binding.sizeTxt.text = "${property.size} m2"

        binding.garageTxt.text = if (property.isGarage) "Car Garage" else "no-Car Garage"
    }

    private fun getBundles() {
        property = intent.getSerializableExtra("object") as ItemsDomain
    }
}
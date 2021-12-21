package com.pitaya.mobile.uinspector.ui.optional

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.bumptech.glide.Glide
import com.pitaya.mobile.uinspector.demo.databinding.ActivityImageLoaderBinding

/**
 * @author YvesCheung
 * 2020/12/31
 */
class ImageLoaderActivity : Activity() {
    private lateinit var binding: ActivityImageLoaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageLoaderBinding.inflate(layoutInflater)
        Glide.with(this)
            .load("https://raw.githubusercontent.com/YvesCheung/UInspector/2.x/art/uinspector.png")
            .error(ColorDrawable(Color.GREEN))
            .placeholder(ColorDrawable(Color.parseColor("#ff0099cc")))
            .into(binding.glideImageview)

        binding.frescoImageview.setImageURI(
            "https://raw.githubusercontent.com/YvesCheung/UInspector/2.x/art/uinspector.png"
        )
    }
}
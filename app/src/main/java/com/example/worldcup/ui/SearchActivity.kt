package com.example.worldcup.ui

import android.view.LayoutInflater
import com.example.worldcup.databinding.ActivitySearchBinding

class SearchActivity: BaseActivity<ActivitySearchBinding>(){
    override val logTag: String = "SearchActivity"
    override val bindingInflater: (layoutInflater: LayoutInflater) -> ActivitySearchBinding = ActivitySearchBinding::inflate

    override fun setup() {

    }

    override fun addCallBacks() {

    }

}
package com.example.worldcup.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding> : AppCompatActivity() {

    abstract val logTag: String
    abstract val bindingInflater: (layoutInflater: android.view.LayoutInflater) -> VB
    private var _binding :ViewBinding?=null //prevent memory leaks
    protected val binding: VB by lazy {
        requireNotNull(_binding) { "Binding cannot be accessed before onCreateView" } as VB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
        addCallBacks()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    abstract fun setup()
    abstract fun addCallBacks()

    protected fun logV(msg: Any) {
        Log.v(logTag, msg.toString())
    }

    protected fun logE(msg: String) {
        Log.e(logTag, msg)
    }
}

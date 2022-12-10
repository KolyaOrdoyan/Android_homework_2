package com.example.androidhomework.ui.details



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidhomework.databinding.FragmentDetailesBinding
import com.example.common.BaseCommonFragment

class DetailsFragment: BaseCommonFragment() {

    private lateinit var binding: FragmentDetailesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailesBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}
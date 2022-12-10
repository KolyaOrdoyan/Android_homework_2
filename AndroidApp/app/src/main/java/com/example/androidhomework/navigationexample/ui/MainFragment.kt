package com.example.androidhomework.navigationexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.androidhomework.databinding.FragmentMainBinding
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidhomework.R


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        binding.buttonFragment1.setOnClickListener { controller.navigate(R.id.orangeFragment) }
        binding.buttonFragment2.setOnClickListener { controller.navigate(R.id.greyFragment) }

    }
}
package com.reynaldo.horoscapp.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reynaldo.horoscapp.databinding.FragmentPalminstryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalminstryFragment : Fragment() {
    private var _binding: FragmentPalminstryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPalminstryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}
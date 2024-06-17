package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.compose.AndroidFragment
import com.example.myapplication.databinding.FragmentNestedBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstTopLevelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AndroidFragment<NestedInComposeFragment>()
            }
        }
    }
}

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NestedInComposeFragment : Fragment() {

    private var _binding: FragmentNestedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNestedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


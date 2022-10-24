package com.qjmttejada.healthfitness

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.qjmttejada.healthfitness.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home, container, false)

        binding.btnContent1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_content1Fragment)
        }

        binding.btnContent2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_content2Fragment)
        }

        binding.btnContent3.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_content3Fragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}
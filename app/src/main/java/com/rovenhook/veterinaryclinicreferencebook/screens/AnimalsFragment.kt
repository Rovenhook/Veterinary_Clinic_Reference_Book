package com.rovenhook.veterinaryclinicreferencebook.screens

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.rovenhook.veterinaryclinicreferencebook.R
import com.rovenhook.veterinaryclinicreferencebook.data.Animal
import com.rovenhook.veterinaryclinicreferencebook.data.Dog
import com.rovenhook.veterinaryclinicreferencebook.databinding.FragmentAnimalsBinding
import com.rovenhook.veterinaryclinicreferencebook.databinding.FragmentCatsBinding
import com.rovenhook.veterinaryclinicreferencebook.viewmodels.ReferenceBookViewModel

class AnimalsFragment(val contex: Context) : Fragment() {
    private var _binding: FragmentAnimalsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ReferenceBookViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cont = context
        val adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(contex, android.R.layout.simple_list_item_1, mutableListOf())
        binding.listViewRoomItems.adapter = adapter

        viewModel.getAnimalsList()
            .subscribe({ v ->
                adapter.clear()
                adapter.addAll(v)
                adapter.notifyDataSetChanged()

            },
                { e ->  })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
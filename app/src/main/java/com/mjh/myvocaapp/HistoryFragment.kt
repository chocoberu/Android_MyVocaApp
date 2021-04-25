package com.mjh.myvocaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mjh.myvocaapp.databinding.FragmentHistoryBinding
import com.mjh.myvocaapp.model.Voca
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryFragment : Fragment() {

    private var _binding : FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val view = binding.root

        // recyclerView 설정
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        val adapter = VocaAdapter()
        recyclerView.adapter = adapter

        // viewModel
        viewModel.apply {
            getAll().observe(viewLifecycleOwner, Observer {
                adapter.updateItems(it)
            })
        }

        // floating action button 설정
        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(activity, "TODO : Add voca", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Voca("amused","흥겨운"))
            }
        }



        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
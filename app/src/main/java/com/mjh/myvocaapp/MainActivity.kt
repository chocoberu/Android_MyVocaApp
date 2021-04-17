package com.mjh.myvocaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.mjh.myvocaapp.databinding.ActivityMainBinding
import com.mjh.myvocaapp.model.AppDatabase
import com.mjh.myvocaapp.model.Voca
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this, MainViewModel.Factory(application)).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        //val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        // 리사이클러뷰 레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = VocaAdapter()
        // 리사이클러뷰 어댑터 설정
        binding.recyclerView.adapter = adapter

        viewModel.apply {
            //loadingLiveData.observe(this@MainActivity, Observer {
                //binding.progressBar.visibility = if(it) View.VISIBLE else View.GONE
            //})
            getAll().observe(this@MainActivity, Observer {
                adapter.updateItems(it)
            })
        }

        // 플로팅액션바 클릭리스너 설정
        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(this, "TODO : Add voca", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Voca("amused","흥겨운"))
            }
        }
    }
}
package com.mjh.myvocaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mjh.myvocaapp.databinding.ActivityMainBinding
import com.mjh.myvocaapp.model.Voca
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var historyFragment: HistoryFragment
    private lateinit var listFragment: ListFragment
    private lateinit var settingFragment: SettingFragment

    /*private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this, MainViewModel.Factory(application)).get(MainViewModel::class.java)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 프래그먼트 관련
        historyFragment = HistoryFragment()
        listFragment = ListFragment()
        settingFragment = SettingFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, historyFragment).commit()
        
        // 하단 탭
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.tab_history -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, historyFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab_vocalist -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, listFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab_setting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, settingFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }
}
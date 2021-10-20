package com.example.tablayoutusingviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.tablayoutusingviewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabList = listOf("Business" , "Science" , "Sports" , "Technology")

        val list = ArrayList<Fragment>()
        list.add(FragmentOne())
        list.add(FragmentTwo())
        list.add(FragmentThree())
        list.add(FragmentFour())

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager , lifecycle , list)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
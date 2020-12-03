package com.cloudinteractive.viewbindingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cloudinteractive.viewbindingtest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    companion object {
        val tabs = listOf("Alan", "Barry", "Esther", "Jimi", "Nathan")
    }

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.vpMember.adapter = MemberPageAdapter(this, tabs)

        TabLayoutMediator(binding.tlMember, binding.vpMember) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }


    class MemberPageAdapter(fragmentActivity: FragmentActivity, private val list: List<String>) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = list.size

        override fun createFragment(position: Int): Fragment = MemberFragment.newInstance(list[position])
    }
}
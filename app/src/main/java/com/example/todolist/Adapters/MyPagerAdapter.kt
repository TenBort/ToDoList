package com.example.todolist.Adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.todolist.Fragments.FirstTabFragment
import com.example.todolist.Fragments.SecondTabFragment

val fragmentTitleList = mutableListOf("To do list", "Done list")

class MyPagerAdapter(fm: FragmentManager, val fragmentCount:Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstTabFragment()
            1 -> SecondTabFragment()
            else -> SecondTabFragment()




        }
    }

    override fun getCount(): Int = fragmentCount

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]

    }
}
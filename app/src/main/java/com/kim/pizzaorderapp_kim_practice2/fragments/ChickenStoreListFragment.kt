package com.kim.pizzaorderapp_kim_practice2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kim.pizzaorderapp_kim_practice2.R
import com.kim.pizzaorderapp_kim_practice2.adapters.ChickenStoreListAdapter
import com.kim.pizzaorderapp_kim_practice2.datas.Store
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*

class ChickenStoreListFragment : Fragment() {

    val mchickenStoreList = ArrayList<Store>()

    lateinit var mChickenStoreListAdapter : ChickenStoreListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chicken_store_list, container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mchickenStoreList.add(Store("A 치킨가게", "1111-2222","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mchickenStoreList.add(Store("B 치킨가게", "1111-2222","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mchickenStoreList.add(Store("C 치킨가게", "1111-2222","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mchickenStoreList.add(Store("D 치킨가게", "1111-2222","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))

        mChickenStoreListAdapter = ChickenStoreListAdapter(requireContext(), R.layout.chickenstore_list_item, mchickenStoreList)
        chickenStoreListView.adapter = mChickenStoreListAdapter
    }
}
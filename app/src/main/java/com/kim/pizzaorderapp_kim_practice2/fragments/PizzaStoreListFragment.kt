package com.kim.pizzaorderapp_kim_practice2.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kim.pizzaorderapp_kim_practice2.R
import com.kim.pizzaorderapp_kim_practice2.ViewStoreDetailActivity
import com.kim.pizzaorderapp_kim_practice2.adapters.PizzaStoreListAdapter
import com.kim.pizzaorderapp_kim_practice2.datas.Store
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*

class PizzaStoreListFragment : Fragment() {

    val mPizzaStoreList = ArrayList<Store>()

    lateinit var mPizzaStoreListAdapter : PizzaStoreListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list, container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mPizzaStoreList.add( Store("A 피자가게", "1111-2222","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mPizzaStoreList.add( Store("B 피자가게", "1333-4422","https://cdn1.iconfinder.com/data/icons/cartoon-snack/128/pizza-128.png"))
        mPizzaStoreList.add( Store("C 피자가게", "5123-3332","https://cdn3.iconfinder.com/data/icons/food-set-3/91/Food_C219-128.png"))
        mPizzaStoreList.add( Store("D 피자가게", "7777-6666","https://cdn0.iconfinder.com/data/icons/fastfood-31/64/pizza-italian-food-fast-fastfood-cheese-piece-128.png"))

        mPizzaStoreListAdapter = PizzaStoreListAdapter(requireContext(), R.layout.pizzastore_list_item, mPizzaStoreList)
        pizzaStoreListView.adapter = mPizzaStoreListAdapter

        pizzaStoreListView.setOnItemClickListener { parent, view, position, id ->

            val clickedStore = mPizzaStoreList[position]

            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("storeData", clickedStore)
            startActivity(myIntent)

        }
    }
}
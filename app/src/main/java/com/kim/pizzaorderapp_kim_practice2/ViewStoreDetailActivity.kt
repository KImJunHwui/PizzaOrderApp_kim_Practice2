package com.kim.pizzaorderapp_kim_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kim.pizzaorderapp_kim_practice2.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mStoreData = intent.getSerializableExtra("storeData") as Store

        storeNameTxt.text = mStoreData.name
        storePhoneNumTxt.text = mStoreData.phoneNum

        Glide.with(mContext).load(mStoreData.imgUrl).into(storeLogoImg)

    }


}
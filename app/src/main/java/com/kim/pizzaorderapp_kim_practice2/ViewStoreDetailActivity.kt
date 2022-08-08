package com.kim.pizzaorderapp_kim_practice2

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

        val permissionListener = object : PermissionListener{
            override fun onPermissionGranted() {

                callPhoneBtn.setOnClickListener {

                    val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(mContext, "[설정]에서 다시 확인하세요", Toast.LENGTH_SHORT).show()
            }


        }

        TedPermission.create()
            .setPermissionListener(permissionListener)
            .setDeniedMessage("다시 확인해 주세요")
            .setPermissions(Manifest.permission.CALL_PHONE)
            .check()


    }

    override fun setValues() {

        mStoreData = intent.getSerializableExtra("storeData") as Store

        storeNameTxt.text = mStoreData.name
        storePhoneNumTxt.text = mStoreData.phoneNum

        Glide.with(mContext).load(mStoreData.imgUrl).into(storeLogoImg)

    }


}
package com.permissionx.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.app.databinding.ActivityMainBinding
import com.permissionx.liuxiangwei.PermissionX
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBind.root)

        mainBind.makeCallBtn.setOnClickListener{
            PermissionX.request(this, arrayOf(android.Manifest.permission.CALL_PHONE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)){allGranted,deniedList ->
                if (allGranted){
                    //打电话
                    call()
                }else{
                    "You denied $deniedList".showToast(this)
                }
            }
        }


    }

    private fun call(){
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}
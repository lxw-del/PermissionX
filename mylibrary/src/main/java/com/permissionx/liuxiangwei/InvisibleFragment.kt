package com.permissionx.liuxiangwei

import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

/**
 * 通过一个隐藏的fragment，对运行时权限进行API封装
 */
//typealias用于给任意类型指定一个别名
typealias PermissionCallback = (Boolean,List<String>)->Unit

class InvisibleFragment:Fragment() {
    private var callback:PermissionCallback? = null

    fun requestNow(cb:PermissionCallback,permissions:Array<String>){
        callback = cb
        requestPermissionLauncher.launch(permissions)
    }


    //申请权限
    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

        val deniedList = ArrayList<String>()

        //如果拒绝，则加入拒绝列表
        for ((permission,result) in it){
            if (!result){
                deniedList.add(permission)
            }
        }
        //判断拒绝列表是否为空，是空的则表示全部权限都允许了
        val allGranted = deniedList.isEmpty()
        //执行回调函数
        callback?.let { it(allGranted,deniedList) }
    }





}
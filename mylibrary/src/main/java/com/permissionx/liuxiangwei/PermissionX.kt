package com.permissionx.liuxiangwei

import androidx.fragment.app.FragmentActivity

/**
 * 对外接口
 */
object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity:FragmentActivity,permissions:Array<String>,callback:PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            //如果没有就将碎片手动加入到当前活动中
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,permissions)
    }

}
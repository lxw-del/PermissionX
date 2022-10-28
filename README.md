# PermissionX

PermissionX是一个用于简化Android运行时权限用法的开源库

添加如下配置将PermissionX引入到你的项目中：

```groovy
dependencies {
    ...
    implementation 'com.permissionx.liuxiangwei:permissionx:1.0.0'
}
```

然后就可以使用如下的语法结构来申请运行时权限了：
```kotlin
PermissionX.request(this, arrayOf(android.Manifest.permission.CALL_PHONE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)){allGranted,deniedList ->
                if (allGranted){
                    //打电话
                    call()
                }else{
                    "You denied $deniedList".showToast(this)
                }
            }
```
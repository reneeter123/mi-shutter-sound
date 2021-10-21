package com.reneeter.mishuttersound

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class Hook : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if (lpparam?.packageName == "com.android.camera") {
            XposedHelpers.findAndHookMethod(
                "OooO0O0.OooO0o0.OooO00o.OooO0OO",
                lpparam.classLoader,
                "oo0o0Oo",
                object : XC_MethodHook() {
                    override fun beforeHookedMethod(param: MethodHookParam?) {
                        param?.result = true
                    }
                }
            )
        }
    }
}
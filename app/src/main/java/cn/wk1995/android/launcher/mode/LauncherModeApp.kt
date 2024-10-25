package cn.wk1995.android.launcher.mode

import android.app.Activity
import android.os.Bundle
import cn.entertech.base.BaseApplication
import cn.entertech.log.api.EnterTechLogUtils

class LauncherModeApp : BaseApplication() {

    companion object {
        private const val TAG = "LauncherModeApp"
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                EnterTechLogUtils.d(TAG, "onActivityCreated $activity ")
            }

            override fun onActivityDestroyed(activity: Activity) {
                EnterTechLogUtils.d(TAG, "onActivityDestroyed $activity ")
            }

            // 其他生命周期方法可以保持为空
            override fun onActivityStarted(activity: Activity) {
                EnterTechLogUtils.d(TAG, "onActivityStarted $activity ")
            }

            override fun onActivityResumed(activity: Activity) {
                EnterTechLogUtils.d(TAG, "onActivityResumed $activity ")
            }

            override fun onActivityPaused(activity: Activity) {
                EnterTechLogUtils.d(TAG, "onActivityPaused $activity ")
            }

            override fun onActivityStopped(activity: Activity) {
                EnterTechLogUtils.d(TAG, "onActivityStopped $activity ")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                EnterTechLogUtils.d(TAG, "onActivitySaveInstanceState $activity ")
            }
        })
    }
}
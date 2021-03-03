package com.huya.mobile.uinspector.optional.lottie

import android.content.Context
import com.huya.mobile.uinspector.properties.view.ViewPropertiesPlugin
import com.huya.mobile.uinspector.plugins.UInspectorPluginService
import com.huya.mobile.uinspector.plugins.UInspectorPlugins

/**
 * @author YvesCheung
 * 2021/2/1
 */
class UInspectorLottieService : UInspectorPluginService {

    override fun onCreate(context: Context, plugins: UInspectorPlugins) {
        plugins.append(ViewPropertiesPlugin::class.java, LottiePropertiesParserPlugin())
    }
}
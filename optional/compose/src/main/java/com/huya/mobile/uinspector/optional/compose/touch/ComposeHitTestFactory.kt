package com.huya.mobile.uinspector.optional.compose.touch

import com.huya.mobile.uinspector.hierarchy.HitTest
import com.huya.mobile.uinspector.hierarchy.HitTestFactory
import com.huya.mobile.uinspector.optional.compose.UInspectorComposeService.Companion.PluginKey

/**
 * @author YvesCheung
 * 2021/2/1
 */
class ComposeHitTestFactory : HitTestFactory {

    override val uniqueKey: String = PluginKey

    override fun create(delegate: HitTest): HitTest = ComposeHitTest(delegate)
}
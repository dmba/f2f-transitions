package me.dmba.f2ftransitions.screens.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import me.dmba.f2ftransitions.screens.MainNavigator

/**
 * Created by dmba on 6/10/18.
 */
abstract class NavigatorFragment : Fragment() {

    protected lateinit var navigator: MainNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainNavigator) {
            navigator = context
        } else {
            throw IllegalArgumentException("Activity should implement ${MainNavigator::class}")
        }
    }

}

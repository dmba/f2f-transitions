@file:Suppress("UNCHECKED_CAST")

package me.dmba.f2ftransitions.extensions

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by dmba on 6/10/18.
 */

fun <T : Any> Fragment.arg(key: String) = lazy {
    return@lazy arguments?.get(key) as? T ?: error("Illegal type for $key")
}

fun <T : Fragment> AppCompatActivity.findFragmentByTag(tag: String): T {
    return supportFragmentManager.findFragmentByTag(tag) as T
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(context, message, length).show()
}

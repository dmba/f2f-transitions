package me.dmba.f2ftransitions.screens

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.transition.TransitionInflater
import android.view.View
import me.dmba.f2ftransitions.R
import me.dmba.f2ftransitions.data.DataItem
import me.dmba.f2ftransitions.extensions.findFragmentByTag
import me.dmba.f2ftransitions.screens.details.DetailsFragment
import me.dmba.f2ftransitions.screens.details.newDetailsFragment
import me.dmba.f2ftransitions.screens.main.MainFragment
import me.dmba.f2ftransitions.screens.main.newMainFragment

/**
 * Created by dmba on 6/10/18.
 */

const val TAG_MAIN = "TAG_MAIN"
const val TAG_DETAILS = "TAG_DETAILS"

class MainActivity : AppCompatActivity(), MainNavigator {

    private val transitionInflater: TransitionInflater by lazy { TransitionInflater.from(this) }

    private val mainFragment: MainFragment get() = findFragmentByTag(TAG_MAIN)
    private val detailsFragment: DetailsFragment get() = findFragmentByTag(TAG_DETAILS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            goToMainScreen()
        }
    }

    override fun goToMainScreen() {
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_main_container, newMainFragment(), TAG_MAIN)
            .commitAllowingStateLoss()
    }

    override fun goToDetailsScreen(dataItem: DataItem, sharedView: View) {
        val transitionName = ViewCompat.getTransitionName(sharedView)

        val prevFragment = mainFragment
        val nextFragment = newDetailsFragment(dataItem, transitionName)

        // 1. Transitions for Previous Fragment
        prevFragment.apply {
            exitTransition = Fade()
            enterTransition = Fade()
        }

        // 2. Shared Elements Transition
        nextFragment.apply {
            sharedElementEnterTransition = transitionInflater.inflateTransition(android.R.transition.move)
            sharedElementReturnTransition = transitionInflater.inflateTransition(android.R.transition.move)
        }

        // 3. Transitions for New Fragment
        nextFragment.apply {
            enterTransition = Fade()
            exitTransition = Fade()
        }

        supportFragmentManager.beginTransaction()
            .addSharedElement(sharedView, transitionName)
            .setReorderingAllowed(true)
            .addToBackStack(TAG_DETAILS)
            .replace(R.id.activity_main_container, nextFragment, TAG_DETAILS)
            .commitAllowingStateLoss()
    }

}

package me.dmba.f2ftransitions.screens

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import me.dmba.f2ftransitions.R
import me.dmba.f2ftransitions.data.DataItem
import me.dmba.f2ftransitions.screens.main.MainFragment
import me.dmba.f2ftransitions.screens.main.newMainFragment

/**
 * Created by dmba on 6/10/18.
 */
class MainActivity : AppCompatActivity(), MainNavigator {

    lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToMainScreen()
    }

    override fun goToMainScreen() {
        mainFragment = newMainFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.activity_main_container, mainFragment)
            .commitAllowingStateLoss()
    }

    override fun goToDetailsScreen(dataItem: DataItem, sharedView: View) {
        TODO("not implemented")
    }

}

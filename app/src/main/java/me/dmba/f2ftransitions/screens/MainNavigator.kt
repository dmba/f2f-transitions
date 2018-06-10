package me.dmba.f2ftransitions.screens

import android.view.View
import me.dmba.f2ftransitions.data.DataItem

/**
 * Created by dmba on 6/10/18.
 */
interface MainNavigator {

    fun goToMainScreen()

    fun goToDetailsScreen(dataItem: DataItem, sharedView: View)

}

package me.dmba.f2ftransitions.screens.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import me.dmba.f2ftransitions.R
import me.dmba.f2ftransitions.data.DataProvider.data
import me.dmba.f2ftransitions.screens.base.NavigatorFragment
import me.dmba.f2ftransitions.utils.ItemOffsetDecoration

/**
 * Created by dmba on 6/10/18.
 */

fun newMainFragment() = MainFragment()

class MainFragment : NavigatorFragment() {

    private val isPortrait: Boolean by lazy {
        resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

    private val dataItemsAdapter: DataItemsAdapter by lazy {
        DataItemsAdapter(data, layoutInflater, navigator::goToDetailsScreen)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() = recyclerView.apply {
        adapter = dataItemsAdapter
        layoutManager = GridLayoutManager(context, if (isPortrait) 2 else 4)
        addItemDecoration(ItemOffsetDecoration(4))
    }

}

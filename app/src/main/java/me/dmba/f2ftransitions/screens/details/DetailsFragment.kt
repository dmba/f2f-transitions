package me.dmba.f2ftransitions.screens.details

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import me.dmba.f2ftransitions.R
import me.dmba.f2ftransitions.data.DataItem
import me.dmba.f2ftransitions.extensions.arg
import me.dmba.f2ftransitions.screens.base.NavigatorFragment

/**
 * Created by dmba on 6/10/18.
 */
const val ARG_TRANSITION_NAME = "ARG_TRANSITION_NAME"
const val ARG_TRANSITION_DATA = "ARG_TRANSITION_DATA"

fun newDetailsFragment(data: DataItem, transitionName: String) = DetailsFragment().apply {
    arguments = Bundle().apply {
        putString(ARG_TRANSITION_NAME, transitionName)
        putParcelable(ARG_TRANSITION_DATA, data)
    }
}

class DetailsFragment : NavigatorFragment() {

    private val imageTransionName: String by arg(ARG_TRANSITION_NAME)
    private val imageTransionData: DataItem by arg(ARG_TRANSITION_DATA)

    private val picasso: Picasso by lazy { Picasso.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailImageView.transitionName = imageTransionName

        setupView(imageTransionData)

        delayEnterTransitionBy(3000)
    }

    private fun setupView(item: DataItem) {
        detailImageName.text = item.name

        picasso.load(item.imgUrl)
            .into(detailImageView)
    }

    private fun delayEnterTransitionBy(delayMs: Long) {
        Handler().postDelayed({
            startPostponedEnterTransition()
        }, delayMs)
    }

}

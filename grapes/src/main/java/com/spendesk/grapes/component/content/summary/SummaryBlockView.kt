package com.spendesk.grapes.component.content.summary

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.spendesk.grapes.R

/**
 * Base class for any view that is a block inside a summary screen.
 *
 * @author Vivien Mahe
 * @since 06/01/2021
 */
open class SummaryBlockView : CardView {

    //region constructors
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)
    //endregion constructors

    init {
        setupView()
    }

    private fun setupView() {
        radius = resources.getDimension(R.dimen.contentBlockCardRadius)
        cardElevation = resources.getDimension(R.dimen.contentBlockElevation)
    }
}
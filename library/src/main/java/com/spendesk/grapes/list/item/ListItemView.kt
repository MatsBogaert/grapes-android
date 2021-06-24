package com.spendesk.grapes.list.item

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.spendesk.grapes.R
import com.spendesk.grapes.extensions.gone
import com.spendesk.grapes.extensions.visible
import com.spendesk.grapes.extensions.visibleWithTextOrGone
import com.spendesk.grapes.internal.libs.glide.loadFromUrl
import kotlinx.android.synthetic.main.lists_list_item.view.*

/**
 * @author danyboucanova
 * @since 22/06/2021
 */
class ListItemView : ConstraintLayout {

    //region constructors

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    //endregion constructors

    class Configuration(
        val primaryImage: String? = null,
        val shouldCircleCropPrimaryImage: Boolean = false,
        @DrawableRes val placeholderPrimaryImage: Int = ResourcesCompat.ID_NULL,
        val secondaryImage: String? = null,
        val shouldCircleCropSecondaryImage: Boolean = false,
        @DrawableRes val placeholderSecondaryImage: Int = ResourcesCompat.ID_NULL,
        val titleStart: CharSequence,
        val descriptionStart: CharSequence? = null,
        val titleEnd: CharSequence? = null,
        val descriptionEnd: CharSequence? = null
    )

    init {
        View.inflate(context, R.layout.lists_list_item, this)

        val paddingStart = resources.getDimensionPixelOffset(R.dimen.listItemPaddingStart)
        val paddingEnd = resources.getDimensionPixelOffset(R.dimen.listItemPaddingEnd)
        val paddingVert = resources.getDimensionPixelOffset(R.dimen.listItemPaddingVert)

        setPadding(paddingStart, paddingVert, paddingEnd, paddingVert)
    }

    fun updateConfiguration(configuration: Configuration) {
        configuration.primaryImage?.let {
            listItemPrimaryImage.visible()
            listItemPrimaryImage.loadFromUrl(url = configuration.primaryImage, errorResId = configuration.placeholderPrimaryImage, shouldCircleCrop = configuration.shouldCircleCropPrimaryImage)
        } ?: run {
            listItemPrimaryImage.gone()
        }

        configuration.secondaryImage?.let {
            listItemSecondaryImage.visible()
            listItemSecondaryImage
                .loadFromUrl(url = configuration.secondaryImage, errorResId = configuration.placeholderSecondaryImage, shouldCircleCrop = configuration.shouldCircleCropSecondaryImage)
        } ?: run {
            listItemSecondaryImage.gone()
        }

        listItemTitleStart.visibleWithTextOrGone(configuration.titleStart)
        listItemDescriptionStart.visibleWithTextOrGone(configuration.descriptionStart)
        listItemTitleEnd.visibleWithTextOrGone(configuration.titleEnd)
        listItemDescriptionEnd.visibleWithTextOrGone(configuration.descriptionEnd)
    }
}
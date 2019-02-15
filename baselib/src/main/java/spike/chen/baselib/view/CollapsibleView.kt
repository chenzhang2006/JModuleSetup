package spike.chen.baselib.view

import android.animation.LayoutTransition
import android.content.Context
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import spike.chen.baselib.R
import kotlin.math.roundToInt

class CollapsibleView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
  LinearLayout(context, attrs, defStyleAttr) {

  private val titleView: TextView
  private var startExpanded = false

  private var collapsed = false

  init {
    orientation = VERTICAL
    layoutTransition = LayoutTransition()

    // get the initial parameters from xml
    var title: String? = null
    var titlePaddingStart = 0f
    var titlePaddingEnd = 0f
    context.theme.obtainStyledAttributes(attrs, R.styleable.CollapsibleView, defStyleAttr, 0)
      .apply {
        try {
          title = getString(R.styleable.CollapsibleView_title)
          startExpanded = getBoolean(R.styleable.CollapsibleView_startExpanded, false)
          titlePaddingStart = getDimension(R.styleable.CollapsibleView_titlePaddingStart, 0f)
          titlePaddingEnd = getDimension(R.styleable.CollapsibleView_titlePaddingEnd, 0f)
        } finally {
          recycle()
        }
      }

    // add the title view
    titleView = LayoutInflater.from(context)
      .inflate(R.layout.view_collapsible_title, this, false) as TextView
    ViewCompat.setPaddingRelative(
      titleView,
      titlePaddingStart.roundToInt(),
      titleView.paddingTop,
      titlePaddingEnd.roundToInt(),
      titleView.paddingBottom
    )
    addView(titleView, 0)
    titleView.setOnClickListener { if (collapsed) expand() else collapse() }
    titleView.text = title
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    if (startExpanded) {
      expand()
    } else {
      collapse()
    }
  }

  private fun collapse() {
    titleView.compoundDrawables.filterNotNull().forEach { it.level = 0 }

    for (i in 1 until childCount) {
      getChildAt(i).visibility = View.GONE
    }
    collapsed = true
  }

  private fun expand() {
    titleView.compoundDrawables.filterNotNull().forEach { it.level = 1 }

    for (i in 1 until childCount) {
      getChildAt(i).visibility = View.VISIBLE
    }
    collapsed = false
  }
}
package com.example.imdb_project.ui.presentation.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.imdb_project.R


class SectionTitleView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    private var sectionTitle: TextView

    init{
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.section_title, this, true)

        // retrieve textview
        sectionTitle = view.findViewById(R.id.sectionTitle)
    }

    fun setTitle(title: String){
        sectionTitle.text = title
    }

}
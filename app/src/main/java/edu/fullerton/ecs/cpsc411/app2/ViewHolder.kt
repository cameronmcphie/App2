package edu.fullerton.ecs.cpsc411.app2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var taskCheckBox = view.findViewById<CheckBox>(R.id.itemCheckbox)!!
    var listItemText = view.findViewById<EditText>(R.id.itemText)!!


}
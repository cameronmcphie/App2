package edu.fullerton.ecs.cpsc411.app2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
    var taskCheckBox = item.findViewById<CheckBox>(R.id.itemCheckbox)!!
    var listItemText = item.findViewById<EditText>(R.id.itemText)!!


}
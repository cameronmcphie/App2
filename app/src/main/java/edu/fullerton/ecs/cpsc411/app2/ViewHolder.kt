package edu.fullerton.ecs.cpsc411.app2

import android.arch.persistence.room.Room
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item.*

class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
    var taskCheckBox = item.findViewById<CheckBox>(R.id.itemCheckbox)!!
    var listItemText = item.findViewById<EditText>(R.id.itemText)!!
    var itemId = item.findViewById<TextView>(R.id.listIdHolder)!!
    init {
        listItemText.onChange(item)
    }

    fun EditText.onChange(item: View) {
        this.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val db = Room.databaseBuilder(item.context, ChecklistDatabase::class.java, "ChecklistsDB").allowMainThreadQueries().build()
                val checklistDAO = db.checklistDAO()
                var listItemText = item.findViewById<EditText>(R.id.itemText)!!
                var itemId = item.findViewById<TextView>(R.id.listIdHolder)!!
                checklistDAO.updateContent(listItemText.text.toString(), itemId.text.toString().toInt())
            }
        })
    }
}
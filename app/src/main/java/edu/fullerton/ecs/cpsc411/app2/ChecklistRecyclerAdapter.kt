package edu.fullerton.ecs.cpsc411.app2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText

class ChecklistRecyclerAdapter(content: List<Checklist>): RecyclerView.Adapter<ViewHolder>() {

    private var checklist: List<Checklist> = content


    override fun onCreateViewHolder(holder: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(holder.context).inflate(R.layout.list_item, holder, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listItemText.setText(checklist[position].checklistContent)
    }

    override fun getItemCount(): Int {
        return checklist.size
    }

    fun addContent(contentList: List<Checklist>) {
        this.checklist = contentList
    }
}
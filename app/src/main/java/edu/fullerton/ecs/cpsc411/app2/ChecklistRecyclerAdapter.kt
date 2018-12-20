package edu.fullerton.ecs.cpsc411.app2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ChecklistRecyclerAdapter(content: List<Checklist>): RecyclerView.Adapter<ViewHolder>() {

    private var checklist: List<Checklist> = content


    override fun onCreateViewHolder(holder: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(holder.context).inflate(R.layout.list_item, holder, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listItemText.setText(checklist[position].checklistContent)
        holder.itemId.text = checklist[position].checklistId.toString()
        holder.taskCheckBox.setOnClickListener {
            val appDatabase = ChecklistDatabase.getDatabase(it.context)
            val id = holder.itemId.text.toString()
            appDatabase.checklistDAO().deleteItem(id.toInt())
            it.visibility = View.GONE
            holder.listItemText.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return checklist.size
    }

    fun addContent(contentList: List<Checklist>) {
        this.checklist = contentList
    }
}

package edu.fullerton.ecs.cpsc411.app2

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

class ContentViewModel(application: Application): AndroidViewModel(application) {

    private var listContent: MutableList<Checklist>
    private val appDatabase: ChecklistDatabase

    init {
        appDatabase = ChecklistDatabase.getDatabase(this.getApplication())
        listContent = appDatabase.checklistDAO().getCheckList().toMutableList()
    }

    fun getListContent(): MutableList<Checklist> {
        return listContent
    }

    fun addEmptyListItem(): MutableList<Checklist> {
        listContent.add(Checklist())
        return listContent
    }

    fun addContent(content: Checklist) {
        appDatabase.checklistDAO().insertItem(content)
    }

}
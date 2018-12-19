package edu.fullerton.ecs.cpsc411.app2

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class ContentViewModel(application: Application): AndroidViewModel(application) {

    private var listContent: LiveData<List<Checklist>>
    private val appDatabase: ChecklistDatabase

    init {
        appDatabase = ChecklistDatabase.getDatabase(this.getApplication())
        listContent = appDatabase.checklistDAO().getCheckList()
    }

    fun getListContent(): LiveData<List<Checklist>> {
        return listContent
    }

    fun addContent(content: Checklist) {
        appDatabase.checklistDAO().insertItem(content)
    }

}
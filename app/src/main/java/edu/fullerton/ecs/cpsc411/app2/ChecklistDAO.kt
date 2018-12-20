package edu.fullerton.ecs.cpsc411.app2

import android.arch.persistence.room.*

@Dao
interface ChecklistDAO {
    @Query("SELECT * FROM ChecklistTbl")
    fun getCheckList(): List<Checklist>

    @Insert
    fun insertItem(checklist: Checklist)

    @Query("UPDATE ChecklistTbl SET checklist_content = :checklistContent WHERE checklist_id = :id")
    fun updateContent(checklistContent: String, id: Int)

    @Query("DELETE FROM ChecklistTbl WHERE checklist_id = :id")
    fun deleteItem(id : Int)

    @Query("SELECT LAST_INSERT_ROWID()")
    fun getLastInserted() : Int

    @Query("DELETE FROM ChecklistTbl")
    fun deleteChecklist()
}
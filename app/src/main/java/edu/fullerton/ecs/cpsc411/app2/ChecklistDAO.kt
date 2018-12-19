package edu.fullerton.ecs.cpsc411.app2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ChecklistDAO {
    @Query("SELECT * FROM ChecklistTbl")
    fun getCheckList(): List<Checklist>

    @Insert
    fun insertItem(checklist: Checklist)

    @Query("DELETE FROM ChecklistTbl WHERE checklist_id = :id")
    fun deleteItem(id : Int)

    @Query("DELETE FROM ChecklistTbl")
    fun deleteChecklist()
}
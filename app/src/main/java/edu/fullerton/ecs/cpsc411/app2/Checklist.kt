package edu.fullerton.ecs.cpsc411.app2

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity (tableName = "ChecklistTbl")
data class Checklist(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "checklist_id")
    var checklistId: Int = 0,

    @ColumnInfo(name = "checklist_content")
    var checklistContent: String = "",

    @ColumnInfo(name = "is_completed")
    var isCompleted: Boolean = false
)
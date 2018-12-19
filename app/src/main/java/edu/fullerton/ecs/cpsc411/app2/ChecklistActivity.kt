package edu.fullerton.ecs.cpsc411.app2

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem


import kotlinx.android.synthetic.main.activity_check_list.*
import kotlinx.android.synthetic.main.content_check_list.*

class ChecklistActivity: AppCompatActivity() {

    var recyclerAdapter: ChecklistRecyclerAdapter? = null
    var contentRecyclerView: RecyclerView? = null
//
//    var db: ChecklistDatabase? = null
//
//    var viewModel: ContentViewModel? = null

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ContentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_check_list)
        setSupportActionBar(toolbar)

//        db = ChecklistDatabase.getDatabase(this)
//        val checklistDAO = db!!.checklistDAO()
//        val tmp2 = checklistDAO.getCheckList()
//
//
//
//        contentRecyclerView = findViewById(R.id.checklistRecyclerView)
//        recyclerAdapter = ChecklistRecyclerAdapter(arrayListOf())
//
//        contentRecyclerView!!.layoutManager = LinearLayoutManager(this)
//        contentRecyclerView!!.adapter = recyclerAdapter


//        var tmp : List<Checklist> = viewModel!!.getListContent()

//        viewModel = ViewModelProviders.of(this).get(ContentViewModel::class.java)



//        viewModel!!.getListContent().observe(this, Observer {
//            items -> recyclerAdapter!!.addContent(items!!)
//        })

        //setContentView(R.layout.list_item)




//        val db = Room.databaseBuilder(applicationContext, ChecklistDatabase::class.java, "ChecklistsDB").allowMainThreadQueries().build()
//        val checklistDAO = db.checklistDAO()
//        var content = checklistDAO.getCheckList()



        //recyclerAdapter = ChecklistRecyclerAdapter(content)

        recyclerAdapter = ChecklistRecyclerAdapter(viewModel.getListContent())
        contentRecyclerView = findViewById(R.id.checklistRecyclerView)

        contentRecyclerView!!.layoutManager = LinearLayoutManager(this)
        contentRecyclerView!!.adapter = recyclerAdapter




        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            recyclerAdapter = ChecklistRecyclerAdapter(viewModel.addEmptyListItem())
            contentRecyclerView = findViewById(R.id.checklistRecyclerView)

            contentRecyclerView!!.layoutManager = LinearLayoutManager(this)
            contentRecyclerView!!.adapter = recyclerAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_check_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun insertChecklist(db: ChecklistDatabase) {

        val tmp = Checklist(checklistContent = "test")

        val checklistDAO = db.checklistDAO()

        checklistDAO.insertItem(tmp)
    }

    private fun printAllChecklists(db: ChecklistDatabase) {
        val checklistDAO = db.checklistDAO()
        val tmp2 = checklistDAO.getCheckList()

        for (item in tmp2) {

            val tmp3: String = if (!item.isCompleted) "false" else {
                "true"
            }

            println(item.checklistId.toString() + " " + item.checklistContent + " " + tmp3)
        }
    }

    private fun delete(db: ChecklistDatabase) {
        val checklistDAO = db.checklistDAO()
        checklistDAO.deleteChecklist()
    }

    private fun removeItem(db: ChecklistDatabase, id: Int) {
        val checklistDAO = db.checklistDAO()
        checklistDAO.deleteItem(id)
    }
}

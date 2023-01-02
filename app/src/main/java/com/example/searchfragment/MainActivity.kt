package com.example.searchfragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.searchfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var listView:ListView
    private lateinit var binidng:ActivityMainBinding
   /* val name= arrayOf("James","Artur","Robert","Lux","Lukan","Anton","Eliza","Aziza","Babur","Nurtilek"
    ,"Adil","Doni","Nursuluu","Alex")*/
    private lateinit var adapter:ArrayAdapter<String>
    var name = arrayOf(
        "James", "Artur", "Robert", "Lux", "Lukan",
        "Anton", "Eliza", "Aziza", "Babur", "Nurtilek", "Adil", "Doni", "Nursuluu", "Alex", "Ainazik", "Илон", "Стив", "Марк", "Бил", "Карл",
        "Виктория", "Джонни", "Джобс", "Боб", "Джейми", "Оскар", "Билли", "Джонс", "Ричард"


    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binidng=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binidng.root)
        /*listView=findViewById(R.id.listView)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, name)
        listView.adapter=arrayAdapter*/


        setupListView()
        setupSearchView()


    }

    private fun setupListView() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, name)
        binidng.listView.adapter = adapter
    }

    private fun setupSearchView() {
        binidng.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val isMatchFound = name.contains(p0)
                val msg = if (isMatchFound) "Found: $p0" else getString(R.string.no_match)
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })
    }
}

/*

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        val menuItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView = menuItem?.actionView as SearchView
        //val searchView: SearchView = menuItem?.actionView as SearchView
        searchView.queryHint = "Type"
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu )

    }

    override fun onQueryTextSubmit(new: String?): Boolean {
return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        arrayAdapter.filter.filter(newText)

        return false
    }

}
*/



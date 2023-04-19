package com.example.recipeapp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var isBackgroundBlack = false
    private lateinit var searchField: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLightMode: Button = findViewById(R.id.view_togglebutton)
        var backgroundLayer: LinearLayout = findViewById(R.id.mainLayout)
        var titleSearch: TextView = findViewById(R.id.title_search)
        searchField = findViewById(R.id.search_recipe)
        var selectFood: TextView = findViewById(R.id.select_food)
        var spin: Spinner = findViewById(R.id.cuisine_spinner)
        var check1: CheckBox = findViewById(R.id.vegetarian_checkbox)
        var check2: CheckBox = findViewById(R.id.gluten_free_checkbox)
        var radio1: RadioButton = findViewById(R.id.rating_radiobutton)
        var radio2: RadioButton = findViewById(R.id.difficulty_radiobutton)
        var preferenceResults: TextView = findViewById(R.id.results_preferences)
        var sortingCategory: TextView = findViewById(R.id.results_sorting)
        var resultOfSearch: TextView = findViewById(R.id.results_search)
        var resultType: TextView = findViewById(R.id.results_type)
        var resumeTitle: TextView = findViewById(R.id.resumeTitle)

        setupAutoCompleteTextView()

        btnLightMode.setOnClickListener {

            isBackgroundBlack = !isBackgroundBlack // Toggle the state

            // Update the background color based on the current state
            if (isBackgroundBlack) {
                backgroundLayer.setBackgroundColor(Color.BLACK)
                btnLightMode.setBackgroundColor(Color.DKGRAY)
                btnLightMode.setTextColor(Color.WHITE)
                titleSearch.setTextColor(Color.WHITE)
                searchField.setBackgroundColor(Color.DKGRAY)
                searchField.setTextColor(Color.WHITE)
                searchField.setHintTextColor(Color.WHITE)
                selectFood.setTextColor(Color.WHITE)
                spin.setBackgroundColor(Color.WHITE)
                resumeTitle.setTextColor(Color.WHITE)
                resultType.setTextColor(Color.WHITE)
                preferenceResults.setTextColor(Color.WHITE)
                sortingCategory.setTextColor(Color.WHITE)
                resultOfSearch.setTextColor(Color.WHITE)

            } else {
                backgroundLayer.setBackgroundColor(Color.WHITE)
                btnLightMode.setBackgroundColor(Color.BLACK)
                btnLightMode.setTextColor(Color.WHITE)
                titleSearch.setTextColor(Color.BLACK)
                searchField.setBackgroundColor(Color.WHITE)
                searchField.setTextColor(Color.BLACK)
                searchField.setHintTextColor(Color.BLACK)
                selectFood.setTextColor(Color.BLACK)
                resumeTitle.setTextColor(Color.BLACK)
                resultType.setTextColor(Color.BLACK)
                preferenceResults.setTextColor(Color.BLACK)
                sortingCategory.setTextColor(Color.BLACK)
                resultOfSearch.setTextColor(Color.BLACK)

            }


        }

        check1.setOnCheckedChangeListener{ buttonView, isChecked ->

            var baseText = "Preferences: "

            if(!check2.isChecked) preferenceResults.text = baseText
            if(isChecked) preferenceResults.text = "" + preferenceResults.text + check1.text + " "
            else {

                if(check2.isChecked) preferenceResults.text = baseText + check2.text + " "
                else preferenceResults.text = baseText

            }

        }

        check2.setOnCheckedChangeListener{ buttonView, isChecked ->

            var baseText = "Preferences: "

            if(!check1.isChecked) preferenceResults.text = baseText
            if(isChecked) preferenceResults.text = "" + preferenceResults.text + check2.text + " "
            else {

                if(check1.isChecked) preferenceResults.text = baseText + check1.text + " "
                else preferenceResults.text = baseText

            }

        }

        radio1.setOnCheckedChangeListener{ buttonView, isCheked ->

            var baseText = "Sorting category: "

            if(isCheked) sortingCategory.text = baseText + radio1.text

        }

        radio2.setOnCheckedChangeListener{ buttonView, isCheked ->

            var baseText = "Sorting category: "

            if(isCheked) sortingCategory.text = baseText + radio2.text

        }

        searchField.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var baseText = "Result of search: "
                resultOfSearch.text = baseText + p0
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var baseText = "Type of food: "
                val selectItem = spin.selectedItem.toString()
                resultType.text = baseText + selectItem
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


    }

    fun setupAutoCompleteTextView() {

        val foods = resources.getStringArray(R.array.foods_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, foods)
        searchField.setAdapter(adapter)

    }

}
package com.stimednp.practiceanko

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.stimednp.practiceanko.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                val name = editText() {
                    hint = "Siapa nama kamu ?"
                    width = matchParent
                    height = dip(100)
                }

                button("Say Hello") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener { toast("Hello ${name.text}") }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Alert!") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        alert("Happy Coding ${name.text}!") {
                            yesButton { toast("Oh") }
                            noButton {}
                        }.show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Selector") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        val listClub =
                            listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
                        selector(
                            "Hello ${name.text}  What's football club do you love?",
                            listClub
                        ) { _, i ->
                            toast("So you love ${listClub[i]}, right!?")
                        }
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Snackbar") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener { snackbar("Hello ${name.text}") }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Go to Second Activity") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
            }
        }
    }
}

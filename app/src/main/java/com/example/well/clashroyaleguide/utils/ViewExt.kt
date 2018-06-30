package com.example.well.clashroyaleguide.utils

import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.showSnackBar(message: String, duration: Int) {
    Snackbar.make(this, message, duration).show()
}

fun View.showSnackBar(message: String, duration: Int, actionText: String, actionAction: () -> Unit) {
    Snackbar.make(this, message, duration)
            .setAction(actionText, { actionAction() })
            .show()
}


fun View.showSnackBar(message: String, duration: Int, actionText: String) {
    Snackbar.make(this, message, duration)
            .setAction(actionText, { })
            .show()
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}
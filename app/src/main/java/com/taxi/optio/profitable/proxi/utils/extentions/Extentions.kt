package com.taxi.optio.profitable.proxi.utils.extentions

import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.AppCompatAutoCompleteTextView

fun AppCompatAutoCompleteTextView.onTextChanged(onTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(source: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChanged.invoke(source.toString())
        }
    })
}
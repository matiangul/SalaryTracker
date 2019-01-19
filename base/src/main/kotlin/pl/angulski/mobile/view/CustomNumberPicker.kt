/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.angulski.mobile.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.NumberPicker

class CustomNumberPicker(context: Context, attrs: AttributeSet) : NumberPicker(context, attrs) {

    override fun addView(child: View) {
        super.addView(child)
        initEditText(child)
    }

    override fun addView(child: View, index: Int) {
        super.addView(child, index)
        initEditText(child)
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        super.addView(child, index, params)
        initEditText(child)
    }

    override fun addView(child: View, params: ViewGroup.LayoutParams) {
        super.addView(child, params)
        initEditText(child)
    }

    override fun addView(child: View, width: Int, height: Int) {
        super.addView(child, width, height)
        initEditText(child)
    }

    private fun initEditText(view: View) {
        if (view is EditText) {
            view.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    try {
                        this@CustomNumberPicker.value = Integer.parseInt(s.toString())
                    } catch (ignored: NumberFormatException) {
                    }

                }

                override fun afterTextChanged(s: Editable) {}

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }
            })
        }
    }
}
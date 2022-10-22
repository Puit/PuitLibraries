package com.nunnos.components

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.OnFocusChangeListener
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.nunnos.components.databinding.CustomEditTextBinding

@RequiresApi(Build.VERSION_CODES.M)
class CustomEditText(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private lateinit var databinding: CustomEditTextBinding
    private lateinit var listener : CustomListener
    private lateinit var errorText : String

    init {
        bindView()
        setListener()
        parseAttributes(attrs)
    }
    private fun bindView() {
        databinding = CustomEditTextBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun parseAttributes(attrs: AttributeSet?) {
        if(attrs == null) return

        val attributes : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0)
        val text = attributes.getString(R.styleable.CustomEditText_edit_text_text)
        val hintText = attributes.getString(R.styleable.CustomEditText_edit_text_hint_text)
        errorText = attributes.getString(R.styleable.CustomEditText_edit_text_error_text).toString()
        val textColor = attributes.getColor(
            R.styleable.CustomEditText_edit_text_text_color,
            context.getColor(R.color.black)
        )
        val hintTextColorAtEndPosition = attributes.getColor(
            R.styleable.CustomEditText_edit_text_hint_text_color_at_end_position,
            context.getColor(R.color.background_gray_middle)
        )
        val hintTextColorAtStartPosition = attributes.getColor(
            R.styleable.CustomEditText_edit_text_hint_text_color_at_start_position,
            context.getColor(R.color.background_gray_dark)
        )
        val underLineColor = attributes.getColor(
            R.styleable.CustomEditText_edit_text_underline_color,
            context.getColor(R.color.background_purple)
        )
        val clickable = attributes.getBoolean(R.styleable.CustomEditText_edit_text_clickable, true)
        val focusable = attributes.getBoolean(R.styleable.CustomEditText_edit_text_focusable, true)
        if (!TextUtils.isEmpty(hintText)) {
            databinding.tilTitle.hint = hintText
        }
        if (!TextUtils.isEmpty(text)) {
            databinding.etTitle.setText(text)
        }
        databinding.tilTitle.isClickable = clickable
        databinding.etTitle.isClickable = clickable
        databinding.tilTitle.isFocusable = focusable
        databinding.etTitle.isFocusable = focusable
        databinding.etTitle.setTextColor(textColor)
        databinding.tilTitle.hintTextColor = ColorStateList.valueOf(hintTextColorAtEndPosition)
        databinding.tilTitle.setHelperTextColor(ColorStateList.valueOf(hintTextColorAtStartPosition))
        databinding.tilTitle.setBoxStrokeColorStateList(ColorStateList.valueOf(underLineColor))

    }
    private fun setListener() {
        databinding.etTitle.setOnClickListener {
            listener.onItemClick()
        }
    }
    fun onFocusChanged(l:OnFocusChangeListener) {
        databinding.etTitle.onFocusChangeListener =
            OnFocusChangeListener { v, hasFocus -> l.onFocusChange(v, hasFocus) }
    }
    fun setErrorState() {
        databinding.tilTitle.error = errorText
    }

    fun setSuccessState() {
        databinding.tilTitle.isErrorEnabled = false
    }
    fun setListener(l:CustomListener){
        this.listener = l
    }
    fun getText(): String? {
        return databinding.tilTitle.editText!!.text.toString()
    }

    fun setText(text: String?) {
        databinding.etTitle.setText(text)
    }
    fun setInputType(vararg types: Int) {
        for (t in types) {
            databinding.etTitle.inputType = t
        }
    }
    /**
     * Interface
     * */
    interface CustomListener{
       fun onItemClick()
    }
}
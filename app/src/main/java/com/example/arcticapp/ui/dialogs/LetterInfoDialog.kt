package com.example.arcticapp.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.arcticapp.data.models.LetterModel
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.CustomDialogLetterInfoBinding

class LetterInfoDialog(private var letterModel: LetterModel) : AppCompatDialogFragment() {

    private lateinit var binding: CustomDialogLetterInfoBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = CustomDialogLetterInfoBinding.inflate(LayoutInflater.from(context))

        binding.tvInfoLetter.text = letterModel.nameLetter
        Glide
            .with(binding.root)
            .load(R.drawable.education_item_img)
            .into(binding.imgLetter)
        binding.btnClose.setOnClickListener {
            dismiss()
        }
        return AlertDialog.Builder(this.context)
            .setView(binding.root)
            .create()
    }
}
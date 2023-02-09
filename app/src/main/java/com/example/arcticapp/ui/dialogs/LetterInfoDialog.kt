package com.example.arcticapp.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialogFragment
import com.bumptech.glide.Glide
import com.example.arcticapp.data.models.LetterModel
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.CustomDialogLetterInfoBinding

class LetterInfoDialog(private var letterModel: LetterModel) : AppCompatDialogFragment() {

    private lateinit var binding: CustomDialogLetterInfoBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = CustomDialogLetterInfoBinding.inflate(LayoutInflater.from(context))
        binding.letter.text = letterModel.letter
        binding.wordOriginal.text = letterModel.word.originalWord
        binding.translation.text = letterModel.word.translation

        Glide
            .with(binding.root)
            .load(R.drawable.education_item_img)
            .into(binding.letterIllustration)

        return AlertDialog.Builder(this.context)
            .setView(binding.root)
            .create()
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}
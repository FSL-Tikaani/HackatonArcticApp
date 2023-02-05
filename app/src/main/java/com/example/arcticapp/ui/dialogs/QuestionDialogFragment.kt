package com.example.arcticapp.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.arcticappfinal.R
import com.google.android.exoplayer2.util.Log

class QuestionDialogFragment(val textAnswer: Int) : AppCompatDialogFragment(){

    private lateinit var customView: View;

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //set custom xml
        customView = this.layoutInflater.inflate(R.layout.fragment_custom_dialog_task_compare_question, null)
        val tvAnswer = customView.findViewById<TextView>(R.id.tv_answer)
        tvAnswer.text = getString(textAnswer)

        //dismiss dialog
        val btn: Button = customView.findViewById(R.id.btn_exit)
        btn.setOnClickListener {
            dismiss()
        }

        return AlertDialog.Builder(this.context)
            .setView(customView)
            .create()
    }

}

package com.example.arcticapp.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.arcticappfinal.R

class ExitDialogFragment(private val clickedExit: () -> Unit) : AppCompatDialogFragment() {
    private lateinit var customView: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //set custom xml
        customView = this.layoutInflater.inflate(R.layout.fragment_custom_dialog_task_compare_exit, null)
        //init btns
        val btnExit: Button = customView.findViewById(R.id.btn_exit)
        val btnReturn: Button = customView.findViewById(R.id.btn_return)
        //dismiss dialog
        btnReturn.setOnClickListener { dismiss() }
        //exit from TaskCompareActivity
        btnExit.setOnClickListener {
            clickedExit()
            dismiss()
        }

        return AlertDialog.Builder(this.context)
            .setView(customView)
            .create()
    }
}
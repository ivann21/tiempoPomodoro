package com.example.tiempopomodoro

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tiempopomodoro.database.AppDatabase
import com.example.tiempopomodoro.databinding.RegisterLayoutBinding
import com.example.tiempopomodoro.model.Register

class RegisterAdapter(
    var registers: List<Register>,
    val context: Context,
    val db: AppDatabase
) : RecyclerView.Adapter<RegisterAdapter.ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.register_layout,null)
        )
    }

    override fun getItemCount(): Int {
        return registers.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val register = registers[position]
        val binding = RegisterLayoutBinding.bind(holder.itemView)

        binding.numberTextView.text = register.number
        binding.nombreTextView.text = register.nombre
        binding.descriptionTextView.text = register.description
        binding.tiempoTextView.text = register.tiempo

        binding.deleteRegisterButton.setOnClickListener {
            val deletedRows = db.RegisterDao().delete(register.number)

            registers = db.RegisterDao().list()

            notifyDataSetChanged()
            if (deletedRows == 0) {
                Toast.makeText(context, "No se ha eliminado ningún registro", Toast.LENGTH_LONG).show()
            }
        }
        binding.editRegisterButton.setOnClickListener{
            val intent = Intent(
                context, editRegisterActivity::class.java
            )
            intent.putExtra("number", register.number)
            context.startActivity(intent)
        }
    }
}

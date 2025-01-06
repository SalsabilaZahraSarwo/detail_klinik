package com.mobile.klinikapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.klinikapp.DetailDoctors
import com.mobile.klinikapp.R
import com.mobile.klinikapp.model.ModelListDoctors
import com.mobile.klinikapp.screen.HomeDoctorsActivity


class ListDoctorAdapter (
    val getDetailDoctors: HomeDoctorsActivity,
    val itemDoctorList: List<ModelListDoctors>
) : RecyclerView.Adapter<ListDoctorAdapter.MyViewHolder>() {
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgItemDoctor : ImageView = itemView.findViewById(R.id.imgDoctor)
        var txtNamaDoctor : TextView = itemView.findViewById(R.id.imgNama)
        var txtSpesDoctor : TextView = itemView.findViewById(R.id.txtSpes)
        var txtReviewDoctor : TextView = itemView.findViewById(R.id.txtReview)
        var txtRatingDoctor : TextView = itemView.findViewById(R.id.txtRating)
        val cardDoctor : CardView = itemView.findViewById(R.id.cardDoctor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_doctors, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorList[position]
        holder.txtNamaDoctor.text = currentItem.NamaDoctor
        holder.txtSpesDoctor.text = currentItem.Spesdoctors
        holder.txtReviewDoctor.text = currentItem.JumlahReview
        holder.txtRatingDoctor.text = currentItem.JumlahRating
        holder.imgItemDoctor.setImageResource(currentItem.ImgDoctor)

        holder.cardDoctor.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getDetailDoctors, DetailDoctors::class.java)
            //put Extra
            intent.putExtra("ImgDoctor", itemDoctorList[position].ImgDoctor)
            intent.putExtra("NamaDoctor",itemDoctorList[position].NamaDoctor)
            intent.putExtra("Spesdoctors",itemDoctorList[position].Spesdoctors)
            intent.putExtra("JumlahReview",itemDoctorList[position].JumlahReview)
            intent.putExtra("JumlahRating",itemDoctorList[position].JumlahRating)
            //intent.putExtra("judul",itemList[position].judul)
            // start pindah ke detail
            getDetailDoctors.startActivity(intent)

            Toast.makeText(getDetailDoctors,itemDoctorList[position].NamaDoctor, Toast.LENGTH_SHORT).show()

        }

    }

}
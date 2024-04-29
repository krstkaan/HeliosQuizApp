package com.sufaka.heliosquizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.sufaka.heliosquizapp.Adapter.LeaderAdapter
import com.sufaka.heliosquizapp.Domain.UserModel
import com.sufaka.heliosquizapp.R
import com.sufaka.heliosquizapp.databinding.ActivityLeaderBinding
import com.sufaka.heliosquizapp.databinding.ActivityMainBinding
import com.sufaka.heliosquizapp.databinding.ViewholderLeadersBinding

class LeaderActivity : AppCompatActivity() {
    lateinit var binding: ActivityLeaderBinding
    private  val leaderAdapter by lazy {  LeaderAdapter()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@LeaderActivity.window
        window.statusBarColor= ContextCompat.getColor(this@LeaderActivity, R.color.grey)

        binding.apply{
            scoreTop1Txt.text=loadData().get(0).score.toString()
            scoreTop2Txt.text=loadData().get(1).score.toString()
            scoreTop3Txt.text=loadData().get(2).score.toString()

            titleTop1Txt.text=loadData().get(0).name
            titleTop2Txt.text=loadData().get(1).name
            titleTop3Txt.text=loadData().get(2).name

            val drawableResourceId1:Int=binding.root.resources.getIdentifier(
                loadData().get(0).pic,
                "drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)
            val drawableResourceId2:Int=binding.root.resources.getIdentifier(
                loadData().get(1).pic,
                "drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic1)

            val drawableResourceId3:Int=binding.root.resources.getIdentifier(
                loadData().get(2).pic,
                "drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic1)

            bottomMenu.setItemSelected(R.id.Board)
            bottomMenu.setOnItemSelectedListener {
               if (
                     it==R.id.home){
                     val intent= Intent(this@LeaderActivity,MainActivity::class.java)
                     startActivity(intent)
                }

            }
            var list:MutableList<UserModel> = mutableListOf()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)
            leaderView.apply {
                layoutManager= LinearLayoutManager(this@LeaderActivity)
                adapter=leaderAdapter

            }


        }



    }

    //listeyi API servisinden alabiliriz. Bu bir örnek

    private  fun loadData():MutableList<UserModel>{
        val users:MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1,"Sophia", "person1",1,4850))
        users.add(UserModel(2,"Daniel", "person2",1,5380))
        users.add(UserModel(3,"Veli", "person3",1,1425))
        users.add(UserModel(4,"Mehmet", "person4",1,4562))
        users.add(UserModel(5,"Kaan", "person5",1,7832))
        users.add(UserModel(6,"Şüheda", "person6",1,4387))
        users.add(UserModel(7,"Fatma", "person7",1,3579))
        users.add(UserModel(8,"Suat", "person8",1,4526))
        users.add(UserModel(9,"Fatma", "person9",1,3579))
        return users



    }
}
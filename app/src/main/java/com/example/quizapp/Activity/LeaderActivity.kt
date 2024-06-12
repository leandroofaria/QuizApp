package com.example.quizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quizapp.Adapter.LeaderAdapter
import com.example.quizapp.Domain.UserModel
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityLeaderBinding

class LeaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.apply {
            val users = loadData()
            scoreTxt1.text = users[0].score.toString()
            scoreTxt2.text = users[1].score.toString()
            scoreTxt3.text = users[2].score.toString()
            titleTop1Txt.text = users[0].name
            titleTop2Txt.text = users[1].name
            titleTop3Txt.text = users[2].name

            // Load images using Glide
            Glide.with(root.context).load(R.drawable.pic1).into(pic1);
            Glide.with(root.context).load(R.drawable.pic2).into(pic2);
            Glide.with(root.context).load(R.drawable.pic3).into(pic3);

// Handle bottom menu item selection
            bottomMenu.setOnItemSelectedListener {
                when (it) {
                    R.id.home -> startActivity(Intent(this@LeaderActivity, MainActivity::class.java))
                }
            }

            // Load data for the RecyclerView
            val list: MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(0)
            list.removeAt(0)
            leaderAdapter.differ.submitList(list)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }
    }

    private fun loadData(): MutableList<UserModel> {
        val users: MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1, "Sophia", "person1", 4850))
        users.add(UserModel(2, "Daniel", "person2", 4560))
        users.add(UserModel(3, "James", "person3", 3873))
        users.add(UserModel(4, "John Smith", "person4", 3250))
        users.add(UserModel(5, "Emily Johnson", "person5", 3015))
        users.add(UserModel(6, "David Brown", "person6", 2970))
        users.add(UserModel(7, "Sarah Wilson", "person7", 2870))
        users.add(UserModel(8, "Michael Davis", "person8", 2670))
        users.add(UserModel(9, "Sarah Wilson", "person9", 2380))
        users.add(UserModel(10, "Sarah Wilson", "person9", 2380))
        return users
    }
}

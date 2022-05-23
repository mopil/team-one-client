package com.team1.teamone.board.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.team1.teamone.R
import com.team1.teamone.board.model.BoardApi
import com.team1.teamone.board.model.BoardResponse
import com.team1.teamone.board.model.WantedBoardRequest
import com.team1.teamone.databinding.ActivityUpdateWantedBoardBinding
import com.team1.teamone.home.view.HomeActivity
import com.team1.teamone.util.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_update_wanted_board.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UpdateWantedBoardActivity : AppCompatActivity() {
    private val api = RetrofitClient.create(BoardApi::class.java, RetrofitClient.getAuth())
    private lateinit var updateWantedBoardBinding: ActivityUpdateWantedBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_wanted_board)

        updateWantedBoardBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_wanted_board)
        updateWantedBoardBinding.btnUpdateWantedBoard.setOnClickListener{
            val title = et_updateWantedBoardTitle.text.toString()
            val memberCount = et_updateWantedBoardMemberCount.text.toString()
            val classTitle = et_updateWantedBoardClassTitle.text.toString()
            val classDate = et_updateWantedBoardClassDate.text.toString()
            val content = et_updateWantedBoardContent.text.toString()
            val boardId = intent.getLongExtra("updateBoardId", 0)
            val request = WantedBoardRequest(title, memberCount, classTitle,classDate, content)
            updateWantedBoard(request,boardId)
        }
    }

    private fun updateWantedBoard(request: WantedBoardRequest, boardId: Long) {
        api.putWantedBoard(request, boardId = boardId).enqueue(object : Callback<BoardResponse> {
            override fun onResponse(call: Call<BoardResponse>, response: Response<BoardResponse>) {
                Log.d("auth", RetrofitClient.getAuth())
                if (response.body()?.title.toString() == null) {
                    Log.d("log", "blank")
                    return
                } else {
                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("log", "success")
                }
            }

            override fun onFailure(call: Call<BoardResponse>, t: Throwable) {
                // 실패
                Log.d("log", "fail")
            }
        })
    }
}

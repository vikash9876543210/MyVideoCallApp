package com.example.myvideocallapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser
import java.util.Collections

class MainActivity : AppCompatActivity() {

    lateinit var currentUsernameTextView : TextView
    lateinit var targetUsernameInput : EditText
    lateinit var voiceCallBtn : ZegoSendCallInvitationButton
    lateinit var videoCallBtn : ZegoSendCallInvitationButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        currentUsernameTextView = findViewById(R.id.current_username_textView)
        targetUsernameInput = findViewById(R.id.target_username_input)
        voiceCallBtn = findViewById(R.id.voice_call_btn)
        videoCallBtn = findViewById(R.id.video_call_btn)

        currentUsernameTextView.text ="Hello "+ intent.getStringExtra("username")
     targetUsernameInput.addTextChangedListener {
         val targetUsername = targetUsernameInput.text.toString()
         setupVoiceCallBtn(targetUsername)
         setupVideoCallBtn(targetUsername)

     }
    }
fun setupVoiceCallBtn(Username: String){
    voiceCallBtn.setIsVideoCall(false)
    voiceCallBtn.resourceID="zego_uikit_call"
    voiceCallBtn.setInvitees(Collections.singletonList(ZegoUIKitUser(Username,Username)))
}
fun setupVideoCallBtn(Username: String){
    videoCallBtn.setIsVideoCall(true)
    videoCallBtn.resourceID="zego_uikit_call"
    videoCallBtn.setInvitees(Collections.singletonList(ZegoUIKitUser(Username ,Username)))
}
}
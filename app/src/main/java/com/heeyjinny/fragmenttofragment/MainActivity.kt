package com.heeyjinny.fragmenttofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.heeyjinny.fragmenttofragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰바인딩
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        setContentView(binding.root)

        //1
        //프래그먼트에서 프래그먼트로 값 전달하기
        //안드로이드 fragment버전 1.3.x부터 프래그먼트 간 통신을 위해
        //Fragment Listener의 기능 제공
        //프래그먼트에서 다른 프래그먼트로 직접 값을 전달하기 위해서는 부가적 설정 필요
        //build.gradle - dependencies{} - 프래그먼트 버전과 코틀린용 버전 추가 - Sync Now
        //프래그먼트 버전 : https://developer.android.com/jetpack/androidx/releases/fragment

        //1-1
        //수신받는 프래그먼트 생성
        //java 디렉터리 밑 패키지명 우클릭 - New - Fragment - Fragment(Blank)
        //ReceiverFragment 생성

    }
}
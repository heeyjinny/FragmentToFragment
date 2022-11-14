package com.heeyjinny.fragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener
import com.heeyjinny.fragmenttofragment.databinding.ActivityMainBinding
import com.heeyjinny.fragmenttofragment.databinding.FragmentReceiverBinding

//1
//onCreateView() 메서드 남기고 모두 삭제
//fragment_receiver.xml 수정
class ReceiverFragment : Fragment() {

    //2
    //뷰바인딩 선언
    //다른 메서드에서도 사용하기 위해 전역변수로 바인딩 선언
    //lateinit var 선언이유 : 프래그먼트는 바인딩 생성 시 onCreateView()메서드 안에서만
    //사용할 수 있는 파라미터가 필요하기 때문에 미리 lateinit으로 선언하고 onCreateView에서 초기화 함
    lateinit var binding: FragmentReceiverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //2-1
        //뷰바인딩
        //바인딩 프로퍼티에 바인딩을 생성하여 저장 후 binding.root반환
        //바인딩 프로퍼티에 바인딩을 저장했기 때문에 다른 메서드에서도 가져다 쓸 수 있음
        binding = FragmentReceiverBinding.inflate(inflater, container, false)
        return binding.root

    }//onCreateView...

    //3
    //onViewCreated()메서드 오버라이드
    //뷰가 생성되었을 때 실행할 코드 생성
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //3-1
        //setFragmentResultListener:프래그먼트의 결과를 수신하여 듣는 리스너 메서드 추가
        //파라미터 키 : request
        //값을 보내는 측 프래그먼트에서 request라는 키로 값을 보내면 이 리스너 안의 코드 실행됨
        setFragmentResultListener("request"){ key, bundle ->
            //3-2
            //리스너는 값을 수신 시 key, bundle 2개의 파라미터 사용 가능
            //실제 값은 bundle안에 Map형태(키)로 담겨 있음
            //그래서 bundle.getString("키") 로 값을 꺼낼 수 있음
            //스코프함수 let을 사용해 꺼낸 값이 있을 때만 화면의 textView에 값 넣어줌
            bundle.getString("valueKey")?.let {
                binding.textView.text = it
            }
        }

        //4
        //값을 전달하는 송신 프래그먼트 생성
        //java 디렉터리 밑 패키지명 우클릭 - New - Fragment - Fragment(Blank)
        //SenderFragment 생성

    }//onViewCreate...

}//Fragment...
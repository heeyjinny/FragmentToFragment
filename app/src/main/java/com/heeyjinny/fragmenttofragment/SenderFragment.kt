package com.heeyjinny.fragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.heeyjinny.fragmenttofragment.databinding.FragmentSenderBinding

//1
//onCreateView() 메서드 남기고 모두 삭제
//fragment_sender.xml 수정
class SenderFragment : Fragment() {

    //2
    //뷰바인딩 선언
    lateinit var binding: FragmentSenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //2-1
        //뷰바인딩
        binding = FragmentSenderBinding.inflate(inflater, container, false)
        return binding.root

    }//onCreateView

    //3
    //onViewCreated()메서드 오버라이드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //3-1
        //YSE 버튼이 클릭됐을 때 값을 전송하는 코드 작성
        //버튼에 클릭 리스너를 달고 리스너 안에서 수신하는 프래그먼트에서 getString()해서 받은
        //키 값 valueKey 키로 Yes값(보여질 텍스트뷰의 메세지 값)을 갖는 번들 생성하여 bundle변수에 저장
        //setFragmentResult()메서드에 키값 : request, 값 : bundle 을 파라미터로 입력하여
        //호출하면 수신 프래그먼트 ReceiverFragment로 값이 전달 됨
        binding.btnYes.setOnClickListener {
            //번들 만들기: bundleOf(키값, 값) 을 사용해 번들에 키값, 값 부여
            val bundle = bundleOf("valueKey" to "메시지: Yes")
            //결과를 전송하는 메서드 setFragmentResult()
            setFragmentResult("request",bundle)
        }

        //3-2
        //NO 버튼이 클릭됐을 때 값을 전송하는 코드 작성
        binding.btnNo.setOnClickListener {
            val bundle = bundleOf("valueKey" to "메시지: No")
            setFragmentResult("request",bundle)
        }

    }//onViewCreated...

    //FIN
    //activity_main.xml에 프래그먼트 화면 배치...

}//clss...
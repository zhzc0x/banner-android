package com.zhzc0x.banner.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.MarginPageTransformer
import com.zhzc0x.banner.demo.been.BannerInfo
import com.zhzc0x.banner.demo.databinding.FragmentBanner1Binding
import com.zhzc0x.banner.demo.transformer.FlipPageTransformer

class Banner1Fragment : Fragment() {

    private var _binding: FragmentBanner1Binding? = null
    private val binding get() = _binding!!

    private val dataList1 = listOf(
        BannerInfo(imageId = R.drawable.ic_test1, displayText = "我是图片test1"),
        BannerInfo(imageId = R.drawable.ic_test2, displayText = "我是图片test2"),
        BannerInfo(imageId = R.drawable.ic_test3, displayText = "我是图片test3"),
        BannerInfo(imageId = R.drawable.ic_test4, displayText = "我是图片test4")
    )
    private val dataList2 = listOf(
        BannerInfo(imageId = R.drawable.ic_test5, displayText = "我是图片test5"),
        BannerInfo(imageId = R.drawable.ic_test6, displayText = "我是图片test6"),
        BannerInfo(imageId = R.drawable.ic_test7, displayText = "我是图片test7"),
        BannerInfo(imageId = R.drawable.ic_test8, displayText = "我是图片test8")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBanner1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bannerView1.setData(
            dataList1,
            dataList1.map { it.displayText }) { itemBinding, data ->
            itemBinding.root.setImageResource(data.imageId)
            itemBinding.root.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "${data.displayText}: 被点击了！",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.bannerView1.setPageTransformer(MarginPageTransformer(48))

        binding.bannerView2.setData(
            dataList2,
            dataList2.map { it.displayText }) { itemBinding, data ->
            itemBinding.root.setImageResource(data.imageId)
            itemBinding.root.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "${data.displayText}: 被点击了！",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.bannerView2.setPageTransformer(FlipPageTransformer())
    }

    override fun onResume() {
        super.onResume()
//        binding.bannerView1.setAutoplay(true)
//        binding.bannerView2.setAutoplay(true)
    }

    override fun onPause() {
        super.onPause()
//        binding.bannerView1.setAutoplay(false)
//        binding.bannerView2.setAutoplay(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

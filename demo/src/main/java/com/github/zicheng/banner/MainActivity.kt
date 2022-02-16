package com.github.zicheng.banner

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.MarginPageTransformer
import com.github.zicheng.banner.been.BannerInfo
import com.github.zicheng.banner.databinding.ActivityMainBinding
import com.github.zicheng.banner.transformer.FlipPageTransformer
import com.github.zicheng.banner.transformer.ZoomPageTransformer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataList1 = listOf(
        BannerInfo(R.drawable.ic_test1,"我是图片test1"),
        BannerInfo(R.drawable.ic_test2,"我是图片test2"),
        BannerInfo(R.drawable.ic_test3,"我是图片test3"),
        BannerInfo(R.drawable.ic_test4,"我是图片test4")
    )
    private val dataList2 = listOf(
        BannerInfo(R.drawable.ic_test5,"我是图片test5"),
        BannerInfo(R.drawable.ic_test6,"我是图片test6"),
        BannerInfo(R.drawable.ic_test7,"我是图片test7"),
        BannerInfo(R.drawable.ic_test8,"我是图片test8")
    )
    private val dataList3 = listOf(
        BannerInfo(R.drawable.ic_test9,"我是图片test9"),
        BannerInfo(R.drawable.ic_test10,"我是图片test10"),
        BannerInfo(R.drawable.ic_test11,"我是图片test11"),
        BannerInfo(R.drawable.ic_test12,"我是图片test12")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bannerView1.setData(dataList1, dataList1.map { it.displayText }) { itemBinding, data ->
            itemBinding.root.setImageResource(data.imageId)
            itemBinding.root.scaleType = ImageView.ScaleType.CENTER_CROP
            itemBinding.root.setOnClickListener {
                Toast.makeText(this, "${data.displayText}: 被点击了！", Toast.LENGTH_SHORT).show()
            }
        }
        binding.bannerView1.setPageTransformer(MarginPageTransformer(48))

        binding.bannerView2.setData(dataList2, dataList2.map { it.displayText }) { itemBinding, data ->
            itemBinding.root.setImageResource(data.imageId)
            itemBinding.root.scaleType = ImageView.ScaleType.CENTER_CROP
            itemBinding.root.setOnClickListener {
                Toast.makeText(this, "${data.displayText}: 被点击了！", Toast.LENGTH_SHORT).show()
            }
        }
        binding.bannerView2.setPageTransformer(FlipPageTransformer())

        binding.bannerView3.setData(dataList3, dataList3.map { it.displayText }) { itemBinding, data ->
            itemBinding.root.setImageResource(data.imageId)
            itemBinding.root.scaleType = ImageView.ScaleType.CENTER_CROP
            itemBinding.root.setOnClickListener {
                Toast.makeText(this, "${data.displayText}: 被点击了！", Toast.LENGTH_SHORT).show()
            }
        }
        binding.bannerView3.setPageTransformer(ZoomPageTransformer())
    }

    override fun onResume() {
        super.onResume()
        binding.bannerView1.setAutoplay(true)
        binding.bannerView2.setAutoplay(true)
    }

    override fun onPause() {
        super.onPause()
        binding.bannerView1.setAutoplay(false)
        binding.bannerView2.setAutoplay(false)
    }

}
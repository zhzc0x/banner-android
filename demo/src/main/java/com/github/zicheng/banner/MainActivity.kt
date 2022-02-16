package com.github.zicheng.banner

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.MarginPageTransformer
import com.bumptech.glide.Glide
import com.github.zicheng.banner.been.BannerInfo
import com.github.zicheng.banner.databinding.ActivityMainBinding
import com.github.zicheng.banner.transformer.FlipPageTransformer
import com.github.zicheng.banner.transformer.ZoomPageTransformer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
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
    private val dataList3 = listOf(
        BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni7w0LiIWS5IckQE9TG0t1ftC89uRDmF.vB14O6fOc2FZphzCrtsdqH6GAsbLCpfsG5wov8Ozz7TyS45UyAVf6WI!/b&bo=ngL2AZ4C9gEFFzQ!&rf=viewer_4",
            displayText = "我是图片test9"),
        BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni83Es8qQnOlse*pbVd1M1HZfzu7HzvPNEeBfuKoXEYcKLv1MAEx0HFHwpgoyGSM8VNqmeINMJcNRtyDKTGIKK*0!/b&bo=LAIgAywCIAMFFzQ!&rf=viewer_4",
            displayText = "我是图片test10"),
        BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni0YAeqnprq8Bz*2LVpYQXcbygVY1K8xi7t8fOe6KdEK6V*hj6vlsz2CJbP5obbQKYYelaUfvptiyFC83Y9SAB84!/b&bo=CQI3AQkCNwEFFzQ!&rf=viewer_4",
            displayText = "我是图片test11"),
        BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni1tyipuKGV5Qo53j5*PS*1xryaKKaT1QibzItxvf4i*fiw8m9aV86cUhG0SGknOczhjV.TQ6DgyUkyXyhIHFEIY!/b&bo=ngLOAZ4CzgEFFzQ!&rf=viewer_4",
            displayText = "我是图片test12")
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
            Glide.with(this).load(data.imageUrl).into(itemBinding.root)
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
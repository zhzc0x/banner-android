package com.zhzc0x.banner.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.zhzc0x.banner.demo.been.BannerInfo
import com.zhzc0x.banner.demo.databinding.FragmentBanner2Binding
import com.zhzc0x.banner.demo.transformer.ZoomPageTransformer

class Banner2Fragment : Fragment() {

    private var _binding: FragmentBanner2Binding? = null
    private val binding get() = _binding!!

    private val dataList3 = listOf(
        BannerInfo(
            imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni7w0LiIWS5IckQE9TG0t1ftC89uRDmF.vB14O6fOc2FZphzCrtsdqH6GAsbLCpfsG5wov8Ozz7TyS45UyAVf6WI!/b&bo=ngL2AZ4C9gEFFzQ!&rf=viewer_4",
            displayText = "我是图片test9"
        ),
        BannerInfo(
            imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni83Es8qQnOlse*pbVd1M1HZfzu7HzvPNEeBfuKoXEYcKLv1MAEx0HFHwpgoyGSM8VNqmeINMJcNRtyDKTGIKK*0!/b&bo=LAIgAywCIAMFFzQ!&rf=viewer_4",
            displayText = "我是图片test10"
        ),
        BannerInfo(
            imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni0YAeqnprq8Bz*2LVpYQXcbygVY1K8xi7t8fOe6KdEK6V*hj6vlsz2CJbP5obbQKYYelaUfvptiyFC83Y9SAB84!/b&bo=CQI3AQkCNwEFFzQ!&rf=viewer_4",
            displayText = "我是图片test11"
        ),
        BannerInfo(
            imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni1tyipuKGV5Qo53j5*PS*1xryaKKaT1QibzItxvf4i*fiw8m9aV86cUhG0SGknOczhjV.TQ6DgyUkyXyhIHFEIY!/b&bo=ngLOAZ4CzgEFFzQ!&rf=viewer_4",
            displayText = "我是图片test12"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBanner2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bannerView3.setData(
            dataList3,
            dataList3.map { it.displayText }) { itemBinding, data ->
            Glide.with(this).load(data.imageUrl).into(itemBinding.root)
            itemBinding.root.setOnClickListener {
                Toast.makeText(requireContext(), "${data.displayText}: 被点击了！", Toast.LENGTH_SHORT).show()
            }
        }
        binding.bannerView3.setPageTransformer(ZoomPageTransformer())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

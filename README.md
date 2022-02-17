# BannerView-Android

Android Kotlin基于ViewPage2和ViewBinding的轻量级BannerView，功能全面，易定制扩展

# Demo效果图

<img src="https://github.com/zhangzicheng2019/BannerView-Android/blob/master/demo.gif" style="zoom:60%;" />

# 使用

- 添加gradle依赖（version=[![](https://jitpack.io/v/zicheng2019/banner-android.svg)](https://jitpack.io/#zicheng2019/banner-android)）

  ```groovy
  //Add it in your root build.gradle at the end of repositories:
  allprojects {
	repositories {
		...
  		maven { url 'https://jitpack.io' }
  	}
  }
  
  //Add it in your app build.gradle
  dependencies {
      implementation 'com.github.zicheng2019:banner-android:$version'
  }
  ```  

- 布局文件中声明（更多属性说明详见 #自定义属性说明）

  ```xml
  <com.github.zicheng.banner.BannerView
          android:id="@+id/bannerView1"
          android:layout_width="match_parent"
          android:layout_height="0dp"
          app:autoplay="true"
          app:loopPlay="true"
          app:displayTextBackground="#4D000000"
          app:displayTextColor="@color/white"
          app:displayTextGravity="left"
          app:displayTextSize="16sp"
          app:displayTextStyle="bold"
          app:indicatorGravity="bottom|right"
          app:isNumberIndicator="false"
          app:layout_constraintBottom_toTopOf="@+id/bannerView2"
          app:layout_constraintTop_toTopOf="parent" /> 
  ```

- 代码调用

  ```kotlin
  val dataList1 = listOf(
          BannerInfo(R.drawable.ic_test1,"我是图片test1"),
          BannerInfo(R.drawable.ic_test2,"我是图片test2"),
          BannerInfo(R.drawable.ic_test3,"我是图片test3"),
          BannerInfo(R.drawable.ic_test4,"我是图片test4")
      )
  //加载本地图片
  binding.bannerView1.setData(dataList1, dataList1.map { it.displayText }) { itemBinding, data ->
          itemBinding.root.setImageResource(data.imageId)
          itemBinding.root.setOnClickListener {
              Toast.makeText(this, "${data.displayText}: 被点击了！", Toast.LENGTH_SHORT).show()
          }
      }
  val dataList3 = listOf(
          BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni7w0LiIWS5IckQE9TG0t1ftC89uRDmF.vB14O6fOc2FZphzCrtsdqH6GAsbLCpfsG5wov8Ozz7TyS45UyAVf6WI!/b&bo=ngL2AZ4C9gEFFzQ!&rf=viewer_4",
              displayText = "我是图片test9"),
          BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni83Es8qQnOlse*pbVd1M1HZfzu7HzvPNEeBfuKoXEYcKLv1MAEx0HFHwpgoyGSM8VNqmeINMJcNRtyDKTGIKK*0!/b&bo=LAIgAywCIAMFFzQ!&rf=viewer_4",
              displayText = "我是图片test10"),
          BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni0YAeqnprq8Bz*2LVpYQXcbygVY1K8xi7t8fOe6KdEK6V*hj6vlsz2CJbP5obbQKYYelaUfvptiyFC83Y9SAB84!/b&bo=CQI3AQkCNwEFFzQ!&rf=viewer_4",
              displayText = "我是图片test11"),
          BannerInfo(imageUrl = "http://photocq.photo.store.qq.com/psc?/V14Rxniv2U0S9D/cXP39dXjFtymXNK2lOGni1tyipuKGV5Qo53j5*PS*1xryaKKaT1QibzItxvf4i*fiw8m9aV86cUhG0SGknOczhjV.TQ6DgyUkyXyhIHFEIY!/b&bo=ngLOAZ4CzgEFFzQ!&rf=viewer_4",
              displayText = "我是图片test12")
      )
  //加载网络图片
  binding.bannerView3.setData(dataList3, dataList3.map { it.displayText }) { itemBinding, data ->
              Glide.with(this).load(data.imageUrl).into(itemBinding.root)
              itemBinding.root.setOnClickListener {
                  Toast.makeText(this, "${data.displayText}: 被点击了！", Toast.LENGTH_SHORT).show()
              }
          }
  binding.bannerView1.setPageTransformer(MarginPageTransformer(48))
  //Activity可见时恢复自动播放
  override fun onResume() {
      super.onResume()
      binding.bannerView1.setAutoplay(true)
      binding.bannerView3.setAutoplay(true)
  }
  //Activity不可见时停止自动播放
  override fun onPause() {
      super.onPause()
      binding.bannerView1.setAutoplay(false)
      binding.bannerView3.setAutoplay(false)
  }
  ```

- API说明

  ```kotlin
  //设置Banner数据，可完全自定义Banner Item布局，默认使用ItemBannerImageBinding， 
  fun <VB: ViewBinding, M> setData(dataList: List<M>, displayTextList: List<String>? = null,
                                       itemBinding: KClass<VB>, bind: (VB, M) -> Unit)
  //设置自动播放开关
  fun setAutoplay(autoplay: Boolean)
  //设置跳转指定Item
  fun setCurrentItem(item: Int)}
  //设置是否允许用户滑动
  fun setAllowUserScrollable(scrollable: Boolean) }
  //设置ViewPage2的overScrollMode
  fun setPageOverScrollMode(overScrollMode: Int)
  //添加ViewPage2的OnPageChangeCallback
  fun addOnPageChangeCallback(@NonNull callback: ViewPager2.OnPageChangeCallback)
  //移除ViewPage2的OnPageChangeCallback
  fun removeOnPageChangeCallback(@NonNull callback: ViewPager2.OnPageChangeCallback)
  //设置自定义PageTransformer
  fun setPageTransformer(@Nullable transformer: ViewPager2.PageTransformer)
  ```

# 自定义属性说明
<!-- BannerView -->
    <declare-styleable name="BannerView">
        <!-- 是否显示指示器 -->
        <attr name="showIndicator" format="boolean" />
        <!-- 指示器背景 -->
        <attr name="indicatorBackground" format="reference|color" />
        <!-- 指示器 -->
        <attr name="indicatorDrawable" format="reference" />
        <!-- 指示器高度 -->
        <attr name="indicatorHeight" format="dimension" />
        <!-- 指示器间距 -->
        <attr name="indicatorSpacing" format="dimension" />
        <!-- 指示器的位置 -->
        <attr name="indicatorGravity" format="integer">
            <flag name="top" value="0x30" />
            <flag name="bottom" value="0x50" />
            <flag name="left" value="0x03" />
            <flag name="right" value="0x05" />
            <flag name="center_horizontal" value="0x01" />
        </attr>
        <!-- 指示器左内边距 -->
        <attr name="indicatorPaddingStart" format="dimension" />
        <!-- 指示器右内边距 -->
        <attr name="indicatorPaddingEnd" format="dimension" />
        <!-- 指示器左外边距 -->
        <attr name="indicatorMarginStart" format="dimension" />
        <!-- 指示器右外边距 -->
        <attr name="indicatorMarginEnd" format="dimension" />
        <!-- 指示器上外边距 -->
        <attr name="indicatorMarginTop" format="dimension" />
        <!-- 指示器下外边距 -->
        <attr name="indicatorMarginBottom" format="dimension" />

        <!-- 是否是数字指示器 -->
        <attr name="isNumberIndicator" format="boolean" />
        <!-- 数字指示器文字颜色 -->
        <attr name="numberIndicatorTextColor" format="reference|color" />
        <!-- 数字指示器文字大小 -->
        <attr name="numberIndicatorTextSize" format="dimension" />

        <!-- 是否开启自动轮播 -->
        <attr name="autoplay" format="boolean" />
        <!-- 是否开启循环播放 -->
        <attr name="loopPlay" format="boolean" />
        <!-- 自动轮播的时间间隔 -->
        <attr name="autoplayInterval" format="integer" />
        <!-- 页码切换过程的时间长度 -->
        <attr name="pageChangeDuration" format="integer" />
        <attr name="pageLimit" format="integer" />
        <!-- 页面区域距离 BannerView 顶部的距离 -->
        <attr name="pagePaddingTop" format="dimension" />
        <!-- 页面区域距离 BannerView 底部的距离 -->
        <attr name="pagePaddingBottom" format="dimension" />
        <!-- 页面区域距离 BannerView 左边的距离 -->
        <attr name="pagePaddingStart" format="dimension" />
        <!-- 页面区域距离 BannerView 右边 的距离 -->
        <attr name="pagePaddingEnd" format="dimension" />

        <!-- 是否显示文本 -->
        <attr name="showDisplayText" format="boolean" />
        <!-- 文本颜色 -->
        <attr name="displayTextColor" format="reference|color" />
        <!-- 文本大小 -->
        <attr name="displayTextSize" format="dimension" />
        <!-- 文本最多显示行数 -->
        <attr name="displayTextLines" format="integer" />
        <!-- 文本style Default text typeface style. -->
        <attr name="displayTextStyle"  format="integer">
            <flag name="normal" value="0" />
            <flag name="bold" value="1" />
            <flag name="italic" value="2" />
        </attr>
        <!-- 文本背景 -->
        <attr name="displayTextBackground" format="reference|color" />
        <!-- 文本背景高度 -->
        <attr name="displayTextBgHeight" format="dimension" />
        <attr name="displayTextMarginTop" format="dimension" />
        <attr name="displayTextMarginBottom" format="dimension" />
        <attr name="displayTextPaddingStart" format="dimension" />
        <attr name="displayTextPaddingEnd" format="dimension" />
        <!-- 文本相对于父布局的位置 -->
        <attr name="displayTextLayoutGravity" format="integer">
            <flag name="top" value="0x30" />
            <flag name="bottom" value="0x50" />
            <flag name="center_vertical" value="0x10" />
        </attr>
        <!-- 文本内部的位置 -->
        <attr name="displayTextGravity" format="integer">
            <flag name="left" value="0x03" />
            <flag name="right" value="0x05" />
            <flag name="center_horizontal" value="0x01" />
        </attr>
    </declare-styleable>
    
    

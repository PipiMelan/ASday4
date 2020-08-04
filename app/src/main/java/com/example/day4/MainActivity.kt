package com.example.day4

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins
import kotlin.math.cos

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // build interface with code
        //1.build a container -> load content(承载内容)  ( LinearLayout RelativeLayout ConstraintLayout)
        //MainActivity  -> .... -> Context

        /*
        * The size wrote in code is pixel by default
        * 100dp == 100px
        * This shows 100px in phone,too
        * But different phone has different Density(密度)(Screen Resolution - 分辨率)
        * Density: the number of pixels exists in 1dp
        *       Density =1   100dp = 100px
        *       Density =2   50dp*2 = 100px
        *       Density =5   20*5 = 100px
        * */
        //addLinearLayoutKotlin()

        /*
                RelativeLayout
        * Manually create a RelativeLayout container to make a page layout
        * Each container has its own 'LayoutParams'
        * */
        //addRelativeLayout()

        /*
        * Manually create ConstraintLayout container to make a page layout
        * */

        /*
        * Conclusion：
        *  Use the XML to configurate the interface whenever possible
        * */
        addConstraintLayout()
    }

    private fun addConstraintLayout(){
        val constraintLayout = ConstraintLayout(this).apply {
            id = R.id.mContainer
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
            background = getDrawable(R.color.colorPrimaryDark)
            setContentView(this)
        }
        ImageView(this).apply {
            id = R.id.mImage
            layoutParams = ConstraintLayout.LayoutParams(dp2px(120), dp2px(90)).apply {
                //Align the left side with the parent container
                leftToLeft = R.id.mContainer
                //Align the top with the parent container
                topToTop = R.id.mContainer

                setMargins(dp2px(10),dp2px(10),0,0)
            }
            setImageResource(R.drawable.ic_launcher_foreground)
            scaleType = ImageView.ScaleType.CENTER_CROP
            constraintLayout.addView(this)
        }

        TextView(this).apply {
            id = R.id.mTitle

            layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
            ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            ).apply {
                leftToRight = R.id.mImage
                rightToRight = R.id.mContainer
                topToTop = R.id.mImage
                bottomToBottom = R.id.mImage

                setMargins(dp2px(10),0,dp2px(10),0)
            }
            text = "“功以才成，业由才广。世上一切事物中 人 是 最 可 宝 贵 的，一 切 创 新 成 果 都 是 人 做 出来的。硬实力、软实力，归根到底要靠人才实力。”"
            textSize = 15f
            setTextColor(getColor(R.color.colorwhite))
            constraintLayout.addView( this)
        }

        // Main contents
        TextView(this).apply {
            id = R.id.mTitle

            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            ).apply {
                leftToLeft = R.id.mImage
                rightToRight = R.id.mContainer
                topToBottom = R.id.mImage
                bottomToBottom = R.id.mContainer

                setMargins(0,dp2px(10),0,dp2px(10))
            }
            text = " \"   6月11日，台湾中山科学院深夜在台东及九鹏基地进行导弹试射，外界分析种类极有可能是天弓三型增程型导弹拦截测试。6月12日，\" +\n" +
                    "                    \"民进党立委王定宇在脸书表示，中科院昨晚发射的导弹正是有“台版萨德”称号的“天弓”3型增程型导弹，以天弓二型导弹改装为靶弹，发射“天弓”3型增程型导弹进行作战测试。\"\n" +
                    "           "
            textSize = 15f
            setTextColor(getColor(R.color.colorwhite))
            constraintLayout.addView( this)
        }
    }

    private fun addRelativeLayout(){
        //Build relative container
        val relativeLayout = RelativeLayout(this).apply {
            // width and height
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
            )

            // Add the ID value to the main container
            id = R.id.mContainer

            //set the background color
            background = getDrawable(R.color.colorPrimary)
            // Add this view to the corresponding interface in Activity
            setContentView(this)
        }

        // Image
        ImageView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(dp2px(120),dp2px(90)).apply {
                setMargins(dp2px(10),dp2px(10),0,0)
            }

            // Add id  to control
            id = R.id.mImage

            setImageResource(R.drawable.ic_launcher_foreground)
            scaleType = ImageView.ScaleType.CENTER_CROP
            relativeLayout.addView(this)
        }

        //Add title
        TextView(this).apply {
            id = R.id.mTitle

                layoutParams = RelativeLayout.LayoutParams(0,0).apply {
                // Set the relative  relationship to other controls
                // The relative relationship to image
                addRule(RelativeLayout.RIGHT_OF,R.id.mImage)
                // Align to the right of the parent container
                addRule(RelativeLayout.ALIGN_PARENT_END,R.id.mContainer)
                // Align to the TOP and BOTTOM of the Image
                addRule(RelativeLayout.ALIGN_TOP,R.id.mImage)
                addRule(RelativeLayout.ALIGN_BOTTOM,R.id.mImage)

                marginStart = dp2px(10)
                marginEnd = dp2px(10)
            }
            text = " Wait For You a a a a a qq"
            textSize = 20f
            setTextColor(getColor(R.color.colorwhite))
            relativeLayout.addView(this)

        }

        //Add  the main contents
        TextView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                0).apply {
                // Set the relative  relationship to other controls
                // The relative relationship to image
                addRule(RelativeLayout.BELOW,R.id.mImage)
                //Align to the bottom of the parent container
                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,R.id.mContainer)
                //Align to the left of the Image
                addRule(RelativeLayout.ALIGN_START,R.id.mImage)
                //Align to the right of the title
                addRule(RelativeLayout.ALIGN_END,R.id.mTitle)
                //background = getDrawable(R.color.colorwhite)
                //Distance between the contents and title connected with title
                setMargins(0,dp2px(10),0,0)
                //
                marginStart = dp2px(10)
                marginEnd = dp2px(10)
            }
            text = "   6月11日，台湾中山科学院深夜在台东及九鹏基地进行导弹试射，外界分析种类极有可能是天弓三型增程型导弹拦截测试。6月12日，" +
                    "民进党立委王定宇在脸书表示，中科院昨晚发射的导弹正是有“台版萨德”称号的“天弓”3型增程型导弹，以天弓二型导弹改装为靶弹，发射“天弓”3型增程型导弹进行作战测试。"
            textSize = 20f
            setTextColor(getColor(R.color.colorwhite))
            relativeLayout.addView(this)

        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addLinearLayoutKotlin(){
        //1.build a container  -> LinearLayout
        val container = LinearLayout(this).apply {
            //2. Set the width and height
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)

            //3.set the direction and background color
            orientation = LinearLayout.VERTICAL
            background = getDrawable(R.color.colorPrimary)
        }.also { setContentView(it) }


        //Build the first child control as a Horizontal LinearLayout
        LinearLayout(this).apply {
            //2. Set the width and height
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,dp2px(100))

            //3.set the direction and background color
            orientation = LinearLayout.HORIZONTAL
            background = getDrawable(R.color.colorPrimaryDark)
            //Add this child container to main container
            container.addView(this)
        }.apply{
            // Image
            ImageView(this@MainActivity).apply {
                // The width and height
                layoutParams = LinearLayout.LayoutParams(
                        dp2px(120),
                        LinearLayout.LayoutParams.MATCH_PARENT
                )
                // set the image resource
                setImageResource(R.drawable.ic_launcher_background)
                // set the fill pattern(填充模式)
                scaleType = ImageView.ScaleType.CENTER_CROP
                //add this to container
                addView(this)
            }
            //add the title
            TextView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.MATCH_PARENT
                ).apply {
                    weight = 1f
                    setMargins(dp2px(10),dp2px(10),dp2px(10),dp2px(10))
                }
                text = " Wait For You a a a a a qq"
                textSize = 15f
                setTextColor(getColor(R.color.colorwhite))
                addView(this)
            }
        }

        // Build the second control -> TextView
        TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            ).apply { setMargins(dp2px(10),dp2px(10),dp2px(10),dp2px(10)) }
            text = " 山东舰的入役，使得中国海军进入了双航母时代，但我们明白，距离真正的海上强国，还有一段距离，尤其是与有着10余艘核动力航母的美国海军对比，差距依然明显。但正视差距不代表我们会一直软弱，霸权主义专挑软柿子捏，所以该强硬的时候还是得强硬！央视解密了一段往事，国人这才了解到2016年，数十枚东风导弹曾锁定美军双航母。"
            textSize = 15f
            setTextColor(getColor(R.color.colorwhite))
        }.also { container.addView(it) }
    }


    //100 * Density = px
    fun dp2px(dp:Int): Int{
        return (resources.displayMetrics.density * dp).toInt()
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addLinearLayoutJava(){
        //1.Bulid a container-> LinearLayout
        val linearLayout = LinearLayout(this)

        //2. Set the width and height for the container
        linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)

        //3. Set the layout direction
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.background = getDrawable(R.color.colorAccent)

        //4.Add a new container to Activity
        setContentView(linearLayout)
    }
}
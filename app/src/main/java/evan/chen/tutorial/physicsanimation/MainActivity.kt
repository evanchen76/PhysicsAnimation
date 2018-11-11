package evan.chen.tutorial.physicsanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.view.View.TRANSLATION_X
import kotlinx.android.synthetic.main.activity_main.*
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fling.setOnClickListener {
            val flingAnimation = FlingAnimation(view, DynamicAnimation.X)
            //設定初始速度
            flingAnimation.setStartVelocity(1500f)
            //friction 摩擦力
            flingAnimation.friction = 0.5f
            //開始動畫
            flingAnimation.start()
        }

        spring.setOnClickListener {
            //彈簧動畫
            val springAnimation = SpringAnimation(view, DynamicAnimation.X)

            //設定初始速度
            springAnimation.setStartVelocity(3000f)

            val springForce = SpringForce()
            //設定彈性阻尼，值越大，動畫越快停止
            springForce.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            //設定彈性，彈性越大，動得越快
            springForce.stiffness = SpringForce.STIFFNESS_MEDIUM
            //最後停止時的位置
            springForce.finalPosition = view.x

            springAnimation.spring = springForce
            //開始動畫
            springAnimation.start()
        }
    }
}

package com.theme.demo.app

import android.app.Activity
import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.theme.demo.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val prefs by lazy {
        SharedPreferencesHelper(this@MainActivity)
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val currentTheme = prefs.getInt("theme").toThemes()

        when (currentTheme) {
            Themes.Blue -> {
                setTheme(R.style.Theme_Blue)
            }

            Themes.BlueNight -> {
                setTheme(R.style.Theme_Blue_Dark)
            }

            Themes.Green -> {
                setTheme(R.style.Theme_Green)
            }

            Themes.GreenNight -> {
                setTheme(R.style.Theme_Green_Dark)
            }
        }

        setContentView(binding.root)

        binding.apply {
            this.currentTheme.text = when (currentTheme) {
                Themes.Blue -> {
                    "Theme: Blue"
                }

                Themes.BlueNight -> {
                    "Theme: Blue Night"
                }

                Themes.Green -> {
                    "Theme: Green"
                }

                Themes.GreenNight -> {
                    "Theme: Green Night"
                }
            }

            btnChangeTheme.setOnClickListener {
                when (currentTheme) {
                    Themes.Blue -> {
                        prefs.saveInt("theme", Themes.BlueNight.ordinal)
                        recreate()
                    }

                    Themes.BlueNight -> {
                        prefs.saveInt("theme", Themes.Green.ordinal)
                        recreate()
                    }

                    Themes.Green -> {
                        prefs.saveInt("theme", Themes.GreenNight.ordinal)
                        recreate()
                    }

                    Themes.GreenNight -> {
                        prefs.saveInt("theme", Themes.Blue.ordinal)
                        recreate()
                    }
                }
            }

            svgIcon.setSvgIconColor(
                R.drawable.ic_android_black_24dp,
                getThemeColor(R.attr.colorIcon)
            )

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

    fun ImageView.setSvgIconColor(drawableRes: Int, colorRes: Int) {
        val drawable = AppCompatResources.getDrawable(context, drawableRes)
        val color = ContextCompat.getColor(context, colorRes)
        drawable?.mutate()?.setTint(color)
        setImageDrawable(drawable)
    }

    fun Activity.getThemeColor(attributeResId: Int): Int {
        val typedValue = TypedValue()
        val theme = this.theme
        theme.resolveAttribute(attributeResId, typedValue, true)
        return typedValue.resourceId
    }

    enum class Themes {
        Blue,
        BlueNight,
        Green,
        GreenNight
    }
}

private fun Int.toThemes(): MainActivity.Themes {
    return when (this) {
        0 -> MainActivity.Themes.Blue

        1 -> MainActivity.Themes.BlueNight

        2 -> MainActivity.Themes.Green

        else -> MainActivity.Themes.GreenNight
    }
}

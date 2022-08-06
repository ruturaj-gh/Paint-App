package com.example.paintapp

import android.graphics.Color
import android.graphics.Paint

import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.paintapp.PaintView.Companion.colorList
import com.example.paintapp.PaintView.Companion.currentBrush
import com.example.paintapp.PaintView.Companion.pathList
import com.example.paintapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    companion object{
        var path=Path()
        var paintbrush= Paint()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding= com.example.paintapp.databinding.ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Redbutton.setOnClickListener{
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            paintbrush.color = Color.RED
            currentcolor(paintbrush.color)

        }

        binding.bluebutton.setOnClickListener{
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            paintbrush.color = Color.BLUE
            currentcolor(paintbrush.color)


        }
        binding.yellowbutton.setOnClickListener{
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            paintbrush.color=Color.YELLOW
            currentcolor(paintbrush.color)
        }

        binding.greenbutton.setOnClickListener{
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            paintbrush.color = Color.GREEN
            currentcolor(paintbrush.color)


        }
        binding.whitebutton.setOnClickListener{
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()


        }



    }
    private fun currentcolor(color:Int)
    {
        currentBrush=color
        path=Path()
    }
}
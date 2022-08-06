package com.example.paintapp
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.graphics.Paint
import android.view.MotionEvent
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintbrush
import com.example.paintapp.MainActivity.Companion.path

class PaintView : View{
    //Height and width of canvas with respect to parent layout
    var params:ViewGroup.LayoutParams?=null

    companion object
    {
        var pathList=ArrayList<Path>()
        var colorList=ArrayList<Int>()
        var currentBrush= Color.BLACK


    }

    constructor(context: Context) : this(context, null)
    {
        init()

    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    {
        init()

    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    {
        init()

    }

    private fun init()
    {
        //for making texture smooth
        paintbrush.isAntiAlias=true
        paintbrush.color= currentBrush
        paintbrush.style=Paint.Style.STROKE
        //end of the path
        paintbrush.strokeJoin=Paint.Join.ROUND
        paintbrush.strokeWidth=8f

        params=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

    }

    //moment when user will draw on screen
    override fun onTouchEvent(event: MotionEvent): Boolean
    {
        var x=event.x
        var y=event.y

        //when certain event occur
        when(event.action)
        {
            MotionEvent.ACTION_DOWN ->
            {
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(x,y)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else->return false
        }
        postInvalidate()
        return false


    }
    //drawing the arraylist path

    override fun onDraw(canvas: Canvas?)
    {
        for (i in pathList.indices)
        {
            paintbrush.setColor(colorList[i])
            canvas?.drawPath(pathList[i], paintbrush)
            //informing non ui threads to informing about changes that has done
            invalidate()
        }




    }

}

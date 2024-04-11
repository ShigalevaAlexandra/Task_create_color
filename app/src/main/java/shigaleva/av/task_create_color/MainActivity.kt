package shigaleva.av.task_create_color

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var rParametr = 0
    var gParametr = 0
    var bParametr = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)

        //открытие диалогового окна по нажатию кнопки на главном экране
        btnStart.setOnClickListener {
            dialogWindowActivity()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //функция жизненного цикла диалогового окна
    @SuppressLint("InflateParams")
    private fun dialogWindowActivity() {
        val dialogWindowLayout = layoutInflater.inflate(R.layout.dialog_window, null)
        val dialogWindow = Dialog(this)

        dialogWindow.setContentView(dialogWindowLayout)
        dialogWindow.setCancelable(true)
        dialogWindow.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogWindow.show()

        //переменные для передачи параметров, указанных пользователем
        val seekBarRedParametr = dialogWindowLayout.findViewById<SeekBar>(R.id.seekbar_red)
        val seekBarGreenParametr = dialogWindowLayout.findViewById<SeekBar>(R.id.seekbar_green)
        val seekBarBlueParametr = dialogWindowLayout.findViewById<SeekBar>(R.id.seekbar_blue)

        val txtViewRedParametr = dialogWindowLayout.findViewById<TextView>(R.id.txtView_red)
        val txtViewGreenParametr = dialogWindowLayout.findViewById<TextView>(R.id.txtView_green)
        val txtViewBlueParametr = dialogWindowLayout.findViewById<TextView>(R.id.txtView_blue)

        val viewNewColor = dialogWindowLayout.findViewById<View>(R.id.View_new_color)

        //изменение значений выставленных параметров
        //красный бегунок
        seekBarRedParametr.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtViewRedParametr.text = "RED = $progress"
                rParametr = progress
                viewNewColor.setBackgroundColor(
                    Color.rgb(
                        rParametr,
                        gParametr,
                        bParametr
                    )
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //зеленый бегунок
        seekBarGreenParametr.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtViewGreenParametr.text = "GREEN = $progress"
                gParametr = progress
                viewNewColor.setBackgroundColor(
                    Color.rgb(
                        rParametr,
                        gParametr,
                        bParametr
                    )
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //голубой бегунок
        seekBarBlueParametr.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtViewBlueParametr.text = "BLUE = $progress"
                bParametr = progress
                viewNewColor.setBackgroundColor(
                    Color.rgb(
                        rParametr,
                        gParametr,
                        bParametr
                    )
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //закрытие диалогового окна по нажатию кнопки "сохранить цвет"
        val btnBack = dialogWindowLayout.findViewById<Button>(R.id.btn_save)

        btnBack.setOnClickListener {
            dialogWindow.dismiss()

            //вывод последнего сохрненного цвета на главный экран
            val txtViewSaveLastColor = findViewById<TextView>(R.id.lbl_last_save_color)
            val viewSaveLastColor = findViewById<View>(R.id.View_last_save_color)

            txtViewSaveLastColor.visibility = View.VISIBLE
            viewSaveLastColor.visibility = View.VISIBLE
            viewSaveLastColor.setBackgroundColor(
                Color.rgb(
                    rParametr,
                    gParametr,
                    bParametr
                )
            )
        }
    }
}
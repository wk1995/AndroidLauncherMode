package cn.wk1995.android.launcher.mode

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.entertech.base.BaseActivity
import cn.wk1995.android.launcher.mode.singleInstance.SingleInstance1Activity
import cn.wk1995.android.launcher.mode.singleInstancePerTask.SingleInstancePerTask1Activity
import cn.wk1995.android.launcher.mode.singleTask.SingleTask1Activity
import cn.wk1995.android.launcher.mode.singleTop.SingleTop1Activity
import cn.wk1995.android.launcher.mode.standard.Standard1Activity


open class MainActivity : BaseActivity() {

    private var tvActivityName: TextView? = null
    private var rvStandard: RecyclerView? = null
    private var rvSingleTop: RecyclerView? = null
    private var rvSingleTask: RecyclerView? = null
    private var rvSingleInstancePerTask: RecyclerView? = null
    private var rvSingleInstance: RecyclerView? = null

    private val standardAdapter by lazy {
        ActivityListAdapter(
            listOf(
                Standard1Activity::class.java,
            )
        )
    }

    private val singleTopAdapter by lazy {
        ActivityListAdapter(
            listOf(
                SingleTop1Activity::class.java,
            )
        )
    }


    private val singleTaskAdapter by lazy {
        ActivityListAdapter(
            listOf(
                SingleTask1Activity::class.java,
            )
        )
    }


    private val singleInstancePerTaskAdapter by lazy {
        ActivityListAdapter(
            listOf(
                SingleInstancePerTask1Activity::class.java,
            )
        )
    }


    private val singleInstanceAdapter by lazy {
        ActivityListAdapter(
            listOf(
                SingleInstance1Activity::class.java,
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        tvActivityName = findViewById(R.id.tvActivityName)
        rvStandard = findViewById(R.id.rvStandard)
        rvSingleTop = findViewById(R.id.rvSingleTop)
        rvSingleTask = findViewById(R.id.rvSingleTask)
        rvSingleInstancePerTask = findViewById(R.id.rvSingleInstancePerTask)
        rvSingleInstance = findViewById(R.id.rvSingleInstance)

        rvStandard?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvSingleTop?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvSingleTask?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvSingleInstancePerTask?.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvSingleInstance?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        rvStandard?.adapter = standardAdapter
        rvSingleTop?.adapter = singleTopAdapter
        rvSingleTask?.adapter = singleTaskAdapter
        rvSingleInstancePerTask?.adapter = singleInstancePerTaskAdapter
        rvSingleInstance?.adapter = singleInstanceAdapter
        tvActivityName?.text = this.toString()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
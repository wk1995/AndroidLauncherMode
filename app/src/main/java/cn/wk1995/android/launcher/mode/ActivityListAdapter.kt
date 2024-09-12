package cn.wk1995.android.launcher.mode

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityListAdapter<T : Activity>(private val data: List<Class<T>>) :
    RecyclerView.Adapter<ActivityListAdapter.ActivityListVH>() {

    class ActivityListVH(rootView: View) : RecyclerView.ViewHolder(rootView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityListVH {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_name_layout, parent, false)
        return ActivityListVH(layout)
    }

    override fun onBindViewHolder(holder: ActivityListVH, position: Int) {
        val item = data[position]
        (holder.itemView as? TextView)?.apply {
            text = item.simpleName
            setOnClickListener {
                context.startActivity(Intent(context, item))
            }
        }
    }

    override fun getItemCount() = data.size
}
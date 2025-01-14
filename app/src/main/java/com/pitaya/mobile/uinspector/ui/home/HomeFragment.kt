package com.pitaya.mobile.uinspector.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.pitaya.mobile.uinspector.demo.R
import com.pitaya.mobile.uinspector.demo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = mutableListOf<HomeItem>()
        val adapter = HomeAdapter(data)

        binding.homeRecyclerView.adapter = adapter
        homeViewModel.data.observe(viewLifecycleOwner, Observer {
            data.clear()
            data.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    private inner class HomeAdapter(val data: List<HomeItem>) : RecyclerView.Adapter<HomeVH>() {

        @SuppressLint("InflateParams")
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_recycler_view, parent, false
            )
        )

        override fun getItemCount(): Int = data.size

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: HomeVH, position: Int) {
            holder.textView.text = "${position + 1}: ${data[position].title}"
            holder.itemView.setOnClickListener { view ->
                data[position].action(requireActivity(), view)
            }
        }
    }

    private class HomeVH(itemView: View, val textView: TextView = itemView.findViewById(R.id.recycler_text)) :
        RecyclerView.ViewHolder(itemView)
}
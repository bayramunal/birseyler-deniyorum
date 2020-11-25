package com.hacib.duygusalbiruygulama.main.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hacib.duygusalbiruygulama.R
import com.hacib.duygusalbiruygulama.main.list.adapter.ListFragmentAdapter

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var factory: ListViewModelFactory
    private lateinit var adapter: ListFragmentAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        factory = ListViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)

        initRecyclerView(viewModel.getModelList().value!!, view)

        return view
    }

    private fun initRecyclerView(list: List<Model>, view: View) {
        adapter = ListFragmentAdapter(list)
        recyclerView = view.findViewById(R.id.recyclerList)
        recyclerView.layoutManager = getLayoutManager()
        recyclerView.adapter = adapter
    }

    private fun getLayoutManager() = LinearLayoutManager(
        activity,
        LinearLayoutManager.VERTICAL,
        false
    )
}
package com.example.androidhomework.ui.contentnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.databinding.FragmentContentNewsBinding
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.Koin

class ContentNewsFragment : Fragment() {

    private lateinit var binding: FragmentContentNewsBinding
    private lateinit var newsAdapter: ContentNewsAdapter
    var isScrolling = false
    private val viewModel by lifecycleScope.viewModel<ContentNewsViewModel>(this)

    private lateinit var scrollListener: RecyclerView.OnScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getContentNews()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentContentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        observeLiveData()
    }

    private fun setupListeners() {
        scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount

                val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
                val isNotAtBeginning = firstVisibleItemPosition >= 0
                val shouldPaginate = isAtLastItem && isNotAtBeginning && isScrolling
                if (shouldPaginate) {
                    isScrolling = false
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }
        }
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
//            navigateFragment(ContentNewsFragment)
            Toast.makeText(requireContext(), "${it.sectionName} is clicked", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun observeLiveData() {
        viewModel.resultsLiveData.observe(viewLifecycleOwner) {
            it?.let { result ->
                newsAdapter.updateData(result)
            }
        }
    }

    private fun setupRecyclerView() {
        newsAdapter = ContentNewsAdapter()
        binding.contentNewsRecyclerView.apply {
            adapter = newsAdapter
            addOnScrollListener(this@ContentNewsFragment.scrollListener)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentNewsFragment()
    }

}
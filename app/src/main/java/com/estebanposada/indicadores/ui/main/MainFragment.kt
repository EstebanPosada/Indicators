package com.estebanposada.indicadores.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.estebanposada.indicadores.App
import com.estebanposada.indicadores.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val indicatorAdapter = IndicatorsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchIndicators()

        binding.rvIndicators.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = indicatorAdapter
            addItemDecoration(
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            )
        }

        binding.sort.setOnClickListener {
            indicatorAdapter.sort()
        }

        indicatorAdapter.onItemClicked = {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailFragment(it)
            )
        }

        binding.search.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.filterIndicators(v.text.toString())
            }
            true
        }

        viewModel.indicators.observe(viewLifecycleOwner, { indicators ->
            indicatorAdapter.setData(indicators)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }
}
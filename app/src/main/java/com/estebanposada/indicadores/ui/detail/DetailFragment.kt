package com.estebanposada.indicadores.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.estebanposada.indicadores.App
import com.estebanposada.indicadores.databinding.FragmentDetailBinding
import com.estebanposada.indicadores.ui.main.MainViewModel
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainViewModel

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val serieAdapter = SeriesAdapter()

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val code = args.code

        binding.rvSeries.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = serieAdapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
        viewModel.findIndicator(code)
        viewModel.detail.observe(viewLifecycleOwner, { indicator ->
            binding.code.text = indicator.code
            binding.name.text = indicator.name
            serieAdapter.setData(indicator.series)
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
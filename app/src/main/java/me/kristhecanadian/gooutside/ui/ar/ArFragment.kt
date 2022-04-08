package me.kristhecanadian.gooutside.ui.ar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.kristhecanadian.gooutside.databinding.FragmentArBinding

class ArFragment : Fragment() {

    private var _binding: FragmentArBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this)[ArViewModel::class.java]

        _binding = FragmentArBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }
}
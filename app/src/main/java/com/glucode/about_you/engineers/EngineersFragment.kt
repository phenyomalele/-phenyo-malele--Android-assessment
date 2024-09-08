package com.glucode.about_you.engineers

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.glucode.about_you.R
import com.glucode.about_you.databinding.FragmentEngineersBinding
import com.glucode.about_you.engineers.models.Engineer
import com.glucode.about_you.mockdata.MockData

class EngineersFragment : Fragment() {
    private lateinit var binding: FragmentEngineersBinding
    //created an instance of the adapter
private lateinit var engineerAdapter: EngineersRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEngineersBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        setUpEngineersList(MockData.engineers)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_engineers, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.action_years) {
//            return true
//        }
//        return super.onOptionsItemSelected(item)

        //referencing and assigning them to the action
        when(item.itemId) {
            R.id.action_years -> engineerAdapter.sortInAscendingByYears()
            R.id.action_bugs -> engineerAdapter.sortInAscendingByBugs()
            R.id.action_coffees -> engineerAdapter.sortInAscendingByCoffee()

            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun setUpEngineersList(engineers: List<Engineer>) {
        engineerAdapter = EngineersRecyclerViewAdapter(engineers) {
            goToAbout(it)
        }
        //initiazling the lateint Adapter instance
        binding.list.adapter = engineerAdapter

        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.list.addItemDecoration(dividerItemDecoration)
    }

    private fun goToAbout(engineer: Engineer) {
        val bundle = Bundle().apply {

            //first fragment sends a key to the next(sender). keys must match with recipient
            putString("name", engineer.name)

            putString("role", engineer.role)
        }
        findNavController().navigate(R.id.action_engineersFragment_to_aboutFragment, bundle)
    }
}
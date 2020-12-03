package com.cloudinteractive.viewbindingtest

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cloudinteractive.viewbindingtest.databinding.FragmentMemberBinding

class MemberFragment : Fragment(R.layout.fragment_member) {

    companion object {
        private const val BUNDLE_MEMBER = "BUNDLE_MEMBER"
        fun newInstance(member: String) = MemberFragment()
            .apply {
                val bundle = Bundle().apply {
                    putString(BUNDLE_MEMBER, member)
                }.also { arguments = it }
            }
    }

    private val binding by viewBinding(FragmentMemberBinding::bind)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvMember.text = arguments?.getString(BUNDLE_MEMBER) ?: throw IllegalArgumentException("null member !")
    }
}
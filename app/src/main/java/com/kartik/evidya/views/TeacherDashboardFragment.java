package com.kartik.evidya.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.chatapp.R;
import com.example.chatapp.adapter.ListItemAdapter;
import com.example.chatapp.databinding.FragmentTeacherDashboardBinding;
import com.example.chatapp.handler.TeacherDashboardClickHandler;
import com.example.chatapp.viewModel.TeacherDashboardClickViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherDashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherDashboardFragment extends Fragment {

    FragmentTeacherDashboardBinding binding;
    TeacherDashboardClickHandler myHandler;
    FragmentManager fragmentManager;
    TeacherDashboardClickViewModel teacherDashboardClickViewModel;
    ListItemAdapter mAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TeacherDashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherDashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherDashboardFragment newInstance(String param1, String param2) {
        TeacherDashboardFragment fragment = new TeacherDashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_teacher_dashboard, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_teacher_dashboard, container, false);

        View view = binding.getRoot();

        teacherDashboardClickViewModel = new ViewModelProvider(this).get(TeacherDashboardClickViewModel.class);
        binding.setTeacherDashboardViewModel(teacherDashboardClickViewModel);
        binding.executePendingBindings();

        myHandler = new TeacherDashboardClickHandler(getActivity(), binding, teacherDashboardClickViewModel,getArguments());
        myHandler.loader();
        binding.setHandler(myHandler);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.seach_name);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Type here to search");
        searchView.setMaxWidth(android.R.attr.width);

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (mAdapter != null) {
                    mAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });;
        super.onCreateOptionsMenu(menu, inflater);
    }


}
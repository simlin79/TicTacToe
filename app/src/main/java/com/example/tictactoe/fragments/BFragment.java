package com.example.tictactoe.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.tictactoe.R;
import com.example.tictactoe.databinding.FragmentBBinding;


public class BFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentBBinding binding = FragmentBBinding.inflate(inflater, container, false);

        String pergale = getResources().getString(R.string.victory);
        String lygiosios = getResources().getString(R.string.draw);

        BFragmentArgs args = BFragmentArgs.fromBundle(requireArguments());
        binding.text.setText(args.getName());

        int[] mas = args.getMasyvas();

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) binding.vaizdas.setText(binding.vaizdas.getText().toString() + "    ");
            else if (mas[i] == 1)
                binding.vaizdas.setText(binding.vaizdas.getText().toString() + " O ");
            else binding.vaizdas.setText(binding.vaizdas.getText().toString() + " X ");
            if ((i +1) % 3 == 0 && i < 8) {
                binding.vaizdas.setText(binding.vaizdas.getText().toString() + "\n");
                binding.vaizdas.setText(binding.vaizdas.getText().toString() + "--------------\n");
            } else if (i < 8) binding.vaizdas.setText(binding.vaizdas.getText().toString() + "|");
        }

        if (binding.text.getText().toString() == pergale)
            binding.cont.setBackgroundColor(0xFFD0A230);
        else if (binding.text.getText().toString() == lygiosios)
            binding.cont.setBackgroundColor(0xFF606060);

        binding.mygtukasB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action =
                        BFragmentDirections
                                .actionBFragmentToAFragment();
                Navigation.findNavController(v).navigate(action);

            }
        });
        return binding.getRoot();
    }
}

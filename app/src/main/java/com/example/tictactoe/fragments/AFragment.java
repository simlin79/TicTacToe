package com.example.tictactoe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;


import com.example.tictactoe.R;
import com.example.tictactoe.databinding.FragmentABinding;

import java.util.Random;


public class AFragment extends Fragment {
    int[] masyvas = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    Random rand = new Random();
    int zaidejas = rand.nextInt(2);   // 2 = X, 1 = O
    int kompiuteris = (zaidejas + 1) % 2;
    int kompEjimas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final FragmentABinding binding = FragmentABinding.inflate(inflater, container, false);

        if (zaidejas == 0) {
            binding.isvedimas.setText(R.string.Nuliukai);
        } else {
            binding.isvedimas.setText(R.string.Kryziukai);
        }

        binding.mygtukasA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA1, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA2, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA3, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA4, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA5, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA6, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA7, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA8, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });
        binding.mygtukasA9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kompEjimas = zaidejoEjimas(masyvas, zaidejas, kompiuteris, binding.mygtukasA9, v);
                if (kompEjimas >= 0)
                    kompiuterioEjimas(kompEjimas, binding, kompiuteris);
            }
        });

        return binding.getRoot();
    }

    public static int zaidejoEjimas(int[] mas, int zaid, int komp, Button mygtukas, View v) {

        // Zaidimas TicTacToe
        int ejimas = -1;
        Random rand = new Random();
        String pergale = v.getResources().getString(R.string.victory);
        String pralaimejimas = v.getResources().getString(R.string.lost);
        String lygiosios = v.getResources().getString(R.string.draw);

        String txt = mygtukas.getText().toString();
        if ((zaid == 0) && (txt.equals(" "))) {
            mygtukas.setText("O");
        } else if (txt.equals(" ")) {
            mygtukas.setText("X");
        } else {
            return -1;
        }
        mas[Integer.parseInt(mygtukas.getTag().toString()) - 1] = zaid + 1;
        if (arLaimejo(mas)) {
            NavDirections action =
                    AFragmentDirections
                            .actionAFragmentToBFragment(pergale, mas);
            Navigation.findNavController(v).navigate(action);
        } else if (arUzpildyta(mas)) {
            NavDirections action =
                    AFragmentDirections
                            .actionAFragmentToBFragment(lygiosios, mas);
            Navigation.findNavController(v).navigate(action);
        } else {
            while (true) {
                ejimas = trecias(mas, komp + 1);  // jei kompiuteriui truksta vieno iki pergales laimim
                if (ejimas < 0) {
                    ejimas = trecias(mas, zaid + 1); // jei zaidejui truksta vieno iki pergales blokuojam
                }
                if (ejimas < 0 && mas[0]!=zaid+1 && mas[2]!=zaid+1 && mas[6]!=zaid+1 && mas[8]!=zaid+1) {
                    int i = rand.nextInt(4); // bandom padeti viename is kampu jeigu laisva ir padeta ne kampe
                    switch (i) {
                        case 0:
                            if (mas[0] == 0) {
                                ejimas = 0;
                                break;
                            }
                        case 1:
                            if (mas[2] == 0) {
                                ejimas = 2;
                                break;
                            }
                        case 2:
                            if (mas[6] == 0) {
                                ejimas = 6;
                                break;
                            }
                        case 3:
                            if (mas[8] == 0) {
                                ejimas = 8;
                                break;
                            }
                        default:
                            break;
                    }
                }
                if (ejimas < 0) {
                    ejimas = rand.nextInt(9);
                }
                if (mas[ejimas] == 0) {
                    mas[ejimas] = komp + 1;
                    break;
                }
            }
            if (arLaimejo(mas)) {
                NavDirections action =
                        AFragmentDirections
                                .actionAFragmentToBFragment(pralaimejimas, mas);
                Navigation.findNavController(v).navigate(action);
            }
        }
        return ejimas;
    }

    public static int trecias(int[] lentele, int zenklas) {
        if (lentele[1] == zenklas && lentele[1] == lentele[2] || lentele[4] == zenklas && lentele[4] == lentele[8] || lentele[3] == zenklas && lentele[3] == lentele[6])
            if (lentele[0] == 0) return 0;
        if (lentele[0] == zenklas && lentele[0] == lentele[2] || lentele[4] == zenklas && lentele[4] == lentele[7])
            if (lentele[1] == 0) return 1;
        if (lentele[0] == zenklas && lentele[0] == lentele[1] || lentele[4] == zenklas && lentele[4] == lentele[6] || lentele[5] == zenklas && lentele[5] == lentele[8])
            if (lentele[2] == 0) return 2;
        if (lentele[0] == zenklas && lentele[0] == lentele[6] || lentele[4] == zenklas && lentele[4] == lentele[5])
            if (lentele[3] == 0) return 3;
        if (lentele[0] == zenklas && lentele[0] == lentele[8] || lentele[1] == zenklas && lentele[1] == lentele[7] || lentele[2] == zenklas && lentele[2] == lentele[6] || lentele[3] == zenklas && lentele[3] == lentele[5])
            if (lentele[4] == 0) return 4;
        if (lentele[2] == zenklas && lentele[2] == lentele[8] || lentele[3] == zenklas && lentele[3] == lentele[4])
            if (lentele[5] == 0) return 5;
        if (lentele[0] == zenklas && lentele[0] == lentele[3] || lentele[4] == zenklas && lentele[4] == lentele[2] || lentele[7] == zenklas && lentele[7] == lentele[8])
            if (lentele[6] == 0) return 6;
        if (lentele[1] == zenklas && lentele[1] == lentele[4] || lentele[6] == zenklas && lentele[6] == lentele[8])
            if (lentele[7] == 0) return 7;
        if (lentele[2] == zenklas && lentele[2] == lentele[5] || lentele[0] == zenklas && lentele[4] == lentele[0] || lentele[6] == zenklas && lentele[7] == lentele[6])
            if (lentele[8] == 0) return 8;
        return -1;
    }

    public static boolean arLaimejo(int[] lentele) {
        if (lentele[0] != 0 && lentele[0] == lentele[3] && lentele[0] == lentele[6])
            return true;
        if (lentele[1] != 0 && lentele[1] == lentele[4] && lentele[1] == lentele[7])
            return true;
        if (lentele[2] != 0 && lentele[2] == lentele[5] && lentele[2] == lentele[8])
            return true;
        if (lentele[0] != 0 && lentele[0] == lentele[1] && lentele[0] == lentele[2])
            return true;
        if (lentele[3] != 0 && lentele[3] == lentele[4] && lentele[4] == lentele[5])
            return true;
        if (lentele[6] != 0 && lentele[6] == lentele[7] && lentele[6] == lentele[8])
            return true;
        if (lentele[0] != 0 && lentele[0] == lentele[4] && lentele[4] == lentele[8])
            return true;
        if (lentele[2] != 0 && lentele[2] == lentele[4] && lentele[4] == lentele[6])
            return true;
        return false;
    }

    public static boolean arUzpildyta(int[] lentele) {
        for (int i = 0; i < 9; i++) {
            if (lentele[i] == 0) return false;
        }
        return true;
    }

    public static void kompiuterioEjimas(int ejimas, FragmentABinding b, int k) {
        switch (ejimas) {
            case 0:
                if (k == 0) {
                    b.mygtukasA1.setText("O");
                } else b.mygtukasA1.setText("X");
                break;
            case 1:
                if (k == 0) {
                    b.mygtukasA2.setText("O");
                } else b.mygtukasA2.setText("X");
                break;
            case 2:
                if (k == 0) {
                    b.mygtukasA3.setText("O");
                } else b.mygtukasA3.setText("X");
                break;
            case 3:
                if (k == 0) {
                    b.mygtukasA4.setText("O");
                } else b.mygtukasA4.setText("X");
                break;
            case 4:
                if (k == 0) {
                    b.mygtukasA5.setText("O");
                } else b.mygtukasA5.setText("X");
                break;
            case 5:
                if (k == 0) {
                    b.mygtukasA6.setText("O");
                } else b.mygtukasA6.setText("X");
                break;
            case 6:
                if (k == 0) {
                    b.mygtukasA7.setText("O");
                } else b.mygtukasA7.setText("X");
                break;
            case 7:
                if (k == 0) {
                    b.mygtukasA8.setText("O");
                } else b.mygtukasA8.setText("X");
                break;
            case 8:
                if (k == 0) {
                    b.mygtukasA9.setText("O");
                } else b.mygtukasA9.setText("X");
                break;
            default:
                break;
        }
    }

}
package com.miguelsolano.appavaliaai;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class EventosPagerAdapter extends FragmentStateAdapter {
    public EventosPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ListaEventosFragment();

            case 1:
                return new ParticipandoFragment();

            case 2:
                return new SalvosFragment();

            default:
                return new ListaEventosFragment();
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}
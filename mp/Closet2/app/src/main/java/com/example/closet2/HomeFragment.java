package com.example.closet2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeFragment extends Fragment implements CardAdapter.OnCounterChangeListener {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private DataManager dataManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inizializza il DataManager
        dataManager = DataManager.getInstance(requireContext());

        // Configura il RecyclerView
        recyclerView = view.findViewById(R.id.cardsRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        // Carica le card salvate
        List<CardItem> cards = dataManager.getCardItems();
        adapter = new CardAdapter(requireContext(), cards, this);
        recyclerView.setAdapter(adapter);

        // Configura il pulsante per caricare nuove immagini
        view.findViewById(R.id.uploadButton).setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_uploadFragment)
        );

        // Configura il pulsante delle impostazioni
        ImageButton settingsButton = view.findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_settingsFragment)
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        // Aggiorna l'adapter con i dati più recenti
        adapter.updateData(dataManager.getCardItems());
    }

    @Override
    public void onCounterChanged(String cardId, int newCount) {
        // Aggiorna il contatore nel DataManager
        dataManager.updateCardCounter(cardId, newCount);

        // Controlla se è necessario inviare una notifica
        checkNotificationThreshold(newCount);
    }

    private void checkNotificationThreshold(int count) {
        // Verifica se le notifiche sono abilitate e se il contatore ha raggiunto la soglia
        if (dataManager.isNotificationsEnabled() && count >= dataManager.getNotificationThreshold()) {
            // Mostra una notifica
            NotificationHelper.showNotification(
                    requireContext(),
                    "Contatore App",
                    "Un contatore ha raggiunto il valore " + count
            );
        }
    }
}
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

import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment implements CardAdapter.OnCounterChangeListener, CardAdapter.OnCardClickListener {

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

        // Initialize DataManager
        dataManager = DataManager.getInstance(requireContext());

        // Configure RecyclerView
        recyclerView = view.findViewById(R.id.cardsRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        // Load saved cards and sort them (high counter cards first)
        List<CardItem> cards = dataManager.getCardItems();
        sortCardsByCounter(cards);

        adapter = new CardAdapter(requireContext(), cards, this, this);
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

    public void onCardClick(String cardId) {
        // Navigate to card detail fragment
        Bundle args = new Bundle();
        args.putString("cardId", cardId);
        Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_cardDetailFragment, args);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Aggiorna l'adapter con i dati più recenti
        adapter.updateData(dataManager.getCardItems());
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

    private void sortCardsByCounter(List<CardItem> cards) {
        Collections.sort(cards, (card1, card2) -> {
            // First check if either card has counter >= 4
            boolean card1IsHigh = card1.getCounter() >= 4;
            boolean card2IsHigh = card2.getCounter() >= 4;

            if (card1IsHigh && !card2IsHigh) {
                // Card1 has high counter but Card2 doesn't, so Card1 comes first
                return -1;
            } else if (!card1IsHigh && card2IsHigh) {
                // Card2 has high counter but Card1 doesn't, so Card2 comes first
                return 1;
            } else {
                // Both cards are either high or low, so sort by counter value (descending)
                return Integer.compare(card2.getCounter(), card1.getCounter());
            }
        });
    }

    @Override
    public void onCounterChanged(String cardId, int newValue) {
        // Save the updated counter
        dataManager.updateCardCounter(cardId, newValue);

        // Re-sort the cards and update the adapter
        List<CardItem> cards = dataManager.getCardItems();
        sortCardsByCounter(cards);
        adapter.updateCards(cards);
    }
}
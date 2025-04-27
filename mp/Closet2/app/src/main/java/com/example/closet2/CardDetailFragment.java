package com.example.closet2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

public class CardDetailFragment extends Fragment {

    private String cardId;
    private ImageView detailImage;
    private TextView detailCounterText;
    private Button detailIncrementButton;
    private Button detailDecrementButton;
    private Button deleteButton;
    private Button backButton;
    private DataManager dataManager;
    private CardItem cardItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the card ID from arguments
        if (getArguments() != null) {
            cardId = getArguments().getString("cardId");
        }

        // Initialize DataManager
        dataManager = DataManager.getInstance(requireContext());

        // Find the card item
        cardItem = dataManager.getCardById(cardId);
        if (cardItem == null) {
            // If card not found, go back
            Navigation.findNavController(view).navigateUp();
            return;
        }

        // Initialize views
        detailImage = view.findViewById(R.id.detailImage);
        detailCounterText = view.findViewById(R.id.detailCounterText);
        detailIncrementButton = view.findViewById(R.id.detailIncrementButton);
        detailDecrementButton = view.findViewById(R.id.detailDecrementButton);
        deleteButton = view.findViewById(R.id.deleteButton);
        backButton = view.findViewById(R.id.backButton);

        // Load image - Add error handling and logging
        try {
            Glide.with(requireContext())
                    .load(cardItem.getImageUri())
                    .centerCrop()
                    .error(R.drawable.ic_launcher_foreground) // Add a fallback image
                    .into(detailImage);

            // Log the URI for debugging
            Log.d("CardDetailFragment", "Loading image URI: " + cardItem.getImageUri());
        } catch (Exception e) {
            Log.e("CardDetailFragment", "Error loading image", e);
        }

        // Set counter
        updateCounterDisplay();

        // Set up increment button
        detailIncrementButton.setOnClickListener(v -> {
            cardItem.incrementCounter();
            dataManager.updateCardCounter(cardId, cardItem.getCounter());
            updateCounterDisplay();
        });

        // Set up decrement button
        detailDecrementButton.setOnClickListener(v -> {
            cardItem.decrementCounter();
            dataManager.updateCardCounter(cardId, cardItem.getCounter());
            updateCounterDisplay();
        });

        // Set up delete button
        deleteButton.setOnClickListener(v -> {
            dataManager.deleteCard(cardId);
            Navigation.findNavController(view).navigateUp();
        });

        // Set up back button
        backButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigateUp()
        );
    }

    private void updateCounterDisplay() {
        detailCounterText.setText(String.valueOf(cardItem.getCounter()));
    }
}
package com.example.closet2;

// ... existing imports ...
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

public class UploadFragment extends Fragment {

    private ImageView previewImage;
    private TextView previewCounterText;
    private Button previewIncrementButton;
    private Button previewDecrementButton;
    private Button selectImageButton;
    private Button insertButton;
    private Button backButton;

    private Uri selectedImageUri;
    private int previewCounter = 0;
    private DataManager dataManager;

    // Use the new ActivityResultLauncher API for better permission handling
    private final ActivityResultLauncher<String> getContent = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                if (uri != null) {
                    selectedImageUri = uri;
                    // Make a persistent copy of the image
                    selectedImageUri = persistImage(uri);

                    // Show the preview of the selected image
                    Glide.with(requireContext())
                            .load(selectedImageUri)
                            .centerCrop()
                            .into(previewImage);
                }
            });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upload, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataManager = DataManager.getInstance(requireContext());

        // Initialize views
        previewImage = view.findViewById(R.id.previewImage);
        previewCounterText = view.findViewById(R.id.previewCounterText);
        previewIncrementButton = view.findViewById(R.id.previewIncrementButton);
        previewDecrementButton = view.findViewById(R.id.previewDecrementButton);
        selectImageButton = view.findViewById(R.id.selectImageButton);
        insertButton = view.findViewById(R.id.insertButton);
        backButton = view.findViewById(R.id.backButton);

        // Set initial counter
        updatePreviewCounter();

        // Configure counter buttons
        previewIncrementButton.setOnClickListener(v -> {
            previewCounter++;
            updatePreviewCounter();
        });

        previewDecrementButton.setOnClickListener(v -> {
            if (previewCounter > 0) {
                previewCounter--;
                updatePreviewCounter();
            }
        });

        // Configure image selection button
        selectImageButton.setOnClickListener(v -> openImagePicker());

        // Configure insert button
        insertButton.setOnClickListener(v -> {
            if (selectedImageUri != null) {
                // Create a new card with the selected image
                CardItem newCard = dataManager.addCard(selectedImageUri);
                // Set initial counter
                dataManager.updateCardCounter(newCard.getId(), previewCounter);
                // Return to home
                Navigation.findNavController(view).navigate(R.id.action_uploadFragment_to_homeFragment);
            } else {
                Toast.makeText(requireContext(), "Seleziona un'immagine prima di inserire", Toast.LENGTH_SHORT).show();
            }
        });

        // Configure back button
        backButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_uploadFragment_to_homeFragment)
        );
    }

    private void openImagePicker() {
        // Launch the image picker
        getContent.launch("image/*");
    }

    private Uri persistImage(Uri sourceUri) {
        // For simplicity, we'll just return the original URI
        // In a production app, you might want to copy the file to your app's storage
        // to ensure it remains accessible even if the original is deleted
        return sourceUri;
    }

    private void updatePreviewCounter() {
        previewCounterText.setText(String.valueOf(previewCounter));
    }
}
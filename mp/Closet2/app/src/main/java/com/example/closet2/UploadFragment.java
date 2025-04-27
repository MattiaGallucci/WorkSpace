package com.example.closet2;

// ... existing imports ...
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

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

    private void updatePreviewCounter() {
        previewCounterText.setText(String.valueOf(previewCounter));
    }

    private Uri persistImage(Uri sourceUri) {
        // For Photo Picker URIs, we need to take a different approach
        if (sourceUri.toString().contains("content://media/picker")) {
            try {
                // Create a copy of the image in your app's cache directory
                InputStream inputStream = requireContext().getContentResolver().openInputStream(sourceUri);
                if (inputStream != null) {
                    // Create a file in the app's cache directory
                    File cacheDir = requireContext().getCacheDir();
                    File outputFile = new File(cacheDir, "image_" + System.currentTimeMillis() + ".jpg");

                    // Copy the content
                    FileOutputStream outputStream = new FileOutputStream(outputFile);
                    byte[] buffer = new byte[4 * 1024];
                    int read;
                    while ((read = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, read);
                    }
                    outputStream.flush();

                    // Close streams
                    inputStream.close();
                    outputStream.close();

                    // Return the URI of the copied file
                    return Uri.fromFile(outputFile);
                }
            } catch (Exception e) {
                Log.e("UploadFragment", "Error copying image", e);
            }
        }

        // If not a photo picker URI or if copying failed, return the original URI
        return sourceUri;
    }

    // Add this constant in your class
    private static final int PICK_IMAGE_REQUEST = 1;

    // Replace your existing image picker method
    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // Add this method to handle the result
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri sourceUri = data.getData();

            // Copy the image to app's internal storage
            selectedImageUri = copyImageToInternalStorage(sourceUri);

            // Show the preview of the selected image
            Glide.with(requireContext())
                    .load(selectedImageUri)
                    .centerCrop()
                    .into(previewImage);
        }
    }

    // Add this method to copy the image
    private Uri copyImageToInternalStorage(Uri sourceUri) {
        try {
            // Get input stream from the source URI
            InputStream inputStream = requireContext().getContentResolver().openInputStream(sourceUri);
            if (inputStream == null) {
                Log.e("UploadFragment", "Failed to open input stream");
                return null;
            }

            // Create a directory for images if it doesn't exist
            File imagesDir = new File(requireContext().getFilesDir(), "images");
            if (!imagesDir.exists()) {
                imagesDir.mkdirs();
            }

            // Create a file with a unique name
            String fileName = "image_" + System.currentTimeMillis() + ".jpg";
            File destFile = new File(imagesDir, fileName);

            // Copy the file
            FileOutputStream outputStream = new FileOutputStream(destFile);
            byte[] buffer = new byte[4 * 1024];
            int read;
            while ((read = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
            }

            // Close streams
            outputStream.flush();
            inputStream.close();
            outputStream.close();

            // Return URI to the copied file
            return Uri.fromFile(destFile);
        } catch (Exception e) {
            Log.e("UploadFragment", "Error copying image", e);
            return null;
        }
    }
}
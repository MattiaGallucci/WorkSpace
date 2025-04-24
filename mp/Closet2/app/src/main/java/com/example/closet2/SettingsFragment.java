package com.example.closet2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class SettingsFragment extends Fragment {

    private Switch notificationsSwitch;
    private EditText thresholdInput;
    private Button saveSettingsButton;
    private DataManager dataManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataManager = DataManager.getInstance(requireContext());

        // Inizializza le viste
        notificationsSwitch = view.findViewById(R.id.notificationsSwitch);
        thresholdInput = view.findViewById(R.id.thresholdInput);
        saveSettingsButton = view.findViewById(R.id.saveSettingsButton);

        // Carica le impostazioni salvate
        notificationsSwitch.setChecked(dataManager.isNotificationsEnabled());
        thresholdInput.setText(String.valueOf(dataManager.getNotificationThreshold()));

        // Configura il pulsante di salvataggio
        saveSettingsButton.setOnClickListener(v -> saveSettings());
    }

    private void saveSettings() {
        // Salva lo stato delle notifiche
        dataManager.setNotificationsEnabled(notificationsSwitch.isChecked());

        // Salva la soglia per le notifiche
        try {
            int threshold = Integer.parseInt(thresholdInput.getText().toString());
            dataManager.setNotificationThreshold(threshold);

            Toast.makeText(requireContext(), "Impostazioni salvate", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(requireView()).navigate(R.id.action_settingsFragment_to_homeFragment);
        } catch (NumberFormatException e) {
            Toast.makeText(requireContext(), "Inserisci un numero valido", Toast.LENGTH_SHORT).show();
        }
    }
}
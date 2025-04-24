package com.example.closet2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<CardItem> cardItems;
    private Context context;
    private OnCounterChangeListener listener;

    public interface OnCounterChangeListener {
        void onCounterChanged(String cardId, int newCount);
    }

    public CardAdapter(Context context, List<CardItem> cardItems, OnCounterChangeListener listener) {
        this.context = context;
        this.cardItems = cardItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem item = cardItems.get(position);

        // Carica l'immagine usando Glide
        Glide.with(context)
                .load(item.getImageUri())
                .centerCrop()
                .into(holder.cardImage);

        // Imposta il contatore
        holder.counterText.setText(String.valueOf(item.getCounter()));

        // Gestisce i pulsanti di incremento e decremento
        holder.incrementButton.setOnClickListener(v -> {
            item.incrementCounter();
            holder.counterText.setText(String.valueOf(item.getCounter()));
            if (listener != null) {
                listener.onCounterChanged(item.getId(), item.getCounter());
            }
        });

        holder.decrementButton.setOnClickListener(v -> {
            item.decrementCounter();
            holder.counterText.setText(String.valueOf(item.getCounter()));
            if (listener != null) {
                listener.onCounterChanged(item.getId(), item.getCounter());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public void updateData(List<CardItem> newItems) {
        this.cardItems = newItems;
        notifyDataSetChanged();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView counterText;
        Button incrementButton;
        Button decrementButton;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            counterText = itemView.findViewById(R.id.counterText);
            incrementButton = itemView.findViewById(R.id.incrementButton);
            decrementButton = itemView.findViewById(R.id.decrementButton);
        }
    }
}
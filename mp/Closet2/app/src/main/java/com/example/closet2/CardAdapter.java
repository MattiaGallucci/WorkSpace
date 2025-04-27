package com.example.closet2;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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

    private OnCardClickListener cardClickListener;

    public interface OnCardClickListener {
        void onCardClick(String cardId);
    }

    public CardAdapter(Context context, List<CardItem> cardItems, OnCounterChangeListener listener, OnCardClickListener cardClickListener) {
        this.context = context;
        this.cardItems = cardItems;
        this.listener = listener;
        this.cardClickListener = cardClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem item = cardItems.get(position);

        // Load image using Glide
        Glide.with(context)
                .load(item.getImageUri())
                .centerCrop()
                .into(holder.cardImage);

        // Set counter
        holder.counterText.setText(String.valueOf(item.getCounter()));

        // Get the threshold from SharedPreferences
        SharedPreferences prefs = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        int threshold = prefs.getInt("counter_threshold", 4); // Default is 4

        // Apply red border highlight if counter meets or exceeds threshold
        if (item.getCounter() >= threshold) {
            holder.itemView.setBackground(ContextCompat.getDrawable(context, R.drawable.card_border_highlight));
        } else {
            // Reset to default background
            holder.itemView.setBackgroundResource(0);
        }

        // Apply red border highlight if counter is 4 or more
        if (item.getCounter() >= 4) {
            holder.itemView.setBackground(ContextCompat.getDrawable(context, R.drawable.card_border_highlight));
        } else {
            // Reset to default background
            holder.itemView.setBackgroundResource(0);
        }

        // Handle increment button
        holder.incrementButton.setOnClickListener(v -> {
            item.incrementCounter();
            holder.counterText.setText(String.valueOf(item.getCounter()));
            if (listener != null) {
                listener.onCounterChanged(item.getId(), item.getCounter());
            }
            notifyItemChanged(position);
        });

        // Handle decrement button
        holder.decrementButton.setOnClickListener(v -> {
            if (item.getCounter() > 0) {
                item.decrementCounter();
                holder.counterText.setText(String.valueOf(item.getCounter()));
                if (listener != null) {
                    listener.onCounterChanged(item.getId(), item.getCounter());
                }
                notifyItemChanged(position);
            }
        });

        // Handle card click
        holder.itemView.setOnClickListener(v -> {
            if (cardClickListener != null) {
                cardClickListener.onCardClick(item.getId());
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

    public void updateCards(List<CardItem> newCards) {
        this.cardItems = newCards;
        notifyDataSetChanged();
    }
}
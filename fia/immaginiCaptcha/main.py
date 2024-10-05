import tkinter as tk
from PIL import Image, ImageTk
import os
import random

# Funzione per caricare immagini da una cartella
def load_images(folder):
    images = []
    for filename in os.listdir(folder):
        img_path = os.path.join(folder, filename)
        if img_path.endswith((".png", ".jpg", ".jpeg")):
            images.append(img_path)
    return images

# Funzione per verificare le selezioni dell'utente
def verify_selection():
    selected_images = [img for img in all_images if img in selected]
    if "boat.png" in selected_images:  # Sostituisci con il nome dell'immagine corretta
        result_label.config(text="Corretto!")
    else:
        result_label.config(text="Sbagliato, riprova.")

# Funzione per selezionare un'immagine
def toggle_selection(img_path):
    if img_path in selected:
        selected.remove(img_path)
    else:
        selected.add(img_path)

# Funzione per creare il CAPTCHA
def create_captcha(images, num_images=9):
    selected_images = random.sample(images, num_images)
    return selected_images

# Imposta la finestra principale
root = tk.Tk()
root.title("Seleziona tutte le immagini con barche")
root.geometry("600x600")

# Carica le immagini dalla cartella
folder_path = "C:/Workspace/fia/immaginiCaptcha"  # Cambia con il percorso della tua cartella
all_images = load_images(folder_path)
selected = set()

# Crea il CAPTCHA
captcha_images = create_captcha(all_images)

# Visualizza le immagini nel GUI
for img_path in captcha_images:
    img = Image.open(img_path)
    img = img.resize((150, 150))  # Ridimensiona l'immagine
    photo = ImageTk.PhotoImage(img)
    
    btn = tk.Button(root, image=photo, command=lambda p=img_path: toggle_selection(p))
    btn.image = photo  # Mantieni un riferimento all'immagine
    btn.pack(side=tk.LEFT, padx=5, pady=5)

# Pulsante di verifica
verify_button = tk.Button(root, text="VERIFICA", command=verify_selection)
verify_button.pack(pady=20)

# Etichetta per i risultati
result_label = tk.Label(root, text="")
result_label.pack()

root.mainloop()

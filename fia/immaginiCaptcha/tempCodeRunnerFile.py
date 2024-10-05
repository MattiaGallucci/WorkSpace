import tkinter as tk
from PIL import Image, ImageTk
import requests
from io import BytesIO
import tensorflow as tf
from tensorflow.keras.applications.mobilenet_v2 import MobileNetV2, preprocess_input, decode_predictions
import numpy as np

# Funzione per scaricare immagini da Unsplash
def download_image(query):
    url = f"https://source.unsplash.com/1600x900/?{query}"
    response = requests.get(url)
    img = Image.open(BytesIO(response.content))
    return img

# Crea una griglia 4x4 di immagini
def create_image_grid(images, grid_size=(4, 4), image_size=(100, 100)):
    grid_width, grid_height = grid_size
    img_width, img_height = image_size
    grid_image = Image.new('RGB', (grid_width * img_width, grid_height * img_height))

    for i, img in enumerate(images):
        img = img.resize(image_size)
        x = i % grid_width * img_width
        y = i // grid_width * img_height
        grid_image.paste(img, (x, y))

    return grid_image

# Funzione per predire il contenuto dell'immagine
def predict_image(image, model):
    img = image.resize((224, 224))
    img_array = np.expand_dims(np.array(img), axis=0)
    img_array = preprocess_input(img_array)
    preds = model.predict(img_array)
    return decode_predictions(preds, top=1)[0][0][1]

# Funzione di callback per la selezione delle immagini
def on_image_click(event, img_label, img_index):
    if img_label.cget("relief") == "sunken":
        img_label.config(borderwidth=0, relief="flat")  # Deseleziona l'immagine
        selected_images.remove(img_index)
    else:
        img_label.config(borderwidth=2, relief="sunken")  # Seleziona l'immagine
        selected_images.add(img_index)

# Funzione principale per creare l'interfaccia
def create_gui(images, model):
    root = tk.Tk()
    root.title("Seleziona tutte le immagini con autobus")

    global selected_images
    selected_images = set()  # Set per tenere traccia delle immagini selezionate

    # Crea una griglia di immagini e gestisci i click
    for i, img in enumerate(images):
        img_tk = ImageTk.PhotoImage(img.resize((100, 100)))
        img_label = tk.Label(root, image=img_tk, borderwidth=0)
        img_label.grid(row=i//4, column=i%4, padx=5, pady=5)
        img_label.bind("<Button-1>", lambda event, l=img_label, idx=i: on_image_click(event, l, idx))
        img_label.image = img_tk  # Evita che l'immagine venga garbage collected

    root.mainloop()

if __name__ == '__main__':
    # Scarica 16 immagini di autobus e altri oggetti
    queries = ['bus', 'car', 'traffic light', 'bicycle']
    images = [download_image(query) for query in queries for _ in range(4)]  # 16 immagini

    # Carica il modello pre-addestrato MobileNetV2
    model = MobileNetV2(weights='imagenet')

    # Predici e stampa i contenuti delle immagini
    for i, img in enumerate(images):
        label = predict_image(img, model)
        print(f"Immagine {i}: {label}")

    # Crea e avvia l'interfaccia grafica
    create_gui(images, model)

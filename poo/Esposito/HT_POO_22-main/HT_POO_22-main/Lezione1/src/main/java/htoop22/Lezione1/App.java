package htoop22.Lezione1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import htoop22.Lezione1.prodotto.*;
import htoop22.Lezione1.prodotto.Maglia.Taglia;

public class App 
{
	public static void main( String[] args )
	{


		HashSet<Prodotto> prodotti = new HashSet<Prodotto>();
		List<Cliente> clienti = new ArrayList<Cliente>();
		List<Ordine> ordini = new ArrayList<Ordine>();
		char ch;

		do{
			System.out.print("Gestione magazzino - Gestione ordini - Uscire(m/o/x)?:");
			Scanner q=new Scanner(System.in);
			ch = q.nextLine().charAt(0);
			if (ch == 'm') {
				System.out.print("Inserimento o Eliminazione (i/e)?:");
				ch=q.nextLine().charAt(0);
				if(ch=='i') {
					boolean error;
					do {
						error = false;
						System.out.print("Maglia, Bibita o Chiavetta (m/b/c)?:");
						char type = q.nextLine().charAt(0);
						System.out.print("Nome: ");
						String nome = q.nextLine();
						System.out.print("Prezzo: ");
						double prezzo = q.nextDouble();
						q.nextLine();
						System.out.print("Marca: ");
						String marca = q.nextLine();
						System.out.print("Quantità: ");
						int qta = q.nextInt();
						q.nextLine();
						try {
							switch (type) {
							case 'm':
								System.out.print("Taglia: ");
								Taglia taglia = Maglia.Taglia.valueOf(q.nextLine());
								System.out.print("Colore: ");
								String colore = q.nextLine();
								if (!prodotti.add(new Maglia(nome, prezzo, marca, qta, taglia, colore))) error = true;
								break;
							case 'b':
								System.out.print("Gas? (1/0) ");
								boolean gas = q.nextBoolean();
								q.nextLine();
								System.out.print("% Alcol: ");
								int perc_alcol = q.nextInt();
								q.nextLine();
								if(!prodotti.add(new Bibita(nome, prezzo, marca, qta, gas, perc_alcol))) error = true;
								break;
							case 'c':
								System.out.print("Spazio: ");
								int spazio = q.nextInt();
								q.nextLine();
								if (!prodotti.add(new Chiavetta(nome, prezzo, marca, qta, spazio))) error = true;
								break;
							default:
								error = true;
								break;
							}
						} catch (NoSuchElementException e) {
							System.out.println("Errore nella lettura, riprovare.");
							error = true;
						} catch (IllegalArgumentException e2) {
							System.out.println("Errore nell'inserimento della taglia, riprovare.");
							error = true;
						}
					} while (error);
				} else if (ch == 'e') {
					System.out.print("Nome: ");
					String nome_modifica = q.nextLine();
					Iterator<Prodotto> iter = prodotti.iterator();
					while (iter.hasNext()) {
						Prodotto p = iter.next();
						if (p.getNome().equals(nome_modifica)) {
							prodotti.remove(p);
						}
					}
				}
			} else if (ch == 'o') {
				System.out.print("Inserimento cliente, Inserimento ordine o Modifica Pagamento Ordine (c/o/m)?:");
				ch=q.nextLine().charAt(0);
				if (ch == 'c') {
					System.out.print("Nome: ");
					String nome = q.nextLine();
					System.out.print("Cognome: ");
					String cognome = q.nextLine();
					Cliente c = new Cliente(clienti.size(), cognome, nome);
					clienti.add(c);
				} else if (ch == 'o') {
					System.out.println("Scegli il cliente");
					clienti.stream().forEach(System.out::println);
					int idCliente = q.nextInt();
					q.nextLine();
					Cliente cli = clienti.get(idCliente);
					Ordine o = new Ordine(ordini.size());
					ch = 's';
					do {
						System.out.println("Scegli il prodotto");
						prodotti.stream().forEach(System.out::println);
						String k = q.nextLine();
						Optional<Prodotto> prodotto_trovato = prodotti.stream().filter(z -> z.getNome().equals(k)).findFirst();
						if (!prodotto_trovato.isPresent()) {
							System.out.println("Il prodotto non è stato trovato, riprovare.");
						} else {
							Prodotto p_t = prodotto_trovato.get();
							System.out.println("Inserire quantità: ");
							int qta = q.nextInt();
							q.nextLine();
							if (p_t.getQta() < qta) {
								System.out.println("La quantità in magazzino non è sufficiente.");
							} else {
								p_t.setQta(p_t.getQta() - qta);
								Prodotto to_add = (Prodotto) p_t.clone();
								to_add.setQta(qta);
								o.addProdottoToOrdine(to_add);
							}
						}
						System.out.print("Inserire altri prodotti (s/n)?");
						ch = q.nextLine().charAt(0);
					} while (ch != 'n');
					ordini.add(o);
					System.out.println("Grazie per aver inserito l'ordine.");
				} else if (ch == 'm') {
					System.out.println("Scegli di quale ordine modificare il pagamento");
					ordini.stream().forEach(System.out::println);
					int ind = q.nextInt();
					q.nextLine();
					Ordine o = ordini.get(ind);
					o.setStato(Ordine.statoPagamento.PAGATO);
					boolean error_payment;
					do {
						try {
							error_payment = false;
							System.out.println("Scegli tipo pagamento (PAYPAL, CONTRASSEGNO, BONIFICO): ");
							o.setPagamento(Ordine.tipoPagamento.valueOf(q.nextLine()));
						} catch (IllegalArgumentException e) {
							System.out.println("Errore nella lettura del tipo di pagamento, riprovare.");
							error_payment = true;
						}
					} while (error_payment != false);
				}
			}
		}while(ch!='x');


	}
}

package poo23;

interface IFigura {
	Punto baricentro();
	int inserisciPunto(Punto punto) throws Exception;
	void rimuoviPunto(int pos) throws Exception;
}

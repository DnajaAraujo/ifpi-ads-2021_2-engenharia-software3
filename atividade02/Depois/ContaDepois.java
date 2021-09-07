package exercicios.poo06.q02;

public class ContaDepois {
	private String numero;
	private double saldo;
	
	public ContaDepois() {
		
	}
	
	public ContaDepois(String numero, double valor) {
		this.numero = numero;
		this.saldo = valor;
	}
	
	public void sacar(double valor) {
		saldo = saldo - valor;
	}
	
	public void depositar(double valor) {
		saldo = saldo + valor;
	}
	
	public double consultarSaldo() {
		return saldo;
	}
	
	public void transferir(ContaDepois destino, double valor) {
		saldo = saldo - valor;
		destino.saldo = destino.saldo + valor;
		//this.sacar(valor);
		//destino.depositar(valor);
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setSaldo(double saldo) {
		if (saldo > 5) {
			this.saldo = saldo;
		}
	}
	
}

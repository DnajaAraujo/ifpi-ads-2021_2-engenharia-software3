package exercicios.poo05.q02;

public class TestaBanco {
    public static void main(String[] args) {
        Banco b = new Banco(4);
        Conta c1 = new Conta("1", 200);
        Conta c2 = new Conta("2", 400);
        Conta c3 = new Conta("3", 100);
        
        b.inserir(c1);
        b.inserir(c2);
	    b.inserir(c3);

	    b.creditar("1", 100);
	    b.creditar("3", 500);
	    b.creditar("4", 200);
	    b.creditar("5", 100);

	    b.transferir("1", "4", 50);
	    b.transferir("2", "3", 100);
	    b.transferir("1", "5", 50);
		
	    //b.consultarIndice("2");

	    System.out.println(b.contarContasCadastradas());
	    System.out.println(b.contarDinheiroTotal());
	    System.out.println(b.calcularMediaConta());
    
    }
}

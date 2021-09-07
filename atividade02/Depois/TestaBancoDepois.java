package exercicios.poo06.q02;

public class TestaBancoDepois {
    public static void main(String[] args) {
        BancoDepois b = new BancoDepois(4);
        ContaDepois c1 = new ContaDepois("1", 200);
        ContaDepois c2 = new ContaDepois("2", 400);
        ContaDepois c3 = new ContaDepois("3", 100);
       
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


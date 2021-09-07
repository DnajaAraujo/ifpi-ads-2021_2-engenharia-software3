package exercicios.poo06.q02;

public class TestaBancoDepois {
    public static void main(String[] args) {
        BancoDepois b = new BancoDepois(4);
        
	ContaDepois c1 = new ContaDepois();
	c1.setNumero("1");
	c1.setSaldo(200);
	
        ContaDepois c2 = new ContaDepois();
	c2.setNumero("2");
	c2.setSaldo(400);
	
        ContaDepois c3 = new ContaDepois();
       	c3.setNumero("3");
	c3.setSaldo(100);
	
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


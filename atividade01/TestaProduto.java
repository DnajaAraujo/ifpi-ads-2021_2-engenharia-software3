public class TestaProduto {
    public static void main(String[] args) {
        Produto produto1 = new Produto(123, "sal", 1, 100);

        produto1.baixar(10);
        produto1.baixar(200);
        produto1.repor(20);
        produto1.reajusta(10);

        System.out.println(produto1.toString());
        
    }
}
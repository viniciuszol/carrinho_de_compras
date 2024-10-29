import java.util.List;
import java.util.ArrayList;

public class Carrinho {
    private List<Item> itemList;

    public Carrinho() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int qtd) {
        itemList.add(new Item(nome,preco,qtd));
    }

    public void removerItem(String nome, double preco, int qtd) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            
        
        for(Item i : itemList) {
            if(i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }
        itemList.removeAll(itensParaRemover);
        }
        else {
            System.out.println("Seu carrinho está vazio");
        }
    }

    public double calcularValorToral() {
        double valorTotal = 0;
        if (!itemList.isEmpty()) {
            for(Item i : itemList) {
                double valorItem = i.getPreco() * i.getQtd();
                valorTotal += valorItem;
            }
            return valorTotal;
        }
        else {
            throw new RuntimeException("Seu carrinho está está vazio");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(itemList);
        }
        else {
            System.out.println("Seu carrinho está vazio");
        }
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        //adicionando itens ao carrinho
        carrinho.adicionarItem("Arroz Branco 1Kg", 2.86, 4);
        carrinho.adicionarItem("Feijão Carioca 1kg", 3.29, 3);
        carrinho.adicionarItem("Macarrão 500g", 2.75, 2);
        carrinho.adicionarItem("Molho de Tomate ", 4, 2);
        carrinho.adicionarItem("Peito de Frango", 24, 1);

        //exibindo os itens do carrinho
        carrinho.exibirItens();

        //removendo item do carrinho
        carrinho.removerItem("Feijão Carioca",0 ,0);

        //exibindo os itens *atualizado* do carrinho
        carrinho.exibirItens();

        //calculando o valor e exibindo o montante das compras do carrinho
        System.out.println("O valor total da compra é: " + carrinho.calcularValorToral());
    }
}
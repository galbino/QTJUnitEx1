package carrinho;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;
    private Carrinho carrinhoCheio;

    @BeforeEach
    public void inicializa() {

        carrinho = new Carrinho();
        carrinhoCheio = new Carrinho();
        carrinhoCheio.addItem(new Produto("Item", 100.0));
        carrinhoCheio.addItem(new Produto("Item2", 200.0));
    }

    @DisplayName("Testa a inserção de itens")
    @Test
    public void testCarregaCarrinho() {
        Produto prod = new Produto("Prod1", 15.0);
        carrinho.addItem(prod);
        Assertions.assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testValorTotal() {
        assertEquals(carrinhoCheio.getValorTotal(), 300.0);
    }

    @Test
    public void testQtdDeItens() {
        assertEquals(carrinhoCheio.getQtdeItems(), 2);
    }

    @Test
    public void testEsvaziaCarrinho() {
        carrinhoCheio.esvazia();
        assertEquals(carrinhoCheio.getQtdeItems(), 0);
    }

    @Test
    public void testRemoveItem() throws ProdutoNaoEncontradoException{
        Produto prod = new Produto("item para deletar", 100.0);
        carrinho.addItem(prod);
        assertEquals(carrinho.getQtdeItems(), 1);
        carrinho.removeItem(prod);
        assertEquals(carrinho.getQtdeItems(), 0);
    }

}

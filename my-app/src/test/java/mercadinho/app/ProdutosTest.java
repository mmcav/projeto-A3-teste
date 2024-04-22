package mercadinho.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class ProdutosTest {

  private final ProdutoPeso produtoPeso = new ProdutoPeso();
  private final ProdutoUnidade produtoUnidade = new ProdutoUnidade();

  @Test
  public void setEGetFabricanteTest() {
    String fabricanteGet;
    produtoPeso.setFabricante("Camil");
    fabricanteGet = produtoPeso.getFabricante();
    assertNotNull("Fabricante incorreto", fabricanteGet);

  }

  @Test
  public void setEGetNomeTest() {
    String nomeGet;
    produtoPeso.setNome("Arroz parbolizado");
    nomeGet = produtoPeso.getNome();
    assertNotNull("Nome incorreto", nomeGet);
  }

  @Test
  public void setEGetPrecoTest() {
    float precoGet;
    produtoPeso.setPreco((float) 7.50);
    precoGet = produtoPeso.getPreco();
    assertNotNull("Preço incorreto", precoGet);
  }

  @Test
  public void setEGetDataValidadeTest() {
    Date dataGet = new Date();
    produtoPeso.setDataValidade(dataGet);
    dataGet = produtoPeso.getDataValidade();
    assertNotNull("Data de validade não definida", dataGet);
  }

  @Test
  public void setEGetPesoTest() {
    float pesoGet;
    produtoPeso.setQuantidade((float) 1.00);
    pesoGet = produtoPeso.getQuantidade();
    assertNotNull("Peso incorreto", pesoGet);
  }

  @Test
  public void setEGetUnidadeTest() {
    int unidadeGet;
    produtoUnidade.setQuantidade((int) 5);
    unidadeGet = (int) produtoUnidade.getQuantidade();
    assertNotNull("Unidade incorreta", unidadeGet);
  }

  @Test
  public void validaStringsProdutoTest() {
    final String stringTest = "Nestlé";
    assertTrue(produtoPeso.validaStringsProduto(stringTest));
  }

  @Test
  public void validaDataValidadeTest() throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataSubmetida = new Date();
    dataSubmetida = simpleDateFormat.parse("2024-04-25");
    assertTrue(produtoPeso.validaDataValidade(dataSubmetida));
  }

  @Test
  public void validaProdutoFloatNonZeroTest() {
    final float someFloat = (float) 10.23;
    assertTrue(produtoPeso.validaProdutoFloatNonZero(someFloat));
  }

  @Test
  public void validaProdutoIntNonZeroTest() {
    final int someInt = (int) 3;
    assertTrue(produtoUnidade.validaProdutoIntNonZero(someInt));
  }
}

package mercadinho.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

  private final Cliente cliente = new Cliente();

  @Test
  public void setEGetNomeTest() {
    String nomeGet;
    cliente.setNome("Luísa Ferreira");
    nomeGet = cliente.getNome();
    assertNotNull("Nome incorreto", nomeGet);
  }

  @Test
  public void setEGetCpfTest() {
    String cpfGet;
    cliente.setCpf("123.456.789-09");
    cpfGet = cliente.getCpf();
    assertNotNull("CPF incorreto", cpfGet);
  }

  @Test
  public void setEGetDataNascimentoTest() {
    Date dataGet = new Date();
    cliente.setDataNascimento(dataGet);
    dataGet = cliente.getDataNascimento();
    assertNotNull("Data de nascimento não definida", dataGet);
  }

  @Test
  public void validaNomeClienteTrueTest() {
    final String nome = "Adrianô M´aciél";
    assertTrue(cliente.validaNomeCliente(nome));
  }

  @Test
  public void validaNomeClienteFalseTest(){
    final String nome = "C3-PO";
    assertFalse(cliente.validaNomeCliente(nome));
  }

  @Test
  public void validaCpfClienteTrueTest() {
    final String cpf = "123.456.789-09";
    assertTrue(cliente.validaCpfCliente(cpf));

  }

  @Test
  public void validaCpfClienteFalseTest() {
    final String cpf = "123.456.789-19";
    assertFalse(cliente.validaCpfCliente(cpf));
  }

  @Test
  public void validaDataNascimentoClienteTrueTest() throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataSubmetida = new Date();
    dataSubmetida = simpleDateFormat.parse("2024-04-05");
    assertTrue(cliente.validaDataNascimentoCliente(dataSubmetida));
  }

  @Test
  public void validaDataNascimentoClienteFalseTest() throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataSubmetida = new Date();
    dataSubmetida = simpleDateFormat.parse("2025-04-05");
    assertFalse(cliente.validaDataNascimentoCliente(dataSubmetida));
  }
}

public class Veiculo {
  private int id, ano;
  private long preco;
  private String modelo, cor, placa;

  public Veiculo() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getPreco() {
    return preco;
  }

  public void setPreco(long preco) {
    this.preco = preco;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  @Override
  public String toString() {
    return "Veiculo [ano=" + ano + ", cor=" + cor + ", id=" + id + ", modelo=" + modelo + ", placa=" + placa
        + ", preco=" + preco + "]";
  }

}

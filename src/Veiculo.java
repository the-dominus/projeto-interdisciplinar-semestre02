public class Veiculo {
  private int id, ano;
  private double preco;
  private String modelo, cor, placa, marca;

  public Veiculo(int ano, double preco, String marca, String modelo, String cor, String placa) {
    this.ano = ano;
    this.preco = preco;
    this.marca = marca;
    this.modelo = modelo;
    this.cor = cor;
    this.placa = placa;
  }

  public Veiculo(int ano, double preco, String marca, String modelo, String cor) {
    this.ano = ano;
    this.preco = preco;
    this.marca = marca;
    this.modelo = modelo;
    this.cor = cor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
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

  public void imprimir() {
    String message = "";

    message += "[" + this.getId() + "] ";
    message += "Veículo: " + this.getNomeVeiculo() + "\n";
    message += "Cor: " + this.getCor() + " - Preço: " + this.getPreco() + "\n";
    message += "Placa: " + this.getPlaca() + "\n";

    System.out.println(message);
  }

  public String getNomeVeiculo() {
    return this.getMarca() + " " + this.getModelo() + " - " + this.getAno();
  }

  @Override
  public String toString() {
    String message = "";

    message += "\n[-] ID: " + this.id + "\n";
    message += "[1] Ano: " + this.ano + "\n";
    message += "[2] Preço: " + this.preco + "\n";
    message += "[3] Marca: " + this.marca + "\n";
    message += "[4] Modelo: " + this.modelo + "\n";
    message += "[5] Cor: " + this.cor + "\n";
    message += "[6] Placa: " + this.placa + "\n";

    return message;
  }

}

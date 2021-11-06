public class Cliente extends Usuario {
  private String endereco;
  private String cpf;

  public Cliente(String nome, String email, String cpf) {
    super(nome, email);
    this.cpf = cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void imprimir() {
    // TODO Auto-generated method stub
  }

}

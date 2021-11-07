public class Cliente extends Usuario {
  private String endereco, cpf;

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
    String message = "";
    message += "[" + this.getId() + "] ";
    message += this.getNome();
    message += "\nCPF: " + this.getCpf() + " - Endereço: " + this.getEndereco();
    message += "\nEmail: " + this.getEmail() + " - Senha: " + this.getSenha();
    message += "\n";

    System.out.println(message);
  }

  @Override
  public String toString() {
    // deixar o toString na foma de listar
    return super.toString() + "CPF=" + cpf + ", Endereco=" + endereco + "]";
  }

}

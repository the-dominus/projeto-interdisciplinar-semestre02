public abstract class Usuario {
  private int id;
  private String nome, email, senha;

  public Usuario(String nome, String email) {
    this.nome = nome;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public abstract void imprimir();

  @Override
  public String toString() {
    return "Usuario [email=" + email + ", id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
  }
}

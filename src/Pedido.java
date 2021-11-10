import java.util.ArrayList;

public class Pedido {
  private int id;
  private double totalPedido;
  private Cliente cliente;
  private ArrayList<Veiculo> veiculos;
  private String formaDePagamento;
  private boolean pedidoFinalizado = false;

  public Pedido(Cliente cliente, ArrayList<Veiculo> veiculos) {
    this.cliente = cliente;
    this.veiculos = veiculos;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getTotalPedido() {
    return totalPedido;
  }

  public void setTotalPedido(double totalPedido) {
    this.totalPedido = totalPedido;
  }

  public String getFormaDePagamento() {
    return formaDePagamento;
  }

  public void setFormaDePagamento(String formaDePagamento) {
    this.formaDePagamento = formaDePagamento;
  }

  public ArrayList<Veiculo> getVeiculos() {
    return veiculos;
  }

  public void setVeiculos(ArrayList<Veiculo> veiculos) {
    this.veiculos = veiculos;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public boolean isPedidoFinalizado() {
    return pedidoFinalizado;
  }

  public void setPedidoFinalizado(boolean pedidoFinalizado) {
    this.pedidoFinalizado = pedidoFinalizado;
  }

  public void imprimir() {
    String message = "";

    message += "[" + this.getId() + "] Pedido: \n";
    message += "Cliente: " + this.getCliente().getNome() + "\n";
    message += "Veículos: \n";
    for (Veiculo veiculo : this.veiculos) {
      message += "\t" + veiculo.getNomeVeiculo() + "\n";
    }
    message += "Forma pagamento: " + this.getFormaDePagamento() + "\n";
    message += "Total pedido: " + this.getTotalPedido() + "\n";
    message += "Foi pago: " + (this.isPedidoFinalizado() ? "sim" : "não") + "\n";

    System.out.println(message);
  }

  @Override
  public String toString() {
    String message = "";

    message += "\n[-] ID: " + this.id + "\n";
    message += "[1] Cliente: " + this.cliente.getNome() + "\n";
    message += "[2] Veículos: \n";
    for (Veiculo veiculo : this.veiculos) {
      message += "\t" + veiculo.getNomeVeiculo() + "\n";
    }
    message += "[3] Forma pagamento: : " + this.formaDePagamento + "\n";
    message += "[4] Total pedido: : " + this.totalPedido + "\n";
    message += "[5] Foi pago: " + (this.pedidoFinalizado ? "sim" : "não") + "\n";

    return message;
  }

  public void calcularTotalPedido() {
    this.totalPedido = 0;
    for (Veiculo veiculo : veiculos) {
      totalPedido += veiculo.getPreco();
    }

  }

}

import java.util.ArrayList;

public class Pedido {
  private int id;
  private long totalPedido;
  private String formaDePagamento;
  private ArrayList<Veiculo> veiculos;
  private Cliente cliente;

  public Pedido() {
  }

  public Pedido(ArrayList<Veiculo> veiculos, Cliente cliente) {
    this.veiculos = veiculos;
    this.cliente = cliente;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getTotalPedido() {
    return totalPedido;
  }

  public void setTotalPedido(long totalPedido) {
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

  @Override
  public String toString() {
    return "Pedido [cliente=" + cliente + ", formaDePagamento=" + formaDePagamento + ", id=" + id + ", totalPedido="
        + totalPedido + ", veiculos=" + veiculos + "]";
  }

  public void calcularTotalPedido() {
    for (Veiculo veiculo : veiculos) {
      totalPedido += veiculo.getPreco();
    }

  }

}

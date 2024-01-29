package contato;

public class Telefone {

    private static int proximoId = 0;
    private int id;
    private String ddd;
    private Long numero;


    public Telefone(String ddd, Long numero) {
        this.id = proximoId++;
        this.ddd = ddd;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return "ID: "  + "\nDDD: " + ddd + "\nNúmero: " + numero;
    }
}

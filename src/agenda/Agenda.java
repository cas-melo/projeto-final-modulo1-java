package agenda;

import contato.Contato;
import contato.Telefone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static contato.Contato.proximoId;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }


    public void criarContato(int proximoId, String nome, String sobrenome, List<Telefone> telefones) {
        Contato novoContato = new Contato(proximoId, nome, sobrenome);
        novoContato.setTelefones(telefones);
        contatos.add(novoContato);
    }


    public void adicionarTelefoneAContato(int idContato, Telefone telefone) {
        for (Contato contato : contatos) {
            if (contato.getId() == idContato) {
                contato.adicionarTelefone(telefone);
                break;
            }
        }
    }

    public void removerContato(int id) {
        contatos.removeIf(contato -> contato.getId() == id);
    }

    public void atualizarContato(int id, String novoNome, String novoSobrenome) {
        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                contato.setNome(novoNome);
                contato.setSobrenome(novoSobrenome);
                break;
            }
        }
    }

    public List<Contato> getContatos() {
        return contatos;
    }


    String caminhoArquivo = "src/dados/contatos.txt";

    public void salvarContatosEmArquivo(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (Contato contato : contatos) {
                writer.write(converterContatoParaLinhaCSV(contato) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void carregarContatosDoArquivo(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String sobrenome = partes[2];

                Contato contato = new Contato(proximoId++, nome, sobrenome);


                if (partes.length > 3) {
                    String[] telefones = partes[3].split(";");
                    for (String telefoneStr : telefones) {
                        String[] telefonePartes = telefoneStr.split("-");
                        String ddd = telefonePartes[0];
                        Long numero = Long.parseLong(telefonePartes[1]);
                        Telefone telefone = new Telefone(ddd, numero);
                        contato.adicionarTelefone(telefone);
                    }
                }

                contatos.add(contato);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String converterContatoParaLinhaCSV(Contato contato) {
        StringBuilder linha = new StringBuilder();
        linha.append(contato.getId()).append(",");
        linha.append(contato.getNome()).append(",");
        linha.append(contato.getSobrenome()).append(",");


        List<Telefone> telefones = contato.getTelefones();
        if (!telefones.isEmpty()) {
            for (Telefone telefone : telefones) {
                linha.append(telefone.getDdd()).append("-");
                linha.append(telefone.getNumero()).append(";");
            }

            linha.setLength(linha.length() - 1);
        }

        return linha.toString();
    }

}

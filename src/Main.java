import agenda.Agenda;
import contato.Contato;
import contato.Telefone;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        agenda.carregarContatosDoArquivo("src/dados/contatos.txt");

        int opcao;
        do {
            System.out.println("""
                    ##################
                    ##### AGENDA #####
                    ##################
                    """);
            System.out.println(">>>> Contatos <<<<");
            System.out.println("Id | Nome");
            for (Contato contato : agenda.getContatos()) {
                System.out.println(contato.getId() + " | " + contato.getNome() + " " + contato.getSobrenome());
            }
            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Editar Contato");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Criar um novo contato:");
                    System.out.print("Nome: ");
                    String nomeNovoContato = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String sobrenomeNovoContato = scanner.nextLine();

                    List<Telefone> telefonesNovoContato = new ArrayList<>();
                    boolean numeroTelefoneUnico = false;
                    do {
                        try {
                            System.out.print("DDD: ");
                            String dddTelefone = scanner.nextLine();
                            System.out.print("Número de telefone: ");
                            String numeroTelefoneString = scanner.nextLine();

                            Long numeroTelefone = Long.valueOf(numeroTelefoneString);


                            boolean numeroTelefoneJaExiste = agenda.getContatos().stream()
                                    .anyMatch(contato -> contato.getTelefones().stream()
                                            .anyMatch(telefone -> telefone.getNumero().equals(numeroTelefone)));

                            if (numeroTelefoneJaExiste) {
                                throw new IllegalArgumentException("Este número de telefone já está em uso por outro contato. Por favor, escolha outro número.");
                            }


                            Long idTelefone = Telefone.getId();
                            Telefone novoTelefone = new Telefone(idTelefone, dddTelefone, numeroTelefone);

                            int telefoneId = Math.toIntExact(Telefone.getId());

                            agenda.adicionarTelefoneAContato(telefoneId,novoTelefone);

                            System.out.print("Deseja adicionar outro número de telefone? (S/N): ");
                            String opcao1 = scanner.nextLine();
                            if (opcao1.equalsIgnoreCase("N")) {
                                numeroTelefoneUnico = true;
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!numeroTelefoneUnico);

                                        int novoId = Contato.getProximoId();

                    agenda.criarContato(novoId, nomeNovoContato, sobrenomeNovoContato, telefonesNovoContato);

                    agenda.salvarContatosEmArquivo("src/dados/contatos.txt");
                    System.out.println("Novo contato criado com sucesso!");
                    break;


                case 2:
                    System.out.println("Remover um contato:");
                    System.out.print("Digite o ID do contato que deseja remover: ");

                    try {
                        int idContatoRemover = scanner.nextInt();
                        scanner.nextLine();


                        boolean contatoEncontrado = false;
                        for (Contato contato : agenda.getContatos()) {
                            if (contato.getId() == idContatoRemover) {
                                contatoEncontrado = true;
                                break;
                            }
                        }

                        if (contatoEncontrado) {

                            agenda.removerContato(idContatoRemover);

                            agenda.salvarContatosEmArquivo("src/dados/contatos.txt");
                            System.out.println("Contato removido com sucesso!");
                        } else {
                            System.out.println("Contato não encontrado com o ID fornecido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um ID válido.");
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    try {

                        System.out.print("Digite o ID do contato que deseja editar: ");
                        int idContatoEditar = scanner.nextInt();
                        scanner.nextLine();


                        Contato contatoEditar = null;
                        for (Contato contato : agenda.getContatos()) {
                            if (contato.getId() == idContatoEditar) {
                                contatoEditar = contato;
                                break;
                            }
                        }

                        if (contatoEditar != null) {

                            System.out.println("Detalhes do Contato:");
                            System.out.println(contatoEditar.detalhesContato());


                            System.out.println("O que deseja editar?");
                            System.out.println("1 - Informações de Contato");
                            System.out.println("2 - Telefones");
                            System.out.print("Escolha uma opção: ");
                            int opcaoEditar = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcaoEditar) {
                                case 1:
                                    System.out.print("Novo nome (deixe em branco para manter o mesmo): ");
                                    String novoNome = scanner.nextLine().trim();
                                    System.out.print("Novo sobrenome (deixe em branco para manter o mesmo): ");
                                    String novoSobrenome = scanner.nextLine().trim();


                                    agenda.atualizarContato(idContatoEditar, novoNome, novoSobrenome);
                                    break;

                                case 2:
                                    System.out.println("TODO");
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                            }


                            agenda.salvarContatosEmArquivo("src/dados/contatos.txt");
                        } else {
                            System.out.println("Contato não encontrado com o ID fornecido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um ID válido.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    System.out.println("Saindo da aplicação...");
                    break;

                case 5:
                    try {

                        System.out.print("Digite o ID do contato que deseja ler: ");
                        int idContatoLer = scanner.nextInt();
                        scanner.nextLine();


                        Contato contatoLer = null;
                        for (Contato contato : agenda.getContatos()) {
                            if (contato.getId() == idContatoLer) {
                                contatoLer = contato;
                                break;
                            }
                        }

                        if (contatoLer != null) {

                            System.out.println("Detalhes do Contato:");
                            System.out.println(contatoLer.detalhesContato());
                        } else {
                            System.out.println("Contato não encontrado com o ID fornecido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um ID válido.");
                        scanner.nextLine();
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}

import java.util.Scanner;

public class Main {
	private final static int READ = 1; // 0001
	private final static int WRITE = 2; // 0010
	private final static int EXEC = 4; // 0100

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			//Programa permissões com Bitwise
			int op = 0;
			int perm = 0;
			
			System.out.println("\nEXERCÍCIO PARA FIXAR O CONTEÚDO DA AULA SOBRE BITWISE!\n");
			
			do {
				// MENU PRINCIPAL
				System.out.println("================== MENU ==================");
				System.out.println("[1] Dar permissão de leitura.");
				System.out.println("[2] Dar permissão de escrita.");
				System.out.println("[3] Dar permissão de execução.");
				System.out.println("[4] Remover permissão de leitura.");
				System.out.println("[5] Remover permissão de escrita.");
				System.out.println("[6] Remover permissão de execução.");
				System.out.println("[7] Listar permissões.");
				System.out.println("[0] Sair");
				System.out.println("Escolha uma opção:");
				System.out.print(">>> ");
				op = Integer.parseInt(scanner.nextLine()); // Entrada da opção
				
				switch (op) {
				// Aqui vai analisar e executar as instruções de acordo com o que o utilizador digitou
					case 0:
						System.out.println("Encerrando...");
						break;
						
					case 1:
						if ((perm & READ) != 0) {
							System.out.println("Usuário já possui permissão!");
						} else {
							System.out.println("Permissão de Leitura concedida!");
							
							perm |= READ;
						}
						scanner.nextLine(); //Para dar tempo de ver a resposta
						break;
						
					case 2:
						if ((perm & WRITE) != 0) {
							System.out.println("Usuário já possui permissão!");
						} else {
							System.out.println("Permissão de Escrita concedida!");
							
							perm |= WRITE;
						}
						scanner.nextLine();
						break;
						
					case 3:
						if ((perm & EXEC) != 0) {
							System.out.println("Usuário já possui permissão!");
						} else {
							System.out.println("Permissão de Execução concedida!");
							perm |= EXEC;
						}
						scanner.nextLine();
						break;
					case 4:
						if ((perm & READ) == 0) {
							System.out.println("Usuário não possui permissão!");
						} else {
						
							System.out.println("Permissão de Leitura removida!");
							
							perm &= ~READ;
						}
						scanner.nextLine();
						break;
						
					case 5:
						if ((perm & WRITE) == 0) {
							System.out.println("Usuário não possui permissão!");
						} else {
							System.out.println("Permissão de Escrita removida!");
							perm &= ~WRITE;
						}
						scanner.nextLine();
						break;
						
					case 6:
						if ((perm & EXEC) == 0) {
							System.out.println("Usuário não possui permissão!");
						} else {
							System.out.println("Permissão de Execução removida!");
							perm &= ~EXEC;
						}
						scanner.nextLine();
						break;
						
					case 7:
						System.out.println("\n==========================================");
						System.out.println("PERMISSÕES DO USUÁRIO: ");
						if (perm == 0) {
							System.out.println("Usuário não tem permissão nenhuma! ");
						} else {
							if ((perm & READ) != 0) {
								System.out.println("READ");
							} if ((perm & WRITE) != 0) {
								System.out.println("WRITE");
							} if ((perm & EXEC) != 0) {
								System.out.println("EXECUTE");
							}
						}
							
						scanner.nextLine();
						break;
						
					default:
						System.out.println("[ERRO] Digite um número entre 1 e 7!");
						scanner.nextLine();
						break;
						
				}
				
			} while (op != 0); // Teste simples para garantir que o usuário digite certo
			
			
		}

	}

}

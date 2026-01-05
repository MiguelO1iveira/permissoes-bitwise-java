import java.util.Scanner;

public class Main {
	private final static int READ = 1; // 001
	private final static int WRITE = 2; // 010
	private final static int EXEC = 4; // 100

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
					case 0 -> System.out.println("Encerrando...");
						
					case 1 -> {
						if ((perm & READ) != 0) { // Comparação para saber se o usuário já possui aquela permissão
							System.out.println("Usuário já possui permissão!");
						} else {
							System.out.println("Permissão de Leitura concedida!");
							
							perm |= READ; // Mantém as permissões que o usuário já possui e acrescenta a nova
						}
						scanner.nextLine(); //Para dar tempo de ver a resposta
					}
						
					case 2 -> {
						if ((perm & WRITE) != 0) {
							System.out.println("Usuário já possui permissão!");
						} else {
							System.out.println("Permissão de Escrita concedida!");
							
							perm |= WRITE;
						}
						scanner.nextLine();
					}
						
					case 3 -> {
						if ((perm & EXEC) != 0) {
							System.out.println("Usuário já possui permissão!");
						} else {
							System.out.println("Permissão de Execução concedida!");
							perm |= EXEC;
						}
						scanner.nextLine();
					}
					case 4 -> {
						if ((perm & READ) == 0) { // Verifica se o usuário não a permissão
							System.out.println("Usuário não possui permissão!");
						} else {
						
							System.out.println("Permissão de Leitura removida!");
							
							perm &= ~READ; 
							/* Se o usuário tiver a permissão, essa linha de comando serve para remover
							 * Exemplo: 
							 * Permissão do usuário  = 111
							 * Valor Binário do READ = 001
							 * 
							 * Se (perm & READ) vai resultar em 001 que vai retornar false na primeira condição, então vai executar
							 * o else. No else ele vai pegar a permissão = 111 e comparar com o inverso do READ ficado assim:
							 * 
							 * 111 & ~(001) -> 111 & 110 
							 * resultado da comparação = 110
							 * 
							 * Ou seja, ele vai respeitar os valores anteriores, mas vai remover a permissão selecionada
							 * 
							 * */
							
						}
						scanner.nextLine();
					}
						
					case 5 -> {
						if ((perm & WRITE) == 0) {
							System.out.println("Usuário não possui permissão!");
						} else {
							System.out.println("Permissão de Escrita removida!");
							perm &= ~WRITE;
						}
						scanner.nextLine();
					}
						
					case 6 -> {
						if ((perm & EXEC) == 0) {
							System.out.println("Usuário não possui permissão!");
						} else {
							System.out.println("Permissão de Execução removida!");
							perm &= ~EXEC;
						}
						scanner.nextLine();
					}
						
					case 7 -> {
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
					}
						
					default -> {
						System.out.println("[ERRO] Digite um número entre 1 e 7!");
						scanner.nextLine();
				}
						
				}
				
			} while (op != 0); // Se a opção digitada for igual a 0, ele encerra o laço
			
			
		}

	}

}

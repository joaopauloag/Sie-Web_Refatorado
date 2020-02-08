package sistema;

import java.util.Scanner;

public class FactoryUsuario {

	private static Scanner entrada;


	public static Usuario getUsuario() {
		
		char opcao;
		Usuario novoUsuario = null;
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n(1) Aluno");
			System.out.println("(2) Professor");
			opcao = entrada.nextLine().charAt(0);
			
			if(opcao == '1') {
				novoUsuario = new Aluno();
			} else if(opcao == '2') {
				novoUsuario = new Professor();
			} else {
				System.out.println("\nOpcao invalida!");
				continue;
			}
			while(!procurarEmail(novoUsuario)) {
			}
			return novoUsuario;
		}
	}
		
		
	private static boolean procurarEmail(Usuario novoUsuario) {
		
		String email;
		entrada = new Scanner(System.in);
		System.out.print("\nInsira o email: ");
		email = entrada.nextLine();
		
		for(Usuario u : Sistema.usuarios) {
			if(u.getEmail().equalsIgnoreCase(email)) {
				System.out.println("\nEste email de usuario ja existe.");
				return false;
			}
		}
		novoUsuario.setEmail(email);
		return true;
	}
}

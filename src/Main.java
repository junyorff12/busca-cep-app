import service.BuscaCepService;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int option = 1;
        int cepToSearch = 0;
        Scanner sc = new Scanner(System.in);

        while (option != 0){
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Buscar um CEP. ");
            System.out.println("0 - Sair. ");
            option = sc.nextInt();
            if (option == 1 ){
                System.out.println("Digite o cep que deseja efetuar a busca: ");
                cepToSearch = sc.nextInt();
                System.out.println("===========================");
                System.out.println("== Cep digitado: " + cepToSearch + " ==");
                System.out.println("===========================");
                System.out.println(" ");
                HttpResponse data = BuscaCepService.buscaCep(cepToSearch);

                System.out.println(data.body());
            } else if (option == 0){
                System.out.println("Programa finalizado.");
                break;
            } else {
                System.out.println("Opção invalida!!!");
            }

        }

    }
}

import model.Andress;
import service.AndressFileWriter;
import service.DataToAndressHandler;
import service.GetAndressData;

import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = 1;
        //String cepToSearch = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Buscar um CEP. ");
            System.out.println("0 - Sair. ");
            option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                System.out.println("Digite o cep que deseja efetuar a busca: ");
                String cepToSearch = sc.nextLine();
                System.out.println("===========================");
                System.out.println("== Cep digitado: " + cepToSearch + " ==");
                System.out.println("===========================");
                System.out.println(" ");
                HttpResponse<String> data = GetAndressData.getAndressData(cepToSearch);

                DataToAndressHandler dataToAndress = new DataToAndressHandler();
                Andress andress = dataToAndress.cepToAndress(data.body());

                if(andress.cep() != null) {

                    System.out.println("Criando arquivo json!");
                    System.out.println("Lendo arquivo Json criado!");
                    AndressFileWriter andressWriter = new AndressFileWriter();
                    andressWriter.andressWrite(andress);
                } else {
                    System.out.println("Cep não encontrado! " + data.body());
                    return;
                }


            } else if (option == 0) {
                System.out.println("Programa finalizado.");
                break;
            } else {
                System.out.println("Opção invalida!!!");
            }
        }

    }

}

package babbonataleclient;

import babbonatale.Bambino;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import babbonatale.BabboNataleRemote;
import java.util.Scanner;
import java.util.List;

public class BabboNataleClient {

    public static void main(String[] args) throws NamingException {
        Context ctx = (Context) new InitialContext();
        BabboNataleRemote babboNataleEJB = (BabboNataleRemote) ctx.lookup("java:global/BabboNataleEJB/BabboNataleController!babbonatale.BabboNataleRemote");

        System.out.println("###FIND ALL BAMBINI###");
        List<Bambino> lista;
        lista = babboNataleEJB.findAllBambini();
        stampaBambini(lista);
        System.out.println("\n\n");

        System.out.println("###FIND BAMBINI BY NUCLEO###");
        int nucleo = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("inserire n nucleo: ");
        nucleo = scan.nextInt();
        lista = babboNataleEJB.findBambiniByNucleo(nucleo);
        stampaBambini(lista);
        System.out.println("\n\n");

        System.out.println("###FIND BAMBINI BY STATO###");
        lista = babboNataleEJB.findBambiniByStato();
        stampaBambini(lista);
        System.out.println("\n\n");
    }

    private static void stampaBambini(List<Bambino> bambini) {
        System.out.println("risultati: ");
        for (Bambino bambino : bambini) {
            System.out.println(bambino);
        }
    }
}
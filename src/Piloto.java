import model.bean.Pessoa;

import java.io.IOException;
import java.util.Arrays;

public class Piloto {
    public static void main(String[] args) throws IOException {
     Pessoa lucas = new Pessoa("Lucas Alves","701.673.334-37","11/11/1998");
     Pessoa[] x = new Pessoa[500];
        for (int i = 0; i <500 ; i++) {
            x[i] = new Pessoa();
        }
        System.out.println(lucas);
        System.out.println(Arrays.toString(x));

    }
}

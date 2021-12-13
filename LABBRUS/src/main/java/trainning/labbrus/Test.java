package trainning.labbrus;

import java.util.ArrayList;

/**
 *
 * @author Maximiliano Di Ludovico
 */
public class Test {

    public static void main(String[] args) {

        ObjetosJson obj = new ObjetosJson();
        LecturaFichero file = new LecturaFichero();
        ArrayList<String> listaDeObjetos = new ArrayList<String>();

        listaDeObjetos = file.lecturaDeFichero(obj, listaDeObjetos);

        long initialTime = System.currentTimeMillis();

        Ensayo ensayo1 = new Ensayo(listaDeObjetos, initialTime);
        Ensayo ensayo2 = new Ensayo(listaDeObjetos, initialTime);

        ensayo1.start();
        ensayo2.start();
    }

}
/*
Codigo Reciclado:
for(int i=0;i< listaDeObjetos.size();i++){
    System.out.println(listaDeObjetos.get(i).toString());
}
 */

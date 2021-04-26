/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;
import model.ArvoreAVL;

/**
 *
 * @author Leo
 */
public class Funcao {
    ArvoreAVL valor = new ArvoreAVL();
    Scanner scan =  new Scanner(System.in);
    int n1 = scan.nextInt();
    
public void inserir(){
    System.out.println("Informe o valor a ser INSERIDO: ");
    scan.nextInt();
    valor.inserir(n1);
}

public void excluir(){
    System.out.println("Informe o valor a ser EXCLUIDO: ");
    scan.nextInt();
    
}

public void pesquisar(){
    System.out.println("Informe o valor a ser PESQUISADO: ");
    scan.nextInt();
}

public void valoresPreOrdem(){
    System.out.println("");
}

public void valoresPosOrdem(){
     System.out.println("");
}


}

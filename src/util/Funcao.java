/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Random;
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
    
    
public void inserirRandom(){
    Random aleatorio = new Random();
    for(int i = 0 ; i < 15 ; i++){
        valor.inserir(aleatorio.nextInt(30));
                }
}    
 
public void inserir(){
    System.out.println("Informe o valor a ser INSERIDO: ");
    scan.nextInt();
    valor.inserir(n1);
}

public void excluir(){
    System.out.println("Informe o valor a ser EXCLUIDO: ");
    scan.nextInt();
    valor.remover(n1);
}

public void pesquisar(){
    System.out.println("Informe o valor a ser PESQUISADO: ");
    scan.nextInt();

}

public void valoresPreOrdem(){
    System.out.println("Valores em Pre Ordem");
    valor.preOrdem(valor.raiz);
}

public void valoresPosOrdem(){
     System.out.println("Valores em Pos Ordem");
     valor.posOrdem(valor.raiz);
}
public void valoresEmOrdem(){
    System.out.println("");
    valor.emOrdem(valor.raiz);
}

}

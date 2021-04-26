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
public class Menu {
    
public void menuArvore (){ 
    ArvoreAVL arvore = new ArvoreAVL();
    
    
    Scanner scan = new Scanner(System.in);
    int value = 0;
    
        Funcao funcao = new Funcao();
    
    do{    
        System.out.println(" MENU ");
        System.out.println("");
        System.out.println("0 - Informe a quantidade de valores dentro da árvore");
        System.out.println("1 - Inserir os valores dos nós");
        System.out.println("2 - Pesquisar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Imprimir valores da árvore em pré ordem");
        System.out.println("5 - Imprimir valores da árvore em pós ordem");
        System.out.println("6 - Imprimir valores da árvore em ordem");
        System.out.println("7 - Sair");
        
        System.out.print("Informe o valor : ");
        value = scan.nextInt();
       
        
        switch(value){
            case 0:
                funcao.inserirRandom(); //Insere valores randomicos na árvore
                break;                    
            case 1:      
                funcao.inserir();       //Insere valores individuais na árvore
                break;            
            case 2:
                funcao.pesquisar();     //pesquisa os valores individuais na arvore
                break;       
            case 3:
                funcao.excluir();       //exclui valores individuais na arvore
                break;
            case 4:
                funcao.valoresPreOrdem();   //apresenta os valores em Pré-Ordem
                break;
            case 5:
                funcao.valoresPosOrdem();   //apresenta os valores em Pós-Ordem
                break;
            case 6:
                funcao.valoresEmOrdem();    //apresenta os valores em ordem 
        }
            
        } while(value != 7 || value > 7 );
    
}
    
}

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
    
        System.out.println(" MENU ");
        System.out.println("");
        System.out.println("1 - Inserir os valores dos nós");
        System.out.println("2 - Pesquisar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Imprimir valores da árvore em pré ordem");
        System.out.println("5 - Imprimir valores da árvore em pós ordem");
        System.out.println("6 - Imprimir valores da árvore em ordem");
        System.out.println("");
        
        value = scan.nextInt();
        switch(value){
            case 1:      
                funcao.inserir();
                break;
            
            case 2:
                funcao.pesquisar();
                break;
            
            case 3:
                funcao.excluir();
                break;
            
            case 4:
            
                break;
        }
}
    
}
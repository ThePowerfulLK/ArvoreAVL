/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public class ArvoreAVL {
 public No raiz;

    public void inserir(int value) {
        No n = new No(value);
	inserirAVL(this.raiz, n);
	}

    public void inserirAVL(No aComparar, No aInserir) {
        if (aComparar == null) {	
        this.raiz = aInserir;	
            } else { 
                if (aInserir.getChave() < aComparar.getChave()) { 	
                    if (aComparar.getEsquerda() == null) {    
                        aComparar.setEsquerda(aInserir); 
                        aInserir.setPai(aComparar);	 
                        verificarBalanceamento(aComparar);
                            } else {
                                inserirAVL(aComparar.getEsquerda(), aInserir); 
                                    }}  
                                    else if (aInserir.getChave() > aComparar.getChave()) {  
                                if (aComparar.getDireita() == null) { 
                            aComparar.setDireita(aInserir);
                            aInserir.setPai(aComparar);
                            verificarBalanceamento(aComparar);
        		} else {    
                    inserirAVL(aComparar.getDireita(), aInserir); 
                                }
                    } else {	
		}
            }
	}
    
    public void verificarBalanceamento(No atual) {
        setBalanceamento(atual);
	int balanceamento = atual.getBalanceamento();
            if (balanceamento == -2) {
                if(atual.getDireita() == null){
            if (alturaNo(atual.getEsquerda().getEsquerda()) >= alturaNo(atual.getEsquerda().getDireita())) {
                atual = roteDireita(atual);
		} else {
                    atual = duplaRotacaoEsquerdaDireita(atual);
                        }
		} else if (balanceamento == 2) {
                    if (alturaNo(atual.getDireita().getDireita()) >= alturaNo(atual.getDireita().getEsquerda())) {
			atual = roteEsquerda(atual);
			} else {
			atual = duplaRotacaoDireitaEsquerda(atual);
                        	}       
                                                }
		if (atual.getPai() != null) {
                    verificarBalanceamento(atual.getPai());
		} else {
                	this.raiz = atual;
		}
	}
        
    }
        
    public void remover(int k) {
            removerAVL(this.raiz, k);
	}
        
    public void removerAVL(No atual, int k) {
        if (atual == null) {
            } else {
                if (atual.getChave() > k) {
                    removerAVL(atual.getEsquerda(), k);}
                        else if (atual.getChave() < k) {
                            removerAVL(atual.getDireita(), k);}
                                else if (atual.getChave() == k) {
                                    removerNoEncontrado(atual);}                                                
                                        }}
	
    public void removerNoEncontrado(No aRemover) {
	No remove;
            if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {
		if (aRemover.getPai() == null) {
                    this.raiz = null;
                    aRemover = null;
                    return;
		}
		remove = aRemover;
		} else {
                    remove = sucessor(aRemover);
                    aRemover.setChave(remove.getChave());
		}
		No p;
                    if (remove.getEsquerda() != null) {
                    p = remove.getEsquerda();
                        } else {
                        p = remove.getDireita();
		}
                    if (p != null) {
                    p.setPai(remove.getPai());
		}
                    if (remove.getPai() == null) {
                    this.raiz = p;
                        } else {
                            if (remove == remove.getPai().getEsquerda()) {
                            remove.getPai().setEsquerda(p);
                            } else {
                            remove.getPai().setDireita(p);
                        }
                            verificarBalanceamento(remove.getPai());
                    }
                remove = null;
	}
    
    public No roteEsquerda(No inicial) {

	No direita = inicial.getDireita();
	direita.setPai(inicial.getPai());
            inicial.setDireita(direita.getEsquerda());
                if (inicial.getDireita() != null) {
                    inicial.getDireita().setPai(inicial);
		}
		direita.setEsquerda(inicial);
		inicial.setPai(direita);
                    if (direita.getPai() != null) {
                        if (direita.getPai().getDireita() == inicial) {
                            direita.getPai().setDireita(direita);
                            }else if (direita.getPai().getEsquerda() == inicial) {
                                direita.getPai().setEsquerda(direita);
			}
		}
                    setBalanceamento(inicial);
                    setBalanceamento(direita);
                    return direita;
    }

    public No roteDireita(No inicial) {

	No esquerda = inicial.getEsquerda();
	esquerda.setPai(inicial.getPai());
	inicial.setEsquerda(esquerda.getDireita());
            if (inicial.getEsquerda() != null) {
		inicial.getEsquerda().setPai(inicial);
		}
		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);
                    if (esquerda.getPai() != null) {
			if (esquerda.getPai().getDireita() == inicial) {    
                            esquerda.getPai().setDireita(esquerda);
                            }else if (esquerda.getPai().getEsquerda() == inicial) {
                            esquerda.getPai().setEsquerda(esquerda);
			}
		}
		setBalanceamento(inicial);
		setBalanceamento(esquerda);
		return esquerda;
	}

    public No duplaRotacaoEsquerdaDireita(No inicial) {
		inicial.setEsquerda(roteEsquerda(inicial.getEsquerda()));
		return roteDireita(inicial);
	}

    public No duplaRotacaoDireitaEsquerda(No inicial) {
		inicial.setDireita(roteDireita(inicial.getDireita()));
		return roteEsquerda(inicial);
	}

    public No sucessor(No q) {
		if (q.getDireita() != null) {
			No r = q.getDireita();
			while (r.getEsquerda() != null) {
				r = r.getEsquerda();
			}
			return r;
		} else {
			No p = q.getPai();
			while (p != null && q == p.getDireita()) {
				q = p;
				p = q.getPai();
			}
			return p;
		}
	}

    private int alturaNo(No atual) {
        if (atual == null) {
            return -1;
		}
		if(atual.getEsquerda() == null && atual.getDireita() == null) {
                    return 0;
                        }else if(atual.getEsquerda() == null) {
                            return 1 + alturaNo(atual.getDireita());
                                }else if (atual.getDireita() == null) {
                            return 1 + alturaNo(atual.getEsquerda());	
                        }else{
                    return 1 + Math.max(alturaNo(atual.getEsquerda()), alturaNo(atual.getDireita()));
		}
	}

    private void setBalanceamento(No no) {
		no.setBalanceamento(alturaNo(no.getDireita()) - alturaNo(no.getEsquerda()));
	}

    public void preOrdem(No no){
        if (no !=null){
            System.out.println(no.getChave() + "");
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }
    
    public void emOrdem(No no){
        if(no != null){
            emOrdem(no.getEsquerda());
            System.out.println(no.getChave() + "");
            emOrdem(no.getDireita());
        }
    }

}
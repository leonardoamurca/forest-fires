/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatrabalho;

/**
 *
 * @author leonardoamurca
 */
public interface StackADT<E> {

    void push(E e);

    E pop();

    boolean isEmpty();

}

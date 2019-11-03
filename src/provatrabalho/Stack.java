/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatrabalho;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardoamurca
 * @param <E>
 */
public class Stack<E> implements StackADT<E> {

    Node top = null;

    public Stack() {
    }

    @Override
    public void push(E e) {

        Node newNode = new Node();
        newNode.setValue(e);
        newNode.setPrevious(top);
        top = newNode;
    }

    @Override
    public E pop() {
        E value = null;
        try {
            if (!isEmpty()) {
                value = (E) top.getValue();
                top = top.getPrevious();
            } else {
                throw new EmptyStackException("Pilha vazia!");
            }

        } catch (EmptyStackException e) {
            try {
                LogWriter.writeFileTXT(Arrays.toString(e.getStackTrace()));
            } catch (Exception ex) {
                Logger.getLogger(Stack.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public E getTop() {
        return (E) top.getValue();
    }

}
